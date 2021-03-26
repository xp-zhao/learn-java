package com.xp.spring.bean.definition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhaoxiaoping
 * @Description: Bean 垃圾回收(GC) 示例
 * @Date 2021-3-26
 **/
public class BeanGarbageCollectionDemo {

  public static void main(String[] args) {
    // 创建 ApplicationContext 容器
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
    // 注册 Configuration Class(配置类)
    applicationContext.register(BeanInitializationDemo.class);
    // 启动应用上下文
    applicationContext.refresh();
    // 关闭应用上下文
    applicationContext.close();
    System.out.println("Spring 应用上下文已关闭...");
    // 强制触发 GC
    System.gc();
  }
}
