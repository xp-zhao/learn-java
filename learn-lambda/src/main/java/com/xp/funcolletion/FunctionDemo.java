package com.xp.funcolletion;

import com.xp.funcolletion.entity.Student;
import java.math.BigDecimal;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * FunctionDemo.java 常用函数式接口示例
 *
 * @author: zhaoxiaoping
 * @date: 2019/07/16
 **/
public class FunctionDemo {

  public static void main(String[] args) {
    /**
     * 判断真假
     */
    Predicate<Integer> predicate = x -> x > 185;
    Student student = new Student("xp", 24, 170);
    System.out.println("身高高于185么？：" + predicate.test(student.getStature()));

    /**
     * 消费消息
     */
    Consumer<String> consumer = System.out::println;
    consumer.accept("Consumer 测试");

    /**
     * 将 T 映射为 R (转换功能)
     */
    Function<Student, String> function = Student::getName;
    String name = function.apply(student);
    System.out.println(name);

    /**
     * 生产消息
     */
    Supplier<Integer> supplier = () -> Integer.valueOf(BigDecimal.TEN.toString());
    System.out.println(supplier.get());

    /**
     * 一元操作
     */
    UnaryOperator<Boolean> unaryOperator = flag -> !flag;
    Boolean apply = unaryOperator.apply(true);
    System.out.println(apply);

    /**
     * 二元操作
     */
    BinaryOperator<Integer> operator = (x, y) -> x * y;
    Integer integer = operator.apply(2, 3);
    System.out.println(integer);

    test(() -> "自定义函数式接口的使用");
  }


  /**
   * 自定义函数式接口的使用
   * @param worker
   */
  public static void test(Worker worker){
    String work = worker.work();
    System.out.println(work);
  }

  public interface Worker{
    String work();
  }
}