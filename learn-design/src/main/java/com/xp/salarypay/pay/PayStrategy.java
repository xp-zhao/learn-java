package com.xp.salarypay.pay;

import com.xp.salarypay.entity.PayDetail;

/**
 * 支付策略接口
 *
 * @author: zhaoxiaoping
 * @date: 2019/07/30
 **/
public interface PayStrategy {

  double calculatePay(PayDetail detail);
}
