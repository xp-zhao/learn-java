package concurrent.example;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author xp-zhao
 */
public class FileHandler {
    public static void main(String[] args) {
        LocalTime start = LocalTime.now();
        List<String> fileList = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            fileList.add(String.valueOf(i));
        }
        // 对文件进行压缩
        fileList.forEach(item -> sleep(1));
        for (String s : fileList) {
            // 切图
            sleep(1);
            // 保存数据库
            sleep(1);
            // 上传阿里云
            sleep(1);
        }
        LocalTime end = LocalTime.now();
        Duration duration = Duration.between(start, end);
        System.out.println(duration.getSeconds());
    }

    public static void sleep(long time){
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
