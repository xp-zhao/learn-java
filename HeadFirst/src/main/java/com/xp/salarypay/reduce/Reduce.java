package com.xp.salarypay.reduce;

import com.xp.salarypay.entity.PayDetail;

/**
 * 服务费用接口
 *
 * @author: zhaoxiaoping
 * @date: 2019/07/30
 **/
public interface Reduce {

  double calculateDeductions(PayDetail detail);
}
