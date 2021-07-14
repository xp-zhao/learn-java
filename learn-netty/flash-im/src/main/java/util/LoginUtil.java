package util;


import attribute.Attributes;
import io.netty.channel.Channel;
import io.netty.util.Attribute;

/**
 * @description: 登录工具类
 * @author: zhaoxp
 * @create: 2019/05/30
 **/
public class LoginUtil {

  public static void markAsLogin(Channel channel) {
    channel.attr(Attributes.LOGIN).set(true);
  }

  public static boolean hasLogin(Channel channel) {
    Attribute<Boolean> loginAtr = channel.attr(Attributes.LOGIN);
    return loginAtr.get() != null;
  }
}