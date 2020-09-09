package com.xp.pojo;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2020-9-9
 **/
public class People {

  /**
   * 如果显示定义了 Autowired 的 required 的值为 false,说明这个对象可以为 null,否则不能为空
   */
  @Autowired(required = false)
  private Cat cat;
  @Autowired
  private Dog dog;
  private String name;

  public Cat getCat() {
    return cat;
  }

  public void setCat(Cat cat) {
    this.cat = cat;
  }

  public Dog getDog() {
    return dog;
  }

  public void setDog(Dog dog) {
    this.dog = dog;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "People{" +
        "cat=" + cat +
        ", dog=" + dog +
        ", name='" + name + '\'' +
        '}';
  }
}
