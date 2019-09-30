package com.xp.math;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Data.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/09/23
 **/
public class Data {

  public static Pattern pattern = Pattern.compile("\\d+");

  public static void main(String[] args) {
    Matcher matcher = pattern.matcher("2006年12月第2版");
    while (matcher.find()) {
      System.out.println(matcher.group());
    }
    System.out.println("2006".substring(2));
    System.out.println("".split("/")[0]);
    String str = "English Immershion Textbook For Preschool Children";
    System.out.println(str.length());
  }


  private List<BookBean> book;
  private List<AssistantBean> assistant;
  private List<ThematicBean> thematic;
  private List<KnowledgeChapterBean> knowledge_chapter;

  public List<BookBean> getBook() {
    return book;
  }

  public void setBook(List<BookBean> book) {
    this.book = book;
  }

  public List<AssistantBean> getAssistant() {
    return assistant;
  }

  public void setAssistant(List<AssistantBean> assistant) {
    this.assistant = assistant;
  }

  public List<ThematicBean> getThematic() {
    return thematic;
  }

  public void setThematic(List<ThematicBean> thematic) {
    this.thematic = thematic;
  }

  public List<KnowledgeChapterBean> getKnowledge_chapter() {
    return knowledge_chapter;
  }

  public void setKnowledge_chapter(List<KnowledgeChapterBean> knowledge_chapter) {
    this.knowledge_chapter = knowledge_chapter;
  }

  public static class BookBean {

  }

  public static class AssistantBean {

  }

  public static class ThematicBean {

  }

  public static class KnowledgeChapterBean {

  }
}