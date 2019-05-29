package part1;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by xp-zhao on 2018/11/26.
 */
public class IOServer {

  public static void main(String[] args) throws IOException {

    ServerSocket serverSocket = new ServerSocket(8000);
    // 接收新连接的线程
    new Thread(() -> {
      while (true) {
        try {
          // 阻塞方法获取新的连接
          Socket socket = serverSocket.accept();
          // 每一个新连接都创建一个线程，负责读取数据
          new Thread(() -> {
            try {
              int len;
              byte[] data = new byte[1024];
              InputStream inputStream = socket.getInputStream();
              // 按字节流的方式读取数据
              while ((len = inputStream.read(data)) != -1) {
                System.out.println(new String(data, 0, len));
              }
            } catch (Exception e) {
              e.printStackTrace();
            }
          }).start();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }).start();
  }
}
