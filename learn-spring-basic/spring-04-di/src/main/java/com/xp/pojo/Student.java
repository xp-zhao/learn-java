package com.xp.pojo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2020-9-9
 **/
public class Student {

  private String name;
  private Address address;
  private String[] books;
  private List<String> hobby;
  private Map<String, String> card;
  private Set<String> games;
  private Properties info;
  private String wife;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public String[] getBooks() {
    return books;
  }

  public void setBooks(String[] books) {
    this.books = books;
  }

  public List<String> getHobby() {
    return hobby;
  }

  public void setHobby(List<String> hobby) {
    this.hobby = hobby;
  }

  public Map<String, String> getCard() {
    return card;
  }

  public void setCard(Map<String, String> card) {
    this.card = card;
  }

  public Set<String> getGames() {
    return games;
  }

  public void setGames(Set<String> games) {
    this.games = games;
  }

  public Properties getInfo() {
    return info;
  }

  public void setInfo(Properties info) {
    this.info = info;
  }

  public String getWife() {
    return wife;
  }

  public void setWife(String wife) {
    this.wife = wife;
  }

  @Override
  public String toString() {
    return "Student{" +
        "name='" + name + '\'' +
        ", address=" + address +
        ", books=" + Arrays.toString(books) +
        ", hobby=" + hobby +
        ", card=" + card +
        ", games=" + games +
        ", info=" + info +
        ", wife='" + wife + '\'' +
        '}';
  }
}
