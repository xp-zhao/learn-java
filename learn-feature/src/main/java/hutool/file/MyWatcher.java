package hutool.file;

import cn.hutool.core.io.watch.Watcher;
import lombok.extern.slf4j.Slf4j;

import java.nio.file.Path;
import java.nio.file.WatchEvent;

/**
 * @author zhaoxiaoping
 * @date 2023-1-10
 */
@Slf4j
public class MyWatcher implements Watcher {
  @Override
  public void onCreate(WatchEvent<?> watchEvent, Path path) {
    Object context = watchEvent.context();
    log.info("创建: {} -> {}", path, context);
  }

  @Override
  public void onModify(WatchEvent<?> watchEvent, Path path) {
    Object context = watchEvent.context();
    log.info("修改: {} -> {}", path, context);
  }

  @Override
  public void onDelete(WatchEvent<?> watchEvent, Path path) {
    Object context = watchEvent.context();
    log.info("删除: {} -> {}", path, context);
  }

  @Override
  public void onOverflow(WatchEvent<?> watchEvent, Path path) {
    Object context = watchEvent.context();
    log.info("覆盖: {} -> {}", path, context);
  }
}
