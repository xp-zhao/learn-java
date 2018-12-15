package org.litespring.test.v3;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by xp-zhao on 2018/12/15.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	ApplicationContextTestV3.class,
	BeanDefinitionTestV3.class,
	ConstructorResolverTest.class
})
public class V3AllTests
{
}
