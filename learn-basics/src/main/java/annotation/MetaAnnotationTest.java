package annotation;

import java.lang.annotation.*;

@MyAnnotaion
public class MetaAnnotationTest {
    /**
     * 注解可以显示赋值，如果没有默认值，就必须给注解赋值
     */
    @MyAnnotaion(name = "xp", schools = {"1", "2"})
    public void test() {

    }
}

/**
 * 自定义一个注解
 * Target：表示我们的注解可以用在哪些地方
 * Retention：表示我们的注解在什么地方还有效 runtime > class > source
 * Documented：表示是否将我们的注解生成在 JavaDoc 中
 * Inherited：表示子类可以继承父类的注解
 */
@Target(value = {ElementType.METHOD, ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
@Inherited
@interface MyAnnotaion {
    // 注解的参数：参数类型+参数名()
    String name()default "";
    int age() default 0;
    // 如果默认值为 -1 ，代表不存在
    int id() default -1;
    String[] schools() default {"清华"};
}
