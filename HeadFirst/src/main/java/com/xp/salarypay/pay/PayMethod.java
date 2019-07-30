package com.xp.salarypay.pay;

import com.xp.salarypay.entity.PayDetail;

/**
 * 支付方式接口
 *
 * @author: zhaoxiaoping
 * @date: 2019/07/30
 **/
public interface PayMethod {

  void pay(PayDetail detail);
}
