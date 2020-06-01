package com.xp.generate.v2;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * @author zhaoxiaoping
 * @Description: 随机 id 生成器
 * @Date 2020-6-1
 **/
public class RandomIdGenerator implements IdGenerator {

  @Override
  public String generate() {
    return null;
  }

  private String getLastfieldOfHostName() {
    String substrOfHostName = null;
    try {
      String hostName = InetAddress.getLocalHost().getHostName();
      String[] tokens = hostName.split("\\.");
      substrOfHostName = tokens[tokens.length - 1];
      return substrOfHostName;
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }
    return substrOfHostName;
  }

  private String generateRandomAlphameric(int length) {
    char[] randomChars = new char[length];
    int count = 0;
    Random random = new Random();
    while (count < length) {
      int maxAscii = 'z';
      int randomAscii = random.nextInt(maxAscii);
      boolean isDigit = randomAscii >= '0' && randomAscii <= '9';
      boolean isUppercase = randomAscii >= 'A' && randomAscii <= 'Z';
      boolean isLowercase = randomAscii >= 'a' && randomAscii <= 'z';
      if (isDigit || isUppercase || isLowercase) {
        randomChars[count] = (char) (randomAscii);
        ++count;
      }
    }
    return new String(randomChars);
  }
  
  
}
