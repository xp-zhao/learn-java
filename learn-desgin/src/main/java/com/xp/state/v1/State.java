package com.xp.state.v1;

import lombok.Getter;

public enum State {
  SMALL(0),
  SUPER(1),
  FIRE(2),
  CAPE(3);
  @Getter
  private int value;

  State(int value) {
    this.value = value;
  }
}
