package main.java;

import java.util.ArrayList;

public class Education {
    private String school;
    private String startYear;
    private String gradYear;
    private String degree;
    private String minor;
    private String gpa;
    private ArrayList<String> bulletPoint;

    public Education(String school, String startYear, String gradYear, String degree, String minor, String gpa) {
        this.school = school;
        this.startYear = startYear;
        this.gradYear = gradYear;
        this.degree = degree;
        this.minor = minor;
        this.gpa = gpa;
        this.bulletPoint = new ArrayList<String>();
    }

    public Education(String school, String startYear, String gradYear, String degree, String gpa) {
        this.school = school;
        this.startYear = startYear;
        this.gradYear = gradYear;
        this.degree = degree;
        this.gpa = gpa;
        this.bulletPoint = new ArrayList<String>();
    }


    public Education(String school, String startYear, String gradYear, String degree) {
        this.school = school;
        this.startYear = startYear;
        this.gradYear = gradYear;
        this.degree = degree;
        this.bulletPoint = new ArrayList<String>();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    public String getGradYear() {
        return gradYear;
    }

    public void setGradYear(String gradYear) {
        this.gradYear = gradYear;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getMinor() {
        return minor;
    }

    public void setMinor(String minor) {
        this.minor = minor;
    }

    public String getGpa() {
        return gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    public ArrayList<String> getBulletPoint() {
        return bulletPoint;
    }

    public void setBulletPoint(ArrayList<String> bulletPoint) {
        this.bulletPoint = bulletPoint;
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

    @Override
    public String toString() {
        return "Education{" +
                "school='" + school + '\'' +
                ", startYear='" + startYear + '\'' +
                ", gradYear='" + gradYear + '\'' +
                ", degree='" + degree + '\'' +
                ", minor='" + minor + '\'' +
                ", gpa='" + gpa + '\'' +
                '}';
    }
}


