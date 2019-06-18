package client.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import protocol.response.QuitGroupResponsePacket;

/**
 * @description: 退出群聊响应处理器
 * @author: zhaoxiaoping
 * @create: 2019/06/18
 **/
public class QuitGroupResponseHandler extends SimpleChannelInboundHandler<QuitGroupResponsePacket> {

  @Override
  protected void channelRead0(ChannelHandlerContext ctx,
      QuitGroupResponsePacket responsePacket) throws Exception {
    if (responsePacket.isSuccess()) {
      System.out.println("退出群聊[" + responsePacket.getGroupId() + "]成功！");
    } else {
      System.out.println("退出群聊[" + responsePacket.getGroupId() + "]失败！");
    }
  }
}