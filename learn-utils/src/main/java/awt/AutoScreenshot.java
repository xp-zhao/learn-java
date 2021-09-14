package awt;

import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @author zhaoxiaoping
 * @Description: 自动截图工具示例
 * @Date 2021-9-6
 **/
public class AutoScreenshot {
  public static void main(String[] args) throws IOException, URISyntaxException {
    Desktop.getDesktop().browse(new URL("https://www.baidu.com/").toURI());
    
  }
}
