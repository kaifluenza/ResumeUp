package main.java;

public class Club extends AbstractExperience{
    private String clubName;

    public Club(String title, String startDate, String location, String clubName) {
        super(title, startDate, location);
        this.clubName = clubName;
    }

    public Club(String title, String startDate, String endDate, String location, String clubName) {
        super(title, startDate, endDate, location);
        this.clubName = clubName;
    }
}
