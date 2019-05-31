package client.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import java.util.Date;
import protocol.response.MessageResponsePacket;

/**
 * @description: 消息响应处理器
 * @author: zhaoxp
 * @create: 2019/05/31
 **/
public class MessageResponseHandler extends SimpleChannelInboundHandler<MessageResponsePacket> {

  @Override
  protected void channelRead0(ChannelHandlerContext channelHandlerContext,
      MessageResponsePacket messageResponsePacket) throws Exception {
    System.out.println(new Date() + ": 收到服务端的消息: " + messageResponsePacket.getMessage());
  }
}