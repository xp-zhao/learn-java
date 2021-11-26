package com.xp.state.v3;

import com.xp.state.v1.State;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2021-6-19
 **/
public class SmallMario implements IMario {

  private static final SmallMario INSTANCE = new SmallMario();

  private SmallMario() {
  }

  public static SmallMario getInstance() {
    return INSTANCE;
  }

  @Override
  public State getName() {
    return State.SMALL;
  }

  @Override
  public void obtainMushRoom(MarioStateMachine stateMachine) {
    stateMachine.setCurrentState(SuperMario.getInstance());
    stateMachine.setScore(stateMachine.getScore() + 100);
  }

  @Override
  public void obtainCape(MarioStateMachine stateMachine) {
    stateMachine.setCurrentState(CapeMario.getInstance());
  }

  @Override
  public void obtainFireFlower(MarioStateMachine stateMachine) {

  }

  @Override
  public void meetMonster(MarioStateMachine stateMachine) {

  }
}
