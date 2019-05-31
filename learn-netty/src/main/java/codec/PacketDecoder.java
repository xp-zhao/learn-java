package codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.List;
import protocol.command.PacketCodeC;

/**
 * @description: 服务端解码
 * @author: zhaoxp
 * @create: 2019/05/31
 **/
public class PacketDecoder extends ByteToMessageDecoder {

  @Override
  protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf,
      List<Object> list) throws Exception {
    list.add(PacketCodeC.INSTANCE.decode(byteBuf));
  }
}