package com.blog.service;

import com.blog.dao.Demodao;

import java.util.List;
import java.util.Map;

/**
 * @program: blog
 * @description: this is a demo 请和demodao配合食用
 * @author: BIG_TRUCK li zonglin
 * @create: 2020-07-17 00:08
 **/

public class DemoService {

    // 暂设这个类就一个服务
    private Demodao demodao = new Demodao();

    public List<Map<String, Object>> getOne(){
        return demodao.getOneArticle();
    }
}
