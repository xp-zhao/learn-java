package validate;

/**
 * 性别枚举
 *
 * @author zhaoxiaoping
 * @date 2022-4-29
 */
public enum GenderEnum {
  /** 男 */
  MEN("男"),
  /** 女 */
  WOMEN("女");
  private String name;

  GenderEnum(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
