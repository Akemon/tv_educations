package application.com.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class adminDao {
    Connection connection =new DBConn().getConnect();
    //登陆
    public boolean login(String adminName,String adminPass){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from tv_adminlogin where adminName=? and adminPass=?");
            preparedStatement.setString(1,adminName);
            preparedStatement.setString(2,adminPass);
            ResultSet rs = preparedStatement.executeQuery();
            System.out.print("eqq:"+rs);
            if(rs.next()){
                 preparedStatement = connection.prepareStatement("UPDATE  tv_adminlogin set adminStatus='在线' where adminName=?");
                preparedStatement.setString(1,adminName);
                int i=preparedStatement.executeUpdate();
                if(i==1){return true;}
                else{return false;}
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return false;

    }
    //注销
 public boolean logout (String adminName){
     try {
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE  tv_adminlogin set adminStatus='离线' where adminName=?");
             preparedStatement.setString(1,adminName);
             int i=preparedStatement.executeUpdate();
             if(i==1){return true;}
             else{return false;}

     } catch (SQLException e) {
         e.printStackTrace();

     }
     return false;
 }
public static void main(String[] args){
     adminDao ad=new adminDao();
     System.out.print(ad.logout("hk"));
}
}
