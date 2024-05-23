package org.example.hotswap;

import com.sun.tools.attach.VirtualMachine;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.Optional;

/**
 * @author zhaoxiaoping
 * @date 2024-5-23
 */
@Slf4j
public class AgentLoader {
  public static void run(String[] args) {
    String agentJarPath =
        "D:\\user\\code\\learn-java\\learn-example\\debug-agent\\target\\debug-agent.jar";
    String appName = "JavaAgent";
    Optional<String> jvmProcessOpt =
        Optional.ofNullable(
            VirtualMachine.list().stream()
                .filter(
                    jvm -> {
                      log.info("jvm:{}", jvm.displayName());
                      return jvm.displayName().contains(appName);
                    })
                .findFirst()
                .get()
                .id());

    if (!jvmProcessOpt.isPresent()) {
      log.error("Target Application not found");
      return;
    }
    File agentFile = new File(agentJarPath);
    try {
      String jvmPid = jvmProcessOpt.get();
      log.info("Attaching to target JVM with PID: " + jvmPid);
      VirtualMachine jvm = VirtualMachine.attach(jvmPid);
      jvm.loadAgent(agentFile.getAbsolutePath());
      jvm.detach();
      log.info("Attached to target JVM and loaded Java agent successfully");
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
