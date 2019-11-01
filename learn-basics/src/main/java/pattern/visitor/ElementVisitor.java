package pattern.visitor;

/**
 * ElementVisitor.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/01
 **/
public class ElementVisitor implements Visitor {

  @Override
  public void visit(XmlElement xmlElement) {
    System.out.println("processing xml element with uuid: " + xmlElement.uuid);
  }

  @Override
  public void visit(JsonElement jsonElement) {
    System.out.println("processing json element with uuid: " + jsonElement.uuid);
  }
}