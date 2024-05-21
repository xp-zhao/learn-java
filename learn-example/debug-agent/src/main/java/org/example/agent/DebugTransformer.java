package org.example.agent;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import javassist.*;
import javassist.expr.ExprEditor;
import javassist.expr.MethodCall;

/**
 * @author zhaoxiaoping
 * @date 2024-5-20
 */
public class DebugTransformer implements ClassFileTransformer {
  @Override
  public byte[] transform(
      ClassLoader loader,
      String className,
      Class<?> classBeingRedefined,
      ProtectionDomain protectionDomain,
      byte[] classfileBuffer)
      throws IllegalClassFormatException {
    byte[] transformed = null;
    if (!className.contains("bytecode")) {
      return classfileBuffer;
    }
    System.out.println("Transforming " + className);
    ClassPool pool = ClassPool.getDefault();
    CtClass cl = null;
    try {
      cl = pool.makeClass(new java.io.ByteArrayInputStream(classfileBuffer));
      if (cl.isInterface() == false) {
        CtBehavior[] methods = cl.getDeclaredBehaviors();
        for (int i = 0; i < methods.length; i++) {
          if (methods[i].isEmpty() == false) {
            doMethod(methods[i]);
          }
        }
        transformed = cl.toBytecode();
      }
    } catch (Exception e) {
      System.err.println("Could not instrument  " + className + ",  exception : " + e.getMessage());
    } finally {
      if (cl != null) {
        cl.detach();
      }
    }
    return transformed;
  }

  private void doMethod(CtBehavior method) throws CannotCompileException {
    // 打印方法的执行时间
    method.instrument(
        new ExprEditor() {
          public void edit(MethodCall m) throws CannotCompileException {
            String name = m.getClassName() + "." + m.getMethodName();
            m.replace(
                "{ long startTime = System.nanoTime(); $_ = $proceed($$); System.out.println(\""
                    + name
                    + ":\" + (System.nanoTime() - startTime));}");
          }
        });
  }
}
