package Test2;

import org.apache.commons.lang.SerializationUtils;

import java.io.IOException;
import java.io.Serializable;

/**
 * Created by xp-zhao on 2017/11/28.
 */
public class Sender extends BaseConnector
{
	public Sender(String queueName)
	{
		super(queueName);
	}

	public void sendMessage(Serializable object) throws IOException
	{
		channel.basicPublish("",queueName,null, SerializationUtils.serialize(object));
	}
}
