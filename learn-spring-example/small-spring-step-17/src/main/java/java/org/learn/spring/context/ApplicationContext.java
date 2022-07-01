package java.org.learn.spring.context;

import org.learn.spring.beans.factory.HierarchicalBeanFactory;
import org.learn.spring.beans.factory.ListableBeanFactory;
import org.learn.spring.core.io.ResourceLoader;

/**
 * 应用上下文接口
 *
 * @author zhaoxiaoping
 * @date 2022-1-5
 */
public interface ApplicationContext
    extends ListableBeanFactory,
        HierarchicalBeanFactory,
        ResourceLoader,
        ApplicationEventPublisher {}
