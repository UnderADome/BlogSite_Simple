package com.site.blog.Model;

public class Article_item {
    private Integer id;
    private String item;

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

    @Override
    public String toString() {
        return "Article_item{" +
                "id=" + id +
                ", item='" + item + '\'' +
                '}';
    }
}
