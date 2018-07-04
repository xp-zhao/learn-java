package rabbitmq.spring.listener;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import rabbitmq.model.User;

import java.io.UnsupportedEncodingException;

/**
 * Created by xp-zhao on 2018/5/12.
 */
public class QueueListener implements MessageListener
{
	@Override
	public void onMessage(Message message)
	{
		String messageBody = null;
		try
		{
			messageBody = new String(message.getBody(),"utf-8");
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		JSONObject object = JSON.parseObject(messageBody);
		User user = JSONObject.toJavaObject(object,User.class);
		System.out.println("recv : " + user );
	}
}
