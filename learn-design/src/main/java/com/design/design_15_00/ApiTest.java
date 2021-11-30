package com.design.design_15_00;

import com.design.design_15_00.group.Employee;
import com.design.design_15_00.group.GroupStructure;
import com.design.design_15_00.group.Link;
import com.design.design_15_00.lang.Iterator;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2021-11-30
 */
@Slf4j
public class ApiTest {
  @Test
  public void testIterator() {
    GroupStructure groupStructure = new GroupStructure("1", "小傅哥");
    groupStructure.add(new Employee("2", "花花", "二级部门"));
    groupStructure.add(new Employee("3", "豆包", "二级部门"));
    groupStructure.add(new Employee("4", "蹦蹦", "三级部门"));
    groupStructure.add(new Employee("5", "大烧", "三级部门"));
    groupStructure.add(new Employee("6", "虎哥", "四级部门"));
    groupStructure.add(new Employee("7", "玲姐", "四级部门"));
    groupStructure.add(new Employee("8", "秋雅", "四级部门"));

    groupStructure.addLink("1", new Link("1", "2"));
    groupStructure.addLink("1", new Link("1", "3"));

    groupStructure.addLink("2", new Link("2", "4"));
    groupStructure.addLink("2", new Link("2", "5"));

    groupStructure.addLink("5", new Link("5", "6"));
    groupStructure.addLink("5", new Link("5", "7"));
    groupStructure.addLink("5", new Link("5", "8"));

    Iterator<Employee> iterator = groupStructure.iterator();
    while (iterator.hasNext()) {
      Employee employee = iterator.next();
      log.info("{}，雇员 Id：{} Name：{}", employee.getDesc(), employee.getUId(), employee.getName());
    }
  }
}
