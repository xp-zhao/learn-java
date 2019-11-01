package pattern.visitor;

import java.util.UUID;

/**
 * Client.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/01
 **/
public class Client {

  public static void main(String[] args) {
    Visitor visitor = new ElementVisitor();

    Document document = new Document(generateUuid());
    document.elements.add(new JsonElement(generateUuid()));
    document.elements.add(new JsonElement(generateUuid()));
    document.elements.add(new XmlElement(generateUuid()));

    document.accept(visitor);
  }

  private static String generateUuid() {
    return UUID.randomUUID().toString();
  }
}