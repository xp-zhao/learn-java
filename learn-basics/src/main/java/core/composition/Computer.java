package core.composition;

import java.util.Optional;
import lombok.Data;

/**
 * Computer.java 电脑
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/21
 **/
@Data
public class Computer {

  private Processor processor;
  private Memory memory;
  private SoundCard soundCard;

  public Optional<SoundCard> getSoundCard() {
    return Optional.ofNullable(soundCard);
  }

}