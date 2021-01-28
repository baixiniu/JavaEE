package sas.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

public class C3p0Util {
    private static DataSource ds=null;
    static{
       ds=new ComboPooledDataSource("student");
    }
    public static DataSource getConnection(){
        return ds;
    }
}
