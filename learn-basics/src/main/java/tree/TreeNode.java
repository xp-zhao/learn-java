package tree;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;

/**
 * @author zhaoxiaoping
 * @Description: 树节点
 * @Date 2020/4/7
 **/
@Data
@Builder
public class TreeNode {

  private String id;
  private String pId;
  private String name;
  private List<TreeNode> child;

  public static void main(String[] args) {
    List<TreeNode> list = Arrays.asList(
        TreeNode.builder().id("1").pId("0").build(),
        TreeNode.builder().id("2").pId("0").build(),
        TreeNode.builder().id("3").pId("1").build(),
        TreeNode.builder().id("4").pId("1").build(),
        TreeNode.builder().id("5").pId("2").build(),
        TreeNode.builder().id("6").pId("2").build(),
        TreeNode.builder().id("7").pId("3").build(),
        TreeNode.builder().id("8").pId("3").build(),
        TreeNode.builder().id("9").pId("3").build()
    );
    Map<String, List<TreeNode>> map = list.stream()
        .collect(Collectors.groupingBy(TreeNode::getPId));
    Map<String, Boolean> markMap = new HashMap<>();
    while (markMap.size() < list.size()) {
      list.forEach(item -> {
        item.setChild(map.get(item.getId()));
        markMap.put(item.getId(), true);
      });
    }
    System.out.println(list);
    String str = "-";
    System.out.println(str.split("-").length);
  }

  public <T> List<T> getChild(List<T> list, String idField, String idValue, String pIdField) {
    Class<?> clazz = list.get(0).getClass();
    try {
      PropertyDescriptor idDesc = new PropertyDescriptor(idField, clazz);
      PropertyDescriptor pIdDesc = new PropertyDescriptor(pIdField, clazz);
      Method getIdMethod = idDesc.getReadMethod();
      Method getPidMethod = pIdDesc.getReadMethod();
      List<T> result = list.stream()
          .filter(item -> getValue(getIdMethod, item).equals(idValue))
          .collect(Collectors.toList());
      while (CollectionUtils.isNotEmpty(result)) {
        for (T t : result) {
          List<T> child = list.stream()
              .filter(item -> getValue(getPidMethod, item).equals(getValue(getIdMethod, t)))
              .collect(Collectors.toList());
        }
      }
      for (T item : list) {
        getIdMethod.invoke(item);
        getPidMethod.invoke(item);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return list;
  }

  public String getValue(Method method, Object o) {
    try {
      return String.valueOf(method.invoke(o));
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
    return null;
  }

}
