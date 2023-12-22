import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.util.ArrayList;

public class Main {

    private static void runApp(){
        String greeting = "Hey, what's up! Welcome to ResumeUp\nWhat would you like to do?";
        String title = "ResumeUp!";
        Icon icon = new ImageIcon("/Users/wanruenikhuantang/Downloads/ResumeUp/icon_logo.png");
        String[] selection1 = {"Create new resume", "Edit existing resume"};
        String defResponse = "Create new resume";
        String response1 = ""; //response: create new OR edit?

        //create new OR edit?
        JOptionPane pane = new JOptionPane("hello");
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
            if (response2.equals("Step by step tutorial")) {
                res = makeResumeBeginner();
            } else {// case 2: advanced
                res = makeResumeAdvanced();
            }

        }else{
            //for edit existing resume: which one?
            editResume();
        }



    }

    //method to create new resume - beginner mode
    private static Resume makeResumeBeginner(){
        Resume myResume = new Resume();
        //get contact, experience, education from user
        //add info to resume
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
    public static void main(String[] args){
        runApp();
    }



}
