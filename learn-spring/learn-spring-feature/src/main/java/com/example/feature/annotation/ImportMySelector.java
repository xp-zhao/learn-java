package com.example.feature.annotation;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author zhaoxiaoping
 * @date 2023-3-2
 */
public class ImportMySelector implements ImportSelector {
  @Override
  public String[] selectImports(AnnotationMetadata importingClassMetadata) {
    return new String[] {SimpleSelector.class.getName()};
  }
}
