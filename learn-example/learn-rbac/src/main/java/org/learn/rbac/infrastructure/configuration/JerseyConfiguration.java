package org.learn.rbac.infrastructure.configuration;

import java.util.Objects;
import java.util.stream.Collectors;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Path;
import javax.ws.rs.ext.Provider;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.util.ClassUtils;

/**
 * Jersey服务器配置
 *
 * @author zhaoxiaoping
 * @date 2024-12-18
 */
@Configuration
@ApplicationPath("/restful")
public class JerseyConfiguration extends ResourceConfig {
  public JerseyConfiguration() {
    scanPackages("org.learn.rbac.resource");
    scanPackages("org.learn.rbac.infrastructure.jaxrs");
  }

  /** Jersey的packages()方法在Jar形式运行下有问题，这里修理一下 */
  private void scanPackages(String scanPackage) {
    ClassPathScanningCandidateComponentProvider scanner =
        new ClassPathScanningCandidateComponentProvider(false);
    scanner.addIncludeFilter(new AnnotationTypeFilter(Path.class));
    scanner.addIncludeFilter(new AnnotationTypeFilter(Provider.class));
    this.registerClasses(
        scanner.findCandidateComponents(scanPackage).stream()
            .map(
                beanDefinition ->
                    ClassUtils.resolveClassName(
                        Objects.requireNonNull(beanDefinition.getBeanClassName()),
                        this.getClassLoader()))
            .collect(Collectors.toSet()));
  }
}
