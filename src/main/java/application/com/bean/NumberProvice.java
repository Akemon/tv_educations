package application.com.bean;

public class NumberProvice {
    private String province;

    private int peopleNumber;

    public NumberProvice(String province, int peopleNumber) {
        this.province = province;
        this.peopleNumber = peopleNumber;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getPeopleNumber() {
        return peopleNumber;
    }

    public void setPeopleNumber(int peopleNumber) {
        this.peopleNumber = peopleNumber;
    }
}
