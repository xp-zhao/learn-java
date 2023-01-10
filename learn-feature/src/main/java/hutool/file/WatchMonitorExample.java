package hutool.file;

import cn.hutool.core.io.file.Tailer;
import cn.hutool.core.io.watch.WatchMonitor;

import java.io.File;

/**
 * 文件变动监听
 *
 * @author zhaoxiaoping
 * @date 2023-1-10
 */
public class WatchMonitorExample {
  public static void main(String[] args) {
    File file = new File("D:\\temp\\test.txt");
    WatchMonitor watchMonitor = new WatchMonitor(file, WatchMonitor.ENTRY_MODIFY);
    watchMonitor.setWatcher(new MyWatcher());
    watchMonitor.setMaxDepth(3);
    watchMonitor.start();
    // 监听文件最后部分的变化
    Tailer tailer = new Tailer(file, new MyLineHandler());
    tailer.start();
  }
}
