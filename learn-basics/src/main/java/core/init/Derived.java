package core.init;
/**
 * @author zhaoxiaoping
 * @date 2023-8-4
 */
public class Derived extends Base {
  public String whenAmISet = "set when declared";

  @Override
  void preProcess() {
    System.out.println("Derived preProcess()");
    whenAmISet = "set in preProcess()";
  }
}
