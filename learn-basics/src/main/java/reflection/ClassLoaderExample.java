package reflection;

public class ClassLoaderExample {
    public static void main(String[] args) throws ClassNotFoundException {
        // 获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        // 获取系统类加载器的父类加载器 --> 扩展类加载器
        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println(extClassLoader);

        // 获取扩展加载器的父类加载器 --> 根加载器
        ClassLoader rootClassLoader = extClassLoader.getParent();
        System.out.println(rootClassLoader);

        // 测试当前类是哪个加载器加载的
        ClassLoader classLoader = ClassLoaderExample.class.getClassLoader();
        System.out.println(classLoader);

        // 测试 JDK 内置的类是谁加载的
        ClassLoader objClassLoader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(objClassLoader);

        // 如何获取系统加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));
    }
}
