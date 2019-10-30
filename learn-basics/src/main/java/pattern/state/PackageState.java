package pattern.state;

/**
 * @author: zhaoxiaoping
 * @date: 2019/10/30
 **/
public interface PackageState {

  void next(Package pck);

  void prev(Package pck);

  void printStatus();
}
