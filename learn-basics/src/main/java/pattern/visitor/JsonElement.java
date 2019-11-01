package pattern.visitor;

/**
 * JsonElement.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/01
 **/
public class JsonElement extends Element {

  public JsonElement(String uuid) {
    super(uuid);
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}