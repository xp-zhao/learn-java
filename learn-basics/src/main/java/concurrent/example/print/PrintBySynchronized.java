package concurrent.example.print;
/**
 * 两个线程交替打印 A, B - 通过 synchronized 关键字实现
 *
 * @author zhaoxiaoping
 * @date 2023-7-11
 */
public class PrintBySynchronized {
  public static void main(String[] args) {
    Print print = new Print(1, 5);
    new Thread(() -> print.print("A", 1, 2)).start();
    new Thread(() -> print.print("B", 2, 1)).start();
  }
}

class Print {
  private int flag;
  private final int loopNum;

  public Print(int flag, int loopNum) {
    this.flag = flag;
    this.loopNum = loopNum;
  }

  public void print(String letter, int currFlag, int nextFlag) {
    for (int i = 0; i < loopNum; i++) {
      synchronized (this) {
        while (flag != currFlag) {
          try {
            this.wait();
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        }
        System.out.println(letter);
        flag = nextFlag;
        this.notifyAll();
      }
    }
  }
}
