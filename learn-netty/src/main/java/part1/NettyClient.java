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

  public static void main(String[] args) throws InterruptedException {
    Bootstrap bootstrap = new Bootstrap();
    NioEventLoopGroup group = new NioEventLoopGroup();

    bootstrap
        .group(group)
        .channel(NioSocketChannel.class)
        .handler(new ChannelInitializer<Channel>() {
          @Override
          protected void initChannel(Channel channel) {
            channel.pipeline().addLast(new StringEncoder());
          }
        });
    Channel channel = bootstrap.connect("127.0.0.1", 8000).channel();
    while (true) {
      channel.writeAndFlush(new Date() + ": hello world!");
      TimeUnit.SECONDS.sleep(2);
    }
  }
}
