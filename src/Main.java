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
        String response = "Create new resume";
        //what user wants to do
        JOptionPane pane = new JOptionPane("hello");

        Frame f = new Frame("hello");
        try{
            response = (String)pane.showInputDialog(f,greeting,title,JOptionPane.QUESTION_MESSAGE,icon,selection,response);
        }catch(HeadlessException he){
            System.out.println("exception..");
        }
        f.setLayout(null);

        if (response.equals("Create  new resume")) { // new resume
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

        }
    }

        //create new resume
            //advanced mode, beginner mode
        //edit existing resumes

}
