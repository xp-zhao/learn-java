package Test2;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by xp-zhao on 2017/11/28.
 */
@Data
@ToString
public class MessageInfo implements Serializable
{
	private static final long serialVersionUID = 2459505844278669234L;
	private String channel;
	private String content;
}
