package com.xp.state.v3;

import com.xp.state.v1.State;

/**
 * @author zhaoxiaoping
 * @Description: 状态机类接口
 * @Date 2021-6-19
 **/
public interface IMario {

  State getName();

  void obtainMushRoom(MarioStateMachine stateMachine);

  void obtainCape(MarioStateMachine stateMachine);

  void obtainFireFlower(MarioStateMachine stateMachine);

  void meetMonster(MarioStateMachine stateMachine);
}
