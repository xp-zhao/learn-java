package Test2;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;
import org.apache.commons.lang.SerializationUtils;

import java.io.IOException;

/**
 * Created by xp-zhao on 2017/11/28.
 */
public class Receiver extends BaseConnector implements Runnable,Consumer
{
	public Receiver(String queueName)
	{
		super(queueName);
	}

	public void run()
	{
		try
		{
			channel.basicConsume(queueName,true,this);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	// 当消费者注册完成自动调用
	public void handleConsumeOk(String s)
	{
		System.out.println("Consumer "+s+" registered");
	}

	// 当消费者接收到消息会自动调用
	public void handleDelivery(String s , Envelope envelope , AMQP.BasicProperties basicProperties , byte[] bytes)
		throws IOException
	{
		MessageInfo info = (MessageInfo) SerializationUtils.deserialize(bytes);
		System.out.println(info.toString());
	}

	public void handleCancelOk(String s)
	{
	}

	public void handleCancel(String s) throws IOException
	{
	}

	public void handleShutdownSignal(String s , ShutdownSignalException e)
	{
	}

	public void handleRecoverOk(String s)
	{
	}
}
