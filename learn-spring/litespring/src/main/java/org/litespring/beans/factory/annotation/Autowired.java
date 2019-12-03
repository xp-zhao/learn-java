package org.litespring.beans.factory.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xp-zhao
 * @date 2018/12/23
 */
@Target({ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD,
    ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Autowired {

  /**
   * Declares whether the annotated dependency is required.
   * <p>Defaults to {@code true}.
   *
   * @return true/false
   */
  boolean required() default true;
}
