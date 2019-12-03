package org.litespring.beans.factory.annotation;

import org.litespring.beans.BeanDefinition;
import org.litespring.core.type.AnnotationMetadata;

/**
 *
 * @author xp-zhao
 * @date 2018/12/23
 */
public interface AnnotatedBeanDefinition extends BeanDefinition
{
	AnnotationMetadata getMetadata();
}
