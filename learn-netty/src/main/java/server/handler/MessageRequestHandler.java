package server.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import protocol.request.MessageRequestPacket;
import protocol.response.MessageResponsePacket;
import session.Session;
import util.SessionUtil;

/**
 * @description: 消息处理逻辑处理器
 * @author: zhaoxp
 * @create: 2019/05/31
 **/
public class MessageRequestHandler extends SimpleChannelInboundHandler<MessageRequestPacket> {

  @Override
  protected void channelRead0(ChannelHandlerContext channelHandlerContext,
      MessageRequestPacket messageRequestPacket) throws Exception {
    // 1.拿到消息发送方的对话信息
    Session session = SessionUtil.getSession(channelHandlerContext.channel());

    // 2.通过消息发送方的会话信息构造要发送的信息
    MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
    messageResponsePacket.setFromUserId(session.getUserId());
    messageResponsePacket.setFromUserName(session.getUserName());
    messageResponsePacket.setMessage(messageRequestPacket.getMessage());

    // 3.拿到消息接收方的 channel
    Channel toUserChannel = SessionUtil.getChannel(messageRequestPacket.getToUserId());

    // 4.将消息发送给消息接收方
    if (toUserChannel != null && SessionUtil.hasLogin(toUserChannel)) {
      toUserChannel.writeAndFlush(messageResponsePacket);
    } else {
      System.err.println("[" + messageRequestPacket.getToUserId() + "] 不在线，发送失败!");
    }
//    System.out.println(new Date() + ": 收到客户端消息: " + messageRequestPacket.getMessage());
//    messageResponsePacket.setMessage("服务端回复【" + messageRequestPacket.getMessage() + "】");

//    channelHandlerContext.channel().writeAndFlush(messageResponsePacket);
  }
}