public class Contact {
    private String name;
    private String phoneNum;
    private String city;
    public Contact() {
        this.name = null;
        this.phoneNum = null;
        this.city = null;
    }

    public Contact(String name, String phoneNum, String city) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
