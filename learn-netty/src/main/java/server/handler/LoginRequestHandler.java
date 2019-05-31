package server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import java.util.Date;
import protocol.request.LoginRequestPacket;
import protocol.response.LoginResponsePacket;

/**
 * @description: 登录请求处理器
 * @author: zhaoxp
 * @create: 2019/05/31
 **/
public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {

  @Override
  protected void channelRead0(ChannelHandlerContext channelHandlerContext,
      LoginRequestPacket loginRequestPacket)
      throws Exception {
    // 登录逻辑
    System.out.println(new Date() + ": 收到客户端登录请求。。。");

    LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
    loginResponsePacket.setVersion(loginRequestPacket.getVersion());

    if (valid(loginRequestPacket)) {
      loginResponsePacket.setSuccess(true);
      System.out.println(new Date() + ": 登录成功！");
    } else {
      loginResponsePacket.setReason("账号密码校验失败");
      loginResponsePacket.setSuccess(false);
      System.out.println(new Date() + ": 登录失败!");
    }

    channelHandlerContext.channel().writeAndFlush(loginResponsePacket);
  }

  private boolean valid(LoginRequestPacket loginRequestPacket) {
    return true;
  }

}