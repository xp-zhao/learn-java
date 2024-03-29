package protocol.command;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import java.util.HashMap;
import java.util.Map;
import protocol.request.CreateGroupRequestPacket;
import protocol.request.GroupMessageRequestPacket;
import protocol.request.HeartBeatRequestPacket;
import protocol.request.JoinGroupRequestPacket;
import protocol.request.ListGroupMembersRequestPacket;
import protocol.request.LoginRequestPacket;
import protocol.request.LogoutRequestPacket;
import protocol.request.MessageRequestPacket;
import protocol.request.QuitGroupRequestPacket;
import protocol.response.CreateGroupResponsePacket;
import protocol.response.GroupMessageResponsePacket;
import protocol.response.HeartBeatResponsePacket;
import protocol.response.JoinGroupResponsePacket;
import protocol.response.ListGroupMembersResponsePacket;
import protocol.response.LoginResponsePacket;
import protocol.response.LogoutResponsePacket;
import protocol.response.MessageResponsePacket;
import protocol.response.QuitGroupResponsePacket;
import serialize.Serializer;
import serialize.impl.JSONSerializer;

/**
 * @description: java对象编码解码
 * @author: zhaoxp
 * @create: 2019/05/30
 **/
public class PacketCodeC {

  public static final PacketCodeC INSTANCE = new PacketCodeC();
  public static final int MAGIC_NUMBER = 0x12345678;
  private static final Map<Byte, Class<? extends Packet>> packetTypeMap;
  private static final Map<Byte, Serializer> serializerMap;

  static {
    packetTypeMap = new HashMap<>();
    packetTypeMap.put(Command.LOGIN_REQUEST, LoginRequestPacket.class);
    packetTypeMap.put(Command.LOGIN_RESPONSE, LoginResponsePacket.class);
    packetTypeMap.put(Command.MESSAGE_REQUEST, MessageRequestPacket.class);
    packetTypeMap.put(Command.MESSAGE_RESPONSE, MessageResponsePacket.class);
    packetTypeMap.put(Command.LOGOUT_REQUEST, LogoutRequestPacket.class);
    packetTypeMap.put(Command.LOGOUT_RESPONSE, LogoutResponsePacket.class);
    packetTypeMap.put(Command.CREATE_GROUP_REQUEST, CreateGroupRequestPacket.class);
    packetTypeMap.put(Command.CREATE_GROUP_RESPONSE, CreateGroupResponsePacket.class);
    packetTypeMap.put(Command.JOIN_GROUP_REQUEST, JoinGroupRequestPacket.class);
    packetTypeMap.put(Command.JOIN_GROUP_RESPONSE, JoinGroupResponsePacket.class);
    packetTypeMap.put(Command.QUIT_GROUP_REQUEST, QuitGroupRequestPacket.class);
    packetTypeMap.put(Command.QUIT_GROUP_RESPONSE, QuitGroupResponsePacket.class);
    packetTypeMap.put(Command.LIST_GROUP_MEMBERS_REQUEST, ListGroupMembersRequestPacket.class);
    packetTypeMap.put(Command.LIST_GROUP_MEMBERS_RESPONSE, ListGroupMembersResponsePacket.class);
    packetTypeMap.put(Command.GROUP_MESSAGE_REQUEST, GroupMessageRequestPacket.class);
    packetTypeMap.put(Command.GROUP_MESSAGE_RESPONSE, GroupMessageResponsePacket.class);
    packetTypeMap.put(Command.HEARTBEAT_REQUEST, HeartBeatRequestPacket.class);
    packetTypeMap.put(Command.HEARTBEAT_RESPONSE, HeartBeatResponsePacket.class);

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
   * java 对象封装成二进制
   */
  public ByteBuf encode(ByteBuf byteBuf, Packet packet) {
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