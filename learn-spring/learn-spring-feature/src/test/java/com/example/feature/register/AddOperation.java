package com.example.feature.register;

/**
 * @author zhaoxiaoping
 * @date 2023-10-30
 */
@Operator("#a + #b")
public interface AddOperation {
  Object add(int a, int b);
}
