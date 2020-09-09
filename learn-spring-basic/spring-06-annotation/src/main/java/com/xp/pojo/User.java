package com.xp.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2020-9-9
 **/
@Component
public class User {

  public String name;

  /**
   * 相当于 <property name="name" value="xxx"/>
   * @param name
   */
  @Value("xxx")
  public void setName(String name){
    this.name = name;
  }
}
