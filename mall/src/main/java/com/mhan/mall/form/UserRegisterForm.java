package com.mhan.mall.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserRegisterForm {
    //@NotEmpty : for set

    @NotBlank(message = "The username cannot be null")
    private String username;
    @NotBlank
    private  String password;
    @NotBlank
    private String email;
}
