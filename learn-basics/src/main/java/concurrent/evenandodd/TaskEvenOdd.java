package concurrent.evenandodd;

/**
 * TaskEvenOdd.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/08
 **/
public class TaskEvenOdd implements Runnable {

  private int max;
  private Printer printer;
  private boolean isEvenNumber;

  public TaskEvenOdd(int max, boolean isEvenNumber, Printer printer) {
    this.max = max;
    this.printer = printer;
    this.isEvenNumber = isEvenNumber;
  }

  @Override
  public void run() {
    int number = isEvenNumber ? 2 : 1;
    while (number <= max) {
      if (isEvenNumber) {
        printer.printEven(number);
      } else {
        printer.printOdd(number);
      }
      number += 2;
    }
  }
}