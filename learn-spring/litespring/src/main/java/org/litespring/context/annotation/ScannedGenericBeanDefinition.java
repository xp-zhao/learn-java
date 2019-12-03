package org.litespring.context.annotation;

import org.litespring.beans.factory.annotation.AnnotatedBeanDefinition;
import org.litespring.beans.factory.support.GenericBeanDefinition;
import org.litespring.core.type.AnnotationMetadata;

/**
 * @author xp-zhao
 * @date 2018/12/23
 */
public class ScannedGenericBeanDefinition extends GenericBeanDefinition implements
    AnnotatedBeanDefinition {

  private final AnnotationMetadata metadata;


  public ScannedGenericBeanDefinition(AnnotationMetadata metadata) {
    super();

    this.metadata = metadata;

    setBeanClassName(this.metadata.getClassName());
  }


  public final AnnotationMetadata getMetadata() {
    return this.metadata;
  }

}
