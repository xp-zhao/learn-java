package mockito.demo;

/**
 * @author zhaoxiaoping
 * @date 2024-3-28
 */
public class DemoService {
  private DemoDao demoDao;

  public DemoService(DemoDao demoDao) {
    this.demoDao = demoDao;
  }

  public int getRandomCount() {
    return demoDao.getRandomCount();
  }
}
