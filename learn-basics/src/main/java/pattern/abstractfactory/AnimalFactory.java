package pattern.abstractfactory;

/**
 * AnimalFactory.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/29
 **/
public class AnimalFactory implements AbstractFactory<Animal> {

  @Override
  public Animal create(String animalType) {
    if ("Dog".equalsIgnoreCase(animalType)) {
      return new Dog();
    } else if ("Duck".equalsIgnoreCase(animalType)) {
      return new Duck();
    }
    return null;
  }
}