package server.handler;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import util.SessionUtil;

/**
 * @description: 登录认证处理器
 * @author: zhaoxiaoping
 * @create: 2019/06/13
 **/
@Sharable
public class AuthHandler extends ChannelInboundHandlerAdapter {

  public static final AuthHandler INSTANCE = new AuthHandler();

  protected AuthHandler() {

  }

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    if (!SessionUtil.hasLogin(ctx.channel())) {
      ctx.channel().close();
    } else {
      // 实现逻辑的删除
      ctx.pipeline().remove(this);
      super.channelRead(ctx, msg);
    }
  }

  @Override
  public void handlerRemoved(ChannelHandlerContext ctx) {
    if (SessionUtil.hasLogin(ctx.channel())) {
      System.out.println("当前连接登录验证完毕，无需再次验证, AuthHandler 被移除");
    } else {
      System.out.println("无登录验证，强制关闭连接!");
    }
  }
}