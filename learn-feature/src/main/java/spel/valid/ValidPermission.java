package spel.valid;

import java.lang.annotation.*;

/**
 * @author zhaoxiaoping
 * @date 2024-5-28
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface ValidPermission {
  /**
   * 用户id, 支持 el 表达式
   *
   * @return
   */
  String userId();
}
