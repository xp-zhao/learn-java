package com.xp.state.v1;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2021-6-19
 **/
@Slf4j
public class Client {

  public static void main(String[] args) {
    MarioStateMachine mario = new MarioStateMachine();
    mario.obtainMushRoom();
    log.info("mario score: {}, state: {}", mario.getScore(), mario.getCurrentState());
  }
}
