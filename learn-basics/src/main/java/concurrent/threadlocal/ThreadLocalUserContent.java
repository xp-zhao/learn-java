package concurrent.threadlocal;

/**
 * ThreadLocalUserContent.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/14
 **/
public class ThreadLocalUserContent implements Runnable {

  private static ThreadLocal<Content> user = new ThreadLocal<>();
  private Integer userId;
  private UserRepository userRepository = new UserRepository();

  public ThreadLocalUserContent(Integer userId) {
    this.userId = userId;
  }

  @Override
  public void run() {
    String userName = userRepository.getUserNameForUserId(userId);
    user.set(new Content(userName));
    System.out.println("thread context for given userId: " + userId + " is: " + user.get());
  }
}