package server;

import codec.PacketDecoder;
import codec.PacketEncoder;
import codec.Spliter;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import java.util.Date;
import server.handler.AuthHandler;
import server.handler.LifeCyCleTestHandler;
import server.handler.LoginRequestHandler;
import server.handler.MessageRequestHandler;
import server.handler.inbound.InBoundHandlerA;
import server.handler.inbound.InBoundHandlerB;
import server.handler.inbound.InBoundHandlerC;
import server.handler.outbound.OutBoundHandlerA;
import server.handler.outbound.OutBoundHandlerB;
import server.handler.outbound.OutBoundHandlerC;

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
          protected void initChannel(NioSocketChannel nioSocketChannel) {
//            nioSocketChannel.pipeline()
//                .addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 7, 4));
//            nioSocketChannel.pipeline().addLast(new Spliter());
//            nioSocketChannel.pipeline().addLast(new FirstServerHandler());
//            nioSocketChannel.pipeline().addLast(new ServerHandler());
            // inBound, 处理读数据的逻辑链
//            nioSocketChannel.pipeline().addLast(new InBoundHandlerA());
//            nioSocketChannel.pipeline().addLast(new InBoundHandlerB());
//            nioSocketChannel.pipeline().addLast(new InBoundHandlerC());

            // outBound，处理写数据的逻辑链
//            nioSocketChannel.pipeline().addLast(new OutBoundHandlerA());
//            nioSocketChannel.pipeline().addLast(new OutBoundHandlerB());
//            nioSocketChannel.pipeline().addLast(new OutBoundHandlerC());
            // channelHandler 生命周期
//            nioSocketChannel.pipeline().addLast(new LifeCyCleTestHandler());
            nioSocketChannel.pipeline().addLast(new PacketDecoder());
            nioSocketChannel.pipeline().addLast(new LoginRequestHandler());
            // 新增用户认证 handler
            nioSocketChannel.pipeline().addLast(new AuthHandler());
            nioSocketChannel.pipeline().addLast(new MessageRequestHandler());
            nioSocketChannel.pipeline().addLast(new PacketEncoder());
          }
        });
    serverBootstrap.handler(new ChannelInitializer<NioServerSocketChannel>() {
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
