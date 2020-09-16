package com.pay.pay.service.impl;


import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.pay.pay.PayApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class PayServiceTest extends PayApplicationTests {

    @Autowired
    private PayService payService;

    @Test
    public void create() {
        //BigDecimal.valueOf(0.01)  parameter is double
        // new BigDecimal("0.01")   parameter is string
        payService.create("123456789123455559",BigDecimal.valueOf(0.01), BestPayTypeEnum.WXPAY_NATIVE);
    }
}