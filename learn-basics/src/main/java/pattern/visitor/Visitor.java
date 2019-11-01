package pattern.visitor;

/**
 * Visitor.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/01
 **/
public interface Visitor {

  void visit(XmlElement xmlElement);

  void visit(JsonElement jsonElement);
}