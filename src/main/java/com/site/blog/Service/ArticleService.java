package com.site.blog.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.site.blog.Mapper.ArticleQueryAll;
import com.site.blog.Response.RArticle;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    ArticleQueryAll articleQueryAll;

    public List<RArticle> articleQueryAll(){
        List<RArticle> result = articleQueryAll.selectAllArticle();
        return result;
    }

    public Page<RArticle> selectArticleByPage(int page, int pagesize){
        PageHelper.startPage(page, pagesize);
        return articleQueryAll.selectArticleByPage();
    }

    public RArticle selectArticleById(int id){
        RArticle result = articleQueryAll.selectArticleById(id);
        return result;
    }

}
