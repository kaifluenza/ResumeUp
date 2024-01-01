package main.java;

import java.util.ArrayList;
public abstract class AbstractExperience {
    // title, start, end, description
    private String title, startDate, endDate, location;
    private ArrayList<String> bulletPoint;
    public AbstractExperience(String title, String startDate, String location) {
        this.title = title;
        this.startDate = startDate;
        this.location = location;
        this.bulletPoint = new ArrayList<String>();
    }

    public AbstractExperience(String title, String startDate, String endDate, String location) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.bulletPoint = new ArrayList<String>();
    }

    public void addBulletPoint(String s){
        bulletPoint.add(s);
    }

    public Boolean removeBulletPoint(String s){
        if(bulletPoint.contains(s)){
            bulletPoint.remove(s);
            return true;
        }else return false;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<String> getBulletPoint() {
        return this.bulletPoint;
    }

    public void setBulletPoint(ArrayList<String> bulletPoint) {
        this.bulletPoint = bulletPoint;
    }

    @Override
    public String toString() {
        return "AbstractExperience{" +
                "title='" + title + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", location='" + location + '\'' +
                ", bulletPoint=" + bulletPoint +
                '}';
    }
}

