package proxy.test;

import java.io.File;
import java.io.FileOutputStream;
import proxy.IUserService;
import proxy.UserService;
import proxy.cglib.CglibProxy;
import proxy.jdk.reflect.JDKProxy;
import proxy.jdk.util.ClassLoaderUtils;
import sun.misc.ProxyGenerator;

/**
 * @author zhaoxiaoping
 * @date 2022-2-17
 */
public class ApiTest {
  public static void main(String[] args) throws ClassNotFoundException {
//    test_proxy_jdk();
        test_proxy_cglib();
  }

  public static void test_proxy_jdk() throws ClassNotFoundException {
    IUserService proxy =
        (IUserService) JDKProxy.getProxy(ClassLoaderUtils.forName("proxy.IUserService"));
    String name = proxy.queryUserNameById("1001");
    System.out.println(name);

    String proxyClassName = "ProxyUserService";
    byte[] data =
        ProxyGenerator.generateProxyClass(proxyClassName, new Class[] {IUserService.class});
    // 输出类的字节码
    try (FileOutputStream fos = new FileOutputStream(proxyClassName + ".class")) {
      System.out.println(new File("").getAbsolutePath());
      fos.write(data);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void test_proxy_cglib() {
    CglibProxy cglibProxy = new CglibProxy();
    UserService userService = (UserService) cglibProxy.newInstance(new UserService());
    String userName = userService.queryUserNameById("10001");
    System.out.println(userName);
  }
}
