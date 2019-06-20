package server;

import codec.PacketCodecHandler;
import codec.Spliter;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import java.util.Date;
import server.handler.AuthHandler;
import server.handler.HeartBeatRequestHandler;
import server.handler.IMHandler;
import handler.IMIdleStateHandler;
import server.handler.LoginRequestHandler;

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
        .option(ChannelOption.SO_BACKLOG, 1024)
        .option(ChannelOption.SO_KEEPALIVE, true)
        .option(ChannelOption.TCP_NODELAY, true)
        .childHandler(new ChannelInitializer<NioSocketChannel>() {
          @Override
          protected void initChannel(NioSocketChannel channel) {
            // 空闲检测
            channel.pipeline().addLast(new IMIdleStateHandler());
            channel.pipeline().addLast(new Spliter());
            channel.pipeline().addLast(PacketCodecHandler.INSTANCE);
            // 单例模式，多个 channel 公用一个 handler
            channel.pipeline().addLast(LoginRequestHandler.INSTANCE);
            channel.pipeline().addLast(HeartBeatRequestHandler.INSTANCE);
            // 新增用户认证 handler
            channel.pipeline().addLast(AuthHandler.INSTANCE);
            channel.pipeline().addLast(IMHandler.INSTANCE);
          }
        });
    serverBootstrap.handler(new ChannelInitializer<NioServerSocketChannel>() {
      @Override
      protected void initChannel(NioServerSocketChannel ch) {
        System.out.println(new Date() + ": 服务端启动中");
      }
    });
    bind(serverBootstrap, 8000);
  }

  private static void bind(ServerBootstrap serverBootstrap, int port) {
    // 添加监听器，监听端口是否绑定成功
    serverBootstrap.bind(port).addListener(future -> {
      if (future.isSuccess()) {
        System.out.println(new Date() + ": 端口[" + port + "]绑定成功");
      } else {
        System.out.println(new Date() + ": 端口[" + port + "]绑定失败");
        bind(serverBootstrap, port + 1);
      }
    });
  }
}
