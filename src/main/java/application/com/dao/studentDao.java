package application.com.dao;


import application.com.bean.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class studentDao {
    Connection connection =new DBConn().getConnect();
    //插入学生
    public boolean insertStudent(Student stu){
        try {
            PreparedStatement preparedStatement =connection.prepareStatement("INSERT  into tv_student(studentNunber,studentName,studentGrade,schoolID,studentPhone) VALUES (?,?,?,?,?)");
            preparedStatement.setString(1,stu.getStudentnunber());
            preparedStatement.setString(2,stu.getStudentname());
            preparedStatement.setString(3,stu.getStudentgrade());
            preparedStatement.setInt(4,stu.getSchoolid());
            preparedStatement.setString(5,stu.getStudentphone());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    //删除学生
    public boolean delStudent(int studentID){
        try{
            PreparedStatement preparedStatement =connection.prepareStatement("DELETE from tv_student where studentID= ?");
            preparedStatement.setInt(1,studentID);
            preparedStatement.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    //修改学生信息
    public boolean modifyStudent(Student student){
        try{
            PreparedStatement preparedStatement =connection.prepareStatement("update tv_student set studentNunber=?, studentName=?,studentGrade=?,schoolID=?,studentPhone=? where studentID= ?");
            preparedStatement.setString(1,student.getStudentnunber());
            preparedStatement.setString(2,student.getStudentname());
            preparedStatement.setString(3,student.getStudentgrade());
            preparedStatement.setInt(4,student.getSchoolid());
            preparedStatement.setString(5,student.getStudentphone());
            preparedStatement.setInt(6,student.getStudentid());
            preparedStatement.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    //获取特定学生
   public Student getOneStudent(int studentID) {
       Student student;

       try {
           PreparedStatement preparedStatement = connection.prepareStatement("select * from tv_student  where studentID= ?");
           preparedStatement.setInt(1, studentID);
           ResultSet rs = preparedStatement.executeQuery();
           student = new Student(studentID, rs.getString("studentNunber"), rs.getString("studentName"), rs.getString("studentGrade"), rs.getInt("schoolID"), rs.getString("studentPhone"));
           return student;
       } catch (SQLException e) {
           e.printStackTrace();

       }
       return null;
   }
   //获取所有学生
   public List getStudent(){
       try {
           PreparedStatement preparedStatement = connection.prepareStatement("select * from tv_student ");

           ResultSet rs = preparedStatement.executeQuery();
           List<Student> students=new ArrayList<Student>();
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
   //根据学校获取学生
   public List getStudentForSchool(int schoolid){
       try {
           PreparedStatement preparedStatement = connection.prepareStatement("select * from tv_student where schoolID=?");
           preparedStatement.setInt(1,schoolid );
           ResultSet rs = preparedStatement.executeQuery();
           List<Student> students=new ArrayList<Student>();
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
}
