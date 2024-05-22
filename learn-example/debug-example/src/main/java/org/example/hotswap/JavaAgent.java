package org.example.hotswap;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.StrUtil;
import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.instrument.ClassDefinition;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;
import java.lang.management.ManagementFactory;
import java.net.URL;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import lombok.extern.slf4j.Slf4j;
import org.example.agent.DebugAgent;
import org.example.agent.DebugAgentLocation;

/**
 * @author zhaoxiaoping
 * @date 2024-5-22
 */
@Slf4j
public class JavaAgent {
  private static String jarPath;
  private static VirtualMachine vm;
  private static String pid;

  static {
    jarPath = getJarPath();
    jarPath = "D:\\user\\code\\learn-java\\learn-example\\debug-agent\\target\\debug-agent.jar";
    log.error("java agent:jarPath:{}", jarPath);

    // 当前进程pid
    String name = ManagementFactory.getRuntimeMXBean().getName();
    pid = StrUtil.subBefore(name, "@", false);
    log.error("current pid {}", pid);
  }

  /**
   * 获取jar包路径
   *
   * @return
   */
  private static String getJarPath() {
    // 基于jar包中的类定位jar包位置
    String path =
        DebugAgentLocation.class.getProtectionDomain().getCodeSource().getLocation().getPath();

    URL resource =
        DebugAgentLocation.class
            .getClassLoader()
            .getResource(DebugAgentLocation.class.getName().replace(".", "/"));
    // 定位绝对路径
    return new File(path).getAbsolutePath();
  }

  private static void init()
      throws IOException,
          AttachNotSupportedException,
          AgentLoadException,
          AgentInitializationException {
    if (DebugAgent.getInstrumentation() != null) {
      // 已经有此对象，则无需再次初始化获取
      return;
    }
    // 连接虚拟机，并attach当前agent的jar包
    // agentmain()方法会设置Instrumentation
    vm = VirtualMachine.attach(pid);
    vm.loadAgent(jarPath);

    // 从而获取到当前虚拟机
    Instrumentation instrumentation = DebugAgent.getInstrumentation();
    if (instrumentation == null) {
      log.error("instrumentation is null");
    }
  }

  private static void destroy() throws IOException {
    if (vm != null) {
      vm.detach();
    }
    log.error("java agent redefine classes end");
  }

  /**
   * 从jar包重新加载类
   *
   * @param classArr
   * @throws ClassNotFoundException
   * @throws IOException
   * @throws UnmodifiableClassException
   * @throws AttachNotSupportedException
   * @throws AgentLoadException
   * @throws AgentInitializationException
   */
  public static void javaAgent(String[] classArr)
      throws ClassNotFoundException,
          IOException,
          UnmodifiableClassException,
          AttachNotSupportedException,
          AgentLoadException,
          AgentInitializationException {
    log.error("java agent redefine classes started");
    init();
    try {
      LinkedHashMap<String, LinkedHashSet<Class<?>>> redefineMap = new LinkedHashMap<>();
      // 1.整理需要重定义的类
      List<ClassDefinition> classDefList = new ArrayList<ClassDefinition>();
      for (String className : classArr) {
        Class<?> c = Class.forName(className);
        String classLocation = c.getProtectionDomain().getCodeSource().getLocation().getPath();
        LinkedHashSet<Class<?>> classSet =
            redefineMap.computeIfAbsent(classLocation, k -> new LinkedHashSet<>());
        classSet.add(c);
      }
      if (!redefineMap.isEmpty()) {
        for (Map.Entry<String, LinkedHashSet<Class<?>>> entry : redefineMap.entrySet()) {
          String classLocation = entry.getKey();
          log.error("class read from:{}", classLocation);
          if (classLocation.endsWith(".jar")) {
            try (JarFile jf = new JarFile(classLocation)) {
              for (Class<?> cls : entry.getValue()) {
                String clazz = cls.getName().replace('.', '/') + ".class";
                JarEntry je = jf.getJarEntry(clazz);
                if (je != null) {
                  log.error("class redefined:\t{}", clazz);
                  try (InputStream stream = jf.getInputStream(je)) {
                    byte[] data = IoUtil.readBytes(stream);
                    classDefList.add(new ClassDefinition(cls, data));
                  }
                } else {
                  throw new IOException("JarEntry " + clazz + " not found");
                }
              }
            }
          } else {
            File file;
            for (Class<?> cls : entry.getValue()) {
              String clazz = cls.getName().replace('.', '/') + ".class";
              file = new File(classLocation, clazz);
              log.error("class redefined:{}", file.getAbsolutePath());
              byte[] data = FileUtil.readBytes(file);
              classDefList.add(new ClassDefinition(cls, data));
            }
          }
        }
        // 2.redefine
        DebugAgent.getInstrumentation()
            .redefineClasses(classDefList.toArray(new ClassDefinition[0]));
      }
    } finally {
      destroy();
    }
  }

  public static void main(String[] args)
      throws UnmodifiableClassException,
          AgentLoadException,
          IOException,
          AttachNotSupportedException,
          ClassNotFoundException,
          AgentInitializationException {
    javaAgent(new String[] {Test.class.getName()});
  }
}
