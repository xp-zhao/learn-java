package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通过反射，动态创建对象
 */
public class DynamicObjectExample {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        // 获得 class 对象
        Class c1 = Class.forName("reflection.User");

        // 构造一个对象，默认调用无参构造函数
        User user = (User) c1.newInstance();
        System.out.println(user);

        // 通过构造器创建对象
        Constructor constructor = c1.getDeclaredConstructor(String.class, Integer.class, Integer.class);
        User xp = (User) constructor.newInstance("xp", 18, 18);
        System.out.println(xp);

        // 通过反射调用普通方法
        // 通过反射获取一个方法
        Method setName = c1.getDeclaredMethod("setName", String.class);
        // invoke: 激活（对象，"方法的值"）
        setName.invoke(xp, "xp1");
        System.out.println(xp.getName());

        // 通过反射操作属性
        // 获取一个属性
        Field name = c1.getDeclaredField("name");
        // 默认不能直接操作私有属性，setAccessible 设置为 true 之后就可以操作私有属性了
        name.setAccessible(true);
        name.set(xp, "xp2");
        System.out.println(xp.getName());
    }
}
