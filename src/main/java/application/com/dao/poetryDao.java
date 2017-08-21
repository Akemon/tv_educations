package application.com.dao;

import application.com.bean.Poetry;
import application.com.bean.Record;
import org.apache.commons.collections.map.HashedMap;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class poetryDao {
    Connection connection = new DBConn().getConnect();

    //插入古诗
    public boolean insertPoem(Poetry poe) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT  into tv_poetry(title,poet,poem) VALUES (?,?,?)");
            preparedStatement.setString(1, poe.getTitle());
            preparedStatement.setString(2, poe.getPoet());
            preparedStatement.setString(3, poe.getPoem());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //随机获取三首古诗
    public List<Poetry> getThreePoemList() {
        List<Poetry> list = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT  * from tv_poetry ORDER  BY RAND() LIMIT 3");
            list = new ArrayList<Poetry>();
            while (rs.next()) {
                int poetryID = rs.getInt(1);
                String title = rs.getString(2);
                String poet = rs.getString(3);
                String poem = rs.getString(4);
                Poetry poe = new Poetry();
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
    public Poetry getOnePoem(int poetryID) {
        Poetry poe = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * from tv_poetry where poetryID=" + poetryID);
            if (rs.next()) {
                int poeID = rs.getInt(1);
                String title = rs.getString(2);
                String poet = rs.getString(3);
                String poem = rs.getString(4);
                poe = new Poetry(poeID, title, poet, poem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return poe;
    }


    //搜索古诗
    public List<Poetry> getResearchPoem(String title) {
        List<Poetry> list = new ArrayList<Poetry>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT  * from tv_poetry WHERE title like '%" + title + "%' LIMIT 5");
            while (rs.next()) {
                int poeID = rs.getInt(1);
                String titleNew = rs.getString(2);
                String poet = rs.getString(3);
                String poem = rs.getString(4);
                System.out.print(poem);
                String[] p=poem.split("/");

                Poetry poe = new Poetry(poeID, titleNew, poet, p);
                list.add(poe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }


    //记录结果
    public boolean recordScore(Record record) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT  into tv_record(studentID,poetryID,score,scoreTime) VALUES (?,?,?,?)");
            preparedStatement.setInt(1, record.getStudentid());
            preparedStatement.setInt(2, record.getPoetryid());
            preparedStatement.setString(3, record.getScore());
            preparedStatement.setString(4, record.getScoretime());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    //取出前七天的数据，用List存储起来
    public List<Record>  getSevenDayData(){
        //七天的所有分數和日期
        List<Record> recordList =new ArrayList<Record>();
        //七天的平均分和日期
        List<Record> averageList =new ArrayList<Record>();
        Date date =new Date();
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        try {
            long todayTime =df.parse(df.format(date)).getTime();
            long sevenDaysAgoTime =df.parse(df.format(new Date(date.getTime() -7 * 24 * 60 * 60 * 1000))).getTime();
            System.out.println("today:"+todayTime);
            System.out.println("sevenDaysAgo:"+sevenDaysAgoTime);
            Statement statement =connection.createStatement();
            ResultSet rs =statement.executeQuery("select  DATE_FORMAT(scoreTime,'%Y-%m-%d'),score from tv_record");

            while(rs.next()){
                long dataBaseTime =df.parse(df.format(rs.getDate(1))).getTime();
              //  System.out.println("dataBaseTime:"+dataBaseTime);
                //找出從今天開始往前七天的所有數據
                if(dataBaseTime>=sevenDaysAgoTime&&dataBaseTime<=todayTime){
                    Record record =new Record();
                    record.setScore(rs.getString("score"));
                    record.setScoretime(rs.getString(1));
                //    System.out.println("存储进List的时间："+rs.getString(1));
                    recordList.add(record);
                }

            }
            //将七天的数据整合成日期和对应的平均分
            //每循環一次將對應的平均分求出
            for(int i =1;i<=7;i++){
                int averageScore=0;
                Iterator<Record> iterator =recordList.iterator();
                //計算當天錄分次數
                int count =0;
                //遍歷所有七天的所有數據
                while(iterator.hasNext()){
                    Record record =iterator.next();
                    long recordTime =df.parse(record.getScoretime()).getTime();
                    //當天日期的時間
                    if(recordTime==todayTime){
                       averageScore+=Integer.parseInt(record.getScore());
                       count++;
                    }
                }
                //求出平均分
                averageScore=averageScore/count;
                System.out.println("平均分："+averageScore);
                Record newRecord =new Record();
                newRecord.setScore(String.valueOf(averageScore));
                Date newDate =new Date(todayTime);
                newRecord.setScoretime(df.format(newDate));
                averageList.add(newRecord);
                long needToSubtract =i*24*60*60*1000;
                //前一天的時間
                todayTime =df.parse(df.format(new Date(date.getTime() -needToSubtract))).getTime();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return averageList;
    }

    //test AverageList
    public void testAverageList(){
        Iterator<Record> iterator =getSevenDayData().iterator();
        while(iterator.hasNext()){
            Record record =iterator.next();
            System.out.println("日期："+record.getScoretime());
            System.out.println("平均分："+record.getScore());
        }
    }

       public static void main(String args[]){
        new poetryDao().getResearchPoem("忆");
    }




}