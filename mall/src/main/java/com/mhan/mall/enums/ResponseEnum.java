package com.mhan.mall.enums;

import lombok.Getter;

@Getter
public enum ResponseEnum {
    ERROR(-1, "Sever error"),

    SUCCESS(0, "Success"),

    PASSWORD_ERROR(1,"Password is wrong"),

    USERNAME_EXIST(2, "Username exists"),

    PARAM_ERROR(3, "Param is wrong"),

    EMAIL_EXIST(4, "Email exists"),

    NEED_LOGIN(10, "User has not registered, please register first"),

    USERNAME_OR_PASSWORD_ERROR(11, "Username or password error"),
//
//    PRODUCT_OFF_SALE_OR_DELETE(12, "商品下架或删除"),
//
//    PRODUCT_NOT_EXIST(13, "商品不存在"),
//
//    PROODUCT_STOCK_ERROR(14, "库存不正确"),
//
//    CART_PRODUCT_NOT_EXIST(15, "购物车里无此商品"),
//
//    DELETE_SHIPPING_FAIL(16, "删除收货地址失败"),
//
//    SHIPPING_NOT_EXIST(17, "收货地址不存在"),
//
//    CART_SELECTED_IS_EMPTY(18, "请选择商品后下单"),
//
//    ORDER_NOT_EXIST(19, "订单不存在"),
//
//    ORDER_STATUS_ERROR(20, "订单状态有误"),

    ;

    Integer code;

    String desc;

    ResponseEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
