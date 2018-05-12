package rabbitmq.utils;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by xp-zhao on 2018/5/11.
 */
public class ConnectionUtil
{
	/**
	 * 获取 MQ 连接
	 * @return
	 */
	public static Connection getConnetion() throws IOException, TimeoutException
	{
		// 定义一个连接工厂
		ConnectionFactory factory = new ConnectionFactory();

		// 设置服务地址
		factory.setHost("127.0.0.1");

		// 设置端口
		factory.setPort(5672);

		// 设置 vhost
		factory.setVirtualHost("/");

		// 设置用户名
		factory.setUsername("guest");
		// 设置密码
		factory.setPassword("guest");
		return factory.newConnection();
	}
}
