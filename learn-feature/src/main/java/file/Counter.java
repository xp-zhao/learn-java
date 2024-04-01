package file;

import java.util.BitSet;
import lombok.Getter;

/**
 * @author zhaoxiaoping
 * @date 2024-3-29
 */
public class Counter {
  @Getter private String serviceName;
  @Getter private long numberOfCalls;
  private final BitSet daysWithCalls;

  public Counter(String serviceName, int numberOfDays) {
    this.serviceName = serviceName;
    this.numberOfCalls = 0L;
    this.daysWithCalls = new BitSet(numberOfDays);
  }

  public void add() {
    numberOfCalls++;
  }

  public void setDay(int dayNumber) {
    daysWithCalls.set(dayNumber);
  }

  public boolean allDaysSet() {
    return daysWithCalls.stream()
        .mapToObj(index -> daysWithCalls.get(index))
        .reduce(Boolean.TRUE, Boolean::logicalAnd);
  }
}
