package com.xp.generate.v1;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * @author zhaoxiaoping
 * @Description: id 生成器
 * @Date 2020-6-1
 **/
public class IdGenerator {

  public static void main(String[] args) {
    System.out.println(IdGenerator.generate());
  }
  
  public static String generate() {
    String id = "";
    try {
      String hostName = InetAddress.getLocalHost().getHostName();
      String[] tokens = hostName.split("\\.");
      if (tokens.length > 0) {
        hostName = tokens[tokens.length - 1];
      }
      char[] randomChars = new char[8];
      int count = 0;
      Random random = new Random();
      while (count < 8) {
        int randomAscii = random.nextInt(122);
        if (randomAscii >= 48 && randomAscii <= 57) {
          randomChars[count] = (char) ('0' + (randomAscii - 48));
          count++;
        } else if (randomAscii >= 65 && randomAscii <= 90) {
          randomChars[count] = (char) ('A' + (randomAscii - 65));
          count++;
        } else if (randomAscii >= 97 && randomAscii <= 122) {
          randomChars[count] = (char) ('a' + (randomAscii - 97));
          count++;
        }
      }
      id = String.format("%s-%d-%s", hostName,
          System.currentTimeMillis(), new String(randomChars));
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }
    return id;
  }
}
