package org.example.register;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.example.common.URL;

/**
 * 模拟远程注册中心（真实项目中一般使用 Redis, zookeeper等）
 *
 * @author zhaoxiaoping
 * @date 2023-10-10
 */
public class MapRemoteRegister {
  private static Map<String, List<URL>> map = new HashMap<>();

  public static void register(String interfaceName, URL url) {
    map.computeIfAbsent(interfaceName, key -> new ArrayList<>()).add(url);
    saveFile();
  }

  public static List<URL> get(String interfaceName) {
    map = getFile();
    return map.get(interfaceName);
  }

  private static void saveFile() {
    try {
      FileOutputStream fileOutputStream = new FileOutputStream("/temp.txt");
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
      objectOutputStream.writeObject(map);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private static Map<String, List<URL>> getFile() {
    try {
      FileInputStream fileInputStream = new FileInputStream("/temp.txt");
      ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
      return (Map<String, List<URL>>) objectInputStream.readObject();
    } catch (IOException | ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}
