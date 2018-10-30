package org.litespring.test.v2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.litespring.test.v1.ApplicationContextTest;
import org.litespring.test.v1.BeanFactoryTest;
import org.litespring.test.v1.ResourceTest;

/**
 * Created by xp-zhao on 2018/7/23.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses ({
	ApplicationContextTestV2.class,
	BeanDefinitionTestV2.class,
	BeanDefinitionValueResolverTest.class,
	CustomBooleanEditorTest.class,
	CustomNumberEditorTest.class,
	TypeConverterTest.class})
public class V2AllTests
{
}
