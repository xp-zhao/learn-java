package client.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import protocol.response.GroupMessageResponsePacket;
import session.Session;

/**
 * @description: 群聊消息发送返回请求处理器
 * @author: zhaoxiaoping
 * @create: 2019/06/18
 **/
public class GroupMessageResponseHandler extends
    SimpleChannelInboundHandler<GroupMessageResponsePacket> {

  @Override
  protected void channelRead0(ChannelHandlerContext ctx,
      GroupMessageResponsePacket responsePacket) throws Exception {
    String fromGroupId = responsePacket.getFromGroupId();
    Session fromUser = responsePacket.getFromUser();
    System.out
        .println("收到群[" + fromGroupId + "]中[" + fromUser + "]发来的消息：" + responsePacket.getMessage());
  }
}