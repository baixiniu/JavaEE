package sas.dao;

import sas.util.DBHelper;
import sas.util.Md5Util;

import java.util.ArrayList;
import java.util.List;

public class userDao {
    //查询账号密码
    public boolean checkLogin(User user){
        String sql="select * from user where Name=? and password=?";
        List<Object> params=new ArrayList<Object>();
        params.add(user.getUsername());
        //把明文转换为密文
        String encryptPassword= Md5Util.stringToMD5(user.getPassword());
        //列表内部为：用户名，密码密文
        params.add(encryptPassword);
        DBHelper dbHelper=new DBHelper();
        List<Object> query=new ArrayList<Object>();
        //dbHelper.query(sql,params);
        //query.add(dbHelper.query(sql,params));
        query=dbHelper.query(sql,params);
        if(query.isEmpty())
        {
            return false;
        }
        return true;
    }

    //插入数据库
    public boolean saveUser(User u){
        String sql="insert into user(Name,password) values(?,?)";
        //对占位符进行赋值，保存到内存中
        List<Object> params=new ArrayList<Object>();
        params.add(u.getUsername());
        params.add(Md5Util.stringToMD5(u.getPassword()));
        DBHelper dbHelper=new DBHelper();
        int result=dbHelper.update(sql,params);
        return result>0;
    }

    //修改数据库
    public boolean modifyUser(User u){
        String sql="update user set name=?,password=? where name=?";
        //对占位符进行赋值，保存到内存中
        List<Object> params=new ArrayList<Object>();
        params.add(u.getUsername());
        params.add(Md5Util.stringToMD5(u.getPassword()));
        params.add(u.getUsername());
        DBHelper dbHelper=new DBHelper();
        int result=dbHelper.update(sql,params);
        return result>0;
    }
}
