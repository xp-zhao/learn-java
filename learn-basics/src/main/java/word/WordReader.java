package word;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

/**
 * @author zhaoxiaoping
 * @Description: word 文档读取
 * @Date 2020-6-17
 **/
public class WordReader {

  private static Map<String, String> map = new HashMap<>();

  static {
    map.put("##出版社##", StringUtils.EMPTY);
    map.put("##主编##", StringUtils.EMPTY);
    map.put("##版次##", StringUtils.EMPTY);
    map.put("##印次##", StringUtils.EMPTY);
    map.put("##教辅品牌##", StringUtils.EMPTY);
  }

  public static void main(String[] args) throws IOException {
    String path = "D:\\data\\拍搜录题标准样例v1.0.0.docx";
    XWPFDocument doc = new XWPFDocument(new FileInputStream(path));
    List<XWPFParagraph> list = doc.getParagraphs();
    List<String> bookInfo = new ArrayList<>(map.size());
    String text = list.get(0).getText();
    if (!text.equals("@@书本信息@@")) {
      // 记录解析异常
    }
    for (int i = 1; i < list.size(); i++) {
      if (list.get(i).getText().equals("&&索引表&&")) {
        break;
      }
      bookInfo.add(list.get(i).getText());
    }
    System.out.println(bookInfo);
  }
}
