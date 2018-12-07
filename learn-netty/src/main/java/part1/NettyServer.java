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
public class NettyServer
{
	public static void main(String[] args)
	{
		ServerBootstrap serverBootstrap = new ServerBootstrap();
		NioEventLoopGroup boss = new NioEventLoopGroup();
		NioEventLoopGroup worker = new NioEventLoopGroup();
		serverBootstrap.group(boss , worker).channel(NioServerSocketChannel.class)
			.childHandler(new ChannelInitializer<NioSocketChannel>()
			{
				@Override protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception
				{
					nioSocketChannel.pipeline().addLast(new StringDecoder());
					nioSocketChannel.pipeline().addLast(new SimpleChannelInboundHandler<String>()
					{
						@Override protected void channelRead0(
							ChannelHandlerContext channelHandlerContext , String s)
							throws Exception
						{
							System.out.println(s);
						}
					});
				}
			});
		serverBootstrap.bind(1000).addListener(future -> {
			if(future.isSuccess()){
				System.out.println("端口绑定成功");
			}else{
				System.out.println("端口绑定失败");
			}
		});
	}
}
