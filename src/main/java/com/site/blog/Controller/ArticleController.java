package com.site.blog.Controller;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import sun.nio.ch.SelectorImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ArticleController {
//    public String uploadFile(HttpServletRequest request, @Param("file")MultipartFile file){
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");
//        String res = sdf.format(new Date());
//
//        //图片原始名称
//
//
//        return "上传成功";
//    }
//
    @RequestMapping("/uploadarticle")
    public String uploadFile(HttpServletRequest request, Model model){
        System.out.println("in");
        return "/uploadarticle";
    }
}
