package org.litespring.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.litespring.test.v1.V1AllTests;
import org.litespring.test.v2.V2AllTests;
import org.litespring.test.v3.V3AllTests;
import org.litespring.test.v4.V4AllTests;

/**
 * Created by xp-zhao on 2018/7/23.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        V1AllTests.class,
        V2AllTests.class,
        V3AllTests.class,
        V4AllTests.class})
public class AllTests {
}
