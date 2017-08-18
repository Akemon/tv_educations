package application.com.dao;

import application.com.bean.NumberProvice;

import java.util.ArrayList;
import java.util.List;

public class NumberProviceDao {

    //所有省份的统计
    public List<NumberProvice> countNumberProvince(){
        studentDao sd=new studentDao();
        teacherDao td=new teacherDao();


        List<NumberProvice> ls=new ArrayList<NumberProvice>();
        String[] province={"北京市","天津市","上海市","重庆市","河北省","山西省","辽宁省","吉林省","黑龙江省","江苏省","浙江省","安徽省","福建省","江西省","山东省","河南省","湖北省","湖南省","广东省","海南省","四川省","贵州省","云南省","陕西省","甘肃省","青海省","台湾省","内蒙古自治区","广西壮族自治区","西藏自治区","宁夏回族自治区","新疆维吾尔自治区","香港特别行政区","澳门特别行政区"} ;
        for(int i=0;i<34;i++){
            NumberProvice np=new NumberProvice(province[i],sd.countNumberProvice().get(i).getPeopleNumber()+ td.countNumberProvice().get(i).getPeopleNumber());
            System.out.println(np.getProvince()+":"+np.getPeopleNumber());
            ls.add(np);
    }

    return ls;
    }








    //找出省份前四名
    public List<NumberProvice> listNumberProvince() {
      NumberProviceDao numberProvice=new NumberProviceDao();
      List<NumberProvice> count=numberProvice.countNumberProvince();

        List<NumberProvice> Alist = new ArrayList<NumberProvice>();

//        for (int i = 0; i < 34; i++) {
//            NumberProvice np = new NumberProvice(province[i], sd.countNumberProvice().get(i).getPeopleNumber() + td.countNumberProvice().get(i).getPeopleNumber());
//            System.out.println(np.getProvince() + ":" + np.getPeopleNumber());
//
//        }
        for(int i=0;i<4;i++){
            NumberProvice np=count.get(i);

            for(int j=i+1;j<=34;j++){
                  if(count.get(j).getPeopleNumber()>np.getPeopleNumber()){np=count.get(j);}
            }


        }

        return Alist;
    }


    public static void main(String[] args) {
        NumberProviceDao nb = new NumberProviceDao();
        nb.countNumberProvince();



    }
}
