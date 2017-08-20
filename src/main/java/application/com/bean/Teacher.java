package application.com.bean;

public class Teacher {
    private Integer teacherid;

    private String teachernumber;

    private String teachername;

    private Integer schoolid;

    private String teacherphone;

    private String schoolName;

    public Teacher(Integer teacherid, String teachernumber, String teachername, Integer schoolid, String teacherphone,String schoolName) {
        this.teacherid = teacherid;
        this.teachernumber = teachernumber;
        this.teachername = teachername;
        this.schoolid = schoolid;
        this.teacherphone = teacherphone;
        this.schoolName = schoolName;

    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getUserName() {
        return userName;
    }

    public Teacher(String teachernumber, String teachername, Integer schoolid, String teacherphone, String userName, String userPass) {
        this.teachernumber = teachernumber;
        this.teachername = teachername;
        this.schoolid = schoolid;
        this.teacherphone = teacherphone;
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

    private String userName;

    private String userPass;

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public String getTeachernumber() {
        return teachernumber;
    }

    public void setTeachernumber(String teachernumber) {
        this.teachernumber = teachernumber == null ? null : teachernumber.trim();
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername == null ? null : teachername.trim();
    }

    public Integer getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(Integer schoolid) {
        this.schoolid = schoolid;
    }

    public String getTeacherphone() {
        return teacherphone;
    }

    public void setTeacherphone(String teacherphone) {
        this.teacherphone = teacherphone == null ? null : teacherphone.trim();
    }

    public Teacher(Integer teacherid, String teachernumber, String teachername, Integer schoolid, String teacherphone) {
        this.teacherid = teacherid;
        this.teachernumber = teachernumber;
        this.teachername = teachername;
        this.schoolid = schoolid;
        this.teacherphone = teacherphone;
    }
}