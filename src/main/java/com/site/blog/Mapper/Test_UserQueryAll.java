package com.site.blog.Mapper;

import com.site.blog.Model.Test_User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository  //这个注解必须用不用则service报错。大概是用来作为bean注入的
@Mapper
public interface Test_UserQueryAll {

    @Select("SELECT * FROM test_user WHERE username = #{username}")
    @ResultType(Test_User.class)
    List<Test_User> selectUser(String username);

}
