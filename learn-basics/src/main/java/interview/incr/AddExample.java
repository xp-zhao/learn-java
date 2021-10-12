package interview.incr;

/** @author zhaoxiaoping @Description: @Date 2021-10-12 */
public class AddExample {
  public static void main(String[] args) {
    ipp();
    ppi();
    test1();
    test2();
    test3();
  }
  
  public static void ipp(){
    int i = 1;
    i = i++;
  }
  
  public static void ppi(){
    int i = 1;
    i = ++i;
  }
  
  public static void test1(){
    int i = 2;
    int y = ++i + i++;
    System.out.println(y);
  }

  public static void test2(){
    int i = 2;
    i = i++ + ++i;
    System.out.println(i);
  }

  public static void test3(){
    int i = 2;
    i = i++ + (++i + ++i) + (i += 2);
    System.out.println(i);
  }
}
