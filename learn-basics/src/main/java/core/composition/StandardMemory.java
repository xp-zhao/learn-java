package core.composition;

import lombok.Data;

/**
 * StandardMemory.java 标准内存
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/21
 **/
@Data
public class StandardMemory implements Memory {

  private String brand;
  private String size;
}