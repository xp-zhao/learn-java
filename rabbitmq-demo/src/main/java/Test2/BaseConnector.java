package Test2;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Created by xp-zhao on 2017/11/28.
 */
public class BaseConnector
{
	protected Channel channel;
	protected Connection connection;
	protected String queueName;

	public BaseConnector(String queueName)
	{
		this.queueName = queueName;
		try
		{
			//打开连接
			ConnectionFactory factory = new ConnectionFactory();
			// 设置 rabbitmq 所在的主机 ip
			factory.setHost("127.0.0.1");
			// 创建连接(tcp 连接)
			connection = factory.newConnection();
			// 创建频道|通道（虚拟连接）
			channel = connection.createChannel();
			// 声明创建队列
			channel.queueDeclare(queueName,false,false,false,null);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
