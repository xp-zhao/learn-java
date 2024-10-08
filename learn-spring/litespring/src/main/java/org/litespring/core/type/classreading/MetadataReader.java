package org.litespring.core.type.classreading;

import org.litespring.core.io.Resource;
import org.litespring.core.type.AnnotationMetadata;
import org.litespring.core.type.ClassMetadata;

/**
 * Simple facade for accessing class metadata,
 * as read by an ASM {@link org.springframework.asm.ClassReader}.
 *
 * @author Juergen Hoeller
 * @since 2.5
 */
public interface MetadataReader {

  /**
   * Return the resource reference for the class file.
   *
   * @return Resource
   */
  Resource getResource();

  /**
   * Read basic class metadata for the underlying class.
   *
   * @return ClassMetadata
   */
  ClassMetadata getClassMetadata();

  /**
   * Read full annotation metadata for the underlying class,
   * including metadata for annotated methods.
   *
   * @return AnnotationMetadata
   */
  AnnotationMetadata getAnnotationMetadata();

}
