package async.worker;

import async.wrapper.WorkerWrapper;

/**
 * 对依赖的 wrapper 的封装
 *
 * @author zhaoxiaoping
 * @date 2023-6-16
 */
public class DependWrapper {
  private WorkerWrapper<?, ?> dependWrapper;

  /** 是否该依赖必须完成后才能执行自己 */
  private boolean must = true;

  public DependWrapper(WorkerWrapper<?, ?> dependWrapper, boolean must) {
    this.dependWrapper = dependWrapper;
    this.must = must;
  }

  public DependWrapper() {}

  public WorkerWrapper<?, ?> getDependWrapper() {
    return dependWrapper;
  }

  public void setDependWrapper(WorkerWrapper<?, ?> dependWrapper) {
    this.dependWrapper = dependWrapper;
  }

  public boolean isMust() {
    return must;
  }

  public void setMust(boolean must) {
    this.must = must;
  }

  @Override
  public String toString() {
    return "DependWrapper{" + "dependWrapper=" + dependWrapper + ", must=" + must + '}';
  }
}
