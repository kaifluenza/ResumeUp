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


}
