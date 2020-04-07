package tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Data;

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
}
