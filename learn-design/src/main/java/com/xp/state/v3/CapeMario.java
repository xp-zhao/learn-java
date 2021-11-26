package com.xp.state.v3;

import com.xp.state.v1.State;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2021-6-19
 **/
public class CapeMario implements IMario {

  private static final CapeMario INSTANCE = new CapeMario();

  private CapeMario() {
  }

  public static CapeMario getInstance() {
    return INSTANCE;
  }

  @Override
  public State getName() {
    return State.CAPE;
  }

  @Override
  public void obtainMushRoom(MarioStateMachine stateMachine) {
    
  }

  @Override
  public void obtainCape(MarioStateMachine stateMachine) {

  }

  @Override
  public void obtainFireFlower(MarioStateMachine stateMachine) {

  }

  @Override
  public void meetMonster(MarioStateMachine stateMachine) {

  }
}
