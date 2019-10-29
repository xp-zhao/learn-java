package pattern.abstractfactory;

/**
 * Dog.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/29
 **/
public class Dog implements Animal {

  @Override
  public String getAnimal() {
    return "Dog";
  }

  @Override
  public String makeSound() {
    return "Dog Sound";
  }
}