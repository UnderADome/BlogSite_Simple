package com.site.blog.Service;

import com.site.blog.Mapper.Test_UserQueryAll;
import com.site.blog.Model.Test_User;
import netscape.security.UserTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class Test_UserServiceImpl implements  Test_UserService {

    @Autowired
    Test_UserQueryAll test_userQueryAll; //userqueryall要用re注解，不然mapper报错
    @Override
    public List<Test_User> queryUserByUserName(String username) {
        List<Test_User> list = test_userQueryAll.selectUser(username);
        System.out.println(list);
        return list;
    }
}
