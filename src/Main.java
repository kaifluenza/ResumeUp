import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.util.ArrayList;

public class Main {

    //get user info

    //create a resume instance

    //method to edit resume

    //save resume for later edit

    //export the resume as PDF

    //main
    public static void main(String[] args){
        String greeting = "Hey, what's up! What would you like to do?";
        String title = "ResumeUp!";
        Icon icon = new ImageIcon("/Users/wanruenikhuantang/Downloads/ResumeUp/icon_logo.png");
        String[] selection = {"Create new resume", "Edit existing resume"};
        String defResponse = "Create new resume";
        String response = ""; // user response
        //what user wants to do
        JOptionPane pane = new JOptionPane("hello");

        Frame f = new Frame("hello");
        try{
            response = (String)pane.showInputDialog(f,greeting,title,JOptionPane.QUESTION_MESSAGE,icon,selection,defResponse);
        }catch(HeadlessException he){
            System.out.println("exception..");
        }
        f.setLayout(null);
        System.out.println(response);
        if (response.equals("Create new resume")) { // new resume
            System.out.println("inside if");
            // first get input from the user if they want advanced or step by step
            String question = "Hey, what's up! Do you want to make a resume step by step or " +
                    "would you like to use advanced mode?";
            String title2 = "ResumeUp!";
            icon = new ImageIcon("/Users/wanruenikhuantang/Downloads/ResumeUp/icon_logo.png");
            String[] options = {"Step by step tutorial", "Advance mode"};
            String defaultRes = "Step by step tutorial";
            String response2 = "";
            JOptionPane pane2 = new JOptionPane("New resume");
            Frame f2 = new Frame("New resume");
            try{
                response2 = (String)pane2.showInputDialog(f2,question,title2,JOptionPane.QUESTION_MESSAGE,icon,options,defaultRes);
            }catch(HeadlessException he){
                System.out.println("exception..");
            }
            f.setLayout(null);
            System.out.println("response 2 " + response2);
            // case 1: Step by step
            // case 2: advanced
            // make a new resume object

            Resume myResume = new Resume();
            // get contact info from user
            // add contact info to resume

            // get experience info from user
            // add experience info to resume

            // get education info from user
            // add education info to resume

            // get 
        }
        else { // edit resume
            return;
        }
    }

        //create new resume
            //advanced mode, beginner mode
        //edit existing resumes

}
