package com.mhan.mall.dao;

import com.mhan.mall.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    int countByUsername(String username);
    int countByEmail(String email);

    User selectByUsername(String username);
}