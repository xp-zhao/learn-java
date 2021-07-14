package handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;
import java.util.concurrent.TimeUnit;

/**
 * @description: 空闲检测处理器
 * @author: zhaoxiaoping
 * @create: 2019/06/20
 **/
public class IMIdleStateHandler extends IdleStateHandler {

  public static final int READER_IDLE_TIME = 15;

  public IMIdleStateHandler() {
    super(READER_IDLE_TIME, 0, 0, TimeUnit.SECONDS);
  }

  @Override
  protected void channelIdle(ChannelHandlerContext ctx, IdleStateEvent event) {
    System.out.println(READER_IDLE_TIME + "秒内未读到数据，关闭连接");
    ctx.channel().close();
  }
}