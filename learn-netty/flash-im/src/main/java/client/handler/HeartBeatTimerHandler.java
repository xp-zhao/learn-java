package client.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import java.util.concurrent.TimeUnit;
import protocol.request.HeartBeatRequestPacket;

/**
 * @description: 心跳检测处理器
 * @author: zhaoxiaoping
 * @create: 2019/06/20
 **/
public class HeartBeatTimerHandler extends ChannelInboundHandlerAdapter {

  public static final int HEARTBEAT_INTERVAL = 5;

  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
    scheduleSendHeartBeat(ctx);
    super.channelActive(ctx);
  }

  private void scheduleSendHeartBeat(ChannelHandlerContext ctx) {
    ctx.executor().schedule(() -> {
      if (ctx.channel().isActive()) {
        ctx.writeAndFlush(new HeartBeatRequestPacket());
        scheduleSendHeartBeat(ctx);
      }
    }, HEARTBEAT_INTERVAL, TimeUnit.SECONDS);
  }
}