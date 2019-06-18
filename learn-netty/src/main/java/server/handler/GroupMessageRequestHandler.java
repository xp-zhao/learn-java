package server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import protocol.request.GroupMessageRequestPacket;
import protocol.response.GroupMessageResponsePacket;
import util.SessionUtil;

/**
 * @description: 群聊消息发送请求处理器
 * @author: zhaoxiaoping
 * @create: 2019/06/18
 **/
public class GroupMessageRequestHandler extends
    SimpleChannelInboundHandler<GroupMessageRequestPacket> {

  @Override
  protected void channelRead0(ChannelHandlerContext ctx,
      GroupMessageRequestPacket requestPacket) throws Exception {
    // 1.拿到 groupId 构造群聊消息的响应
    String groupId = requestPacket.getToGroupId();

    GroupMessageResponsePacket responsePacket = new GroupMessageResponsePacket();
    responsePacket.setFromGroupId(groupId);
    responsePacket.setMessage(requestPacket.getMessage());
    responsePacket.setFromUser(SessionUtil.getSession(ctx.channel()));

    // 2. 拿到群聊对应的 channelGroup，写到每个客户端
    ChannelGroup group = SessionUtil.getChannelGroup(groupId);
    group.writeAndFlush(responsePacket);
  }
}