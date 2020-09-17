package com.mhan.mall.controller;

import com.mhan.mall.consts.MallConst;
import com.mhan.mall.form.UserLoginForm;
import com.mhan.mall.form.UserRegisterForm;
import com.mhan.mall.pojo.User;
import com.mhan.mall.service.IUserService;
import com.mhan.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.util.Objects;

import static  com.mhan.mall.enums.ResponseEnum.PARAM_ERROR;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private IUserService userService;
    @PostMapping("/register")
    public ResponseVo register(@Valid @RequestBody UserRegisterForm userform, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("The parameters are wrong,{},{}", Objects.requireNonNull(bindingResult.getFieldError()).getField(),bindingResult.getFieldError().getDefaultMessage());
            return ResponseVo.error( PARAM_ERROR, bindingResult);

        }
//        log.info("username={}",userform.getUsername());
//        //return  ResponseVo.success();
//        return ResponseVo.error(NEED_LOGIN);
        User user = new User();
        BeanUtils.copyProperties(userform, user);
        return userService.register(user);


    }
    @PostMapping("/login")
    public ResponseVo<User> login(@Valid @RequestBody UserLoginForm userLoginForm, BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return ResponseVo.error(PARAM_ERROR, bindingResult);

        }
        ResponseVo<User> userResponseVo = userService.login(userLoginForm.getUsername(), userLoginForm.getPassword());
        //Set session
        session.setAttribute(MallConst.CURRENT_USER, userResponseVo.getData());
        return userResponseVo;
    }

}
