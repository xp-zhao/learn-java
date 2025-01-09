package com.example.feature.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import org.springframework.core.ResolvableType;
import org.springframework.core.ResolvableTypeProvider;

public class BaseEvent<T> extends ApplicationEvent implements ResolvableTypeProvider {

  @Getter private String userName;

  public BaseEvent(T source) {
    super(source);
  }

  public BaseEvent(T source, String userName) {
    super(source);
    this.userName = userName;
  }

  @Override
  public ResolvableType getResolvableType() {
    return ResolvableType.forClassWithGenerics(getClass(), ResolvableType.forInstance(getSource()));
  }
}
