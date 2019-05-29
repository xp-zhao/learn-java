package part1;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by xp-zhao on 2018/11/26.
 */
public class NettyClient {

  private static final Integer MAX_RETRY = 5;

  public static void main(String[] args) {
    // 引导类
    Bootstrap bootstrap = new Bootstrap();
    NioEventLoopGroup group = new NioEventLoopGroup();

    bootstrap
        .group(group) // 指定线程模型
        .channel(NioSocketChannel.class) // 指定 IO 类型为 NIO
        .handler(new ChannelInitializer<Channel>() { // IO 处理逻辑
          @Override
          protected void initChannel(Channel channel) {
            channel.pipeline().addLast(new StringEncoder());
          }
        });
    connect(bootstrap, 8000, MAX_RETRY);
  }

  private static void connect(Bootstrap bootstrap, int port, int retry) {
    bootstrap.connect("127.0.0.1", port).addListener(future -> {
      if (future.isSuccess()) {
        System.out.println("连接成功");
      } else if (retry == 0) {
        System.err.println("重试次数已用完，放弃连接！");
      } else {
        // 第几次重连
        int order = MAX_RETRY - retry + 1;
        // 本次重连的间隔
        int delay = 1 << order;
        System.err.println(new Date() + ": 连接失败，第" + order + "次重连……");
        bootstrap.config().group()
            .schedule(() -> connect(bootstrap, 8000, retry - 1), delay, TimeUnit.SECONDS);
      }
    });
  }
}
