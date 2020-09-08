package com.xp;

import com.xp.pojo.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2020-9-8
 **/
public class SpringTest {

  public static void main(String[] args) {
    // 获取 Spring 的上下文对象
    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    // 我们的对象现在都在 Spring 中管理了
    Hello hello = (Hello) context.getBean("hello");
    System.out.println(hello.getStr());
  }

}
