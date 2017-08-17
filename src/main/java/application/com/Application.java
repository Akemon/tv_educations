package  application.com;
import application.com.bean.*;
import application.com.dao.poetryDao;
import application.com.dao.schoolDao;
import application.com.dao.studentDao;
import application.com.dao.teacherDao;
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
    studentDao stuDao =new studentDao();
    teacherDao teachDao =new teacherDao();
    schoolDao schDao =new schoolDao();


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




    //学生管理的映射
    //  #############################################################
    //增加学生信息
    @RequestMapping("/addStudent")
    public void addStudent(HttpServletRequest request, HttpServletResponse response){
        String userName =request.getParameter("userName");
        String userPass =request.getParameter("userPass");
        String schoolIDString =request.getParameter("schoolID");
        String studentNumber =request.getParameter("studentNumber");
        String studentName =request.getParameter("studentName");
        String studentGrade =request.getParameter("studentGrade");
        String studentPhone =request.getParameter("studentPhone");
        int studentID=0;
        int schoolID =0;
        if(schoolIDString!=null){
            schoolID =Integer.parseInt(schoolIDString);
        }
        Student student =new Student(studentNumber,studentName,studentGrade,schoolID,studentPhone,userName,userPass);
        boolean flag = stuDao.insertStudent(student);
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
    //删除学生信息
    @RequestMapping("/deleteStudent")
    public void deleteStudent(HttpServletRequest request, HttpServletResponse response){
            String studentIDString =request.getParameter("studentID");
            int studentID=0;
            if(studentIDString!=null){
                studentID =Integer.parseInt(studentIDString);
            }
            boolean flag = stuDao.delStudent(studentID);
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

    //修改学生信息
    @RequestMapping("/modifyStudent")
    public void modifyStudent(HttpServletRequest request, HttpServletResponse response){
        String studentIDString =request.getParameter("studentID");
        String schoolIDString =request.getParameter("schoolID");
        String studentNumber =request.getParameter("studentNumber");
        String studentName =request.getParameter("studentName");
        String studentGrade =request.getParameter("studentGrade");
        String studentPhone =request.getParameter("studentPhone");
        int studentID=0;
        int schoolID =0;
        if(schoolIDString!=null&&studentIDString!=null){
            studentID =Integer.parseInt(studentIDString);
            schoolID =Integer.parseInt(schoolIDString);
        }
        Student student =new Student(schoolID,studentNumber,studentName,studentGrade,schoolID,studentPhone);
        boolean flag =stuDao.modifyStudent(student);
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
    //搜索学生
    @RequestMapping("/searchStudent")
    public void getOneStudent(HttpServletRequest request, HttpServletResponse response){
         String search =request.getParameter("search");
         List<Student> stuList =stuDao.searchStudent(search);
        JSONArray jsonArray =JSONArray.fromObject(stuList);
        JSONObject jsonObject =new JSONObject();
        jsonObject.put("stuList", jsonArray);
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

    //获取所有学生
    @RequestMapping("/getAllStudent")
    public void getAllStudetn(HttpServletResponse response){
        List<Student> stuList =stuDao.getStudent();
        JSONArray jsonArray =JSONArray.fromObject(stuList);
        JSONObject jsonObject =new JSONObject();
        jsonObject.put("stuList", jsonArray);
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

    //根据省份获取学校
    @RequestMapping("getSchoolByProvince")
    public void getSchoolByProvince(HttpServletRequest request, HttpServletResponse response){
        String province =request.getParameter("province");
        List<School> schoolList =schDao.getSchoolForProvince(province);
        JSONArray jsonArray =JSONArray.fromObject(schoolList);
        JSONObject jsonObject =new JSONObject();
        jsonObject.put("schoolList", jsonArray);
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

    //根据省份,学校获取班级
    @RequestMapping("/getClassBySchool")
    public void getClassBySchool(HttpServletRequest request, HttpServletResponse response){
            String schoolName =request.getParameter("schoolName");
            String province =request.getParameter("province");
            List<String> ClassList =stuDao.getSchoolGrade(schoolName,province);
            JSONArray jsonArray =JSONArray.fromObject(ClassList);
            JSONObject jsonObject =new JSONObject();
            jsonObject.put("ClassList", jsonArray);
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

    //根据省份，学校，班级获取学生
    @RequestMapping("/getStudentByProvinceSchoolClass")
    public void getStudentByProvinceSchoolClass(HttpServletRequest request, HttpServletResponse response){
        String province =request.getParameter("province");
        String schoolName =request.getParameter("schoolName");
        String gradeName = request.getParameter("gradeName");
        List<Student>  studentList = stuDao.getStudentForSchoolAndGrade(gradeName,schoolName,province);
        JSONArray jsonArray =JSONArray.fromObject(studentList);
        JSONObject jsonObject =new JSONObject();
        jsonObject.put("studentList", jsonArray);
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


    //教师管理的映射
    //  #############################################################
    //增加教师
    @RequestMapping("/addTeacher")
    public void addTeacher(HttpServletRequest request, HttpServletResponse response){
        String userName =request.getParameter("userName");
        String userPass =request.getParameter("userPass");
        String schoolIDString  =request.getParameter("schoolID");
        String teacherNumber =request.getParameter("teacherNumber");
        String teacherName =request.getParameter("teacherName");
        String teacherPhone =request.getParameter("teacherPhone");
        int teacherID =0;
        int schoolID =0;
        if(schoolIDString!=null){
            schoolID =Integer.parseInt(schoolIDString);
        }
        Teacher teacher =new Teacher(teacherNumber,teacherName,schoolID,teacherPhone,userName,userPass);
        boolean flag =teachDao.insertTeacher(teacher);
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

    //删除教师
    @RequestMapping("/deleteTeacher")
    public void deleteTeacher(HttpServletRequest request, HttpServletResponse response){
        String teacherIDString =request.getParameter("teacherID");
        int teacherID=0;
        if(teacherIDString!=null){
            teacherID =Integer.parseInt(teacherIDString);
        }
        boolean flag =teachDao.delTeacher(teacherID);
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
    //修改教师个人信息
    @RequestMapping("/modifyTeacher")
    public void modifyTeacher(HttpServletRequest request, HttpServletResponse response){
        String teacherIDString =request.getParameter("teacherID");
        String schoolIDString  =request.getParameter("schoolID");
        String teacherNumber =request.getParameter("teacherNumber");
        String teacherName =request.getParameter("teacherName");
        String teacherPhone =request.getParameter("teacherPhone");
        int teacherID =0;
        int schoolID =0;
        if(teacherIDString!=null&&schoolIDString!=null){
            teacherID =Integer.parseInt(teacherIDString);
            schoolID =Integer.parseInt(schoolIDString);
        }
        Teacher teacher =new Teacher(teacherID,teacherNumber,teacherName,schoolID,teacherPhone);
        boolean flag =teachDao.modifyTeacher(teacher);
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

    //搜索教师
    @RequestMapping("/searchTeacher")
    public void searchTeacher(HttpServletRequest request, HttpServletResponse response){
        String search =request.getParameter("search");
        List<Teacher> teachList =teachDao.searchTeacher(search);
        JSONArray jsonArray =JSONArray.fromObject(teachList);
        JSONObject jsonObject =new JSONObject();
        jsonObject.put("teacherList", jsonArray);
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
    //获取所有教师
    @RequestMapping("/getAllTeacher")
    public void getAllTeacher(HttpServletResponse response){
        List<Teacher> teacherList =teachDao.getTeacher();
        JSONArray jsonArray =JSONArray.fromObject(teacherList);
        JSONObject jsonObject =new JSONObject();
        jsonObject.put("teacherList", jsonArray);
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
    //根据省份,学校获取教师
    @RequestMapping("/getTeacherByProvinceSchool")
    public void getTeacherByProvinceSchool(HttpServletRequest request, HttpServletResponse response){
        String province =request.getParameter("province");
        String schoolName =request.getParameter("schoolName");
        List<Teacher> teacherList =teachDao.getTeacherForSchool(schoolName,province);
        JSONArray jsonArray =JSONArray.fromObject(teacherList);
        JSONObject jsonObject =new JSONObject();
        jsonObject.put("teacherList", jsonArray);
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

    //学校管理的映射
    //  #############################################################
    //增加学校
    @RequestMapping("/addSchool")
    public void addSchool(HttpServletRequest request, HttpServletResponse response){
        String schoolName =request.getParameter("schoolName");
        String schoolProvice =request.getParameter("schoolProvince");
        String schooAddress =request.getParameter("schoolAddress");
        String schoolType =request.getParameter("schoolType");
        String schoolPhone =request.getParameter("schoolPhone");
        School school =new School(schoolName,schoolProvice,schooAddress,schoolType,schoolPhone);
        boolean flag =schDao.insertSchool(school);
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
    //删除学校
    @RequestMapping("/deleteSchool")
    public void deleteSchool(HttpServletRequest request, HttpServletResponse response){
        String schoolDString =request.getParameter("schoolID");
        int schoolID =0;
        if(schoolDString!=null){
            schoolID =Integer.parseInt(schoolDString);
        }
        boolean flag =schDao.delSchool(schoolID);
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

    //修改学校
    @RequestMapping("/modifySchool")
    public  void modifySchool(HttpServletRequest request, HttpServletResponse response){
        String schoolIDString =request.getParameter("schoolID");
        String schoolName =request.getParameter("schoolName");
        String schoolProvice =request.getParameter("schoolProvince");
        String schoolAddress =request.getParameter("schoolAddress");
        String schoolType =request.getParameter("schoolType");
        String schoolPhone =request.getParameter("schoolPhone");
        int schoolID =0;
        if(schoolIDString!=null){
            schoolID =Integer.parseInt(schoolIDString);
        }
        School school =new School(schoolID,schoolName,schoolProvice,schoolAddress,schoolType,schoolPhone);
        boolean flag =schDao.modifyStudent(school);
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

    //获取所有学校
    @RequestMapping("/getAllSchool")
    public void getAllSchool(HttpServletResponse response){
        List<School> schoolList =schDao.getSchool();
        JSONArray jsonArray =JSONArray.fromObject(schoolList);
        JSONObject jsonObject =new JSONObject();
        jsonObject.put("schoolList", jsonArray);
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

    //搜索学校
    @RequestMapping("/searchSchool")
    public void searchSchool(HttpServletRequest request, HttpServletResponse response){
        String search =request.getParameter("search");
        List<School> schoolList =schDao.getSchoolForName(search);
        JSONArray jsonArray =JSONArray.fromObject(schoolList);
        JSONObject jsonObject =new JSONObject();
        jsonObject.put("schoolList", jsonArray);
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


    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}