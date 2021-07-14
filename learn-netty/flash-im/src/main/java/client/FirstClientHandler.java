package client;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import java.nio.charset.Charset;
import java.util.Date;

/**
 * @description: 客户端逻辑处理器
 * @author: zhaoxp
 * @create: 2019/05/29
 **/
public class FirstClientHandler extends ChannelInboundHandlerAdapter {

  /**
   * 在客户端建立连接成功之后被调用
   */
  @Override
  public void channelActive(ChannelHandlerContext ctx) {
    System.out.println(new Date() + ": 客户端写出数据");

    for (int i = 0; i < 1000; i++) {
      // 获取数据
      ByteBuf buffer = getByteBuf(ctx);
      // 写数据
      ctx.channel().writeAndFlush(buffer);
    }
  }

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) {
    ByteBuf byteBuf = (ByteBuf) msg;
    System.out.println(new Date() + ": 客户端读取到数据 -> " + byteBuf.toString(Charset.forName("utf-8")));
  }

  private ByteBuf getByteBuf(ChannelHandlerContext ctx) {
    // 1. 获取二进制抽象 ByteBuf
    ByteBuf buffer = ctx.alloc().buffer();

    // 2. 准备数据，指定字符串的字符集为 utf-8
    byte[] bytes = "你好，netty".getBytes(Charset.forName("utf-8"));

    // 3. 填充数据到 ByteBuf
    buffer.writeBytes(bytes);
    return buffer;
  }
}