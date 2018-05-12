package rabbitmq.tx;

import com.rabbitmq.client.*;
import rabbitmq.utils.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by xp-zhao on 2018/5/12.
 */
public class TxRecv
{
	private static final String QUEUE_NAME = "test_queue_tx";

	public static void main(String[] args) throws IOException, TimeoutException
	{
		Connection connection = ConnectionUtil.getConnetion();
		Channel channel = connection.createChannel();
		channel.queueDeclare(QUEUE_NAME,false,false,false,null);

		channel.basicConsume(QUEUE_NAME,true,new DefaultConsumer(channel){
			@Override public void handleDelivery(String consumerTag , Envelope envelope ,
				AMQP.BasicProperties properties , byte[] body) throws IOException
			{
				System.out.println("[recv[tx]] msg:"+new String(body,"utf-8"));
			}
		});
	}
}
