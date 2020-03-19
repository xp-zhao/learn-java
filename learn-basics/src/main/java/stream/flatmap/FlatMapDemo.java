package stream.flatmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author ch113
 */
public class FlatMapDemo {
    public static void main(String[] args) {
//        List<List<String>> list = Arrays.asList(
//                Arrays.asList("a"),
//                Arrays.asList("b")
//        );
//        System.out.println(list);
//        List<String> result = list.stream()
//                .flatMap(Collection::stream)
//                .collect(Collectors.toList());
//        System.out.println(result);
        List<Map<String, Integer>> list = new ArrayList<>();
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("1", 1);
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("2", 2);
        list.add(map1);
        list.add(map2);
        
        System.out.println(list);
    }
}
