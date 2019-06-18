package server.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import java.util.ArrayList;
import java.util.List;
import protocol.request.ListGroupMembersRequestPacket;
import protocol.response.ListGroupMembersResponsePacket;
import session.Session;
import util.SessionUtil;

/**
 * @description: 获取成员列表请求处理器
 * @author: zhaoxiaoping
 * @create: 2019/06/18
 **/
public class ListGroupMembersRequestHandler extends
    SimpleChannelInboundHandler<ListGroupMembersRequestPacket> {

  @Override
  protected void channelRead0(ChannelHandlerContext ctx,
      ListGroupMembersRequestPacket requestPacket) throws Exception {
    // 1. 获取群的 ChannelGroup
    String groupId = requestPacket.getGroupId();
    ChannelGroup group = SessionUtil.getChannelGroup(groupId);

    // 2. 遍历群成员的 channel，对应的 session，构造群成员的信息
    List<Session> sessionList = new ArrayList<>();
    for (Channel channel : group) {
      Session session = SessionUtil.getSession(channel);
      sessionList.add(session);
    }

    // 3. 构建获取成员列表响应写回到客户端
    ListGroupMembersResponsePacket responsePacket = new ListGroupMembersResponsePacket();
    responsePacket.setGroupId(groupId);
    responsePacket.setSessionList(sessionList);
    ctx.channel().writeAndFlush(responsePacket);
  }
}