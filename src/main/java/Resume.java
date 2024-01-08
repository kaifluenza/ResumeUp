package main.java;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.util.Date;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.IOException;

public class Resume {
    private String title; // title of the resume
    private Contact contacts;
    private ArrayList<Club> clubs;
    private ArrayList<Education> education;
    private ArrayList<Project> projects;
    private Skills skills;
    private ArrayList<WorkExp> workExps;
    private String pdfPath; // path to save the pdf of the resume

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
    public Boolean exportPdf(String dest) throws IOException {
        // TODO: export the resume object as a pdf and save it
        // use jfilechooser to choose a directory to export to
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(FileSystemView.getFileSystemView().getDefaultDirectory());
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = chooser.showOpenDialog(null);
        String outputPath;
        if (result == JFileChooser.APPROVE_OPTION) {
            File chosenDir = chooser.getSelectedFile();
            outputPath = (String)chosenDir.getAbsolutePath() + "myResume.pdf";
            System.out.println(chosenDir.getAbsolutePath());
        }
        else {
            System.out.println("No directory selected");
        }
        // generate a string representing the data of the resume
        String myResume = this.generateResumeString();
        // export the pdf into the chosen directory
        // initialize pdf writer
        FileOutputStream fos = new FileOutputStream(dest);
        PdfWriter writer = new PdfWriter(fos);

        // initialize pdf document
        PdfDocument pdf = new PdfDocument(writer);

        // initialize document
        Document document = new Document(pdf);

        // add paragraph to the content
        document.add(new Paragraph(myResume));

        // close document
        document.close();
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
        // add everything to a string
        String result = "";
        // bullet points for the different parts of the resume
        ArrayList<String> bullets;
        // pane for displaying
        JOptionPane pane = new JOptionPane();
        Frame f = new Frame();
        Education currEdu;
        // contacts
        if (this.contacts != null) {
            result = result + this.contacts.getName() + "\n";
            result = result + this.contacts.getCity() + " | ";
            result = result + this.contacts.getPhoneNum();
            // if links
            if (this.contacts.getLinks() != null) {
                Links link;
                for (int i = 0; i < this.contacts.getLinks().size(); i++) {
                    link = this.contacts.getLinks().get(i);
                    result = result + " | " + link.getDisplayUrl();
                }
                result = result + "\n";
            }
            // else
            else {
                result = result + "\n";
            }
        }

        result = result + "EDUCATION\n";
        // Education
        for (int i = 0; i < this.education.size(); i++) {
            currEdu = this.education.get(i);

            result = result + currEdu.getDegree() + " \t";
            result = result + currEdu.getStartYear() + "-" + currEdu.getGradYear() + "\n";
            if (currEdu.getGpa() != null) {
                result = result + currEdu.getSchool() + "- GPA: " + currEdu.getGpa() + "\n"; // TODO: add location
            }
            else {
                result = result + currEdu.getSchool() + "\n";
            }
            if (currEdu.getMinor() != null) {
                result = result + currEdu.getMinor() + "\n";
            }
            // TODO: add description for education
        }
        // prof experience
        result = result + "PROFESSIONAL EXPERIENCE\n";
        WorkExp currWork;
        for (int i = 0; i < this.workExps.size(); i++) {
            currWork = this.workExps.get(i);
            result = result + currWork.getTitle() + " " + currWork.getStartDate() + "-" + currWork.getEndDate() + "\n";
            result = result + currWork.getCompany() + " \t" + currWork.getLocation() + "\n";
            bullets = currWork.getBulletPoint();
            for (int j = 0; j < bullets.size(); j++) {
                result = result + "- " + bullets.get(j) + "\n";
            }
        }
        // skills
        result = result + "SKILLS\n";
        Skills sk = this.getSkills();
        for (int i = 0; i < sk.getSkill().size(); i++) { // TODO: add getter to Skills
            if (i == sk.getSkill().size() - 1) {
                result = result + sk.getSkill().get(i);
            }
            else {
                result = result + sk.getSkill().get(i) + ", ";
            }

        }
        result = result + "\n";
        // projects
        result = result + "PROJECTS\n";
        Project currProj;
        for (int i = 0; i < this.projects.size(); i++) {
            currProj = this.projects.get(i);
            if (currProj.getEndDate() == null) {
                result = result + currProj.getTitle() + " " + currProj.getStartDate() + "\n";
            }
            else {
                result = result + currProj.getTitle() + " " + currProj.getStartDate() + "-" +
                        currProj.getEndDate()+ "\n";
            }
            bullets = currProj.getBulletPoint();
            for (int j = 0; j < bullets.size(); j++) {
                result = result + "- " + bullets.get(j) + "\n";
            }
        }
        // clubs
        result = result + "CLUBS & ACTIVITIES\n";
        Club currClub;
        for (int i = 0; i < this.clubs.size(); i++) {
            currClub = this.clubs.get(i);
            if (currClub.getEndDate() != null) {
                result = result + currClub.getTitle() + " \t" + currClub.getStartDate() + "-" +
                        currClub.getEndDate() + "\n";
            }
            else {
                result = result + currClub.getTitle() + " \t" + currClub.getStartDate() + "\n";
            }
            bullets = currClub.getBulletPoint();
            for (int j = 0; j < bullets.size(); j++) {
                result = result + "- " + bullets.get(j) + "\n";
            }
        }


        // display the string in a pane
        pane.showMessageDialog(f, result, this.title, JOptionPane.PLAIN_MESSAGE);
        System.out.println(result);
    }
    // helper function for export pdf to generate a string of the resume
    public String generateResumeString() {
        String result = "";
        // bullet points for the different parts of the resume
        ArrayList<String> bullets;
        // pane for displaying
        JOptionPane pane = new JOptionPane();
        Frame f = new Frame();
        Education currEdu;
        // contacts
        if (this.contacts != null) {
            result = result + this.contacts.getName() + "\n";
            result = result + this.contacts.getCity() + " | ";
            result = result + this.contacts.getPhoneNum();
            // if links
            if (this.contacts.getLinks() != null) {
                Links link;
                for (int i = 0; i < this.contacts.getLinks().size(); i++) {
                    link = this.contacts.getLinks().get(i);
                    result = result + " | " + link.getDisplayUrl();
                }
                result = result + "\n";
            }
            // else
            else {
                result = result + "\n";
            }
        }

        result = result + "EDUCATION\n";
        // Education
        for (int i = 0; i < this.education.size(); i++) {
            currEdu = this.education.get(i);

            result = result + currEdu.getDegree() + " \t";
            result = result + currEdu.getStartYear() + "-" + currEdu.getGradYear() + "\n";
            if (currEdu.getGpa() != null) {
                result = result + currEdu.getSchool() + "- GPA: " + currEdu.getGpa() + "\n"; // TODO: add location
            }
            else {
                result = result + currEdu.getSchool() + "\n";
            }
            if (currEdu.getMinor() != null) {
                result = result + currEdu.getMinor() + "\n";
            }
            // TODO: add description for education
        }
        // prof experience
        result = result + "PROFESSIONAL EXPERIENCE\n";
        WorkExp currWork;
        for (int i = 0; i < this.workExps.size(); i++) {
            currWork = this.workExps.get(i);
            result = result + currWork.getTitle() + " " + currWork.getStartDate() + "-" + currWork.getEndDate() + "\n";
            result = result + currWork.getCompany() + " \t" + currWork.getLocation() + "\n";
            bullets = currWork.getBulletPoint();
            for (int j = 0; j < bullets.size(); j++) {
                result = result + "- " + bullets.get(j) + "\n";
            }
        }
        // skills
        result = result + "SKILLS\n";
        Skills sk = this.getSkills();
        for (int i = 0; i < sk.getSkill().size(); i++) { // TODO: add getter to Skills
            if (i == sk.getSkill().size() - 1) {
                result = result + sk.getSkill().get(i);
            }
            else {
                result = result + sk.getSkill().get(i) + ", ";
            }

        }
        result = result + "\n";
        // projects
        result = result + "PROJECTS\n";
        Project currProj;
        for (int i = 0; i < this.projects.size(); i++) {
            currProj = this.projects.get(i);
            if (currProj.getEndDate() == null) {
                result = result + currProj.getTitle() + " " + currProj.getStartDate() + "\n";
            }
            else {
                result = result + currProj.getTitle() + " " + currProj.getStartDate() + "-" +
                        currProj.getEndDate()+ "\n";
            }
            bullets = currProj.getBulletPoint();
            for (int j = 0; j < bullets.size(); j++) {
                result = result + "- " + bullets.get(j) + "\n";
            }
        }
        // clubs
        result = result + "CLUBS & ACTIVITIES\n";
        Club currClub;
        for (int i = 0; i < this.clubs.size(); i++) {
            currClub = this.clubs.get(i);
            if (currClub.getEndDate() != null) {
                result = result + currClub.getTitle() + " \t" + currClub.getStartDate() + "-" +
                        currClub.getEndDate() + "\n";
            }
            else {
                result = result + currClub.getTitle() + " \t" + currClub.getStartDate() + "\n";
            }
            bullets = currClub.getBulletPoint();
            for (int j = 0; j < bullets.size(); j++) {
                result = result + "- " + bullets.get(j) + "\n";
            }
        }
        return result;
    }

}
