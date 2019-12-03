package org.litespring.beans.factory.config;

import org.litespring.beans.factory.BeanFactory;

/**
 * @author ch113
 */
public interface AutowireCapableBeanFactory extends BeanFactory {
    /**
     * 解决依赖
     *
     * @param descriptor 依赖对象
     * @return 对象
     */
    Object resolveDependency(DependencyDescriptor descriptor);
}
