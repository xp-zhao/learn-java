package server.handler.inbound;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @description: 测试处理器B
 * @author: zhaoxp
 * @create: 2019/05/31
 **/
public class InBoundHandlerB extends ChannelInboundHandlerAdapter {

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    System.out.println("InboundHandlerB: " + msg);
    super.channelRead(ctx, msg);
  }
}