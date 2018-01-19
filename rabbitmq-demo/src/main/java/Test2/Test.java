package Test2;

import java.io.IOException;

/**
 * Created by xp-zhao on 2017/11/28.
 */
public class Test
{
	public static void main(String[] args) throws IOException
	{
		Receiver receiver = new Receiver("testQueue");
		Thread thread = new Thread(receiver);
		thread.start();
		Sender sender = new Sender("testQueue");
		for(int i = 0; i < 5; i++)
		{
			MessageInfo info = new MessageInfo();
			info.setChannel("test");
			info.setContent("msg"+i);
			sender.sendMessage(info);
		}
	}
}
