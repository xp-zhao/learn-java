package com.xp.state.v3;

import com.xp.state.v1.State;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2021-6-19
 **/
public class SuperMario implements IMario {

  private static final SuperMario INSTANCE = new SuperMario();

  private SuperMario() {
  }

  public static SuperMario getInstance() {
    return INSTANCE;
  }

  @Override
  public State getName() {
    return State.SUPER;
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
