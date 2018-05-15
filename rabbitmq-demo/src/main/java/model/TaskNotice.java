package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 下行数据(调度系统通知客户端执行任务):
 * Created by xp-zhao on 2018/3/23.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TaskNotice
{
	//日志唯一号(由服务端生成)
	String logid;
	//任务组代码
	String groupCode;
	//任务代码(任务唯一标记)
	String taskCode;
	//任务名称
	String taskName;
	//任务执行策略
	String schedule;
	//策略类型
	String scheduleType;
	//通知时间YYYY-MM-DD HH24:MI:SS格式
	String noticeTime;

}
