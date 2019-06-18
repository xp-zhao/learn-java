package server.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import protocol.request.JoinGroupRequestPacket;
import protocol.response.JoinGroupResponsePacket;
import util.SessionUtil;

/**
 * @description: 加入群聊请求处理器
 * @author: zhaoxiaoping
 * @create: 2019/06/18
 **/
public class JoinGroupRequestHandler extends SimpleChannelInboundHandler<JoinGroupRequestPacket> {

  @Override
  protected void channelRead0(ChannelHandlerContext ctx,
      JoinGroupRequestPacket packet) throws Exception {
    // 1. 获取群对应的 channelGroup, 然后将当前用户的 channel 添加进去
    String groupId = packet.getGroupId();
    ChannelGroup group = SessionUtil.getChannelGroup(groupId);
    group.add(ctx.channel());

    // 2. 构造加群响应发送给客户端
    JoinGroupResponsePacket responsePacket = new JoinGroupResponsePacket();
    responsePacket.setSuccess(true);
    responsePacket.setGroupId(groupId);
    ctx.channel().writeAndFlush(responsePacket);
  }
}