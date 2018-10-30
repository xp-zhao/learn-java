package org.litespring.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.litespring.test.v1.ApplicationContextTest;
import org.litespring.test.v1.BeanFactoryTest;
import org.litespring.test.v1.ResourceTest;
import org.litespring.test.v1.V1AllTests;
import org.litespring.test.v2.V2AllTests;

/**
 * Created by xp-zhao on 2018/7/23.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses ({
	V1AllTests.class,
	V2AllTests.class})
public class AllTests
{
}
