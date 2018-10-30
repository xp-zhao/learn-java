package org.litespring.test.v1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by xp-zhao on 2018/7/23.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses ({
	ApplicationContextTest.class,
	BeanFactoryTest.class,
	ResourceTest.class})
public class V1AllTests
{
}
