package video;

import java.io.File;
import ws.schild.jave.EncoderException;
import ws.schild.jave.MultimediaObject;
import ws.schild.jave.ScreenExtractor;

/**
 * @author zhaoxiaoping
 * @Description: 视频解析测试
 * @Date 2020-5-27
 **/
public class VideoTest {

  public static void main(String[] args) throws EncoderException {
    File file = new File("D:\\data\\video.mp4");
    File outputFile = new File("D:\\data\\video.jpg");
    MultimediaObject obj = new MultimediaObject(file);
    ScreenExtractor instance = new ScreenExtractor();
    instance.renderOneImage(obj, -1, -1, 0, outputFile, 1);
  }
}
