package com.xp.html;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * JsoupDemo.java html 解析
 *
 * @author: zhaoxiaoping
 * @date: 2019/08/27
 **/
public class JsoupDemo {

  public static void main(String[] args) {
    String html = "<html><head><title>First parse</title></head>"
        + "<body><p>Parsed HTML into a doc.</p></body></html>";
    Document document = Jsoup.parse(html);
    for (Element allElement : document.getAllElements()) {
      System.out.println(allElement.tagName());
    }
    Elements childs = document.children();
    for (Element child : childs) {
      System.out.println(child.tag().getName());
    }
    Elements elements = document.select("title");
    Element body = document.body();
    for (Element element : elements) {
      System.out.println(element.html());
    }
    System.out.println(body.select("p").html());
  }
}