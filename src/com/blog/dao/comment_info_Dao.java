package com.blog.dao;

import java.util.List;
import java.util.Map;

public class comment_info_Dao extends Demodao {

    public List<Map<String ,Object>> get_All_Comment(int aid){
        List<Map<String ,Object>> list=null;
        String sql="SELECT * FROM remark_info " +
                " WHERE remark_del=0 and remark_aid=?";
        list=super.executeQuery(sql,aid);
        return list;
    }

    public int save_comment(String remark_name,String remark_context,String remark_aid,String remark_date) {
        int row=0;
        int remark_in_aid=0;
        remark_in_aid=Integer.parseInt(remark_aid);
        String sql= "insert into remark_info(remark_name,remark_context,remark_aid,remark_date) values(?,?,?,?)";
        row=super.executeUpdate(sql, remark_name,remark_context,remark_in_aid,remark_date);
        return row;
    }

    public int del_comment(String remark_id){
        int remark_in_id=0;
        remark_in_id=Integer.parseInt(remark_id);
        String sql="UPDATE remark_info\n" +
                " SET remark_del=1\n" +
                " WHERE remark_id=?";
        int row=super.executeUpdate(sql,remark_in_id);
        return row;
    }
}
