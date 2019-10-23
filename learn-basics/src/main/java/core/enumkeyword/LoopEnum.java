package core.enumkeyword;

import java.util.stream.Stream;

public class LoopEnum {
    public static void main(String[] args) {
        for (DaysOfWeekEnum value : DaysOfWeekEnum.values()) {
            System.out.println(value);
        }
        Stream.of(DaysOfWeekEnum.values()).forEach(System.out::println);
    }
}
