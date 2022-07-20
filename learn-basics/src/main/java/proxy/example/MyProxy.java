package proxy.example;

/**
 * TODO
 *
 * @author xp-zhao
 * @date 2022/7/20
 */
public class MyProxy implements IService {
  private IService service;

  public MyProxy(IService service) {
    this.service = service;
  }

  @Override
  public void queryName() {
    System.out.println("proxy name");
    service.queryName();
  }

  @Override
  public void queryAge() {
    System.out.println("proxy age");
    service.queryAge();
  }
}
