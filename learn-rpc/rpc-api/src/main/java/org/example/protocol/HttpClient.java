package org.example.protocol;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.commons.io.IOUtils;
import org.example.common.Invocation;

/**
 * @author xp-zhao
 * @description
 * @date 2023/10/9 23:21
 */
public class HttpClient {
  public String send(String hostname, Integer port, Invocation invocation) {
    // 读取用户配置
    try {
      URL url = new URL("http", hostname, port, "/");
      HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

      httpURLConnection.setRequestMethod("POST");
      httpURLConnection.setDoOutput(true);

      OutputStream outputStream = httpURLConnection.getOutputStream();
      ObjectOutputStream oos = new ObjectOutputStream(outputStream);

      oos.writeObject(invocation);
      oos.flush();
      oos.close();

      InputStream inputStream = httpURLConnection.getInputStream();
      String result = IOUtils.toString(inputStream);
      return result;
    } catch (Exception e) {

    }
    return null;
  }
}
