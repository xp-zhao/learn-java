package server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import java.nio.charset.Charset;
import java.util.Date;

/**
 * @description: 服务端逻辑处理器
 * @author: zhaoxp
 * @create: 2019/05/29
 **/
public class FirstServerHandler extends ChannelInboundHandlerAdapter {

  /**
   * 接收到客户端发来的消息之后被调用
   */
  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) {
    ByteBuf byteBuf = (ByteBuf) msg;

    System.out.println(new Date() + ": 服务端读取到数据 -> " + byteBuf.toString(Charset.forName("utf-8")));

    // 回复数据到客户端
//    System.out.println(new Date() + ": 服务端写出数据");
//    ByteBuf out = getByteBuf(ctx);
//    ctx.channel().writeAndFlush(out);
  }

  private ByteBuf getByteBuf(ChannelHandlerContext ctx) {
    ByteBuf buffer = ctx.alloc().buffer();

    byte[] bytes = "服务端回复数据".getBytes(Charset.forName("utf-8"));

    buffer.writeBytes(bytes);
    return buffer;
  }
}