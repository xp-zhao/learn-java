package hutool.file;

import cn.hutool.core.io.LineHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoxiaoping
 * @date 2023-1-10
 */
@Slf4j
public class MyLineHandler implements LineHandler {
  @Override
  public void handle(String s) {
    log.info("变动内容: {}", s);
  }
}
