package com.site.blog.Response;


import java.sql.Timestamp;

/**
 * 渲染数据
 * response类型一律加上R以区别于Model类型。作为返回到页面上的数据
 */
public class RArticle {
    private Integer id;
    private String item; //返回一个String类型，可以直接渲染到页面上
    private String title;
    private String article_content;
    private String pic;
    private Integer user_id;
    private Timestamp create_time;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticle_content() {
        return article_content;
    }

    public void setArticle_content(String article_content) {
        this.article_content = article_content;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    @Override
    public String toString() {
        return "RArticle{" +
                "id=" + id +
                ", item='" + item + '\'' +
                ", title='" + title + '\'' +
                ", article_content='" + article_content + '\'' +
                ", pic='" + pic + '\'' +
                ", user_id=" + user_id +
                ", create_time=" + create_time +
                '}';
    }
}
