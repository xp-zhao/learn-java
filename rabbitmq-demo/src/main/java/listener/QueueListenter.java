package listener;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import model.TaskNotice;
import model.TaskReport;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import utils.SpringUtils;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * Created by xp-zhao on 2018/3/23.
 */
public class QueueListenter implements MessageListener
{
	@Override
	public void onMessage(Message message)
	{
		String messageBody = new String(message.getBody());
		JSONObject object = JSON.parseObject(messageBody);
		TaskNotice taskNotice = JSONObject.toJavaObject(object,TaskNotice.class);
		System.out.println("recv : "+taskNotice);
		try
		{
			TimeUnit.SECONDS.sleep(2);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		TaskReport taskReport = new TaskReport();
		taskReport.setLogid(taskNotice.getLogid());
		taskReport.setCode("1");
		taskReport.setHosts(Arrays.asList("localhost"));
		taskReport.setDesc("执行成功");
		RabbitTemplate template = SpringUtils.getBean(RabbitTemplate.class);
		String routingKey = MessageFormat.format("task.report.{0}.{1}",taskNotice.getGroupCode(),taskNotice.getTaskCode());
		template.convertAndSend(routingKey,taskReport);
		System.out.println("send : "+taskReport);
	}
}
