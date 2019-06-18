package server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import protocol.request.LogoutRequestPacket;
import protocol.response.LogoutResponsePacket;
import util.SessionUtil;

/**
 * @description: 登出请求处理器
 * @author: zhaoxiaoping
 * @create: 2019/06/18
 **/
public class LogoutRequestHandler extends SimpleChannelInboundHandler<LogoutRequestPacket> {

  @Override
  protected void channelRead0(ChannelHandlerContext ctx,
      LogoutRequestPacket logoutRequestPacket) throws Exception {
    SessionUtil.unBindSession(ctx.channel());
    LogoutResponsePacket logoutResponsePacket = new LogoutResponsePacket();
    logoutResponsePacket.setSuccess(true);
    ctx.channel().writeAndFlush(logoutResponsePacket);
  }
}