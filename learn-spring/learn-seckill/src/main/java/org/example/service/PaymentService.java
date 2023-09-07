package org.example.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.entity.Payment;
import org.example.mapper.PaymentMapper;
import org.springframework.stereotype.Service;

/**
 * ${END}
 *
 * @author zhaoxiaoping
 * @date 2023-9-7
 */
@Service
public class PaymentService extends ServiceImpl<PaymentMapper, Payment> {}
