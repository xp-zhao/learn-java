package com.spring.example03;

/**
 * @author zhaoxiaoping
 * @date 2024-3-27
 */
public interface SoftwareEngineer {
  /** v1. 软件工程师依赖掘金文章 */
  void learn(JuejinArticle juejinArticle);

  /** v2. 软件工程师不再依赖具体的文章，而是依赖知识，由具体的文章去对知识进行实现 */
  void learn(Knowledge knowledge);
}
