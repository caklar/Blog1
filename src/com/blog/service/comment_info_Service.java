package com.blog.service;

import com.blog.dao.comment_info_Dao;

import java.util.List;
import java.util.Map;

public class comment_info_Service {
    private comment_info_Dao comment_Dao=new comment_info_Dao();
    public List<Map<String ,Object>> Find_All_comment(int aid){
        List<Map<String ,Object>> list =null;
        list=comment_Dao.get_All_Comment(aid);
        return list;
    }
    public int dosave(String remark_name,String remark_context,String remark_aid,String remark_date) {
        int row= comment_Dao.save_comment(remark_name,remark_context,remark_aid,remark_date);
        return row;
    }
    public int dodel(String remark_id){
        int row=comment_Dao.del_comment(remark_id);
        return row;
    }
}
