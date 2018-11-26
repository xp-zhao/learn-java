package part1;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by xp-zhao on 2018/11/26.
 */
public class IOServer{
	public static void main(String[] args) throws IOException{

		ServerSocket serverSocket = new ServerSocket(8000);

		new Thread(() -> {
			while(true){
				try {
					Socket socket = serverSocket.accept();
					new Thread(() -> {
						try{
							int len;
							byte[] data = new byte[1024];
							InputStream inputStream = socket.getInputStream();
							while((len = inputStream.read(data)) != -1){
								System.out.println(new String(data,0,len));
							}
						}catch (Exception e){
							e.printStackTrace();
						}
					}).start();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}).start();
	}
}
