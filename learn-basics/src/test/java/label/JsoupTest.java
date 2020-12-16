package label;

import cn.hutool.http.HtmlUtil;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import label.DocumentConstant.LabelEnum;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;
import org.junit.Test;

/**
 * @author zhaoxiaoping
 * @Description: Jsoup 测试
 * @Date 2020-6-28
 **/
public class JsoupTest {

  public static void main(String[] args) {
    String text = "我是测试<加点>文档</加点>";
    Document parse = Jsoup.parse("我是测试<加点>文档</加点>");
    Elements select = parse.select("加点");
    select.tagName("spot");
    for (Element element : select) {
      element.replaceWith(new TextNode(element.toString()));
    }
    System.out.println(Jsoup.clean(parse.outerHtml(), Whitelist.basic())
        .replaceAll(" &lt;", "<")
        .replaceAll("&lt;", "<")
        .replaceAll("&gt; ", ">")
        .replaceAll("&gt;", ">"));
  }

  @Test
  public void testAllLabel() {
    String text = "我是测试<blue>文档</blue>";
    text = "<sup>我是上标</sup>上标\n"
        + "<sub>我是下标</sub>下标\n"
        + "<粗体>我是粗体</粗体>粗体标记\n"
        + "<斜体>我是斜体</斜体>斜体标记\n"
        + "<red>我是红色</red>红色标记\n"
        + "<blue>我是蓝色</blue>蓝色标记\n"
        + "<orange>我是橙色</orange>橙色标记\n"
        + "<yellow>我是黄色</yellow>黄色标记\n"
        + "<green>我是绿色</green>绿色标记\n"
        + "<加点>我加点</加点>加点标记\n"
        + "<下划线>我加下划线</下划线>下划线标记\n"
        + "<波浪线>我加波浪线</波浪线>波浪线标记\n"
        + "<middle>我居中</middle>居中  \n"
        + "<right>我靠右</right>靠右";
    String result = LabelConvertUtil.allLabelConvert(text);
    System.out.println(result);
//    Assert.assertTrue(result.equals("我是测试<font color=\"blue\">文档</font>"));
  }

  @Test
  public void testWrap() {
    String str = "<red>红色</red><spot>测试场</spot>";
    String regex = "(<spot>..+</spot>)";
    Matcher matcher = Pattern.compile(regex).matcher(str);
    while (matcher.find()) {
      String group = matcher.group(1);
      String removeHtmlTag = HtmlUtil.unwrapHtmlTag(group, LabelEnum.SPOT.getTarget());
      String before = "";
      for (int i = 0; i < removeHtmlTag.length(); i++) {
        char c = removeHtmlTag.charAt(i);
        before += String.format("<spot>%s</spot>", c);
      }
      System.out.println(before);
      str = matcher.replaceFirst(before);
    }
    System.out.println(str);
  }


}