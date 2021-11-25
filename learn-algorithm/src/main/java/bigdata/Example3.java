package bigdata;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * <pre>
 * Example3.java
 * 一个ArrayList集合A中有1000个10-999的随机正整数，请编写程序实现如下功能;
 * 1.	将这些正整数中能够被2整除的移到集合B，能被3整除的移到集合C；
 * 2.	启动三个并发任务，并行对集合A\B\C进行处理，获取总和小于2000的最多个数的整数子集；
 * 3.	在三个并发任务处理完成后，将三个子集里的正整数合并为一个集合，去重后按照从大到小排序后返回
 * </pre>
 *
 * @author: zhaoxiaoping
 * @date: 2019/08/20
 **/
public class Example3 {

  public static void main(String[] args) throws Exception {
    Random random = new Random();
    int max = 999;
    int min = 10;
    List<Integer> num = new ArrayList<>(1000);
    // 生成 1000 个 10-999 的随机正整数
    for (int i = 0; i < 1000; i++) {
      num.add(random.nextInt(max - min + 1) + min);
    }
    System.out.println(execute(num));
  }

  /**
   * 程序主入口
   *
   * @param A 集合A
   */
  public static List<Integer> execute(List<Integer> A) throws Exception {
    Iterator iterator = A.iterator();
    // 能被 2 整除的数
    List<Integer> B = new ArrayList<>();
    // 能被 3 整除的数
    List<Integer> C = new ArrayList<>();
    while (iterator.hasNext()) {
      Integer num = (Integer) iterator.next();
      if (num % 2 == 0) {
        B.add(num);
        iterator.remove();
      } else if (num % 3 == 0) {
        C.add(num);
        iterator.remove();
      }
    }
    // 排序
    final List<Integer> finalA = A.stream().sorted().collect(Collectors.toList());
    final List<Integer> finalB = B.stream().sorted().collect(Collectors.toList());
    final List<Integer> finalC = C.stream().sorted().collect(Collectors.toList());

    /**
     * 开启三个线程
     */
    Callable<List<Integer>> taskA = () -> getChild(finalA);
    Callable<List<Integer>> taskB = () -> getChild(finalB);
    Callable<List<Integer>> taskC = () -> getChild(finalC);
    ThreadPoolExecutor executor = new ThreadPoolExecutor(
        3,
        3,
        60,
        TimeUnit.SECONDS,
        new ArrayBlockingQueue<>(2),
        r -> new Thread(r, "ThreadName"),
        new ThreadPoolExecutor.AbortPolicy());
    Future<List<Integer>> futureA = executor.submit(taskA);
    Future<List<Integer>> futureB = executor.submit(taskB);
    Future<List<Integer>> futureC = executor.submit(taskC);
    List<Integer> resultA = futureA.get();
    List<Integer> resultB = futureB.get();
    List<Integer> resultC = futureC.get();
    executor.shutdown();
    resultA.addAll(resultB);
    resultA.addAll(resultC);
    List<Integer> result = resultA.stream().distinct().sorted().collect(Collectors.toList());
    return result;
  }

  /**
   * 计算总和小于2000的最多个数的整数子集
   *
   * @param list 整数集合
   * @return 总和小于 2000 的最大子集
   */
  public static List<Integer> getChild(List<Integer> list) {
    int sum = 0;
    List<Integer> result = new ArrayList<>();
    for (Integer integer : list) {
      sum += integer;
      if (sum >= 2000) {
        break;
      }
      result.add(integer);
    }
    return result;
  }
}