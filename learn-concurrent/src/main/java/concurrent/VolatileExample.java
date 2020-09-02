package concurrent;

/**
 * @author zhaoxiaoping
 * @Description: volatile 示例
 * @Date 2020-9-1
 **/
public class VolatileExample {

  int x = 0;
  volatile boolean v = false;

  public void writer() {
    x = 10;
    v = true;
  }

  public void reader() {
    if (v == true) {
      // x == ?
      // 1.5 之前可能为 0
      // 1.5 之后为 10，Happens-Before 规则：x = 10 Happens-Before v = true, 
      // v 的写操作 Happens-Before v 的读操作，x = 10 Happens-Before v 的读操作, 
      // x = 10 Happens-Before v 的读操作，即 x = 10 对 v 的读操作可见
    }
  }
}
