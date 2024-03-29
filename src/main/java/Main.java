package main.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;

public class Main {

    private static void runApp()throws IOException{
        String greeting = "Hey, what's up! Welcome to ResumeUp\nWhat would you like to do?";
        String title = "ResumeUp!";
        Icon icon = new ImageIcon(Main.class.getResource("/icon_logo.png"));
        String[] selection1 = {"Create new resume", "Edit existing resume"};
        String defResponse = "Create new resume";
        String response1 = ""; //response: create new OR edit?

        //create new OR edit?
        JOptionPane pane = new JOptionPane("App");
        Frame f = new Frame("App");
        try{
            response1 = (String)pane.showInputDialog(f,greeting,title,JOptionPane.QUESTION_MESSAGE,icon,selection1,defResponse);
        }catch(HeadlessException he){
            System.out.println("headless exception..");
        }//f.setLayout(null);
        System.out.println("response 1 " + response1);

        //for create new: advance OR beginner mode?
        if(response1.equals("Create new resume")){
            String modeQuestion = "Would you like to create with a step by step guide (Beginner mode)\n" +
                    "OR create with Advanced mode? ";
            String[] selection2 = {"Beginner", "Advanced"};
            String defaultRes2 = "Step by step tutorial";
            String response2 = ""; //response: creating new resume: advance OR beginner mode?

            try{
                response2 = (String)pane.showInputDialog(f,modeQuestion,title,JOptionPane.QUESTION_MESSAGE,icon,selection2,defaultRes2);
            }catch(HeadlessException he){
                System.out.println("headless exception..");
            }//f.setLayout(null);
            System.out.println("response 2 " + response2);

            //creating resume
            Resume res;
            // case 1: Step by step
            if (response2.equals("Beginner")) {
                res = makeResumeBeginner();

            } else {// case 2: advanced
                res = makeResumeAdvanced();
            }

            //export
            res.exportPdf2();

        }else{
            //for edit existing resume: which one?
            editResume();
        }



    }

    //method to create new resume - beginner mode
    private static Resume makeResumeBeginner()throws IOException{
        Resume myResume = new Resume();
        //get contact,education, experience, skill, project, club
        JOptionPane pane = new JOptionPane("beginnerResume");
        Frame f = new Frame("beginnerResume");
        try{
            //get contact info
            String name = pane.showInputDialog(f,"What is your full name?","ResumeUp",JOptionPane.QUESTION_MESSAGE);
            String number = pane.showInputDialog(f,"What is your phone number?","ResumeUp",JOptionPane.QUESTION_MESSAGE);
            String city = pane.showInputDialog(f,"Where do you live? (city and/or state)","ResumeUp",JOptionPane.QUESTION_MESSAGE);

            //create a contact section from info gathered so far
            Contact contact = new Contact(name,number,city);
            //adding link(s) (if any) to contact section
            int addLink = JOptionPane.showOptionDialog(f,"Would you like to add a link?","ResumeUp",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,new Object[] {"Yes","No"},JOptionPane.YES_NO_OPTION);
            while(addLink==JOptionPane.YES_OPTION){
                String displayUrl = pane.showInputDialog(f,"Please input your link, without https//","ResumeUp",JOptionPane.QUESTION_MESSAGE);
                Links aLink = new Links("https//"+displayUrl,displayUrl);
                contact.addLink(aLink);
                addLink = JOptionPane.showOptionDialog(f,"Would you like to add another link?","ResumeUp",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,new Object[] {"Yes","No"},JOptionPane.YES_NO_OPTION);
            }

            //add the contact section to the resume
            System.out.println(contact);
            myResume.setContacts(contact);

            //education
            ArrayList<Education> schools = new ArrayList<Education>();
            int addSchool = JOptionPane.showOptionDialog(f,"Let's add a school/institution!","ResumeUp",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,new Object[] {"Yes","No"},JOptionPane.YES_NO_OPTION);
            while(addSchool==JOptionPane.YES_OPTION){
                String school = pane.showInputDialog(f,"What is the name of your institution?","ResumeUp",JOptionPane.QUESTION_MESSAGE);
                String degree = pane.showInputDialog(f,"What degree did you earn or are persuing? eg Bachelor of Computer Science","ResumeUp",JOptionPane.QUESTION_MESSAGE);
                String start = pane.showInputDialog(f,"When did you start attending? month/year","ResumeUp",JOptionPane.QUESTION_MESSAGE);
                String end = pane.showInputDialog(f,"When did you graduate/are expected to graduate? month/year","ResumeUp",JOptionPane.QUESTION_MESSAGE);
                String minor = (JOptionPane.showOptionDialog(f,"Optional: Would you like to include your minor?","ResumeUp",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,new Object[] {"Yes","No"},JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) ?
                        (pane.showInputDialog(f,"What is your minor?","ResumeUp",JOptionPane.QUESTION_MESSAGE)) :
                        (null);
                String gpa = (JOptionPane.showOptionDialog(f,"Optional: Would to like to input the GPA?\nTip: It's encouraged if higher than 3.5! ","ResumeUp",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,new Object[] {"Yes","No"},JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) ?
                        (pane.showInputDialog(f,"What is your GPA, out of a scale? eg 3.6/4.0","ResumeUp",JOptionPane.QUESTION_MESSAGE)) :
                        (null);

                schools.add(new Education(school, start, end,degree,minor,gpa));

                addSchool = JOptionPane.showOptionDialog(f,"Would you like to add another institution?","ResumeUp",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,new Object[] {"Yes","No"},JOptionPane.YES_NO_OPTION);
            }

            System.out.println(schools);
            myResume.setEducation(schools);

            //work experience
            ArrayList<WorkExp> workExps = new ArrayList<WorkExp>();
            int addExp = JOptionPane.showOptionDialog(f,"Do you have a work experience to add?","ResumeUp",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,new Object[] {"Yes","No"},JOptionPane.YES_NO_OPTION);
            while(addExp==JOptionPane.YES_OPTION){
                String company = pane.showInputDialog(f,"What is the name of the company in which you worked/are working at?","ResumeUp",JOptionPane.QUESTION_MESSAGE);
                String workTitle = pane.showInputDialog(f,"What is the title of your position?","ResumeUp",JOptionPane.QUESTION_MESSAGE);
                String workStart = pane.showInputDialog(f,"When is the start date?","ResumeUp",JOptionPane.QUESTION_MESSAGE);
                String workEnd = (JOptionPane.showOptionDialog(f,"Are you currently holding this position?","ResumeUp",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,new Object[] {"Yes","No"},JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) ?
                        ("Present") :
                        (pane.showInputDialog(f,"When did you stop working?","ResumeUp",JOptionPane.QUESTION_MESSAGE));
                String workLocation = pane.showInputDialog(f,"Where is this position located? city,state, and/or country","ResumeUp",JOptionPane.QUESTION_MESSAGE);

                WorkExp aWork = new WorkExp(workTitle,workStart,workEnd,workLocation,company);

                int addPoint = JOptionPane.showOptionDialog(f,"Can you give a description of what you accomplished in this position?","ResumeUp",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,new Object[] {"Yes","No"},JOptionPane.YES_NO_OPTION);
                while(addPoint==JOptionPane.YES_OPTION){
                    aWork.addBulletPoint(pane.showInputDialog(f,"A brief description of your accomplishments, such that fits into one bullet point!\nYou could say you use X to do Y and accomplished Z","ResumeUp",JOptionPane.QUESTION_MESSAGE));
                    addPoint = JOptionPane.showOptionDialog(f,"Add another bullet point?","ResumeUp",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,new Object[] {"Yes","No"},JOptionPane.YES_NO_OPTION);
                }

                workExps.add(aWork);
                System.out.println(aWork);

                addExp = JOptionPane.showOptionDialog(f,"Would you like to add another work experience","ResumeUp",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,new Object[] {"Yes","No"},JOptionPane.YES_NO_OPTION);
            }
            myResume.setWorkExps(workExps);

            //skills
            Skills mySkills = new Skills();
            int addSkill = JOptionPane.showOptionDialog(f,"Let's add skills you have!","ResumeUp",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,new Object[] {"Yes","No"},JOptionPane.YES_NO_OPTION);
            while(addSkill==JOptionPane.YES_OPTION){
                mySkills.addSkill(pane.showInputDialog(f,"Input a skill you have. (One at a time)","ResumeUp",JOptionPane.QUESTION_MESSAGE));
                addSkill = JOptionPane.showOptionDialog(f,"Add another skill?","ResumeUp",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,new Object[] {"Yes","No"},JOptionPane.YES_NO_OPTION);
            }
            myResume.setSkills(mySkills);

            //project

            //club

            //don't forget to give the resume a name/title

            myResume.displayResume();

        }catch(HeadlessException he){
            System.out.println("headless exception..");
        }

        return myResume;
    }

    //method to create new resume - advanced mode
    private static Resume makeResumeAdvanced(){
        Resume myResume = new Resume();
        //get contact, experience, education from user
        //add info to resume
        return myResume;
    }

    //method to edit existing resume
    private static void editResume(){
    }

    //main
    public static void main(String[] args)throws IOException {
        //runApp();

        TestClass test = new TestClass();
        test.testExportPdf(test.testCreateResume());
    }

}

