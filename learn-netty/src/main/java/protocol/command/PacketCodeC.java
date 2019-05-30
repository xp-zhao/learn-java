package protocol.command;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import java.util.HashMap;
import java.util.Map;
import protocol.request.LoginRequestPacket;
import protocol.response.LoginResponsePacket;
import serialize.Serializer;
import serialize.impl.JSONSerializer;

/**
 * @description: java对象编码解码
 * @author: zhaoxp
 * @create: 2019/05/30
 **/
public class PacketCodeC {

  public static final PacketCodeC INSTANCE = new PacketCodeC();
  private static final int MAGIC_NUMBER = 0x12345678;
  private static final Map<Byte, Class<? extends Packet>> packetTypeMap;
  private static final Map<Byte, Serializer> serializerMap;

  static {
    packetTypeMap = new HashMap<>();
    packetTypeMap.put(Command.LOGIN_REQUEST, LoginRequestPacket.class);
    packetTypeMap.put(Command.LOGIN_RESPONSE, LoginResponsePacket.class);

    serializerMap = new HashMap<>();
    Serializer serializer = new JSONSerializer();
    serializerMap.put(serializer.getSerializerAlgorithm(), serializer);
  }

  /**
   * java 对象封装成二进制
   */
  public ByteBuf encode(ByteBufAllocator byteBufAllocator, Packet packet) {
    // 创建 ByteBuf 对象
    ByteBuf byteBuf = byteBufAllocator.ioBuffer();
    // 序列化 java 对象
    byte[] bytes = Serializer.DEFAULT.serialize(packet);

    // 实际编码过程
    byteBuf.writeInt(MAGIC_NUMBER);
    byteBuf.writeByte(packet.getVersion());
    byteBuf.writeByte(Serializer.DEFAULT.getSerializerAlgorithm());
    byteBuf.writeByte(packet.getCommand());
    byteBuf.writeInt(bytes.length);
    byteBuf.writeBytes(bytes);

    return byteBuf;
  }

  /**
   * 解析 java 对象
   */
  public Packet decode(ByteBuf byteBuf) {
    // 跳过 magic number
    byteBuf.skipBytes(4);

    // 跳过版本号
    byteBuf.skipBytes(1);

    // 序列化算法标识
    byte serializeAlgorithm = byteBuf.readByte();

    // 指令
    byte command = byteBuf.readByte();

    // 数据包长度
    int length = byteBuf.readInt();

    byte[] bytes = new byte[length];
    byteBuf.readBytes(bytes);

    Class<? extends Packet> requestType = getRequestType(command);
    Serializer serializer = getSerializer(serializeAlgorithm);

    if (requestType != null && serializer != null) {
      return serializer.deserialize(requestType, bytes);
    }
    return null;
  }

  private Serializer getSerializer(byte serializeAlgorithm) {
    return serializerMap.get(serializeAlgorithm);
  }

  private Class<? extends Packet> getRequestType(byte command) {
    return packetTypeMap.get(command);
  }
}