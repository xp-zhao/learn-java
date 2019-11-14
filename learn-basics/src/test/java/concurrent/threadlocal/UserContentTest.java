package concurrent.threadlocal;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Test;

/**
 * UserContentTest.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/14
 **/
public class UserContentTest {

  @Test
  public void testUserMap() throws InterruptedException {
    UserContent firstUser = new UserContent(1);
    UserContent secondUser = new UserContent(2);
    new Thread(firstUser).start();
    new Thread(secondUser).start();
    TimeUnit.SECONDS.sleep(1);
    Assert.assertEquals(UserContent.user.size(), 2);
  }

  @Test
  public void testThreadLocalUserMap() throws InterruptedException {
    ThreadLocalUserContent firstUser = new ThreadLocalUserContent(1);
    ThreadLocalUserContent secondUser = new ThreadLocalUserContent(2);
    new Thread(firstUser).start();
    new Thread(secondUser).start();
    TimeUnit.SECONDS.sleep(1);
  }
}