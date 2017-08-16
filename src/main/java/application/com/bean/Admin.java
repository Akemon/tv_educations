package application.com.bean;

public class Admin {
    private Integer adminid;

    private String adminname;

    private String adminpass;

    private String adminstatus;

    private Integer adminpriority;

    public Integer getAdminid() {
        return adminid;
    }

    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname == null ? null : adminname.trim();
    }

    public String getAdminpass() {
        return adminpass;
    }

    public void setAdminpass(String adminpass) {
        this.adminpass = adminpass == null ? null : adminpass.trim();
    }

    public String getAdminstatus() {
        return adminstatus;
    }

    public void setAdminstatus(String adminstatus) {
        this.adminstatus = adminstatus == null ? null : adminstatus.trim();
    }

    public Integer getAdminpriority() {
        return adminpriority;
    }

    public void setAdminpriority(Integer adminpriority) {
        this.adminpriority = adminpriority;
    }
}