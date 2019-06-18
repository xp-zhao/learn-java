package client.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import protocol.response.ListGroupMembersResponsePacket;

/**
 * @description: 获取群聊成员列表请求返回处理器
 * @author: zhaoxiaoping
 * @create: 2019/06/18
 **/
public class ListGroupMembersResponseHandler extends
    SimpleChannelInboundHandler<ListGroupMembersResponsePacket> {

  @Override
  protected void channelRead0(ChannelHandlerContext ctx,
      ListGroupMembersResponsePacket responsePacket) throws Exception {
    System.out
        .println("群[" + responsePacket.getGroupId() + "]中的人包括：" + responsePacket.getSessionList());
  }
}