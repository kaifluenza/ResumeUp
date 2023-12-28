import java.util.ArrayList;
public class WorkExp extends AbstractExperience{
    private String company;



    public WorkExp(String title, String startDate, String location, String company) {
        super(title, startDate, location);
        this.company = company;
    }

    public WorkExp(String title, String startDate, String endDate, String location, String company) {
        super(title, startDate, endDate, location);
        this.company = company;
    }
    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
