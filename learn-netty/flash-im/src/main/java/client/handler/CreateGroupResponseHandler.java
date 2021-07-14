package client.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import protocol.response.CreateGroupResponsePacket;

/**
 * @description: 创建群聊响应处理器
 * @author: zhaoxiaoping
 * @create: 2019/06/18
 **/
public class CreateGroupResponseHandler extends
    SimpleChannelInboundHandler<CreateGroupResponsePacket> {

  @Override
  protected void channelRead0(ChannelHandlerContext channelHandlerContext,
      CreateGroupResponsePacket createGroupResponsePacket) throws Exception {
    System.out.print("群创建成功，id 为[" + createGroupResponsePacket.getGroupId() + "], ");
    System.out.println("群里面有：" + createGroupResponsePacket.getUserNameList());
  }
}