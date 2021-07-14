package org.smallspring.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2021-7-14
 **/
public interface Resource {

  InputStream getInputStream() throws IOException;
}
