package com.mhan.mall.service.impl;

import com.mhan.mall.dao.UserMapper;
import com.mhan.mall.enums.ResponseEnum;
import com.mhan.mall.enums.RoleEnum;
import com.mhan.mall.pojo.User;
import com.mhan.mall.service.IUserService;
import com.mhan.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import static  com.mhan.mall.enums.ResponseEnum.USERNAME_EXIST;
import static  com.mhan.mall.enums.ResponseEnum.EMAIL_EXIST;
import static  com.mhan.mall.enums.ResponseEnum.ERROR;
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;



    @Override
    public ResponseVo<User>register(User user) {

        //username check
        int countByUsername = userMapper.countByUsername(user.getUsername());
        if(countByUsername >0){
            //throw new RuntimeException("The username has already been registered");
            return ResponseVo.error(USERNAME_EXIST);
        }
        //email check
        int countByEmail = userMapper.countByEmail(user.getEmail());
        if(countByEmail>0){
            //throw new RuntimeException("The email has already been registered");
            return ResponseVo.error(EMAIL_EXIST);
        }


        user.setRole((RoleEnum.CUSTOMER.getCode()));
        //MD5(Spring)
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes(StandardCharsets.UTF_8)));
        //Change the database
        int resultCount=userMapper.insertSelective(user);
        if(resultCount == 0){
            //throw  new RuntimeException("Fail to register");
            return ResponseVo.error(ERROR);
        }

        return ResponseVo.success();


    }

    @Override
    public ResponseVo<User> login(String username, String password) {
        User user =userMapper.selectByUsername(username);
        if(user == null){
            //User does not exists.
            return ResponseVo.error(ResponseEnum.USERNAME_OR_PASSWORD_ERROR);
        }
        //DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8))

        if(!user.getPassword().equalsIgnoreCase(DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8)))){
            //
            return ResponseVo.error(ResponseEnum.USERNAME_OR_PASSWORD_ERROR);
        }
        return ResponseVo.success();
    }


    private  void error(){throw new RuntimeException("Error");}
}
