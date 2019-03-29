package com.site.blog.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.site.blog.Mapper.WhisperQuery;
import com.site.blog.Response.RWhisper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WhisperService {

    @Autowired
    WhisperQuery whisperQuery;

    public Page<RWhisper> selectWhisperByPage(int page, int pagesize){
        PageHelper.startPage(page, pagesize);
        return whisperQuery.selectWhisperByPage();
    }
}
