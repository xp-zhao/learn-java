package async.demo;
/**
 * 包装器，保证 worker 和 回调器
 *
 * @author zhaoxiaoping
 * @date 2023-6-15
 */
public class Wrapper {
  private Object param;
  private Worker worker;
  private Listener listener;

  public Object getParam() {
    return param;
  }

  public void setParam(Object param) {
    this.param = param;
  }

  public Worker getWorker() {
    return worker;
  }

  public void setWorker(Worker worker) {
    this.worker = worker;
  }

  public Listener getListener() {
    return listener;
  }

  /**
   * 添加回调器
   *
   * @param listener
   */
  public void addListener(Listener listener) {
    this.listener = listener;
  }
}
