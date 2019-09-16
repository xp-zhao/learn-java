package com.xp.html;

import com.alibaba.fastjson.JSONObject;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import java.util.List;
import java.util.stream.Collectors;
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
    String str = "<p>Parsed HTML into a doc.</p>";
    Document doc = Jsoup.parse(str);
    List<String> tags = doc.ownerDocument().getAllElements().stream()
        .map(item -> item.tagName())
        .collect(Collectors.toList());
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
    String string = "{\"editorParam\":{\"resourceId\":\"1126320923385929730\",\"icomId\":1003,\"resourceContent\":{\"version\":1,\"template\":\"INDEFINITE_CHOICE_TEMPLATE\",\"prompt\":\"下列说法正确的是（）\",\"body\":{\"options\":[{\"option\":\"A\",\"value\":\"<pinyin direction=\"vertical\" ch='格' py='ge'>1</pinyin>1+1=2\"},{\"option\":\"B\",\"value\":\"2+2=4\"},{\"option\":\"C\",\"value\":\"3+2=6\"},{\"option\":\"D\",\"value\":\"4+4=6\"}]},\"answer\":{\"value\":[\"A\",\"B\"]},\"tip\":\"提示..\",\"explanation\":\"解析..\",\"comment\":\"点评..\",\"extra\":{\"optionMode\":0}},\"resourceFiles\":[],\"resourceInfo\":{\"version\":1,\"resourceType\":\"1\",\"org\":{\"id\":\"1\"},\"attr\":{\"subject\":{\"id\":\"1\"},\"period\":{\"id\":\"1\"},\"ability\":[{\"id\":\"1\"}],\"difficulty\":{\"id\":\"1\"},\"skill\":[{\"id\":\"1\"}],\"cognitiveDimension\":[{\"id\":\"1\"}],\"applicationScene\":{\"id\":\"1\"},\"source\":{\"id\":\"1148540032433287169\"},\"recommendLevel\":4.5},\"relations\":{\"textbook\":[{\"id\":\"1\",\"chapter\":[{\"id\":\"336\"}]}],\"assistant\":[{\"id\":\"1\",\"chapter\":[{\"id\":\"132\"}]}],\"thematic\":[{\"id\":\"3\",\"chapter\":[{\"id\":\"94\"}]}],\"knowledgePoint\":[{\"id\":\"4\",\"kpSystemId\":\"18\"}]},\"extend\":{\"timeConsume\":180,\"tags\":[{\"id\":\"1148545757096210434\"}]}}},\"businessParam\":{\"useScene\":\"1\",\"shareStatus\":1,\"inputType\":1,\"taskId\":\"11111\",\"questionTypeId\":\"1148546069823516673\"}}";
    Document document1 = Jsoup.parse(string);
    Elements elements1 = document1.getAllElements();
    JSONObject object = JSONObject.parseObject(string);

    System.out.println(document1.getAllElements().stream().map(item -> item.tagName())
        .collect(Collectors.toList()));

  }
}