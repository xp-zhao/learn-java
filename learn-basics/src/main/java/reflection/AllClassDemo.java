package reflection;

/**
 * 所有类型的 Class
 */
public class AllClassDemo {
    public static void main(String[] args) {
        // 类
        Class c1 = Object.class;
        // 接口
        Class c2 = Comparable.class;
        // 一维数字
        Class c3 = String[].class;
        // 二维数组
        Class c4 = int[][].class;
        // 注解
        Class c5 = Override.class;
        // 枚举
        Class c6 = Enum.class;
        // 基本数据类型
        Class c7 = Integer.class;
        // void
        Class c8 = void.class;
        // class
        Class c9 = Class.class;

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);
        System.out.println(c6);
        System.out.println(c7);
        System.out.println(c8);
        System.out.println(c9);

        // 只要元素类型与纬度一样，就是同一个 class
        int[] a = new int[10];
        int[] b = new int[100];
        System.out.println(a.getClass().hashCode());
        System.out.println(b.getClass().hashCode());
    }
}
