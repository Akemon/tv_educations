package application.com.dao;


import application.com.bean.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class teacherDao {
    Connection connection =new DBConn().getConnect();
    //插入教师
    public boolean insertTeacher(Teacher tea){
        try {
            PreparedStatement preparedStatement =connection.prepareStatement("INSERT  into tv_teacher(teacherNunber,teacherName,schoolID,teacherPhone) VALUES (?,?,?,?)");
            preparedStatement.setString(1,tea.getTeachernumber());
            preparedStatement.setString(2,tea.getTeachername());
            preparedStatement.setInt(3,tea.getSchoolid());
            preparedStatement.setString(4,tea.getTeacherphone());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    //删除教师
    public boolean delTeacher(int teacherID){
        try{
            PreparedStatement preparedStatement =connection.prepareStatement("DELETE from tv_teacher where teacherID= ?");
            preparedStatement.setInt(1,teacherID);
            preparedStatement.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    //修改学生信息
    public boolean modifyTeacher(Teacher teacher){
        try{
            PreparedStatement preparedStatement =connection.prepareStatement("update tv_teacher set teacherNunber=?, teacherName=?,schoolID=?,teacherPhone=? where teacherID= ?");
            preparedStatement.setString(1,teacher.getTeachernumber());
            preparedStatement.setString(2,teacher.getTeachername());
            preparedStatement.setInt(3,teacher.getTeacherid());
            preparedStatement.setString(4,teacher.getTeacherphone());
            preparedStatement.setInt(5,teacher.getTeacherid());
            preparedStatement.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    //获取特定老师
    public Teacher getOneTeacher(int teacherID) {
        Teacher teacher;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from tv_teacher  where teacherID= ?");
            preparedStatement.setInt(1, teacherID);
            ResultSet rs = preparedStatement.executeQuery();
            teacher = new Teacher(teacherID, rs.getString("teacherNumber"), rs.getString("teacherName"), rs.getInt("schoolID"), rs.getString("teacherPhone"));
            return teacher;
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }
    //获取所有教师
    public List getTeacher(){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from tv_teacher ");

            ResultSet rs = preparedStatement.executeQuery();
            List<Teacher> teachers=new ArrayList<Teacher>();
            while (rs.next()) {
                Teacher teacher = new Teacher(rs.getInt("teacherID"), rs.getString("teacherNumber"), rs.getString("teacherName"), rs.getInt("schoolID"), rs.getString("teacherPhone"));
                teachers.add(teacher);
            }
            return teachers;

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;

    }
    //根据学校获取老师
    public List getTeacherForSchool(int schoolid){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from tv_teacher where schoolID=?");
            preparedStatement.setInt(1,schoolid );
            ResultSet rs = preparedStatement.executeQuery();
            List<Teacher> teachers=new ArrayList<Teacher>();
            while (rs.next()) {
                Teacher teacher = new Teacher(rs.getInt("teacherID"), rs.getString("teacherNumber"), rs.getString("teacherName"), rs.getInt("schoolID"), rs.getString("teacherPhone"));
                teachers.add(teacher);
            }
            return teachers;

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;

    }
}
