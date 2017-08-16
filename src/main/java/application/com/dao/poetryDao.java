package application.com.dao;

import application.com.bean.Poetry;
import application.com.bean.Record;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class poetryDao {
    Connection connection =new DBConn().getConnect();
    //插入古诗
    public boolean insertPoem(Poetry poe){
        try {
            PreparedStatement preparedStatement =connection.prepareStatement("INSERT  into tv_poetry(title,poet,poem) VALUES (?,?,?)");
            preparedStatement.setString(1,poe.getTitle());
            preparedStatement.setString(2,poe.getPoet());
            preparedStatement.setString(3,poe.getPoem());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //随机获取三首古诗
    public List<Poetry> getThreePoemList(){
        List<Poetry> list = null;
        try {
            Statement statement =connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT  * from tv_poetry ORDER  BY RAND() LIMIT 3");
            list =new ArrayList<Poetry>();
            while(rs.next()){
                int poetryID =rs.getInt(1);
                String title =rs.getString(2);
                String poet =rs.getString(3);
                String poem =rs.getString(4);
                Poetry  poe =new Poetry();
                poe.setPoetryid(poetryID);
                poe.setPoem(poem);
                poe.setPoet(poet);
                poe.setTitle(title);
                list.add(poe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //获取一首古诗
    public Poetry getOnePoem(int poetryID){
        Poetry poe =null;
        try {
            Statement statement =connection.createStatement();
            ResultSet rs =statement.executeQuery("SELECT * from tv_poetry where poetryID="+poetryID);
            if(rs.next()){
                int poeID =rs.getInt(1);
                String title =rs.getString(2);
                String poet =rs.getString(3);
                String poem =rs.getString(4);
                poe =new Poetry(poeID,title,poet,poem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return poe;
    }


    //搜索古诗
    public List<Poetry> getResearchPoem(String title){
        List<Poetry> list =new ArrayList<Poetry>();
        try {
            Statement statement =connection.createStatement();
            ResultSet rs =statement.executeQuery("SELECT  * from tv_poetry WHERE title like '%"+title+"%' LIMIT 5");
            while(rs.next()){
                int poeID =rs.getInt(1);
                String titleNew =rs.getString(2);
                String poet =rs.getString(3);
                String poem =rs.getString(4);
                Poetry poe =new Poetry(poeID,titleNew,poet,poem);
                list.add(poe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }


    //记录结果
    public boolean recordScore(Record record){
        try {
            PreparedStatement preparedStatement =connection.prepareStatement("INSERT  into tv_record(studentID,poetryID,score,scoreTime) VALUES (?,?,?,?)");
            preparedStatement.setInt(1,record.getStudentid());
            preparedStatement.setInt(2,record.getPoetryid());
            preparedStatement.setString(3,record.getScore());
            preparedStatement.setString(4,record.getScoretime());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
