package com.xp.state.v1;

import lombok.Data;

/**
 * @author zhaoxiaoping
 * @Description: 马里奥状态机(分支逻辑法)
 * @Date 2021-6-19
 **/
@Data
public class MarioStateMachine {

  private int score;
  private State currentState;

  public MarioStateMachine() {
    this.score = 0;
    this.currentState = State.SMALL;
  }

  public void obtainMushRoom() {
    if (State.SMALL.equals(currentState)) {
      this.currentState = State.SUPER;
      this.score += 100;
    }
  }

  public void obtainCape() {
    if (State.SMALL.equals(currentState) || State.SUPER.equals(currentState)) {
      this.currentState = State.CAPE;
      this.score += 200;
    }
  }

  public void obtainFireFlower() {
    if (State.SMALL.equals(currentState) || State.SUPER.equals(currentState)) {
      this.currentState = State.FIRE;
      this.score += 300;
    }
  }

  public void meetMonster() {
    if (currentState.equals(State.SUPER)) {
      this.currentState = State.SMALL;
      this.score -= 100;
      return;
    }
    if (currentState.equals(State.CAPE)) {
      this.currentState = State.SMALL;
      this.score -= 200;
      return;
    }
    if (currentState.equals(State.FIRE)) {
      this.currentState = State.SMALL;
      this.score -= 300;
      return;
    }
  }
}
