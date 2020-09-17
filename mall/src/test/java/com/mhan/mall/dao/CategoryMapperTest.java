package com.mhan.mall.dao;

import com.mhan.mall.MallApplicationTests;
import com.mhan.mall.pojo.Category;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class CategoryMapperTest extends MallApplicationTests {

    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    public void contextLoads() {
        Category category= categoryMapper.findById(100001);
        System.out.println(category.toString());
    }
    @Test
    public void queryByIdTest() {
        Category category= categoryMapper.queryById(100001);
        System.out.println(category.toString());
    }
}