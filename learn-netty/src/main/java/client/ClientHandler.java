package client;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import java.util.Date;
import java.util.UUID;
import protocol.command.Packet;
import protocol.request.LoginRequestPacket;
import protocol.command.PacketCodeC;
import protocol.response.LoginResponsePacket;

/**
 * @description: 客户端登录逻辑处理器
 * @author: zhaoxp
 * @create: 2019/05/30
 **/
public class ClientHandler extends ChannelInboundHandlerAdapter {

  /**
   * 客户端连接上服务端之后调用
   */
  @Override
  public void channelActive(ChannelHandlerContext ctx) {
    System.out.println(new Date() + ": 客户端开始登录");

    // 创建登录对象
    LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
    loginRequestPacket.setUserId(UUID.randomUUID().toString());
    loginRequestPacket.setUsername("xp");
    loginRequestPacket.setPassword("pwd");

    // 编码
    ByteBuf byteBuf = PacketCodeC.INSTANCE.encode(ctx.alloc(), loginRequestPacket);
    // 写数据
    ctx.channel().writeAndFlush(byteBuf);
  }

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) {
    ByteBuf byteBuf = (ByteBuf) msg;

    Packet packet = PacketCodeC.INSTANCE.decode(byteBuf);

    if (packet instanceof LoginResponsePacket) {
      LoginResponsePacket loginResponsePacket = (LoginResponsePacket) packet;

      if (loginResponsePacket.isSuccess()) {
        System.out.println(new Date() + ": 客户端登录成功");
      } else {
        System.out.println(new Date() + ": 客户端登录失败，原因：" + loginResponsePacket.getReason());
      }
    }
  }
}