package com.mhan.mall.service;

import com.mhan.mall.pojo.User;
import com.mhan.mall.vo.ResponseVo;

public interface IUserService {




    ResponseVo<User> register(User user);
    ResponseVo<User> login (String username, String password);


}
