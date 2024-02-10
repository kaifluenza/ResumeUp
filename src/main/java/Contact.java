package main.java;

import java.util.ArrayList;

public class Contact {
    private String name;
    private String phoneNum;
    private String city;
    private ArrayList<Links> links;

    public Contact() {
        this.name = null;
        this.phoneNum = null;
        this.city = null;
        links = new ArrayList<Links>();
    }

    public Contact(String name, String phoneNum, String city) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.city = city;
        links = new ArrayList<Links>();
    }

    public ArrayList<Links> getLinks() {
        return links;
    }

    public void addLink(Links l){
        links.add(l);
    }

    public Boolean removeLink(Links l){
        if(links.contains(l)){
            links.remove(l);
            return true;
        }else return false;
    }

    public String getName() {
        return this.name;
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

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", city='" + city + '\'' +
                ", links=" + links +
                '}';
    }
}
