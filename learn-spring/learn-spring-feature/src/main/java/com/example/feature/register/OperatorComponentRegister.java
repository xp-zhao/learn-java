package com.example.feature.register;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.BeanInstantiationException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

/**
 * @author zhaoxiaoping
 * @date 2023-10-30
 */
public class OperatorComponentRegister
    implements ImportBeanDefinitionRegistrar, EnvironmentAware, ResourceLoaderAware {

  private Environment environment;
  private ResourceLoader resourceLoader;

  @Override
  public void setEnvironment(Environment environment) {
    this.environment = environment;
  }

  @Override
  public void setResourceLoader(ResourceLoader resourceLoader) {
    this.resourceLoader = resourceLoader;
  }

  @Override
  public void registerBeanDefinitions(
      AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
    // 1. 获取扫描路径
    Set<String> basePackages = new HashSet<>();
    Map<String, Object> attributes =
        metadata.getAnnotationAttributes(EnableOperator.class.getName());
    for (String value : (String[]) attributes.get("value")) {
      if (StringUtils.hasText(value)) {
        basePackages.add(value);
      }
    }
    if (basePackages.isEmpty()) {
      basePackages.add(ClassUtils.getPackageName(metadata.getClassName()));
    }
    // 2. 扫描路径下的 @Operator 接口
    ClassPathScanningCandidateComponentProvider scanner =
        new ClassPathScanningCandidateComponentProvider() {
          @Override
          protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
            return true;
          }
        };
    scanner.setEnvironment(environment);
    scanner.setResourceLoader(resourceLoader);
    scanner.addIncludeFilter(new AnnotationTypeFilter(Operator.class));
    for (String basePackage : basePackages) {
      Set<BeanDefinition> candidateComponents = scanner.findCandidateComponents(basePackage);
      for (BeanDefinition beanDefinition : candidateComponents) {
        if (beanDefinition instanceof AnnotatedBeanDefinition) {
          AnnotationMetadata annotationMetadata =
              ((AnnotatedBeanDefinition) beanDefinition).getMetadata();
          // 3. 生成代理对象, 并注册
          registerOperatorComponent(annotationMetadata, registry);
        }
      }
    }
  }

  private void registerOperatorComponent(
      AnnotationMetadata annotationMetadata, BeanDefinitionRegistry registry) {
    BeanDefinitionBuilder builder =
        BeanDefinitionBuilder.genericBeanDefinition(OperatorFactoryBean.class);
    String className = annotationMetadata.getClassName();
    builder.addPropertyValue("type", className);
    Map<String, Object> attributes =
        annotationMetadata.getAnnotationAttributes(Operator.class.getName());
    builder.addPropertyValue("expression", attributes.get("value"));
    builder.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);

    AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();
    try {
      beanDefinition.setAttribute(FactoryBean.OBJECT_TYPE_ATTRIBUTE, Class.forName(className));
    } catch (ClassNotFoundException e) {
      throw new BeanInstantiationException(this.getClass(), "Cannot fount " + className, e);
    }
    BeanDefinitionHolder beanDefinitionHolder = new BeanDefinitionHolder(beanDefinition, className);
    BeanDefinitionReaderUtils.registerBeanDefinition(beanDefinitionHolder, registry);
  }
}
