package proxy.example;

/**
 * TODO
 *
 * @author xp-zhao
 * @date 2022/7/20
 */
public class MyService implements IService {
  @Override
  public void queryName() {
    System.out.println("name");
  }

  @Override
  public void queryAge() {
    System.out.println("age");
  }
}
