package pattern.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Document.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/01
 **/
public class Document extends Element {

  List<Element> elements = new ArrayList<>();

  public Document(String uuid) {
    super(uuid);
  }

  @Override
  public void accept(Visitor visitor) {
    for (Element element : this.elements) {
      element.accept(visitor);
    }
  }
}