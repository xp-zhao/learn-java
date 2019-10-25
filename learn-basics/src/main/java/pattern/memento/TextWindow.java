package pattern.memento;

/**
 * TextWindow.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/24
 **/
public class TextWindow {

  private StringBuilder currentText;

  public TextWindow() {
    this.currentText = new StringBuilder();
  }

  public void addText(String text) {
    currentText.append(text);
  }

  public TextWindowState save() {
    return new TextWindowState(currentText.toString());
  }

  public void restore(TextWindowState save) {
    currentText = new StringBuilder(save.getText());
  }

  public void print() {
    System.out.println(currentText);
  }
}