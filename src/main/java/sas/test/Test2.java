package sas.test;


import sas.util.C3p0Util;
import sas.util.DbcpUtil;

import java.io.IOException;
import java.sql.SQLException;

class test2 {
    public static void main(String [] args) throws IOException, SQLException {
//        Properties properties=new Properties();
//        InputStream in =new Test().getClass().getClassLoader().getResourceAsStream("dbcpconfig.porperties");
//
        System.out.println(DbcpUtil.getDataSource()==null);
        /**
         * getConnection()会弹出异常
         * 由调用者来处理
         * 可以处理，捕获和throws
         *
         */
        try{
            System.out.println(DbcpUtil.getDataSource().getConnection()==null);
            System.out.println(C3p0Util.getConnection()==null);
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }

    }
}
