package list;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupDemo {
    public static void main(String[] args) {
        List<Employee> list = Arrays.asList(Employee.builder().id(1L).name("name1").build(), Employee.builder().id(1L).name("name1-1").build(), Employee.builder().id(2L).name("name2").build(), Employee.builder().id(2L).name("name2-1").build());
        System.out.println(list);
        Map<Long, List<String>> listMap = list.stream().collect(Collectors.groupingBy(Employee::getId, Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println(listMap);
    }
}
