package pattern.memento;

/**
 * Client.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/25
 **/
public class Client {

  public static void main(String[] args) {
    TextEditor editor = new TextEditor(new TextWindow());
    editor.write("one\n");
    editor.write("two\n");
    editor.print();
    editor.hitSave();

    editor.write("three\n");
    editor.print();

    editor.hitUndo();
    editor.print();
  }
}