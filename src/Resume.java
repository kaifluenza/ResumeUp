import java.util.ArrayList;

public class Resume {
    private String title; // title of the resume
    private Contact contacts;
    private ArrayList<Club> clubs;
    private ArrayList<Education> education;
    private ArrayList<Project> projects;
    private Skills skills;
    private ArrayList<WorkExp> workExps;

    // constructor
    public Resume() {
        this.title = "Untitled Resume";
        this.contacts = null;
        this.clubs = new ArrayList<Club>();
        this.education = new ArrayList<Education>();
        this.projects = new ArrayList<Project>();
        this.workExps = new ArrayList<WorkExp>();
        this.skills = new Skills();
    }
    public Resume(String title, Contact c, ArrayList<Club> club, ArrayList<Education> edu, ArrayList<Project> proj,
                  Skills skil, ArrayList<WorkExp> workXp) {
        this.title = title;
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
    // methods
    public Boolean exportPdf() {
        // TODo: export the resume object as a pdf and save it
        return true;
    }
    public void addExperience(WorkExp w) {
        this.workExps.add(w);
    }
    public void addSkill(String s) {
        this.skills.addSkill(s);
    }
    public void addEducation(Education e) {
        this.education.add(e);
    }
    public void addClub(Club club) {
        this.clubs.add(club);
    }
    public void addProject(Project p) {
        this.projects.add(p);
    }
    public void displayResume() {
        // TODO: display the resume to the user
        // add everything to a string
        String result = "";
        Education currEdu;
        // contacts
        result = result + this.contacts.getName() + "\n";
        result = result + this.contacts.getCity() + "\t";
        result = result + this.contacts.getPhoneNum() + "\n";
        result = result + "EDUCATION\n";
        // Education
        for (int i = 0; i < this.education.size(); i++) {
            currEdu = this.education.get(i);
            result = result + currEdu.getDegree() + " ";
            result = result + currEdu.getStartDate() + "-" + currEdu.getEndDate() + "\n";
            result = result + currEdu.getTitle() + "- GPA: " + currEdu.getGpa()

        }
        // display the string in a pane
    }

}
