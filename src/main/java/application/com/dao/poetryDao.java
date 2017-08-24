package application.com.dao;

import application.com.bean.NumberProvice;
import application.com.bean.Poetry;
import application.com.bean.Record;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.commons.collections.map.HashedMap;

import java.sql.*;
import java.text.DecimalFormat;
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
    public List<Poetry> getResearchPoem(String title,int pageNum) {
        List<Poetry> list = new ArrayList<Poetry>();
        try {
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = statement.executeQuery("SELECT  * from tv_poetry WHERE title like '%" + title + "%' ");

           if(!rs.next())  return list;
            rs.absolute((pageNum-1)*6+1);
           for(int k=0;k<6;k++){
                int poeID = rs.getInt(1);
                String titleNew = rs.getString(2);
                String poet = rs.getString(3);
                String poem = rs.getString(4);
                System.out.print(poem);

                String[] p=poem.split("/");
                String temp="";
                for(int i=0;i<p.length;i++) {
                    temp = temp + p[i];
                    if ((i + 1) % 2 == 0) {
                        temp = temp + "。<br />";
                    } else {
                        temp = temp + "，<br />";
                    }
                }
               // System.out.print(temp);
                Poetry poe = new Poetry(poeID, titleNew, poet, temp);
                list.add(poe);
               if(!rs.next()) break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }
    //获取古诗的总数量
    public int getAllpoemNumber(String title){
        int totalNumber =0;
        try {
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs =statement.executeQuery("select * from tv_poetry WHERE title like '%" + title + "%' ");
            rs.last();
            totalNumber =rs.getRow();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalNumber;

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
    public List<Record>  getSevenDayData(int studentID){
        //七天的所有分數和日期
        List<Record> recordList =new ArrayList<Record>();
        //七天的平均分和日期
        List<Record> averageList =new ArrayList<Record>();
        Date date =new Date();
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        try {
            long todayTime =df.parse(df.format(date)).getTime();
            long sevenDaysAgoTime =df.parse(df.format(new Date(date.getTime() -6 * 24 * 60 * 60 * 1000))).getTime();
            System.out.println("today:"+todayTime);
            System.out.println("sevenDaysAgo:"+sevenDaysAgoTime);
            Statement statement =connection.createStatement();
            ResultSet rs =statement.executeQuery("select  DATE_FORMAT(scoreTime,'%Y-%m-%d'),score from tv_record where studentID="+studentID);

            while(rs.next()){
                long dataBaseTime =df.parse(df.format(rs.getDate(1))).getTime();
              //  System.out.println("dataBaseTime:"+dataBaseTime);
                //找出從今天開始往前七天的所有數據
                if(dataBaseTime>=sevenDaysAgoTime&&dataBaseTime<=todayTime){
                    Record record =new Record();
                    record.setScore(rs.getString("score"));
                    record.setScoretime(rs.getString(1));
                    System.out.println("存储进List的时间："+rs.getString(1));
                    recordList.add(record);
                }

            }
            //将七天的数据整合成日期和对应的平均分
            //每循環一次將對應的平均分求出
            long sevenDaysAgo =df.parse(df.format(new Date(date.getTime() -6*24*60*60*1000))).getTime();
            long currentTime =df.parse(df.format(new Date(date.getTime() -6*24*60*60*1000))).getTime();
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
                    if(recordTime==currentTime){
                       averageScore+=Integer.parseInt(record.getScore());
                       count++;
                    }
                }
                //求出平均分
                if(count!=0)
                averageScore=averageScore/count;
                System.out.println("平均分："+averageScore);
                Record newRecord =new Record();
                newRecord.setScore(String.valueOf(averageScore));
                Date newDate =new Date(currentTime);
                newRecord.setScoretime(df.format(newDate));
                averageList.add(newRecord);
                long needToAdd =i*24*60*60*1000;
                //后一天的時間
                currentTime =df.parse(df.format(new Date(sevenDaysAgo +needToAdd))).getTime();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return averageList;
    }

        //超越人数
        public  String getOverPeoplePercent(int studentID){
            String percent ="";
            int allStudentNum =0;
            Date date =new Date();
            SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
            List<Record> scoreList =new ArrayList<Record>();
            Map<Integer,Record> map =new HashMap<Integer, Record>();
            try {
                long todayTime =df.parse(df.format(date)).getTime();
                Statement statement =connection.createStatement();
                ResultSet rs = statement.executeQuery("SELECT  DATE_FORMAT(scoreTime,'%Y-%m-%d'),studentID,score from tv_record");
                while(rs.next()){
                    long dataBaseTime =df.parse(df.format(rs.getDate(1))).getTime();
                    if(dataBaseTime==todayTime){
                        Record  record =new Record();
                        record.setScore(rs.getString("score"));
                        record.setStudentid(rs.getInt("studentID"));
                        if(!map.containsKey(record.getStudentid())){
                            record.setAlreadyReadNum(1);
                            map.put(record.getStudentid(),record);
                        }else{
                            Record oldRecord =map.get(record.getStudentid());
                            String oldScore =String.valueOf(Integer.parseInt(oldRecord.getScore())+Integer.parseInt(record.getScore()));
                            int oldReadNum =oldRecord.getAlreadyReadNum()+1;
                            oldRecord.setAlreadyReadNum(oldReadNum);
                            oldRecord.setScore(oldScore);
                            map.put(record.getStudentid(),oldRecord);
                        }

                    }
                }
                //再次查询学生表，找出没读的学生
                Statement statement1 =connection.createStatement();
                ResultSet rs2 =statement1.executeQuery("select * from tv_student");
                while(rs2.next()){
                    allStudentNum++;
                    int studentID2 =rs2.getInt("studentID");
                    if(!map.containsKey(studentID2)){
                        Record record2 =new Record();
                        record2.setStudentid(studentID2);
                        record2.setScore("0");
                        map.put(studentID2,record2);
                    }
                }


                //求平均数
                Iterator<Record> iterator =map.values().iterator();
                while(iterator.hasNext()){
                    Record record =iterator.next();
                    int averageScore =0;
                    if(Integer.parseInt(record.getScore())!=0) {
                        averageScore = Integer.parseInt(record.getScore()) / record.getAlreadyReadNum();
                        System.out.println("平均数：" + averageScore);
                        System.out.println("学生ID：" + record.getStudentid());
                        record.setScore(String.valueOf(averageScore));
                    }
                    scoreList.add(record);
                }
                //排序
              Collections.sort(scoreList, new Comparator<Record>() {
                  @Override
                  public int compare(Record o1, Record o2) {
                      return Integer.parseInt(o1.getScore())>Integer.parseInt(o2.getScore())?-1:0;
                  }
              });
               //判断学生id位于第几位
                System.out.println("排序之后 的list");
                Iterator<Record> iteratornew =scoreList.iterator();
                int count =0;
                while(iteratornew.hasNext()){
                    count++;
                    Record record =iteratornew.next();
                    System.out.println("学生ID："+record.getStudentid());
                    System.out.println("分数 ："+record.getScore());
                    if(record.getStudentid()==studentID){
                        break;
                    }

                }
                System.out.println("排名："+count);
                System.out.println("总人数："+allStudentNum);
                percent =(int)( (double)(allStudentNum-count+1)/allStudentNum *100 )+"%";
                System.out.println("超越人数："+percent);



                //testMapList(map);

            } catch (Exception e) {
                e.printStackTrace();
            }
            return percent;
        }





    //当天学生读古诗的数量
    public int countTime(int studentID){
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd ");//设置日期格式
            System.out.println(df.format(new Date()));// new Date()为获取当前系统时
            PreparedStatement preparedStatement = connection.prepareStatement("select  count(*) from tv_record WHERE studentID=? and scoreTime=?");
            preparedStatement.setInt(1,studentID);
            preparedStatement.setString(2, df.format(new Date()));
            ResultSet rs = preparedStatement.executeQuery();
            int sum=0;
            if(rs.next()){
                sum=rs.getInt(1);
            }
            return sum;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    //学生读诗的总共数量
    public int countAllTime(int studentID){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select  count(*) from tv_record WHERE studentID=?");
            preparedStatement.setInt(1,studentID);
            ResultSet rs = preparedStatement.executeQuery();
            int sum=0;
            if(rs.next()){
                sum=rs.getInt(1);
            }
            return sum;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    //testMapList
    public void testMapList(Map<Integer,Record> map){
        Iterator<Record> iterator =map.values().iterator();
        while(iterator.hasNext()){
            Record record =iterator.next();
            System.out.println("学生ID："+record.getStudentid());
            System.out.println("分数 ："+record.getScore());
            System.out.println("次数 ："+record.getAlreadyReadNum());
        }
    }



    //test AverageList
//    public void testAverageList(){
//        Iterator<Record> iterator =getSevenDayData().iterator();
//        while(iterator.hasNext()){
//            Record record =iterator.next();
//            System.out.println("日期："+record.getScoretime());
//            System.out.println("平均分："+record.getScore());
//        }
//    }


//
       public static void main(String args[]){
        new poetryDao().getOverPeoplePercent(8);
    }




}