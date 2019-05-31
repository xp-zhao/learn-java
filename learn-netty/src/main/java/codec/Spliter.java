package codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import protocol.command.PacketCodeC;

/**
 * @description: 屏蔽非本协议的连接
 * @author: zhaoxp
 * @create: 2019/05/31
 **/
public class Spliter extends LengthFieldBasedFrameDecoder {

  private static final int LENGTH_FIELED_OFFSET = 7;
  private static final int LENGTH_FIELED_LENGTH = 4;

  public Spliter() {
    super(Integer.MAX_VALUE, LENGTH_FIELED_OFFSET, LENGTH_FIELED_LENGTH);
  }

  @Override
  protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
    // 屏蔽非本协议的客户端
    if (in.getInt(in.readerIndex()) != PacketCodeC.MAGIC_NUMBER) {
      ctx.channel().close();
      return null;
    }
    return super.decode(ctx, in);
  }
}