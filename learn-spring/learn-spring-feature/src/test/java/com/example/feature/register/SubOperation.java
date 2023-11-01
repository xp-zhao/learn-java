package com.example.feature.register;

/**
 * @author zhaoxiaoping
 * @date 2023-10-30
 */
@Operator("#a - #b")
public interface SubOperation {
  Object sub(int a, int b);
}
