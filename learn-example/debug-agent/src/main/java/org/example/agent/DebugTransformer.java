package org.example.agent;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import javassist.*;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoxiaoping
 * @date 2024-5-20
 */
@Slf4j
public class DebugTransformer implements ClassFileTransformer {

  private static final String QUERY_METHOD = "query";
  private String targetClassName;
  private ClassLoader targetClassLoader;

  public DebugTransformer(String targetClassName, ClassLoader targetClassLoader) {
    this.targetClassName = targetClassName;
    this.targetClassLoader = targetClassLoader;
  }

  @Override
  public byte[] transform(
      ClassLoader loader,
      String className,
      Class<?> classBeingRedefined,
      ProtectionDomain protectionDomain,
      byte[] classfileBuffer)
      throws IllegalClassFormatException {
    byte[] byteCode = classfileBuffer;
    String finalTargetClassName = this.targetClassName.replaceAll("\\.", "/");
    if (!className.equals(finalTargetClassName)) {
      return byteCode;
    }
    if (className.equals(finalTargetClassName) && loader.equals(targetClassLoader)) {
      log.info("Transforming class: {}", className);
      try {
        ClassPool cp = ClassPool.getDefault();
        CtClass cc = cp.get(targetClassName);
        CtMethod cm = cc.getDeclaredMethod(QUERY_METHOD);
        cm.addLocalVariable("startTime", CtClass.longType);
        cm.insertBefore("startTime = System.currentTimeMillis();");

        StringBuilder endLock = new StringBuilder();
        cm.addLocalVariable("endTime", CtClass.longType);
        cm.addLocalVariable("oprTime", CtClass.longType);
        endLock.append("endTime = System.currentTimeMillis();");
        endLock.append("oprTime = (endTime-startTime)/1000;");
        endLock.append("log.info(\"query operation completed in: \" + oprTime + \" seconds!\");");
        //        endBlock.append("LOGGER.info(\"[Application] Withdrawal operation completed in:\"
        // + opTime + \" seconds!\");");
        cm.insertAfter(endLock.toString());

        byteCode = cc.toBytecode();
        cc.detach();
      } catch (Exception e) {
        log.error("Exception", e);
      }
    }

    return byteCode;
  }
}
