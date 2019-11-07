package concurrent.threadsafety.threadlocalfield;

/**
 * ThreadState.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/07
 **/
public class ThreadState {

  public static final ThreadLocal<StateHolder> STATE_HOLDER_THREAD_LOCAL = new ThreadLocal<StateHolder>() {
    @Override
    protected StateHolder initialValue() {
      return new StateHolder("active");
    }
  };

  public static StateHolder getState() {
    return STATE_HOLDER_THREAD_LOCAL.get();
  }
}