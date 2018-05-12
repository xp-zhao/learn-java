package rabbitmq.spring.listener;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import rabbitmq.model.User;

/**
 * Created by xp-zhao on 2018/5/12.
 */
public class QueueListener implements MessageListener
{
	@Override
	public void onMessage(Message message)
	{
		String messageBody = new String(message.getBody());
		JSONObject object = JSON.parseObject(messageBody);
		User user = JSONObject.toJavaObject(object,User.class);
		System.out.println("recv : " + user );
	}
}
