package reflection;

public class Client {
    public static void main(String[] args) throws ClassNotFoundException {
        // 通过反射获取类的 Class 对象
        // 方式一
        Class c1 = Class.forName("reflection.User");
        Class c2 = Class.forName("reflection.User");
        // 方式二
        Class c3 = User.class;
        User user = new User();
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());
        // 方式三
        System.out.println(user.getClass().hashCode());
        Class<Integer> type = Integer.TYPE;
        System.out.println(c1);
    }
}
