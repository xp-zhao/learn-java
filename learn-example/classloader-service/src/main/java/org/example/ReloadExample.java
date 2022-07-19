package org.example;

import java.util.Scanner;

/**
 * TODO
 *
 * @author xp-zhao
 * @date 2022/7/19
 */
public class ReloadExample {
  /** Service类型的全局变量 */
  private static IService service;

  /** 加载指定目录中的 Service */
  private static void loadService() throws Exception {
    // 首先创建一个全新的 ClassLoader 对象
    ClassLoader myLoader =
        new MyClassLoader(
            "/Users/xp-zhao/code/learn-java/learn-example/service-client/target/classes");
    // 调用 Class.forName 加载指定的 Service 类
    Class<?> serviceCls = Class.forName("org.example.MyService", false, myLoader);

    if (service != null) {
      service.end();
    }

    // 创建 Service 对象，然后运行它
    service = (IService) serviceCls.newInstance();
    service.start();
  }

  public static void main(String[] args) throws Exception {
    loadService();

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String command = scanner.nextLine();
      if ("reload".equalsIgnoreCase(command)) {
        // 重新加载服务
        // 在不停止当前进程的前提下，加载最新版本的类
        loadService();
      } else if ("exit".equalsIgnoreCase(command)) {
        // 停止服务
        if (service != null) {
          service.end();
        }
        break;
      } else {
        System.out.println(command);
      }
    }
  }
}
