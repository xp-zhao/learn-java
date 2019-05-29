package part1;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;

/**
 * Created by xp-zhao on 2018/11/26.
 */
public class NettyServer {

  public static void main(String[] args) {
    ServerBootstrap serverBootstrap = new ServerBootstrap();

    NioEventLoopGroup boss = new NioEventLoopGroup(); // 监听端口，accept 新连接的线程组
    NioEventLoopGroup worker = new NioEventLoopGroup(); // 处理每一条连接的数据读写的线程组

    serverBootstrap
        .group(boss, worker)
        .channel(NioServerSocketChannel.class)
        .childHandler(new ChannelInitializer<NioSocketChannel>() {
          @Override
          protected void initChannel(NioSocketChannel nioSocketChannel) {
            nioSocketChannel.pipeline().addLast(new StringDecoder());
            nioSocketChannel.pipeline().addLast(new SimpleChannelInboundHandler<String>() {
              @Override
              protected void channelRead0(
                  ChannelHandlerContext channelHandlerContext, String s) {
                System.out.println(s);
              }
            });
          }
        });
    serverBootstrap.handler(new ChannelInitializer<NioServerSocketChannel>() {
      protected void initChannel(NioServerSocketChannel ch) {
        System.out.println("服务端启动中");
      }
    });
    bind(serverBootstrap, 1000);
  }

  private static void bind(ServerBootstrap serverBootstrap, int port) {
    // 添加监听器，监听端口是否绑定成功
    serverBootstrap.bind(port).addListener(future -> {
      if (future.isSuccess()) {
        System.out.println("端口绑定成功");
      } else {
        System.out.println("端口绑定失败");
        bind(serverBootstrap, port + 1);
      }
    });
  }
}
