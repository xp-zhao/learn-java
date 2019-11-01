package pattern.visitor;

/**
 * XmlElement.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/01
 **/
public class XmlElement extends Element {

  public XmlElement(String uuid) {
    super(uuid);
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}