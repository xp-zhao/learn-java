package core.jol;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

/**
 * @author zhaoxiaoping
 * @Description: 使用 jol 分析 Java 对象布局以及对象头布局
 * @Date 2021-11-5
 **/
public class JolExample {
  
  private boolean b;
  
  public static void main(String[] args) throws InterruptedException {
    Thread.sleep(5000);
    JolExample obj = new JolExample();
    //    System.out.println(VM.current().details());
    //    System.out.println(ClassLayout.parseInstance(obj).toPrintable());
    System.out.println("before lock");
    System.out.println(ClassLayout.parseInstance(obj).toPrintable());
    synchronized(obj){
      System.out.println("lock ing");
      System.out.println(ClassLayout.parseInstance(obj).toPrintable());
    }
    System.out.println("after lock");
    System.out.println(ClassLayout.parseInstance(obj).toPrintable());
  }
}
