package org.smallspring.core.io;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2021-7-14
 **/
public interface ResourceLoader {

  String CLASSPATH_URL_PREFIX = "classpath:";

  Resource getResource(String location);
}
