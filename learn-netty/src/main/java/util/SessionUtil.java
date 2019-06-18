package util;

import attribute.Attributes;
import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
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

  private static final Map<String, ChannelGroup> groupIdChannelGroupMap = new ConcurrentHashMap<>();

  public static void bindSession(Session session, Channel channel) {
    userIdChannelMap.put(session.getUserId(), channel);
    channel.attr(Attributes.SESSION).set(session);
  }

  public static void unBindSession(Channel channel) {
    if (hasLogin(channel)) {
      userIdChannelMap.remove(getSession(channel).getUserId());
      channel.attr(Attributes.SESSION).set(null);
      System.out.println("退出登录");
    }
  }

  public static boolean hasLogin(Channel channel) {
//    return channel.hasAttr(Attributes.SESSION);
    return getSession(channel) != null;
  }

  public static Session getSession(Channel channel) {
    return channel.attr(Attributes.SESSION).get();
  }

  public static Channel getChannel(String userId) {
    return userIdChannelMap.get(userId);
  }

  public static void bindChannelGroup(String groupId, ChannelGroup channelGroup) {
    groupIdChannelGroupMap.put(groupId, channelGroup);
  }

  public static ChannelGroup getChannelGroup(String groupId) {
    return groupIdChannelGroupMap.get(groupId);
  }
}