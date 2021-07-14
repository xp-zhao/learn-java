package client;

import client.console.ConsoleCommandManager;
import client.console.LoginConsoleCommand;
import client.handler.*;
import codec.PacketDecoder;
import codec.PacketEncoder;
import codec.Spliter;
import handler.IMIdleStateHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import util.SessionUtil;

import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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
            // 空闲检测
            channel.pipeline().addLast(new IMIdleStateHandler());
            // 指定连接数据读写逻辑
            channel.pipeline().addLast(new Spliter());
//            channel.pipeline().addLast(PacketCodecHandler.INSTANCE);
            channel.pipeline().addLast(new PacketDecoder());
            // 登录响应处理器
            channel.pipeline().addLast(new LoginResponseHandler());
            // 收消息处理器
            channel.pipeline().addLast(new MessageResponseHandler());
            // 创建群聊响应处理器
            channel.pipeline().addLast(new CreateGroupResponseHandler());
            // 加群响应处理器
            channel.pipeline().addLast(new JoinGroupResponseHandler());
            // 退群响应处理器
            channel.pipeline().addLast(new QuitGroupResponseHandler());
            // 登出响应处理器
            channel.pipeline().addLast(new LogoutResponseHandler());
            // 获取群成员响应处理器
            channel.pipeline().addLast(new ListGroupMembersResponseHandler());
            // 群响应处理器
            channel.pipeline().addLast(new GroupMessageResponseHandler());
            channel.pipeline().addLast(new PacketEncoder());
            // 心跳定时器
            channel.pipeline().addLast(new HeartBeatTimerHandler());
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

    ConsoleCommandManager commandManager = new ConsoleCommandManager();
    LoginConsoleCommand loginConsoleCommand = new LoginConsoleCommand();
    Scanner sc = new Scanner(System.in);
    new Thread(() -> {
      while (!Thread.interrupted()) {
        if (!SessionUtil.hasLogin(channel)) {
          loginConsoleCommand.exec(sc, channel);
        } else {
          commandManager.exec(sc, channel);
        }
      }
    }).start();
  }
}
