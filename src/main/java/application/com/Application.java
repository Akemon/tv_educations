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
    @RequestMapping("/insertPoem")
    String insertPoem(HttpServletRequest request){
        String title =request.getParameter("title");
        String poet =request.getParameter("poet");
        String poem =request.getParameter("poem");
        Poetry po =new Poetry();
        po.setPoem(poem);
        po.setTitle(title);
        po.setPoet(poet);
        boolean flag =new poetryDao().insertPoem(po);
        System.out.println("flag:"+flag);
        System.out.println("title:"+title);
        System.out.println("poet:"+poet);
        System.out.println("poem:"+poem);
        return "index";

    }

    @RequestMapping("/getThreePoem")
    public String getThreePoem(Map<String,Object> map){
        List<Poetry> poetryList = new poetryDao().getThreePoemList();
        JSONArray jsonArray =JSONArray.fromObject(poetryList);
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