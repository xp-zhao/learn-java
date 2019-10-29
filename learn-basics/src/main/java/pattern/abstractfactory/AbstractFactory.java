package pattern.abstractfactory;

/**
 * @author: zhaoxiaoping
 * @date: 2019/10/29
 **/
public interface AbstractFactory<T> {

  T create(String type);
}
