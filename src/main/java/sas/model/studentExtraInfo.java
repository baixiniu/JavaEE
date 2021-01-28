package sas.model;

import org.apache.commons.dbcp2.DelegatingResultSet;
import sas.dao.impl.StudentDaoImpl;

import java.util.*;

public class studentExtraInfo {
    private Map<Integer,String> classes;
    private Map<Integer,String> gender;
    private Map<Integer,String> dormno;
    private Map<Integer,String> major;
    private StudentDaoImpl dao=new StudentDaoImpl();

    public studentExtraInfo(){
        classes=new HashMap<>();
        gender=new HashMap<>();
        dormno=new HashMap<>();
        major=new HashMap<>();
        //按理来说，应该是制作一个相关信息的列表，这里直接手动了
        classes.put(1,"1808041");
        classes.put(2,"1808042");
        classes.put(3,"1808051");
        classes.put(4,"1808052");
        gender.put(1,"男");
        gender.put(2,"女");
        major.put(1,"软件工程");
        major.put(2,"计算机科学与技术");
        major.put(3,"信息安全");
        major.put(4,"密码学");


        int i=1;
        List<Student> students=dao.getAllStudent();
        for(Student s:students){
            if(dormno.containsValue(s.getDormNo()))
            {

            }
            else{
                dormno.put(i,s.getDormNo());
                i++;
            }
        }
    }

    public Map<Integer,String> getClasses(){
        return classes;
    }

    public Map<Integer,String> getGender(){
        return gender;
    }

    public Map<Integer,String> getDormno(){
        return  dormno;
    }

    public Map<Integer,String> getMajor(){
        return major;
    }

    public boolean saveStudent(Student s){
        return dao.saveStudent(s);
    }

    public boolean deleteStudent(String stu){
        return dao.deleStudent(stu);
    }
}
