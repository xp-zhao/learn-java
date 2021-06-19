package com.xp.hutool.tree;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author zhaoxiaoping
 * @Description: TreeUtil 测试
 * @Date 2021-6-18
 **/
public class TreeUtilDemo {

  public static void main(String[] args) {
    // 构建node列表
    List<TreeNode<String>> nodeList = CollUtil.newArrayList();
    Map<String, Object> map = new HashMap<>();
    map.put("xp", "xp");
    nodeList.add(new TreeNode<>("1", "0", "系统管理", 5).setExtra(map));
    nodeList.add(new TreeNode<>("11", "1", "用户管理", 222222));
    nodeList.add(new TreeNode<>("111", "11", "用户添加", 0));
    nodeList.add(new TreeNode<>("2", "0", "店铺管理", 1));
//    nodeList.add(new TreeNode<>("21", "2", "商品管理", 44));
//    nodeList.add(new TreeNode<>("221", "2", "商品管理2", 2));
    // 0表示最顶层的id是0
    List<Tree<String>> treeList = TreeUtil.build(nodeList, "0", (node, tree) -> {
      
    });
    System.out.println(treeList);
  }

  public static void tree() {
    // 构建node列表
    List<Tree<String>> nodeList = CollUtil.newArrayList();
    Map<String, Object> map = new HashMap<>();
    nodeList.add(new Tree<String>().setId("1").setParentId("0").setName("系统管理"));
    nodeList.add(new Tree<String>().setId("11").setParentId("1").setName("用户管理"));
    nodeList.add(new Tree<String>().setId("111").setParentId("11").setName("用户添加"));
    nodeList.add(new Tree<String>().setId("2").setParentId("0").setName("店铺管理"));
    List<Tree<String>> treeList = TreeUtil.build(nodeList, "0", (node, tree) -> {
      tree.setChildren(Optional.ofNullable(node.getChildren()).orElse(new ArrayList<>()));
      tree.setId(node.getId());
      tree.setName(node.getName());
      tree.setParentId(node.getParentId());
    });
    System.out.println(treeList);
  }
}
