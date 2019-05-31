package server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import java.util.Date;
import protocol.request.MessageRequestPacket;
import protocol.response.MessageResponsePacket;

/**
 * @description: 消息处理逻辑处理器
 * @author: zhaoxp
 * @create: 2019/05/31
 **/
public class MessageRequestHandler extends SimpleChannelInboundHandler<MessageRequestPacket> {

  @Override
  protected void channelRead0(ChannelHandlerContext channelHandlerContext,
      MessageRequestPacket messageRequestPacket) throws Exception {
    MessageResponsePacket messageResponsePacket = new MessageResponsePacket();

    System.out.println(new Date() + ": 收到客户端消息: " + messageRequestPacket.getMessage());
    messageResponsePacket.setMessage("服务端回复【" + messageRequestPacket.getMessage() + "】");

    channelHandlerContext.channel().writeAndFlush(messageResponsePacket);
  }
}