package  application.com;
import application.com.bean.Poetry;
import application.com.bean.Record;
import application.com.dao.poetryDao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Controller
@EnableAutoConfiguration
public class Application {
    poetryDao poetryDao =new poetryDao();


    @RequestMapping("/index")
    String home(Map<String,Object> map) {
//        //UserInfo user =new UserInfo();
//      //  user.setNickname("哈哈");
////        model.addAttribute("test" ,"哈哈");
////        model.addAttribute("as","ok");
////        model.addAttribute("user",user);
       map.put("hello","from TemplateController.helloHtml");
        return "index";
    }

    @RequestMapping("/hello")
    String test(){
        return "test";
    }

    //古诗词的映射
  //  #############################################################
    //古诗的插入
    @RequestMapping("/insertPoem")
    void insertPoem(HttpServletRequest request,HttpServletResponse response){
        String title =request.getParameter("title");
        String poet =request.getParameter("poet");
        String poem =request.getParameter("poem");
        Poetry po =new Poetry();
        po.setPoem(poem);
        po.setTitle(title);
        po.setPoet(poet);
        boolean flag =poetryDao.insertPoem(po);
        String str = "{\"flag\":\""+flag+"\"}";
        JSONObject jsonObject = JSONObject.fromObject(str);
        System.out.println(jsonObject.toString());
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            out =response.getWriter();
            out.println(jsonObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    //获取一首古诗
    @RequestMapping("/getOnePoem")
    public void getOnePoem(HttpServletRequest request, HttpServletResponse response){
        String poetryIDString =request.getParameter("no");
        System.out.println("no:"+poetryIDString);
        int poetryID=0;
        if(poetryIDString!=null){
            poetryID =Integer.parseInt(poetryIDString);
        }
        Poetry poetry =poetryDao.getOnePoem(poetryID);
        List<Poetry> poetryList =new ArrayList<Poetry>();
        poetryList.add(poetry);
        JSONArray jsonArray =JSONArray.fromObject(poetryList);
        JSONObject jsonObject =new JSONObject();
        jsonObject.put("poemList", jsonArray);
        System.out.println(jsonObject.toString());
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            out =response.getWriter();
            out.println(jsonObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    //随机获取三首古诗
    @RequestMapping("/getThreePoem")
    public void getThreePoem(HttpServletResponse response){
        List<Poetry> poetryList = poetryDao.getThreePoemList();
        JSONArray jsonArray =JSONArray.fromObject(poetryList);
        JSONObject jsonObject =new JSONObject();
        jsonObject.put("poemList", jsonArray);
        System.out.println(jsonObject.toString());
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            out =response.getWriter();
            out.println(jsonObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //搜索古诗
    @RequestMapping("/searchPoem")
    public void searchPoem(HttpServletRequest request,HttpServletResponse response){
        String title =request.getParameter("keyword");
        List<Poetry> poemList =poetryDao.getResearchPoem(title);
        JSONArray jsonArray =JSONArray.fromObject(poemList);
        JSONObject jsonObject =new JSONObject();
        jsonObject.put("poemList", jsonArray);
        System.out.println(jsonObject.toString());
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            out =response.getWriter();
            out.println(jsonObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //记录结果
    @RequestMapping("/recordScore")
    void recordScore(HttpServletRequest request, HttpServletResponse response){
        String studentIDString =request.getParameter("studentID");
        String poetryIDString =request.getParameter("poetryID");
        int studentID=0;
        int poetryID =0;
        if(studentIDString!=null&&poetryIDString!=null){
            studentID =Integer.parseInt(studentIDString);
            poetryID =Integer.parseInt(poetryIDString);
        }
        String score =request.getParameter("score");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time =  format.format(new Date());
        Record record =new Record(studentID,poetryID,score,time);
        boolean flag =poetryDao.recordScore(record);
        String str = "{\"flag\":\""+flag+"\"}";
        JSONObject jsonObject = JSONObject.fromObject(str);
        System.out.println(jsonObject.toString());
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            out =response.getWriter();
            out.println(jsonObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    //  #############################################################
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}