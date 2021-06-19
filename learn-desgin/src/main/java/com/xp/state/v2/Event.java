package com.xp.state.v2;

import lombok.Getter;

public enum Event {
  GOT_MUSHROOM(0),
  GOT_CAPE(1),
  GOT_FIRE(2),
  MET_MONSTER(3);
  @Getter
  private int value;

  private Event(int value) {
    this.value = value;
  }
}
