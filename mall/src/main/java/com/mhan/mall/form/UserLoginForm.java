package com.mhan.mall.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
@Data
public class UserLoginForm {
    @NotBlank(message = "The username cannot be null")
    private String username;
    @NotBlank
    private  String password;
}
