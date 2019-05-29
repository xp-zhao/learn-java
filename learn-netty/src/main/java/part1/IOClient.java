package part1;

import java.net.Socket;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by xp-zhao on 2018/11/26.
 */
public class IOClient {

  public static void main(String[] args) {
    new Thread(() -> {
      try {
        Socket socket = new Socket("127.0.0.1", 8000);
        while (true) {
          try {
            socket.getOutputStream().write((new Date() + ": hello world").getBytes());
            TimeUnit.SECONDS.sleep(2);
          } catch (Exception e) {
            System.out.println();
            e.printStackTrace();
          }
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }).start();
  }
}
