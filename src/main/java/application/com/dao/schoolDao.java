package application.com.dao;
import java.sql.Connection;
import application.com.bean.School;
import application.com.bean.Teacher;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class schoolDao {
    Connection connection =new DBConn().getConnect();
    //插入学校
    public boolean insertSchool(School school){

        try {

            PreparedStatement preparedStatement =connection.prepareStatement("INSERT  into tv_school(schoolName,schoolProvince,schoolAddress,schoolType,schoolPhone) VALUES (?,?,?,?,?)");
            preparedStatement.setString(1,school.getSchoolname());
            preparedStatement.setString(2,school.getSchoolprovince());
            preparedStatement.setString(3,school.getSchooladdress());
            preparedStatement.setString(4,school.getSchooltype());
            preparedStatement.setString(5,school.getSchoolphone());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    //删除学校
    public boolean delSchool(int schoolID){
        try{
            PreparedStatement preparedStatement =connection.prepareStatement("DELETE from tv_school where schoolID= ?");
            preparedStatement.setInt(1,schoolID);
            preparedStatement.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    //修改学校信息
    public boolean modifyStudent(School school){
        try{
            PreparedStatement preparedStatement =connection.prepareStatement("update tv_school set schoolName=?, schoolProvince=?,schoolAddress=?,schoolType=?,schoolPhone=? where schoolID= ?");
            preparedStatement.setString(1,school.getSchoolname());
            preparedStatement.setString(2,school.getSchoolprovince());
            preparedStatement.setString(3,school.getSchooladdress());
            preparedStatement.setString(4,school.getSchooltype());
            preparedStatement.setString(5,school.getSchoolphone());
            preparedStatement.setInt(6,school.getSchoolid());
            preparedStatement.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    //获取所有学校
    public List getSchool(){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from tv_school ");

            ResultSet rs = preparedStatement.executeQuery();
            List<School> schools=new ArrayList<School>();
            while (rs.next()) {
                School school = new School(rs.getInt("schoolID"), rs.getString("schoolName"), rs.getString("schoolProvince"), rs.getString("schoolAddress"), rs.getString("schoolType"), rs.getString("schoolPhone"));
                schools.add(school);
            }
            return schools;

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;

    }
}
