package com.example.feature.service;

import com.example.feature.event.UserRegisterEvent;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @author xp-zhao
 * @description 优惠券服务
 * @date 2022/9/23 22:03
 */
@Service
@Slf4j
public class CouponService {
  @EventListener
  public void addCoupon(UserRegisterEvent event) {
    log.info("[addCoupon][给用户({}) 发放优惠劵]", event.getUserName());
  }
}
