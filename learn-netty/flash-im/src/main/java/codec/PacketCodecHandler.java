package codec;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister.Pack;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;
import java.util.List;
import protocol.command.Packet;
import protocol.command.PacketCodeC;

/**
 * @description: 编码解码处理器
 * @author: zhaoxiaoping
 * @create: 2019/06/19
 **/
@Sharable
public class PacketCodecHandler extends MessageToMessageCodec<ByteBuf, Packet> {

  public static final PacketCodecHandler INSTANCE = new PacketCodecHandler();

  private PacketCodecHandler() {

  }

  @Override
  protected void encode(ChannelHandlerContext channelHandlerContext, Packet packet,
      List<Object> list) throws Exception {
    ByteBuf byteBuf = channelHandlerContext.channel().alloc().ioBuffer();
    PacketCodeC.INSTANCE.encode(byteBuf, packet);
    list.add(byteBuf);
  }

  @Override
  protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf,
      List<Object> list) throws Exception {
    list.add(PacketCodeC.INSTANCE.decode(byteBuf));
  }
}