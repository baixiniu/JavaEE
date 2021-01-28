package sas.dao;

import sas.model.Student;

import java.util.List;

/**
 * @Description 对student进行增删改查
 */
public interface StudentDao {
    List<Student> getAllStudent();
    List<Student> getStudentsByName(String name);
    boolean saveStudent(Student s);
    boolean deleStudent(String stuno);
    boolean modifyStudent(Student s);
    Student getStudentByNo(String stuno);
    List<Student> getStudentByPaging(int currentPage, int pageSize);
}
