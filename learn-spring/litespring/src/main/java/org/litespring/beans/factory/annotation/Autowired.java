package org.litespring.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * Created by xp-zhao on 2018/12/23.
 */
@Target ({ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention (RetentionPolicy.RUNTIME)
@Documented
public @interface Autowired
{
	/**
	 * Declares whether the annotated dependency is required.
	 * <p>Defaults to {@code true}.
	 */
	boolean required() default true;
}
