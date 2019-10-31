package stream.flatmap;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ch113
 */
public class FlatMapDemo {
    public static void main(String[] args) {
        List<List<String>> list = Arrays.asList(
                Arrays.asList("a"),
                Arrays.asList("b")
        );
        System.out.println(list);
        List<String> result = list.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println(result);
    }
}
