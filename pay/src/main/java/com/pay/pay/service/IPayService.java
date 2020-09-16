package com.pay.pay.service;

import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayResponse;
import com.pay.pay.pojo.PayInfo;

import java.math.BigDecimal;

public interface IPayService {
    /**
     * Create Payment
     */
    PayResponse create(String orderId, BigDecimal amount, BestPayTypeEnum bestPayTypeEnum);
    String asyncNotify(String notifyData);
    //Search payment record
    PayInfo queryByOrderId(String orderId);
}
