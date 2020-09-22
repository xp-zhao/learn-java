package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 获得类的信息
 */
public class ClassInfoExample {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class c1 = Class.forName("reflection.User");
        // 获得类的名字
        // 包名+类名
        System.out.println(c1.getName());
        // 类名
        System.out.println(c1.getSimpleName());

        // 获得类的属性
        Field[] publicFields = c1.getFields(); // 只能找到 public 的属性
        Field[] allFileds = c1.getDeclaredFields(); // 获取全部的属性
        for (Field field : allFileds) {
            System.out.println(field);
        }

        // 获取制定的属性
        Field name = c1.getDeclaredField("name");
        System.out.println(name);

        // 获得类的方法
        Method[] methods = c1.getMethods(); // 获得本类和父类的全部 public 方法
        for (Method method : methods) {
            System.out.println("正常的：" + method);
        }
        methods = c1.getDeclaredMethods(); // 获得本类的所有方法
        for (Method method : methods) {
            System.out.println("getDeclaredMethods:" + method);
        }

        // 获取指定方法
        Method getName = c1.getMethod("getName", null);
        Method setName = c1.getMethod("setName", String.class);
        System.out.println(getName);
        System.out.println(setName);
        // 获得构造器
        Constructor[] constructors = c1.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        constructors = c1.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("declared:" + constructor);
        }

        // 获得指定的构造器
        Constructor declaredConstructor = c1.getDeclaredConstructor(String.class, Integer.class, Integer.class);
        System.out.println(declaredConstructor);
    }
}
