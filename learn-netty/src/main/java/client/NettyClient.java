package client;

import client.handler.LoginResponseHandler;
import client.handler.MessageResponseHandler;
import codec.PacketDecoder;
import codec.PacketEncoder;
import codec.Spliter;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import protocol.command.PacketCodeC;
import protocol.request.MessageRequestPacket;
import util.LoginUtil;

/**
 * Created by xp-zhao on 2018/11/26.
 */
public class NettyClient {

  private static final Integer MAX_RETRY = 5;
  private static final String HOST = "127.0.0.1";
  private static final Integer PORT = 8000;

  public static void main(String[] args) {
    // 引导类
    Bootstrap bootstrap = new Bootstrap();
    NioEventLoopGroup group = new NioEventLoopGroup();

    bootstrap
        .group(group) // 指定线程模型
        .channel(NioSocketChannel.class) // 指定 IO 类型为 NIO
        .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 500)
        .option(ChannelOption.SO_KEEPALIVE, true)
        .option(ChannelOption.TCP_NODELAY, true)
        .handler(new ChannelInitializer<SocketChannel>() { // IO 处理逻辑
          @Override
          protected void initChannel(SocketChannel channel) {
            // 指定连接数据读写逻辑
//            channel.pipeline().addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 7, 4));
            channel.pipeline().addLast(new Spliter());
//            channel.pipeline().addLast(new FirstClientHandler());
//            channel.pipeline().addLast(new ClientHandler());
            channel.pipeline().addLast(new PacketDecoder());
            channel.pipeline().addLast(new LoginResponseHandler());
            channel.pipeline().addLast(new MessageResponseHandler());
            channel.pipeline().addLast(new PacketEncoder());
          }
        });
    connect(bootstrap, HOST, PORT, MAX_RETRY);
  }

  private static void connect(Bootstrap bootstrap, String host, int port, int retry) {
    bootstrap.connect(host, port).addListener(future -> {
      if (future.isSuccess()) {
        System.out.println(new Date() + "连接成功");
        // 启动控制台线程
        Channel channel = ((ChannelFuture) future).channel();
        startConsoleThread(channel);
      } else if (retry == 0) {
        System.err.println("重试次数已用完，放弃连接！");
      } else {
        // 第几次重连
        int order = MAX_RETRY - retry + 1;
        // 本次重连的间隔
        int delay = 1 << order;
        System.err.println(new Date() + ": 连接失败，第" + order + "次重连……");
        bootstrap.config().group()
            .schedule(() -> connect(bootstrap, host, port, retry - 1), delay, TimeUnit.SECONDS);
      }
    });
  }

  private static void startConsoleThread(Channel channel) {
    new Thread(() -> {
      while (!Thread.interrupted()) {
        if (LoginUtil.hasLogin(channel)) {
          System.out.println("输入消息发送至服务端：");
          Scanner sc = new Scanner(System.in);
          String line = sc.nextLine();

          MessageRequestPacket packet = new MessageRequestPacket();
          packet.setMessage(line);
          ByteBuf byteBuf = PacketCodeC.INSTANCE.encode(channel.alloc(), packet);
          channel.writeAndFlush(byteBuf);
        }
      }
    }).start();
  }
}
