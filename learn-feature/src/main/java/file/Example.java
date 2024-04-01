package file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoxiaoping
 * @date 2024-3-29
 */
@Slf4j
public class Example {
  public static void main(String[] args) {
    BitSet bitSet = new BitSet(5);
//    bitSet.set(1, true);
    System.out.println(
        bitSet.stream()
            .mapToObj(index -> bitSet.get(index))
            .peek(item -> System.out.println(item))
            .reduce(Boolean.TRUE, Boolean::logicalAnd));
  }

  private void processFile(final List<File> fileList) {
    Map<String, Counter> compiledMap = new HashMap<>();
    for (int i = 0; i < fileList.size(); i++) {
      processFile(fileList, compiledMap, i);
    }
    List<Counter> topCalls =
        compiledMap.values().stream()
            .filter(Counter::allDaysSet)
            .sorted(Comparator.comparing(Counter::getNumberOfCalls).reversed())
            .limit(10)
            .collect(Collectors.toList());
    log.info("topCalls size: {}", topCalls.size());
  }

  private void processFile(List<File> fileList, Map<String, Counter> compiledMap, int dayNumber) {
    try (Stream<String> lineStream = Files.lines(fileList.get(dayNumber).toPath())) {
      lineStream
          .map(this::toLogLine)
          .forEach(
              logLine -> {
                Counter counter = compiledMap.get(logLine.getServiceName());
                if (counter == null) {
                  counter = new Counter(logLine.getServiceName(), fileList.size());
                  compiledMap.put(logLine.getServiceName(), counter);
                }
                counter.add();
                counter.setDay(dayNumber);
              });
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private LogLine toLogLine(String content) {
    return new LogLine();
  }
}
