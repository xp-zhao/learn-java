package com.xp;

import com.xp.pojo.People;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2020-9-9
 **/
public class SpringTest {
  
  @Test
  public void test1(){
    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    People people = context.getBean("people", People.class);
    System.out.println(people);
    people.getCat().sound();
    people.getDog().sound();
  }
}
