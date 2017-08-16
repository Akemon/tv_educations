package  application.com;
import application.com.bean.Poetry;
import application.com.dao.poetryDao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
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
    String insertPoem(HttpServletRequest request){
        String title =request.getParameter("title");
        String poet =request.getParameter("poet");
        String poem =request.getParameter("poem");
        Poetry po =new Poetry();
        po.setPoem(poem);
        po.setTitle(title);
        po.setPoet(poet);
        boolean flag =poetryDao.insertPoem(po);
        System.out.println("flag:"+flag);
        System.out.println("title:"+title);
        System.out.println("poet:"+poet);
        System.out.println("poem:"+poem);
        return "index";

    }
    //随机获取三首古诗
    @RequestMapping("/getThreePoem")
    public String getThreePoem(Map<String,Object> map){
        List<Poetry> poetryList = poetryDao.getThreePoemList();
        JSONArray jsonArray =JSONArray.fromObject(poetryList);
        JSONObject jsonObject =new JSONObject();
        jsonObject.put("poemList", jsonArray);
        System.out.println(jsonObject.toString());
        map.put("poemList",jsonObject);
        return "index";
    }
    //搜索古诗
    @RequestMapping("/searchPoem")
    public String searchPoem(HttpServletRequest request,Map<String,Object> map){
        String title =request.getParameter("keyword");
        List<Poetry> poemList =poetryDao.getResearchPoem(title);
        JSONArray jsonArray =JSONArray.fromObject(poemList);
        JSONObject jsonObject =new JSONObject();
        jsonObject.put("poemList", jsonArray);
        System.out.println(jsonObject.toString());
        map.put("poemList",jsonObject);
        return "index";
    }

    //  #############################################################
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}