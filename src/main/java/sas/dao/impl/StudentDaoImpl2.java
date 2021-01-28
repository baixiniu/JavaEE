package sas.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import sas.dao.StudentDao;
import sas.model.Student;
import sas.util.C3p0Util;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class StudentDaoImpl2 implements StudentDao {

    @Override
    public List<Student> getAllStudent() {
        String sql="select * from student";
        QueryRunner queryRunner=new QueryRunner(C3p0Util.getConnection());
        try{
            List<Student> students=queryRunner.query(sql,new BeanListHandler<Student>(Student.class));
            return students;
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Student> getStudentsByName(String name) {
        return null;
    }

    @Override
    public boolean saveStudent(Student s) {
        return false;
    }

    @Override
    //这个方法记得重写
    public boolean deleStudent(String stuno) {
        return false;
    }

    @Override
    //这个方法记得重写
    public boolean modifyStudent(Student s) {
        return false;
    }

    @Override
    public Student getStudentByNo(String stuno) {
        return null;
    }

    @Override
    public List<Student> getStudentByPaging(int currentPage, int pageSize) {
        String sql="select * from student where stuno limit ?,?";
        int start=(currentPage-1)*pageSize;
        QueryRunner queryRunner=new QueryRunner(C3p0Util.getConnection());
        try{
            /**
             * 如何让才能把resultSet转换为bean
             * 1.Java reflect，Student.class动态创建Student对象，动态获取方法
             * 2.jdbc meta,获取表得字段名称
             * 3.
             */
            List<Student>students= queryRunner.query(sql,new BeanListHandler<Student>(Student.class),new Object[]{start,pageSize});
            return students;
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }

        return null;
    }

    //重载
    public long totalRecords(){
        String sql ="select count(*) from student";
        QueryRunner queryRunner=new QueryRunner(C3p0Util.getConnection());
        //long result;
        try{
            List<Map<String,Object>> query=queryRunner.query(sql,new MapListHandler());
            return (long)query.get(0).get("count");
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return -1;
    }
}
