public class Education {
    private String school;
    private String startYear;
    private String gradYear;
    private String major;
    private String minor;

    public Education(String school, String startYear, String gradYear, String major, String minor) {
        this.school = school;
        this.startYear = startYear;
        this.gradYear = gradYear;
        this.major = major;
        this.minor = minor;
    }

    public Education(String school, String startYear, String gradYear, String major) {
        this.school = school;
        this.startYear = startYear;
        this.gradYear = gradYear;
        this.major = major;
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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMinor() {
        return minor;
    }

    public void setMinor(String minor) {
        this.minor = minor;
    }
}
