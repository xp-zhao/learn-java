package pattern.builder.lombok;

/**
 * Client.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/25
 **/
public class Client {

  public static void main(String[] args) {
    Message message = Message.builder()
        .sender("1")
        .text("test")
        .recipient("2")
        .text("text")
//        .file(new File(""))
        .build();
    System.out.println(message);

    Child child = Child.builder()
        .parentName("parent")
        .parentAge(50)
        .childName("child")
        .childAge(20)
        .build();
    System.out.println(child);
  }
}