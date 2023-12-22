import java.util.ArrayList;

public class Resume {
    private Contact contacts;
    private ArrayList<Club> clubs;
    private ArrayList<Education> education;
    private ArrayList<Project> projects;
    private Skills skills;
    private ArrayList<WorkExp> workExps;

    // constructor
    public Resume() {
        this.contacts = null;
        this.clubs = new ArrayList<Club>();
        this.education = new ArrayList<Education>();
        this.projects = new ArrayList<Project>();
        this.workExps = new ArrayList<WorkExp>();
        this.skills = new Skills();
    }
    public Resume(Contact c, ArrayList<Club> club, ArrayList<Education> edu, ArrayList<Project> proj,
                  Skills skil, ArrayList<WorkExp> workXp) {
        this.contacts = c;
        this.clubs = club;
        this.education = edu;
        this.projects = proj;
        this.skills = skil;
        this.workExps = workXp;
    }
    // setters
    public void setContacts(Contact c) {
        this.contacts = c;
    }

    public void setClubs(ArrayList<Club> clubs) {
        this.clubs = clubs;
    }
    public void setEducation(ArrayList<Education> education) {
        this.education = education;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }
    public void setSkills(Skills s) {
        this.skills = s;
    }
    public void setWorkExps(ArrayList<WorkExp> w) {
        this.workExps = w;
    }
    // getters
    public Contact getContacts() {
        return contacts;
    }

    public ArrayList<Club> getClubs() {
        return clubs;
    }

    public ArrayList<Education> getEducation() {
        return education;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public Skills getSkills() {
        return skills;
    }

    public ArrayList<WorkExp> getWorkExps() {
        return workExps;
    }

}
