package reflection;

/**
 * 测试类什么时候会初始化
 */
public class ClassInitExample {
    static {
        System.out.println("main 类被加载");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        // 1。主动引用
//        Son son = new Son();
        // 反射也会产生主动引用
//        Class.forName("reflection.Son");
//        System.out.println(Father.b);
        System.out.println(Son.M);
    }
}

class Father{
    static int b = 2;
    static {
        System.out.println("父类被加载");
    }

    public Father(){
        System.out.println("父类构造函数被调用");
    }
}

class Son extends Father{
    static {
        System.out.println("子类被加载");
        m = 300;
    }
    static int m = 100;
    static final int M = 1;
}