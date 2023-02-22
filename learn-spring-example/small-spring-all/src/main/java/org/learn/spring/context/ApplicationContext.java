package org.learn.spring.context;

import org.learn.spring.beans.factory.ListableBeanFactory;

/**
 * 应用上下文接口
 *
 * @author zhaoxiaoping
 * @date 2023-2-2
 */
public interface ApplicationContext extends ListableBeanFactory, ApplicationEventPublisher {}
