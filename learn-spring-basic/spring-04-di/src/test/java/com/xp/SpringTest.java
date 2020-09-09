package com.xp;

import com.xp.pojo.Student;
import com.xp.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2020-9-9
 **/
public class SpringTest {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    Student student = (Student) context.getBean("student");
    System.out.println(student.toString());
  }
  
  @Test
  public void testUser(){
    ApplicationContext context = new ClassPathXmlApplicationContext("user-beans.xml");
    User user2 = context.getBean("user2", User.class);
    User user = context.getBean("user2", User.class);
    System.out.println(user.toString());
    System.out.println(user == user2);
  }
}
