package application.com.dao;


import application.com.bean.NumberProvice;
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
            PreparedStatement preparedStatement2 = connection.prepareStatement("select * from tv_teacher where  userName=? ");
            preparedStatement2.setString(1, tea.getUserName());
            ResultSet rs = preparedStatement2.executeQuery();
            if (rs.next()) {
                return false;
            }
            PreparedStatement preparedStatement =connection.prepareStatement("INSERT  into tv_teacher(teacherNumber,teacherName,schoolID,teacherPhone,userName,userPass) VALUES (?,?,?,?,?,?)");
            preparedStatement.setString(1,tea.getTeachernumber());
            preparedStatement.setString(2,tea.getTeachername());
            preparedStatement.setInt(3,tea.getSchoolid());
            preparedStatement.setString(4,tea.getTeacherphone());
            preparedStatement.setString(5,tea.getUserName());
            preparedStatement.setString(6,tea.getUserPass());
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
            PreparedStatement preparedStatement =connection.prepareStatement("update tv_teacher set teacherNumber=?, teacherName=?,schoolID=?,teacherPhone=? where teacherID= ?");
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
    //搜索老师
    public List<Teacher> searchTeacher(String search) {


        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from tv_teacher  where teacherName like ?");
            preparedStatement.setString(1, "%"+search+"%");
            ResultSet rs = preparedStatement.executeQuery();
            List<Teacher> teachers=new ArrayList<Teacher>();
            while(rs.next()){
                Teacher  teacher = new Teacher(rs.getInt("teacherID"),rs.getString("teacherNumber"), rs.getString("teacherName"), rs.getInt("schoolID"), rs.getString("teacherPhone"));
                teachers.add(teacher);
            }

            PreparedStatement preparedStatement2 = connection.prepareStatement("select * from tv_teacher  where teacherNumber like ?");
            preparedStatement2.setString(1, "%"+search+"%");
            ResultSet rs2= preparedStatement2.executeQuery();
            while(rs2.next()){
                Teacher  teacher = new Teacher(rs.getInt("teacherID"),rs.getString("teacherNumber"), rs.getString("teacherName"), rs.getInt("schoolID"), rs.getString("teacherPhone"));
                teachers.add(teacher);
            }

            return teachers;
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }
    //获取所有教师
    public List<Teacher> getTeacher(){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from tv_teacher,tv_school where tv_teacher.schoolID=tv_school.schoolID ");

            ResultSet rs = preparedStatement.executeQuery();
            List<Teacher> teachers=new ArrayList<Teacher>();
            while (rs.next()) {
                Teacher teacher = new Teacher(rs.getInt("teacherID"), rs.getString("teacherNumber"), rs.getString("teacherName"), rs.getInt("schoolID"), rs.getString("teacherPhone"),rs.getString("schoolName"));
                teachers.add(teacher);
            }
            return teachers;

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;

    }
    //根据省份、学校获取老师
    public List<Teacher> getTeacherForSchool(String schoolName,String schoolProvince){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from tv_teacher,tv_school where tv_teacher.schoolID=tv_school.schoolID AND schoolName=? and schoolProvince=?");
            preparedStatement.setString(1,schoolName );
            preparedStatement.setString(2,schoolProvince );
            ResultSet rs = preparedStatement.executeQuery();
            List<Teacher> teachers=new ArrayList<Teacher>();
            while (rs.next()) {
                Teacher teacher = new Teacher(rs.getInt("teacherID"), rs.getString("teacherNumber"), rs.getString("teacherName"), rs.getInt("schoolID"), rs.getString("teacherPhone"),rs.getString("schoolName"));
                teachers.add(teacher);
            }
            return teachers;

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;

    }

    //教师登陆
    public Teacher studentLogin(String userName, String userPass) {
        try {

            PreparedStatement preparedStatement = connection.prepareStatement("select * from tv_teacher,tv_school where tv_student.schoolID=tv_school.schoolID AND userName=? and userPass=?");
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, userPass);
            ResultSet rs = preparedStatement.executeQuery();
            System.out.print("eqq:" + rs);
            if (rs.next()) {
                Teacher teacher = new Teacher(rs.getInt("teacherID"), rs.getString("teacherNumber"), rs.getString("teacherName"), rs.getInt("schoolID"), rs.getString("teacherPhone"),rs.getString("schoolName"));
                return teacher;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }
    //教师注册
    public boolean teacherRegister(Teacher teacher) {
         return insertTeacher(teacher);
    }
    //统计教师数量
    public int countTeacher(){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select  count(*) from tv_teacher ");

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
                PreparedStatement preparedStatement = connection.prepareStatement("select  count(*) from tv_teacher LEFT join tv_school on tv_teacher.schoolID=tv_school.schoolID where schoolProvince= ?");
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


public static void main(String[] args){
    teacherDao rd=new teacherDao();
   // System.out.print(rd.countTeacher());
    System.out.print(rd.countNumberProvice());
}


}