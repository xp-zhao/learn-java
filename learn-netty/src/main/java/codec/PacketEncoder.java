package codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import protocol.command.Packet;
import protocol.command.PacketCodeC;

/**
 * @description: 客户端编码器
 * @author: zhaoxp
 * @create: 2019/05/31
 **/
public class PacketEncoder extends MessageToByteEncoder<Packet> {

  @Override
  protected void encode(ChannelHandlerContext channelHandlerContext, Packet packet, ByteBuf byteBuf)
      throws Exception {
    PacketCodeC.INSTANCE.encode(byteBuf, packet);
  }
}