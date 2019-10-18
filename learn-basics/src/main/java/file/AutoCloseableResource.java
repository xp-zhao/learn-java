package file;

import java.io.Closeable;
import java.io.IOException;

/**
 * AutoCloseableResource.java 资源自动关闭示例
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/18
 **/
public class AutoCloseableResource implements Closeable {

  public AutoCloseableResource() {
    System.out.println("Constructor -> AutoCloseableResource");
  }

  public void doSomething() {
    System.out.println("Something -> AutoCloseableResource");
  }

  @Override
  public void close() throws IOException {
    System.out.println("Closed -> AutoCloseableResource");
  }

  public static void main(String[] args) {
    try (AutoCloseableResource resource = new AutoCloseableResource()) {
      resource.doSomething();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}