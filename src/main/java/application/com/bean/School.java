package application.com.bean;

import java.util.Date;

public class School {
    private Integer schoolid;

    private String schoolname;

    private String schoolprovince;

    private String schooladdress;

    private String schooltype;

    private String schoolphone;

    private String schoolHoliday;

    public String getSchoolHoliday() {
        return schoolHoliday;
    }

    public void setSchoolHoliday(String schoolHoliday) {
        this.schoolHoliday = schoolHoliday;
    }

    public Integer getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(Integer schoolid) {
        this.schoolid = schoolid;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname == null ? null : schoolname.trim();
    }

    public String getSchoolprovince() {
        return schoolprovince;
    }

    public void setSchoolprovince(String schoolprovince) {
        this.schoolprovince = schoolprovince == null ? null : schoolprovince.trim();
    }

    public String getSchooladdress() {
        return schooladdress;
    }

    public void setSchooladdress(String schooladdress) {
        this.schooladdress = schooladdress == null ? null : schooladdress.trim();
    }

    public String getSchooltype() {
        return schooltype;
    }

    public void setSchooltype(String schooltype) {
        this.schooltype = schooltype == null ? null : schooltype.trim();
    }

    public String getSchoolphone() {
        return schoolphone;
    }

    public void setSchoolphone(String schoolphone) {
        this.schoolphone = schoolphone == null ? null : schoolphone.trim();
    }

    public School(String schoolname, String schoolprovince, String schooladdress, String schooltype, String schoolphone,String schoolHoliday) {
        this.schoolname = schoolname;
        this.schoolprovince = schoolprovince;
        this.schooladdress = schooladdress;
        this.schooltype = schooltype;
        this.schoolphone = schoolphone;
        this.schoolHoliday=schoolHoliday;
    }

    public School(Integer schoolid, String schoolname, String schoolprovince, String schooladdress, String schooltype, String schoolphone,String schoolHoliday) {
        this.schoolid = schoolid;
        this.schoolname = schoolname;
        this.schoolprovince = schoolprovince;
        this.schooladdress = schooladdress;
        this.schooltype = schooltype;

        this.schoolphone = schoolphone;
        this.schoolHoliday=schoolHoliday;
    }
}