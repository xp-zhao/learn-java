package client.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import java.util.Date;
import java.util.UUID;
import protocol.command.PacketCodeC;
import protocol.request.LoginRequestPacket;
import protocol.response.LoginResponsePacket;
import session.Session;
import util.LoginUtil;
import util.SessionUtil;

/**
 * @description: 登录响应处理
 * @author: zhaoxp
 * @create: 2019/05/31
 **/
public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponsePacket> {

//  @Override
//  public void channelActive(ChannelHandlerContext ctx) {
//    // 创建登录对象
//    LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
//    loginRequestPacket.setUserId(UUID.randomUUID().toString());
//    loginRequestPacket.setUsername("xp");
//    loginRequestPacket.setPassword("pwd");
//
//    // 写数据
////    ctx.channel().writeAndFlush(loginRequestPacket);
//  }

  @Override
  protected void channelRead0(ChannelHandlerContext ctx,
      LoginResponsePacket loginResponsePacket) throws Exception {
    String userId = loginResponsePacket.getUserId();
    String userName = loginResponsePacket.getUserName();

    if (loginResponsePacket.isSuccess()) {
      System.out.println("[" + userName + "]登录成功，userId 为: " + loginResponsePacket.getUserId());
      SessionUtil.bindSession(new Session(userId, userName), ctx.channel());
    } else {
      System.out.println("[" + userName + "]登录失败，原因：" + loginResponsePacket.getReason());
    }
  }

  @Override
  public void channelInactive(ChannelHandlerContext ctx) {
    System.out.println("客户端连接被关闭!");
  }
}