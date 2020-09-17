package com.mhan.mall.service.impl;

import com.mhan.mall.MallApplicationTests;
import com.mhan.mall.enums.RoleEnum;
import com.mhan.mall.pojo.User;
import com.mhan.mall.service.IUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;
@Transactional
public class UserServiceImplTest extends MallApplicationTests {
    @Autowired
    private IUserService userService;

    @Test
    public void register() {
        User user=new User("Anna","12345677","anna@gmail.com", RoleEnum.CUSTOMER.getCode());
        userService.register(user);
    }
}