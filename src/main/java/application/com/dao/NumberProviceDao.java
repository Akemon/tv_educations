package application.com.dao;

import application.com.bean.NumberProvice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
     // NumberProviceDao numberProvice=new NumberProviceDao();
     // List<NumberProvice> count=numberProvice.countNumberProvince();
       NumberProvice n1=new NumberProvice("qwe",2) ;
       NumberProvice n2=new NumberProvice("asd",1);
       NumberProvice n3=new NumberProvice("zxc",3);

       List<NumberProvice> Alist = new ArrayList<NumberProvice>();
Alist.add(n1);
Alist.add(n2);
Alist.add(n3);

        Collections.sort(Alist,new Comparator<NumberProvice>(){
            public int compare(NumberProvice o1, NumberProvice o2){
                if(o1.getPeopleNumber() < o2.getPeopleNumber()){
                    return 1;
                }
                if(o1.getPeopleNumber() == o2.getPeopleNumber()){
                    return 0;
                }
                return -1;
            }
        });


        return Alist;
    }


    public static void main(String[] args) {
        NumberProviceDao nb = new NumberProviceDao();
        List<NumberProvice> list=nb.listNumberProvince();
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).getProvince()+":"+list.get(i).getPeopleNumber());
        }


    }
}
