package com.site.blog.Service;

import com.site.blog.Model.Test_User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface Test_UserService {

    //为什么这里用的是接口？？
    //@Autowired
    public List<Test_User> queryUserByUserName(String username);


}
