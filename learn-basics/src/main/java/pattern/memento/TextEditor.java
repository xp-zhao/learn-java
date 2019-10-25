package pattern.memento;

/**
 * TextEditor.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/24
 **/
public class TextEditor {

  private TextWindow textWindow;
  private TextWindowState savedTextWindow;

  public TextEditor(TextWindow textWindow) {
    this.textWindow = textWindow;
  }

  public void hitSave() {
    savedTextWindow = textWindow.save();
  }

  public void hitUndo() {
    textWindow.restore(savedTextWindow);
  }

  public void print() {
    textWindow.print();
  }

  public void write(String str) {
    textWindow.addText(str);
  }
}