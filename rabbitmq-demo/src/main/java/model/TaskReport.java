package model;

import lombok.Data;

import java.util.List;

/**
 * 上行数据(客户端任务执行完成后上报执行结果)
 * Created by xp-zhao on 2018/3/23.
 */
@Data
public class TaskReport
{
	//日志唯一号(由服务端生成)
	String logid;
	//执行任务的主机
	List<String> hosts;
	//执行状态(0:失败,1:成功,2:告警)
	String code;
	//执行结果描述
	String desc;
	//通知时间YYYY-MM-DD HH24:MI:SS格式
	String reportTime;

}
