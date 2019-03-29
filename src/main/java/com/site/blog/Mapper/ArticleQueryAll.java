package com.site.blog.Mapper;

import com.github.pagehelper.Page;
import com.site.blog.Model.Article;
import com.site.blog.Response.RArticle;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ArticleQueryAll {

    @Select("select article.id, article_item.item, article.title, article.article_content, article.pic from " +
            "article, article_item where article.item = article_item.id;")
    @ResultType(RArticle.class)
    List<RArticle> selectAllArticle();

    @Select("select article.id, article_item.item, article.title, article.article_content, article.pic from " +
            "article, article_item where article.item = article_item.id")
    @ResultType(RArticle.class)
    Page<RArticle> selectArticleByPage();

    @Select("select article.id, article_item.item, article.title, " +
            "article.article_content, article.pic, article.user_id, article.create_time " +
            "from article, article_item  where article.item = article_item.id and article.id = #{id};")
    @ResultType(RArticle.class)
    RArticle selectArticleById(int id);
}
