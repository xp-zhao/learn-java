package concurrent.cyclicbarrier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrierDemo.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/08
 **/
public class CyclicBarrierDemo {

  private CyclicBarrier cyclicBarrier;
  private List<List<Integer>> partialResults = Collections.synchronizedList(new ArrayList<>());
  private Random random = new Random();
  private int NUM_PARTIAL_RESULTS;
  private int NUM_WORKERS;

  public static void main(String[] args) {
    CyclicBarrierDemo demo = new CyclicBarrierDemo();
    demo.runSimulation(5, 3);
  }

  public void runSimulation(int numWorkers, int numberOfPartialResults) {
    NUM_PARTIAL_RESULTS = numberOfPartialResults;
    NUM_WORKERS = numWorkers;

    cyclicBarrier = new CyclicBarrier(NUM_WORKERS, new AggregatorThread());
    System.out.println(
        "Spawning " + NUM_WORKERS + " worker threads to compute " + NUM_PARTIAL_RESULTS
            + " partial results each");
    for (int i = 0; i < NUM_WORKERS; i++) {
      Thread worker = new Thread(new WorkerThread());
      worker.setName("Thread " + i);
      worker.start();
    }
  }

  class WorkerThread implements Runnable {

    @Override
    public void run() {
      String thisThreadName = Thread.currentThread().getName();
      List<Integer> partialResult = new ArrayList<>();
      for (int i = 0; i < NUM_PARTIAL_RESULTS; i++) {
        Integer num = random.nextInt(10);
        System.out.println(thisThreadName + ": Crunching some numbers! Final result - " + num);
        partialResult.add(num);
      }
      partialResults.add(partialResult);
      try {
        System.out.println(thisThreadName + " waiting for others to reach barrier.");
        cyclicBarrier.await();
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (BrokenBarrierException e) {
        e.printStackTrace();
      }
    }
  }

  class AggregatorThread implements Runnable {

    @Override
    public void run() {
      String thisThreadName = Thread.currentThread().getName();
      System.out.println(
          thisThreadName + ": Computing sum of " + NUM_WORKERS
              + " workers, having " + NUM_PARTIAL_RESULTS + " results each.");
      int sum = 0;
      for (List<Integer> partialResult : partialResults) {
        System.out.print("Adding ");
        for (Integer integer : partialResult) {
          System.out.print(integer + " ");
          sum += integer;
        }
        System.out.println();
      }
      System.out.println(thisThreadName + ": Final result = " + sum);
    }
  }
}