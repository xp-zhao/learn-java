package client.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import protocol.response.LogoutResponsePacket;
import util.SessionUtil;

/**
 * @description: 登出请求响应处理器
 * @author: zhaoxiaoping
 * @create: 2019/06/18
 **/
public class LogoutResponseHandler extends SimpleChannelInboundHandler<LogoutResponsePacket> {

  @Override
  protected void channelRead0(ChannelHandlerContext channelHandlerContext,
      LogoutResponsePacket logoutResponsePacket) throws Exception {
    SessionUtil.unBindSession(channelHandlerContext.channel());
  }
}