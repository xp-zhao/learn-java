package org.litespring.core.type;

/**
 * @author xp-zhao
 * @date 2018/12/23
 */
public interface ClassMetadata {

  /**
   * Return the name of the underlying class.
   *
   * @return className
   */
  String getClassName();

  /**
   * Return whether the underlying class represents an interface.
   *
   * @return true/false
   */
  boolean isInterface();

  /**
   * Return whether the underlying class is marked as abstract.
   *
   * @return true/false
   */
  boolean isAbstract();


  /**
   * Return whether the underlying class is marked as 'final'.
   *
   * @return true/false
   */
  boolean isFinal();


  /**
   * Return whether the underlying class has a super class.
   *
   * @return true/false
   */
  boolean hasSuperClass();

  /**
   * Return the name of the super class of the underlying class,
   * or {@code null} if there is no super class defined.
   *
   * @return superClassName
   */
  String getSuperClassName();

  /**
   * Return the names of all interfaces that the underlying class
   * implements, or an empty array if there are none.
   *
   * @return interfaceNames
   */
  String[] getInterfaceNames();
}
