package server.handler;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import protocol.request.HeartBeatRequestPacket;
import protocol.response.HeartBeatResponsePacket;

/**
 * @description: 心跳检测请求处理器
 * @author: zhaoxiaoping
 * @create: 2019/06/20
 **/
@Sharable
public class HeartBeatRequestHandler extends SimpleChannelInboundHandler<HeartBeatRequestPacket> {

  public static final HeartBeatRequestHandler INSTANCE = new HeartBeatRequestHandler();

  private HeartBeatRequestHandler() {

  }

  @Override
  protected void channelRead0(ChannelHandlerContext channelHandlerContext,
      HeartBeatRequestPacket heartBeatRequestPacket) throws Exception {
    channelHandlerContext.writeAndFlush(new HeartBeatResponsePacket());
  }
}