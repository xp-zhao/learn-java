package label;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.http.HtmlUtil;
import java.util.List;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import label.DocumentConstant.Label;
import label.DocumentConstant.LabelEnum;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Document.OutputSettings;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;

/**
 * @author zhaoxiaoping
 * @Description: 标签转换工具类
 * @Date 2020-6-28
 **/
public class LabelConvertUtil {

  public static String boldConvert(String content) {
    if (StringUtils.isBlank(content) || !content.contains(LabelEnum.BOLD.getSource())) {
      return content;
    }
    StringJoiner sourceBegin = new StringJoiner(LabelEnum.BOLD.getSource(), "<", ">");
    StringJoiner targetBegin = new StringJoiner(LabelEnum.BOLD.getTarget(), "<", ">");
    StringJoiner sourceEnd = new StringJoiner(LabelEnum.BOLD.getSource(), "</", ">");
    StringJoiner targetEnd = new StringJoiner(LabelEnum.BOLD.getTarget(), "</", ">");
    String result = content.replaceAll(sourceBegin.toString(), targetBegin.toString());
    result.replaceAll(sourceEnd.toString(), targetEnd.toString());
    return result;
  }

  public static String italicConvert(String content) {
    if (StringUtils.isBlank(content) || !content.contains(LabelEnum.ITALIC.getSource())) {
      return content;
    }
    return commonConvert(content, LabelEnum.ITALIC);
  }

  public static String spotConvert(String content) {
    if (StringUtils.isBlank(content) || !content.contains(LabelEnum.SPOT.getSource())) {
      return content;
    }
    String str = commonConvert(content, LabelEnum.SPOT);
    // 加点标记需要针对每个字拆分加点，<spot>测试</spot> -> <spot>测</spot><spot>试</spot>
    String regex = "(<spot>.*?</spot>)";
    Matcher matcher = Pattern.compile(regex).matcher(str);
    while (matcher.find()) {
      String group = matcher.group(0);
      String removeHtmlTag = HtmlUtil.unwrapHtmlTag(group, LabelEnum.SPOT.getTarget());
      String before = "";
      for (int i = 0; i < removeHtmlTag.length(); i++) {
        char c = removeHtmlTag.charAt(i);
        before += String.format("<spot>%s</spot>", c);
      }
      str = str.replaceAll(group, before);
    }
    return str;
  }

  public static String wavelineConvert(String content) {
    if (StringUtils.isBlank(content) || !content.contains(LabelEnum.WAVYLINE.getSource())) {
      return content;
    }
    String str = commonConvert(content, LabelEnum.WAVYLINE);
    // 波浪线标记需要针对每个字拆分加点，<waveline>测试</waveline> -> <waveline>测</waveline><waveline>试</waveline>
    String regex = "(<waveline>.*?</waveline>)";
    Matcher matcher = Pattern.compile(regex).matcher(str);
    while (matcher.find()) {
      String group = matcher.group(0);
      String removeHtmlTag = HtmlUtil.unwrapHtmlTag(group, LabelEnum.WAVYLINE.getTarget());
      String before = "";
      for (int i = 0; i < removeHtmlTag.length(); i++) {
        char c = removeHtmlTag.charAt(i);
        before += String.format("<waveline>%s</waveline>", c);
      }
      str = str.replaceAll(group, before);
    }
    return str;
  }

  public static String underlineConvert(String content) {
    if (StringUtils.isBlank(content) || !content.contains(LabelEnum.UNDERLINE.getSource())) {
      return content;
    }
    String str = commonConvert(content, LabelEnum.UNDERLINE);
    // 下划线标记需要针对每个字拆分加点，<u>测试</u> -> <u>测</u><u>试</u>
    String regex = "(<u>.*?</u>)";
    Matcher matcher = Pattern.compile(regex).matcher(str);
    while (matcher.find()) {
      String group = matcher.group(0);
      String removeHtmlTag = HtmlUtil.unwrapHtmlTag(group, LabelEnum.UNDERLINE.getTarget());
      String before = "";
      for (int i = 0; i < removeHtmlTag.length(); i++) {
        char c = removeHtmlTag.charAt(i);
        before += String.format("<u>%s</u>", c);
      }
      str = str.replaceAll(group, before);
    }
    return str;
  }

  public static String alignConvert(String content) {
    Document document = Jsoup.parse(content);
    String str = content;
    OutputSettings settings = new OutputSettings();
    settings.prettyPrint(false);
    document = document.outputSettings(settings);
    for (String item : LabelEnum.ALIGN.getSources()) {
      Elements select = document.select(item);
      if (ObjectUtil.isNull(select) || select.isEmpty()) {
        continue;
      }
      select.tagName(LabelEnum.ALIGN.getTarget());
      if (Label.MIDDLE.equals(item)) {
        select.attr("type", "center");
      }
      if (Label.RIGHT.equals(item)) {
        select.attr("type", "right");
      }
      str = format(select, document);
    }
    return str;
  }

  public static String fontColorConvert(String content) {
    Document document = Jsoup.parse(content);
    String str = content;
    OutputSettings settings = new OutputSettings();
    settings.prettyPrint(false);
    document.outputSettings(settings);
    for (String item : LabelEnum.FONT_COLOR.getSources()) {
      Elements select = document.select(item);
      if (ObjectUtil.isNull(select) || select.isEmpty()) {
        continue;
      }
      select.tagName(LabelEnum.FONT_COLOR.getTarget());
      select.attr("color", item);
      str = format(select, document);
    }
    return str;
  }

  public static String allLabelConvert(String content) {
    content = boldConvert(content);
    content = italicConvert(content);
    content = spotConvert(content);
    content = wavelineConvert(content);
    content = underlineConvert(content);
    content = alignConvert(content);
    content = fontColorConvert(content);
    return content;
  }

  private static String commonConvert(String content, LabelEnum label) {
    Document document = Jsoup.parse(content);
    OutputSettings settings = new OutputSettings();
    settings.prettyPrint(false);
    document.outputSettings(settings);
    Elements select = document.select(label.getSource());
    if (ObjectUtil.isNull(select) || select.isEmpty()) {
      return content;
    }
    select.tagName(label.getTarget());
    return format(select, document);
  }

  private static String format(Elements select, Document document) {
    List<String> align = LabelEnum.ALIGN.getSources();
    List<String> colors = LabelEnum.FONT_COLOR.getSources();
    Whitelist whitelist = Whitelist.basic()
        .addTags(LabelEnum.SPOT.getTarget(), LabelEnum.WAVYLINE.getTarget(),
            LabelEnum.BOLD.getTarget(), LabelEnum.ITALIC.getTarget(),
            LabelEnum.UNDERLINE.getTarget(), LabelEnum.FONT_COLOR.getTarget())
        .addTags(LabelEnum.SPOT.getSource(), LabelEnum.WAVYLINE.getSource(),
            LabelEnum.BOLD.getSource(), LabelEnum.ITALIC.getSource(),
            LabelEnum.UNDERLINE.getSource(), LabelEnum.ALIGN.getTarget())
        .addTags(align.toArray(new String[align.size()]))
        .addTags(colors.toArray(new String[colors.size()]))
        .addAttributes(LabelEnum.ALIGN.getTarget(), "type")
        .addAttributes(LabelEnum.FONT_COLOR.getTarget(), "color");
    OutputSettings outputSettings = new OutputSettings();
    outputSettings.prettyPrint(false);
    String str = document.outputSettings(outputSettings).outerHtml();
    return Jsoup.clean(str, "", whitelist, outputSettings);
  }
}
