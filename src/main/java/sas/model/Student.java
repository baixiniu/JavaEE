package sas.model;

public class Student {
    private String stuNo;
    private String stuName;
    private String classes;
    private String gender;
    private String major;
    private String tel;
    private String dormNo;
    private String photoPath;

    public Student(String stuNo,String stuName,String classes
        ,String gender,String major,String tel,String dormNo
        ,String photoPath)
    {
        this.stuName=stuName;
        this.stuNo=stuNo;
        this.classes=classes;
        this.gender=gender;
        this.major=major;
        this.tel=tel;
        this.dormNo=dormNo;
        this.photoPath=photoPath;
    }

    public Student()
    {

    }

    @Override
    public String toString(){
        return "Student{"+"stuNo='"+stuNo+'\''+
                ","+"stuName='"+stuName+'\''+
                ","+"classes='"+classes+'\''+
                ","+"gender='"+gender+'\''+
                ","+"major='"+major+'\''+
                ","+"tel='"+tel+'\''+
                ","+"dormNo='"+dormNo+'\''+
                ","+"photoPath='"+photoPath+'\''+
                "}";
    }

    public String getStuNo() {
        return stuNo;
    }

    public String getClasses() {
        return classes;
    }

    public String getGender() {
        return gender;
    }

    public String getDormNo() {
        return dormNo;
    }

    public String getStuName() {
        return stuName;
    }

    public String getTel() {
        return tel;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public String getMajor() {
        return major;
    }
}
