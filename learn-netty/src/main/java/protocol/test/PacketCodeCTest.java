package protocol.test;

import io.netty.buffer.ByteBuf;
import org.junit.Assert;
import org.junit.Test;
import protocol.command.LoginRequestPacket;
import protocol.command.Packet;
import protocol.command.PacketCodeC;
import serialize.Serializer;
import serialize.impl.JSONSerializer;

/**
 * @description:
 * @author: zhaoxp
 * @create: 2019/05/30
 **/
public class PacketCodeCTest {

  @Test
  public void encode() {
    Serializer serializer = new JSONSerializer();
    LoginRequestPacket loginRequestPacket = new LoginRequestPacket();

    loginRequestPacket.setVersion(((byte) 1));
    loginRequestPacket.setUserId(123);
    loginRequestPacket.setUsername("zhangsan");
    loginRequestPacket.setPassword("password");

    PacketCodeC packetCodeC = new PacketCodeC();
    ByteBuf byteBuf = packetCodeC.encode(loginRequestPacket);
    Packet decodedPacket = packetCodeC.decode(byteBuf);

    Assert.assertArrayEquals(serializer.serialize(loginRequestPacket), serializer.serialize(decodedPacket));
  }
}