package org.example.agent;

import java.lang.instrument.Instrumentation;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoxiaoping
 * @date 2024-5-20
 */
@Slf4j
public class DebugAgent {

  public static void premain(String agentArgs, Instrumentation instrumentation) {
    log.info("DebugAgent.premain() was called.");
    String className = "org.example.hotswap.JavaAgent";

    transformClass(className, instrumentation);
  }

  public static void agentmain(String agentArgs, Instrumentation instrumentation) {
    log.info("DebugAgent.agentmain() was called.");
    String className = "org.example.hotswap.JavaAgent";

    transformClass(className, instrumentation);
  }

  private static void transformClass(String className, Instrumentation instrumentation) {
    Class<?> targetClass = null;
    ClassLoader targetClassLoader = null;
    try {
      targetClass = Class.forName(className);
      targetClassLoader = targetClass.getClassLoader();
      transform(targetClass, targetClassLoader, instrumentation);
      return;
    } catch (Exception e) {
      log.error("Class [{}] not found with Class.forName", className);
    }
    for (Class<?> clazz : instrumentation.getAllLoadedClasses()) {
      if (clazz.getName().equals(className)) {
        targetClass = clazz;
        targetClassLoader = targetClass.getClassLoader();
        transform(targetClass, targetClassLoader, instrumentation);
        return;
      }
    }
    throw new RuntimeException("Failed to find class [" + className + "]");
  }

  private static void transform(
      Class<?> clazz, ClassLoader classLoader, Instrumentation instrumentation) {
    DebugTransformer dt = new DebugTransformer(clazz.getName(), classLoader);
    instrumentation.addTransformer(dt, true);
    try {
      instrumentation.retransformClasses(clazz);
    } catch (Exception ex) {
      throw new RuntimeException("Transform failed for class: [" + clazz.getName() + "]", ex);
    }
  }
}
