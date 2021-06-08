package concurrent.example;

import cn.hutool.core.date.StopWatch;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoxiaoping
 * @Description: CopyOnWriteArrayList 使用示例
 * @Date 2021-6-8
 **/
@Slf4j
public class CopyOnWriteArrayListExample {

  public static void main(String[] args) {
    CopyOnWriteArrayListExample example = new CopyOnWriteArrayListExample();
//    example.write();
    example.read();
  }
  
  private void write() {
    List<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
    List<Integer> synchronizedList = Collections.synchronizedList(new ArrayList<>());
    StopWatch stopWatch = new StopWatch();
    int loopCount = 100000;
    stopWatch.start("Write:copyOnWriteArrayList");
    IntStream.rangeClosed(1, loopCount).parallel()
        .forEach(i -> copyOnWriteArrayList.add(ThreadLocalRandom.current().nextInt(loopCount)));
    stopWatch.stop();
    stopWatch.start("Write:synchronizedList");
    IntStream.rangeClosed(1, loopCount).parallel()
        .forEach(i -> synchronizedList.add(ThreadLocalRandom.current().nextInt(loopCount)));
    stopWatch.stop();
    log.info(stopWatch.prettyPrint());
    Map<String, Integer> result = new HashMap<>();
    result.put("copyOnWriteArrayList", copyOnWriteArrayList.size());
    result.put("synchronizedList", synchronizedList.size());
    log.info("数量: {}", result);
  }

  private void read() {
    List<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
    List<Integer> synchronizedList = Collections.synchronizedList(new ArrayList<>());
    addAll(copyOnWriteArrayList);
    addAll(synchronizedList);
    StopWatch stopWatch = new StopWatch();
    int loopCount = 1000000;
    int count = copyOnWriteArrayList.size();
    stopWatch.start("Read:copyOnWriteArrayList");
    IntStream.rangeClosed(1, loopCount).parallel()
        .forEach(i -> copyOnWriteArrayList.get(ThreadLocalRandom.current().nextInt(count)));
    stopWatch.stop();
    stopWatch.start("Read:synchronizedList");
    IntStream.range(0, loopCount).parallel()
        .forEach(i -> synchronizedList.get(ThreadLocalRandom.current().nextInt(count)));
    stopWatch.stop();
    log.info(stopWatch.prettyPrint());
    Map<String, Integer> result = new HashMap<>();
    result.put("copyOnWriteArrayList", copyOnWriteArrayList.size());
    result.put("synchronizedList", synchronizedList.size());
    log.info("数量: {}", result);
  }

  private void addAll(List<Integer> list) {
    list.addAll(IntStream.rangeClosed(1, 1000000).boxed().collect(Collectors.toList()));
  }
}
