package client.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import protocol.response.JoinGroupResponsePacket;

/**
 * @description: 加入群聊响应处理器
 * @author: zhaoxiaoping
 * @create: 2019/06/18
 **/
public class JoinGroupResponseHandler extends SimpleChannelInboundHandler<JoinGroupResponsePacket> {

  @Override
  protected void channelRead0(ChannelHandlerContext ctx,
      JoinGroupResponsePacket responsePacket) throws Exception {
    if (responsePacket.isSuccess()) {
      System.out.println("加入群[" + responsePacket.getGroupId() + "]成功!");
    } else {
      System.err
          .println("加入群[" + responsePacket.getGroupId() + "]失败，原因为：" + responsePacket.getReason());
    }
  }
}