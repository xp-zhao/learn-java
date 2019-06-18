package server.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import java.util.ArrayList;
import java.util.List;
import protocol.request.CreateGroupRequestPacket;
import protocol.response.CreateGroupResponsePacket;
import util.IDUtil;
import util.SessionUtil;

/**
 * @description: 创建群聊请求处理器
 * @author: zhaoxiaoping
 * @create: 2019/06/18
 **/
public class CreateGroupRequestHandler extends
    SimpleChannelInboundHandler<CreateGroupRequestPacket> {

  @Override
  protected void channelRead0(ChannelHandlerContext channelHandlerContext,
      CreateGroupRequestPacket createGroupRequestPacket) throws Exception {
    List<String> userIdList = createGroupRequestPacket.getUserIdList();

    List<String> userNameList = new ArrayList<>();
    // 1.创建一个 channel 分组
    ChannelGroup channelGroup = new DefaultChannelGroup(channelHandlerContext.executor());

    // 2.筛选出待加入群聊的用户的 channel 和 userName
    for (String userId : userIdList) {
      Channel channel = SessionUtil.getChannel(userId);
      if (channel != null) {
        channelGroup.add(channel);
        userNameList.add(SessionUtil.getSession(channel).getUserName());
      }
    }

    // 3.创建群聊创建结果的响应
    CreateGroupResponsePacket responsePacket = new CreateGroupResponsePacket();
    responsePacket.setSuccess(true);
    responsePacket.setGroupId(IDUtil.randomId());
    responsePacket.setUserNameList(userNameList);

    // 4.给每个客户端发送拉群通知
    channelGroup.writeAndFlush(responsePacket);

    System.out.print("群创建成功，id 为[" + responsePacket.getGroupId() + "], ");
    System.out.println("群里面有：" + responsePacket.getUserNameList());
  }
}