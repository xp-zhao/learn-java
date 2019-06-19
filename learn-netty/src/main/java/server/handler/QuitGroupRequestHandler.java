package server.handler;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import protocol.request.QuitGroupRequestPacket;
import protocol.response.QuitGroupResponsePacket;
import util.SessionUtil;

/**
 * @description: 退出群聊请求处理器
 * @author: zhaoxiaoping
 * @create: 2019/06/18
 **/
@Sharable
public class QuitGroupRequestHandler extends SimpleChannelInboundHandler<QuitGroupRequestPacket> {

  public static final QuitGroupRequestHandler INSTANCE = new QuitGroupRequestHandler();

  protected QuitGroupRequestHandler(){

  }

  @Override
  protected void channelRead0(ChannelHandlerContext ctx,
      QuitGroupRequestPacket requestPacket) throws Exception {
    // 1. 获取群对应的 channelGroup，然后将当前用户的 channel 移除
    String groupId = requestPacket.getGroupId();
    ChannelGroup group = SessionUtil.getChannelGroup(groupId);
    group.remove(ctx.channel());

    // 2. 构造退群响应发送给客户端
    QuitGroupResponsePacket responsePacket = new QuitGroupResponsePacket();
    responsePacket.setGroupId(groupId);
    responsePacket.setSuccess(true);
    ctx.channel().writeAndFlush(responsePacket);
  }
}