package util;

import attribute.Attributes;
import io.netty.channel.Channel;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import session.Session;

/**
 * @description: session工具类
 * @author: zhaoxiaoping
 * @create: 2019/06/13
 **/
public class SessionUtil {

  // userId -> channel 的映射
  private static final Map<String, Channel> userIdChannelMap = new ConcurrentHashMap<>();

  public static void bindSession(Session session, Channel channel) {
    userIdChannelMap.put(session.getUserId(), channel);
    channel.attr(Attributes.SESSION).set(session);
  }

  public static void unBindSession(Channel channel) {
    if (hasLogin(channel)) {
      userIdChannelMap.remove(getSession(channel).getUserId());
      channel.attr(Attributes.SESSION).set(null);
    }
  }

  public static boolean hasLogin(Channel channel) {
    return channel.hasAttr(Attributes.SESSION);
  }

  public static Session getSession(Channel channel) {
    return channel.attr(Attributes.SESSION).get();
  }

  public static Channel getChannel(String userId) {
    return userIdChannelMap.get(userId);
  }
}