package pattern.abstractfactory;

/**
 * Duck.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/29
 **/
public class Duck implements Animal {

  @Override
  public String getAnimal() {
    return "Duck";
  }

  @Override
  public String makeSound() {
    return "Squeaks";
  }
}