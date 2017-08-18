package application.com.bean;

public class Student {
    private Integer studentid;

    private String studentnunber;

    private String studentname;

    private String studentgrade;

    private Integer schoolid;

    private String schoolname;

    public String getUserName() {
        return userName;
    }

    public Student(Integer studentid, String studentnunber, String studentname, String studentgrade, Integer schoolid, String studentphone,String schoolname) {
        this.studentid = studentid;
        this.studentnunber = studentnunber;
        this.studentname = studentname;
        this.studentgrade = studentgrade;
        this.schoolid = schoolid;
        this.studentphone = studentphone;
        this.schoolname=schoolname;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    public Student(String studentnunber, String studentname, String studentgrade, Integer schoolid, String studentphone, String userName, String userPass) {
        this.studentnunber = studentnunber;
        this.studentname = studentname;
        this.studentgrade = studentgrade;
        this.schoolid = schoolid;
        this.studentphone = studentphone;
        this.userName = userName;
        this.userPass = userPass;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    private String studentphone;

    private String userName;

    private String userPass;

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public String getStudentnunber() {
        return studentnunber;
    }

    public void setStudentnunber(String studentnunber) {
        this.studentnunber = studentnunber == null ? null : studentnunber.trim();
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname == null ? null : studentname.trim();
    }

    public String getStudentgrade() {
        return studentgrade;
    }

    public void setStudentgrade(String studentgrade) {
        this.studentgrade = studentgrade == null ? null : studentgrade.trim();
    }

    public Integer getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(Integer schoolid) {
        this.schoolid = schoolid;
    }

    public String getStudentphone() {
        return studentphone;
    }

    public void setStudentphone(String studentphone) {
        this.studentphone = studentphone == null ? null : studentphone.trim();
    }

    public Student(Integer studentid, String studentnunber, String studentname, String studentgrade, Integer schoolid, String studentphone) {
        this.studentid = studentid;
        this.studentnunber = studentnunber;
        this.studentname = studentname;
        this.studentgrade = studentgrade;
        this.schoolid = schoolid;
        this.studentphone = studentphone;
    }

}