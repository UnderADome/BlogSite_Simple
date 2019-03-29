package com.site.blog.Mapper;


import com.github.pagehelper.Page;
import com.site.blog.Response.RWhisper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface WhisperQuery {

    @Select("select id, create_time, comment_times, thumbsup, content, img " +
            "from whisper")
    @ResultType(RWhisper.class)
    Page<RWhisper> selectWhisperByPage();
}
