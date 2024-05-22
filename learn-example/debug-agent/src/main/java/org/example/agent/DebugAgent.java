package org.example.agent;

import java.lang.instrument.Instrumentation;
import java.lang.reflect.Method;

/**
 * @author zhaoxiaoping
 * @date 2024-5-20
 */
public class DebugAgent {

  private static Instrumentation instrumentation;
  private static Object lockObject = new Object();

  public static void premain(String agentArgs, Instrumentation instrumentation) {
    System.out.println("DebugAgent.premain() was called.");
    System.out.println("Adding a DebugAgent instance to the JVM.");
    // 注册 transformer
    instrumentation.addTransformer(new DebugTransformer());
  }

  public static void agentmain(String agentArgs, Instrumentation instrumentation) {
    synchronized (lockObject) {
      boolean isSuccess = false;
      Class[] allLoadedClasses = instrumentation.getAllLoadedClasses();
      for (Class loadedClass : allLoadedClasses) {
        if (loadedClass.getSimpleName().equals("JavaAgent")) {
          try {
            ClassLoader classLoader = loadedClass.getClassLoader();
            Class<?> javaDynAgentClass = classLoader.loadClass(DebugAgent.class.getName());
            Method method =
                javaDynAgentClass.getDeclaredMethod("setInstrumentation", Instrumentation.class);
            method.invoke((Object) null, instrumentation);
            System.out.println("0->" + instrumentation);
            isSuccess = true;
            break;
          } catch (Exception var13) {
            var13.printStackTrace();
            throw new RuntimeException(var13);
          }
        }
      }

      if (!isSuccess) {
        System.out.println("instrumentation未成功设置：DebugAgent类未加载");
      }
    }
  }

  public static Instrumentation getInstrumentation() {
    return instrumentation;
  }

  public static void setInstrumentation(Instrumentation instrumentation) {
    DebugAgent.instrumentation = instrumentation;
  }
}
