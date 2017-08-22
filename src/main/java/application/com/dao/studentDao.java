package application.com.dao;


import application.com.bean.NumberProvice;
import application.com.bean.Student;
import ch.qos.logback.classic.pattern.SyslogStartConverter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class studentDao {
    Connection connection = new DBConn().getConnect();

    //插入学生
    public boolean insertStudent(Student stu) {
        try{
            PreparedStatement preparedStatement2 = connection.prepareStatement("select * from tv_student where  userName=? ");
            preparedStatement2.setString(1, stu.getUserName());
            ResultSet rs = preparedStatement2.executeQuery();
            if (rs.next()) {
                return false;
            }
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT  into tv_student(studentNunber,studentName,studentGrade,schoolID,studentPhone,userName,userPass) VALUES (?,?,?,?,?,?,?)");
            preparedStatement.setString(1, stu.getStudentnunber());
            preparedStatement.setString(2, stu.getStudentname());
            preparedStatement.setString(3, stu.getStudentgrade());
            preparedStatement.setInt(4, stu.getSchoolid());
            preparedStatement.setString(5, stu.getStudentphone());
            preparedStatement.setString(6, stu.getUserName());
            preparedStatement.setString(7, stu.getUserPass());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    //删除学生
    public boolean delStudent(int studentID) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE from tv_student where studentID= ?");
            preparedStatement.setInt(1, studentID);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //修改学生信息
    public boolean modifyStudent(Student student) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update tv_student set studentNunber=?, studentName=?,studentGrade=?,schoolID=?,studentPhone=? where studentID= ?");
            preparedStatement.setString(1, student.getStudentnunber());
            preparedStatement.setString(2, student.getStudentname());
            preparedStatement.setString(3, student.getStudentgrade());
            preparedStatement.setInt(4, student.getSchoolid());
            preparedStatement.setString(5, student.getStudentphone());
            preparedStatement.setInt(6, student.getStudentid());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //搜索学生
    public List<Student> searchStudent(String search) {


        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from tv_student where studentName like ? ");
            preparedStatement.setString(1,"%"+search+"%");
            ResultSet rs = preparedStatement.executeQuery();

            List<Student> students = new ArrayList<Student>();
            while (rs.next()) {
                Student student = new Student(rs.getInt("studentID"), rs.getString("studentNunber"), rs.getString("studentName"), rs.getString("studentGrade"), rs.getInt("schoolID"), rs.getString("studentPhone"));
                students.add(student);
            }
            PreparedStatement preparedStatement2 = connection.prepareStatement("select * from tv_student where studentNunber like ? ");
            preparedStatement2.setString(1,"%"+search+"%");
            ResultSet rs2 = preparedStatement2.executeQuery();
            while (rs2.next()) {
                Student student = new Student(rs2.getInt("studentID"), rs.getString("studentNunber"), rs.getString("studentName"), rs.getString("studentGrade"), rs.getInt("schoolID"), rs.getString("studentPhone"));
                students.add(student);
            }
            return students;

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }

    //获取所有学生
    public List<Student> getStudent() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from tv_student,tv_school where tv_student.schoolID=tv_school.schoolID");

            ResultSet rs = preparedStatement.executeQuery();
            List<Student> students = new ArrayList<Student>();
            while (rs.next()) {
                Student student = new Student(rs.getInt("studentID"), rs.getString("studentNunber"), rs.getString("studentName"), rs.getString("studentGrade"), rs.getInt("schoolID"), rs.getString("studentPhone"), rs.getString("schoolName"));
                students.add(student);
            }
            return students;

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;

    }

    //根据省份、学校、班级获取学生
    public List<Student> getStudentForSchoolAndGrade(String studentGrade, String SchoolName, String schoolProvince) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from tv_student,tv_school where tv_student.schoolID=tv_school.schoolID AND studentGrade=? and schoolName=? AND schoolProvince=?");
            preparedStatement.setString(1, studentGrade);
            preparedStatement.setString(2, SchoolName);
            preparedStatement.setString(3, schoolProvince);
            ResultSet rs = preparedStatement.executeQuery();
            List<Student> students = new ArrayList<Student>();
            while (rs.next()) {
                Student student = new Student(rs.getInt("studentID"), rs.getString("studentNunber"), rs.getString("studentName"), rs.getString("studentGrade"), rs.getInt("schoolID"), rs.getString("studentPhone"));
                students.add(student);
            }
            return students;

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;

    }

    //根据省份、学校获取班级
    public List<String> getSchoolGrade(String schoolName, String schoolprovvince) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select distinct  studentGrade from tv_student,tv_school where tv_student.schoolID=tv_school.schoolID and schoolName=? AND schoolProvince=?");
            preparedStatement.setString(1, schoolName);
            preparedStatement.setString(2, schoolprovvince);
            ResultSet rs = preparedStatement.executeQuery();
            List<String> students = new ArrayList<String>();
            while (rs.next()) {
                students.add(rs.getString("studentGrade"));
            }
            return students;

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }

    //登陆获取当前学生信息
    public Student studentLogin(String userName, String userPass) {
        try {

            PreparedStatement preparedStatement = connection.prepareStatement("select * from tv_student,tv_school where tv_student.schoolID=tv_school.schoolID AND userName=? and userPass=?");
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, userPass);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                Date date =new Date();
                SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
                String res="";
                try {
                    long todayTime = df.parse(df.format(date)).getTime();
                    long holidayTime = df.parse(df.format(rs.getDate("schoolHoliday"))).getTime();
                    res=(holidayTime-todayTime)/(24*3600*1000)+"";
                    System.out.println(res);
                }catch(ParseException e){e.printStackTrace();}

                Student student = new Student(rs.getInt("studentID"), rs.getString("studentNunber"), rs.getString("studentName"), rs.getString("studentGrade"), rs.getInt("schoolID"), rs.getString("studentPhone"), rs.getString("schoolName"),res);

                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }

    //学生注册
    public boolean studentRegister(Student student) {
                 return insertStudent(student);
    }
// 统计学生数量
    public int countStudent(){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select  count(*) from tv_student ");

            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){int sum=rs.getInt(1);
                return sum;}




        } catch (SQLException e) {
            e.printStackTrace();

        }

      return 0;
    }

    //按照省份统计学生数量
    public List<NumberProvice> countNumberProvice(){
         String[] province={"北京市","天津市","上海市","重庆市","河北省","山西省","辽宁省","吉林省","黑龙江省","江苏省","浙江省","安徽省","福建省","江西省","山东省","河南省","湖北省","湖南省","广东省","海南省","四川省","贵州省","云南省","陕西省","甘肃省","青海省","台湾省","内蒙古自治区","广西壮族自治区","西藏自治区","宁夏回族自治区","新疆维吾尔自治区","香港特别行政区","澳门特别行政区"} ;
        List<NumberProvice> NumberProvice=new ArrayList<NumberProvice>();
        for(int i=0;i<34;i++){
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("select  count(*) from tv_student LEFT join tv_school on tv_student.schoolID=tv_school.schoolID where schoolProvince= ?");
                preparedStatement.setString(1, province[i]);
                //preparedStatement.setString(1,"广东省");
                ResultSet rs = preparedStatement.executeQuery();
                if(rs.next()){int sum=rs.getInt(1);
                System.out.print("省份："+sum);
                    NumberProvice np=new NumberProvice(province[i],sum);
                    NumberProvice.add(np);
                }
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }

        return NumberProvice;
    }






    public static void main(String[] args)   {
      // studentDao sd=new studentDao();
      // sd.studentLogin("fwz","123");
      // sd.studentLogin("sat","123");


       // System.out.print(sd.searchStudent("冯").get(0).getStudentname());
//
       // Student s1=new Student( "11245533",  "柳而蛋",  "初一二班",  1,  "1224354434232","www","123" );
      //  sd.insertStudent(s1);
        //System.out.print(sd.countNumberProvice());
        //System.out.print(sd.studentLogin("fwz","123").getSchoolname());
        //sd.delStudent(2);
        //System.out.print(sd.getStudent().get(1).getStudentname());

       // System.out.print(sd.countStudent());
   }

}