package core.composition;

import lombok.Data;

/**
 * StandardProcessor.java 标准处理器
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/21
 **/
@Data
public class StandardProcessor implements Processor {

  private String model;
}