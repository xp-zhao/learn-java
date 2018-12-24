package org.litespring.core.type;

import org.litespring.core.annotation.AnnotationAttributes;

import java.util.Set;

/**
 * Created by xp-zhao on 2018/12/23.
 */
public interface AnnotationMetadata extends ClassMetadata{

	Set<String> getAnnotationTypes();


	boolean hasAnnotation(String annotationType);

	public AnnotationAttributes getAnnotationAttributes(String annotationType);
}
