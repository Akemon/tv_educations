package application.com.dao;
import java.sql.*;

import application.com.bean.School;
import application.com.bean.Teacher;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class schoolDao {
    Connection connection =new DBConn().getConnect();
    //插入学校
    public boolean insertSchool(School school){

        try {

            PreparedStatement preparedStatement =connection.prepareStatement("INSERT  into tv_school(schoolName,schoolProvince,schoolAddress,schoolType,schoolPhone,schoolHoliday) VALUES (?,?,?,?,?,?)");
            preparedStatement.setString(1,school.getSchoolname());
            preparedStatement.setString(2,school.getSchoolprovince());
            preparedStatement.setString(3,school.getSchooladdress());
            preparedStatement.setString(4,school.getSchooltype());
            preparedStatement.setString(5,school.getSchoolphone());

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date  date = sdf.parse(school.getSchoolHoliday());
                preparedStatement.setDate(6, (Date) date);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e1) {
            e1.printStackTrace();
        }catch (ParseException e2){
        e2.printStackTrace();
        }
        return false;
    }
    //删除学校
    public boolean delSchool(int schoolID){
        try{
            PreparedStatement preparedStatement2 =connection.prepareStatement("SELECT * from tv_student where schoolID= ?");
            preparedStatement2.setInt(1,schoolID);
            if(preparedStatement2.executeQuery().next()){return false;}

            PreparedStatement preparedStatement3 =connection.prepareStatement("SELECT * from tv_teacher where schoolID= ?");
            preparedStatement3.setInt(1,schoolID);
            if(preparedStatement3.executeQuery().next()){return false;}

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
    public boolean modifyStudent(School school) throws ParseException {
        try{
            PreparedStatement preparedStatement =connection.prepareStatement("update tv_school set schoolName=?, schoolProvince=?,schoolAddress=?,schoolType=?,schoolPhone=?,schoolHoliday=? where schoolID= ?");
            preparedStatement.setString(1,school.getSchoolname());
            preparedStatement.setString(2,school.getSchoolprovince());
            preparedStatement.setString(3,school.getSchooladdress());
            preparedStatement.setString(4,school.getSchooltype());
            preparedStatement.setString(5,school.getSchoolphone());
            preparedStatement.setInt(6,school.getSchoolid());
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date  date = sdf.parse(school.getSchoolHoliday());
                preparedStatement.setDate(7, (Date) date);
            }catch(ParseException e){e.printStackTrace();}
            preparedStatement.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    //获取所有学校
    public List<School> getSchool(){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from tv_school ");

            ResultSet rs = preparedStatement.executeQuery();
            List<School> schools=new ArrayList<School>();
            while (rs.next()) {
                String temp=rs.getDate("schoolHoliday")+"";
                School school = new School(rs.getInt("schoolID"), rs.getString("schoolName"), rs.getString("schoolProvince"), rs.getString("schoolAddress"), rs.getString("schoolType"), rs.getString("schoolPhone"),temp);
                schools.add(school);
            }
            return schools;

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;

    }
    //根据省份获取学校
    public List getSchoolForProvince(String schoolprovince){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from tv_school where schoolProvince=?");
            preparedStatement.setString(1,schoolprovince);
            ResultSet rs = preparedStatement.executeQuery();

            List<School> schools=new ArrayList<School>();
            while (rs.next()) {
                String temp=rs.getDate("schoolHoliday")+"";
                School school = new School(rs.getInt("schoolID"), rs.getString("schoolName"), rs.getString("schoolProvince"), rs.getString("schoolAddress"), rs.getString("schoolType"), rs.getString("schoolPhone"),temp);
                schools.add(school);
            }
            return schools;

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;

    }
    //根据学校名字搜索
    public List<School> getSchoolForName(String schoolname){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from tv_school where schoolName LIKE ?");
            preparedStatement.setString(1,"%"+schoolname+"%");
            ResultSet rs = preparedStatement.executeQuery();

            List<School> schools=new ArrayList<School>();
            while (rs.next()) {
                String temp=rs.getDate("schoolHoliday")+"";
                School school = new School(rs.getInt("schoolID"), rs.getString("schoolName"), rs.getString("schoolProvince"), rs.getString("schoolAddress"), rs.getString("schoolType"), rs.getString("schoolPhone"),temp);


                schools.add(school);
            }
            return schools;

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;

    }
   //统计学校数量
   public int countSchool(){
       try {
           PreparedStatement preparedStatement = connection.prepareStatement("select  count(*) from tv_school ");

           ResultSet rs = preparedStatement.executeQuery();
           if(rs.next()){int sum=rs.getInt(1);
               return sum;}




       } catch (SQLException e) {
           e.printStackTrace();

       }

       return 0;


   }

//   public static  void main(String[] args){
//       schoolDao sd=new schoolDao();
//      //  School s1=new School(2,"深圳高级实验中学","广东省","深圳市","中学","2434343");
//      //System.out.print(sd.getSchool().get(0).getSchoolHoliday());
//        //System.out.print(sd.insertSchool(s1));
//        //System.out.print(sd.modifyStudent(s1));
//       // System.out.print(sd.getSchool());
//       // System.out.print(sd.getSchoolForProvince("广东省 "));
//        //System.out.print(sd.countSchool());
//   }
}
