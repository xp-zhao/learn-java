package juc;

import concurrent.SumCompute;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;
import org.junit.Test;

/**
 * @author zhaoxiaoping
 * @Description: ForkJoin 测试
 * @Date 2020/5/18
 **/
public class SumComputeTest {
  
  @Test
  public void test1(){
    Long sum = 0L;
    long start = System.currentTimeMillis();
    for (Long i = 1L; i < 1_000_000_000; i++) {
      sum += i;
    }
    long end = System.currentTimeMillis();
    System.out.println("sum="+sum+" 时间："+(end-start));
  }
  
  @Test
  public void test2() throws ExecutionException, InterruptedException {
    long start = System.currentTimeMillis();

    ForkJoinPool forkJoinPool = new ForkJoinPool();
    ForkJoinTask<Long> task = new SumCompute(0L, 1_000_000_000L);
    ForkJoinTask<Long> submit = forkJoinPool.submit(task);
    
    Long sum = submit.get();
    long end = System.currentTimeMillis();
    System.out.println("sum="+sum+" 时间："+(end-start));
  }
  
  @Test
  public void test3(){
    long start = System.currentTimeMillis();
    Long sum = LongStream.rangeClosed(0, 1_000_000_000L).parallel().reduce(0, Long::sum);
    long end = System.currentTimeMillis();
    System.out.println("sum="+sum+" 时间："+(end-start));
  }
}
