package com.xp.state.v3;

import com.xp.state.v1.State;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2021-6-19
 **/
public class FireMario implements IMario {

  private static final FireMario INSTANCE = new FireMario();

  private FireMario() {
  }

  public static FireMario getInstance() {
    return INSTANCE;
  }

  @Override
  public State getName() {
    return State.FIRE;
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
