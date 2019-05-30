package server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import java.util.Date;
import protocol.command.Packet;
import protocol.command.PacketCodeC;
import protocol.request.LoginRequestPacket;
import protocol.response.LoginResponsePacket;

/**
 * @description: 服务端登录逻辑处理器
 * @author: zhaoxp
 * @create: 2019/05/30
 **/
public class ServerHandler extends ChannelInboundHandlerAdapter {

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) {
    System.out.println(new Date() + ": 客户端开始登录。。。");
    ByteBuf byteBuf = (ByteBuf) msg;

    // 解码
    Packet packet = PacketCodeC.INSTANCE.decode(byteBuf);

    // 判断是否是登录请求数据包
    if (packet instanceof LoginRequestPacket) {
      LoginRequestPacket loginRequestPacket = (LoginRequestPacket) packet;
      LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
      loginRequestPacket.setVersion(packet.getVersion());
      // 登录校验
      if (valid(loginRequestPacket)) {
        // 校验成功
        loginResponsePacket.setSuccess(true);
        System.out.println(new Date() + ": 登录成功!");
      } else {
        // 校验失败
        loginResponsePacket.setSuccess(false);
        loginResponsePacket.setReason("账号密码校验失败");
        System.out.println(new Date() + ": 登录失败!");
      }

      // 登录响应
      ByteBuf responseByteBuf = PacketCodeC.INSTANCE.encode(ctx.alloc(), loginResponsePacket);
      ctx.channel().writeAndFlush(responseByteBuf);
    }
  }

  private boolean valid(LoginRequestPacket requestPacket) {
    return true;
  }
}