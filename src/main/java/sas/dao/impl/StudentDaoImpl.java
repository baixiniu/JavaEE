package sas.dao.impl;
//这是常规情况下对数据库的操作，未使用servlet
import sas.dao.StudentDao;
import sas.model.Student;
import sas.util.DBHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentDaoImpl  implements StudentDao {
    @Override
    public List<Student> getAllStudent() {
        String sql="select * from student";
        DBHelper db=new DBHelper();
        List<Object> result=db.query(sql,null);
        //从数据库查询学生信息
        List<Student> students=new ArrayList<>();
        //创建学生列表
        for(Object o:result)
        {
            Map map=(Map)o;
            students.add(
                    new Student(
                            (String)map.get("stuno"),
                            (String)map.get("stuname"),
                            (String)map.get("classes"),
                            (String)map.get("gender"),
                            (String)map.get("major"),
                            (String)map.get("tel"),
                            (String)map.get("dormno"),
                            (String)map.get("photopath")
                    )
            );//依据学生信息创建student对象
        }
        return students;
    }


    @Override
    public List<Student> getStudentsByName(String name){
        String sql="select * from student where stuname like ?";
        DBHelper db=new DBHelper();
        List<Object> params=new ArrayList<>();//插入删除较为方便
        params.add('%'+name+'%');
        List<Object> result=db.query(sql,params);
        List<Student> students=new ArrayList<>();
        for(Object o:result)
        {
            Map map=(Map)o;
            students.add(
                    new Student(
                            (String)map.get("stuno"),
                            (String)map.get("stuname"),
                            (String)map.get("classes"),
                            (String)map.get("gender"),
                            (String)map.get("major"),
                            (String)map.get("tel"),
                            (String)map.get("dormno"),
                            (String)map.get("photopath")
                    )
            );
        }
        return students;
    }

    public boolean saveStudent(Student s){
        String sql="insert into student(stuno,stuname,classes,major,gender,tel,dormno,photopath) values(?,?,?,?,?,?,?,?)";
        DBHelper db=new DBHelper();
        List<Object> params=new ArrayList<>();//插入删除较为方便
        params.add(s.getStuNo());
        params.add(s.getStuName());
        params.add(s.getClasses());
        params.add(s.getMajor());
        params.add(s.getGender());
        params.add(s.getTel());
        params.add(s.getDormNo());
        if(s.getGender().equals("男"))
            params.add("/images/students/boy.jpg");
        else
            params.add("/images/students/girl.jpg");
        //顺序无所谓
        int result =db.update(sql,params);
        return result>0;
    }

    @Override
    public boolean deleStudent(String stuno) {
        String sql="delete from student where stuno=?";
        DBHelper db=new DBHelper();
        List<Object> params=new ArrayList<>();
        params.add(stuno);
        int result=db.update(sql,params);
        return result>0;
    }

    @Override
    public boolean modifyStudent(Student s) {
        String sql="update student set stuno=?,stuname=?,classes=?,major=?," +
                "gender=?,tel=?,dormno=?,photopath=? where stuno=?";
        DBHelper db=new DBHelper();
        List<Object> params=new ArrayList<>();//插入删除较为方便
        params.add(s.getStuNo());
        params.add(s.getStuName());
        params.add(s.getClasses());
        params.add(s.getMajor());
        params.add(s.getGender());
        params.add(s.getTel());
        params.add(s.getDormNo());
        if(s.getGender().equals("男"))
            params.add("/images/students/boy.jpg");
        else
            params.add("/images/students/girl.jpg");
        //顺序无所谓
        params.add(s.getStuNo());
        int result =db.update(sql,params);
        return result>0;
    }

    @Override
    public Student getStudentByNo(String stuno) {
        String sql="select * from student where stuno='"+stuno+"'";
        List<Object> query=new DBHelper().query(sql,null);
        Map map=(Map)query.get(0);
        return new Student(
                (String)map.get("stuno"),
                (String)map.get("stuname"),
                (String)map.get("classes"),
                (String)map.get("gender"),
                (String)map.get("major"),
                (String)map.get("tel"),
                (String)map.get("dormno"),
                (String)map.get("photopath")
        );
    }

    @Override
    public List<Student> getStudentByPaging(int currentPage, int pageSize) {
        String sql="select * from student where stuno limit ?,?";
        int start=(currentPage-1)*pageSize;
        DBHelper dbHelper=new DBHelper();
        List<Object> params=new ArrayList<>();
        params.add(start);
        params.add(pageSize);
        List<Object> result=dbHelper.query(sql,params);
        List<Student> students=new ArrayList<>();
        for(Object o:result)
        {
            Map map=(Map)o;
            students.add(
                    new Student(
                            (String)map.get("stuno"),
                            (String)map.get("stuname"),
                            (String)map.get("classes"),
                            (String)map.get("gender"),
                            (String)map.get("major"),
                            (String)map.get("tel"),
                            (String)map.get("dormno"),
                            (String)map.get("photopath")
                    )
            );
        }
        return students;
    }
}
