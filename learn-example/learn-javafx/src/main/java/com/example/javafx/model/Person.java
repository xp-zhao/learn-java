package com.example.javafx.model;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date
 **/
public class Person {

  private SimpleIntegerProperty id;
  private SimpleStringProperty name;
  private SimpleBooleanProperty isEmployed;

  public Person(Integer id, String name, boolean isEmployed) {
    this.id = new SimpleIntegerProperty(id);
    this.name = new SimpleStringProperty(name);
    this.isEmployed = new SimpleBooleanProperty(isEmployed);
  }

  public int getId() {
    return id.get();
  }

  public SimpleIntegerProperty idProperty() {
    return id;
  }

  public void setId(int id) {
    this.id.set(id);
  }

  public String getName() {
    return name.get();
  }

  public SimpleStringProperty nameProperty() {
    return name;
  }

  public void setName(String name) {
    this.name.set(name);
  }

  public boolean isIsEmployed() {
    return isEmployed.get();
  }

  public SimpleBooleanProperty isEmployedProperty() {
    return isEmployed;
  }

  public void setIsEmployed(boolean isEmployed) {
    this.isEmployed.set(isEmployed);
  }
}
