package server.handler.outbound;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

/**
 * @description: 写数据处理逻辑C
 * @author: zhaoxp
 * @create: 2019/05/31
 **/
public class OutBoundHandlerC extends ChannelOutboundHandlerAdapter {

  @Override
  public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise)
      throws Exception {
    System.out.println("OutBoundHandlerC: " + msg);
    super.write(ctx, msg, promise);
  }
}