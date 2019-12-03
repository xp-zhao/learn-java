package org.litespring.test.v4;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ ApplicationContextTestV4.class, AutowiredAnnotationProcessorTest.class,
        ClassPathBeanDefinitionScannerTest.class, ClassReaderTest.class, DependencyDescriptorTest.class,
        InjectionMetadataTest.class, MetadataReaderTest.class, PackageResourceLoaderTest.class,
        XmlBeanDefinitionReaderTest.class })
public class V4AllTests {
}
