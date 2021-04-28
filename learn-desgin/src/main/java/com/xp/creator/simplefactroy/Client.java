package com.xp.creator.simplefactroy;

/**
 * Created by xp-zhao on 2018/9/30.
 */
public class Client {

  public static void main(String[] args) {
    SimpleFactory factory = new SimpleFactory();
    Product product = factory.createProduct(1);
  }
}
