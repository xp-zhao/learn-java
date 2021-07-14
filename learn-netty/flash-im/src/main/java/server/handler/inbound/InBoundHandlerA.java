package server.handler.inbound;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @description: 测试处理器A
 * @author: zhaoxp
 * @create: 2019/05/31
 **/
public class InBoundHandlerA extends ChannelInboundHandlerAdapter {

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    System.out.println("InboundHandlerA: " + msg);
    super.channelRead(ctx, msg);
  }
}