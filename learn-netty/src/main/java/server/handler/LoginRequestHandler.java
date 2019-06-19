package server.handler;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import java.util.Date;
import java.util.UUID;
import protocol.request.LoginRequestPacket;
import protocol.response.LoginResponsePacket;
import session.Session;
import util.SessionUtil;

/**
 * @description: 登录请求处理器
 * 加上注解标识，表明该 handler 是可以多个 channel 共享的
 * @author: zhaoxp
 * @create: 2019/05/31
 **/
@Sharable
public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {

  public static final LoginRequestHandler INSTANCE = new LoginRequestHandler();

  protected LoginRequestHandler(){

  }

  @Override
  protected void channelRead0(ChannelHandlerContext channelHandlerContext,
      LoginRequestPacket loginRequestPacket)
      throws Exception {
    // 登录逻辑
    System.out.println(new Date() + ": 收到客户端登录请求。。。");

    LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
    loginResponsePacket.setVersion(loginRequestPacket.getVersion());
    loginResponsePacket.setUserName(loginRequestPacket.getUsername());

    if (valid(loginRequestPacket)) {
      loginResponsePacket.setSuccess(true);
      String userId = randomUserId();
      loginResponsePacket.setUserId(userId);
      System.out.println("[" + loginRequestPacket.getUsername() + "]登录成功");
      SessionUtil.bindSession(new Session(userId, loginRequestPacket.getUsername()),
          channelHandlerContext.channel());
    } else {
      loginResponsePacket.setReason("账号密码校验失败");
      loginResponsePacket.setSuccess(false);
      System.out.println(new Date() + ": 登录失败!");
    }
    // 登录响应
    channelHandlerContext.channel().writeAndFlush(loginResponsePacket);
  }

  private boolean valid(LoginRequestPacket loginRequestPacket) {
    return true;
  }

  private static String randomUserId() {
    return UUID.randomUUID().toString().split("-")[0];
  }

  @Override
  public void channelInactive(ChannelHandlerContext ctx) {
    SessionUtil.unBindSession(ctx.channel());
  }
}