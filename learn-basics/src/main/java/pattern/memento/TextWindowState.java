package pattern.memento;

/**
 * TextWindowState.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/24
 **/
public class TextWindowState {

  private String text;

  public TextWindowState(String text) {
    this.text = text;
  }

  public String getText() {
    return text;
  }
}