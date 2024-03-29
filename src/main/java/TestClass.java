package main.java;

import java.io.File;
import java.io.IOException;

public class TestClass {
    public static final String DEST = "results/resumes/test_resume.pdf";
    public TestClass() {
    }

    public static void testDisplayResume() {
        Resume res = new Resume();
        res.setContacts(new Contact("Stephanie", "111-111-1111", "Brooklyn, NY"));
        res.addClub(new Club("volleyball captain", "Jan 2002", "Iceland", "volleyball club"));
        res.addEducation(new Education("Harvard", "Aug 2001", "Jul 2003", "BS Nursing",
                "Minor in Mathematics", "3.63/4.0"));
        res.addExperience(new WorkExp("Nurse", "jul 2003",  "Sep 2010", "Boston, MA",
                "Big Hospital"));
        res.getWorkExps().get(0).addBulletPoint("Performed CPR and saved the lives of a million people");
        res.addSkill("Java");
        res.addProject(new Project("Stock trading mobile app", "Aug 2004", "Boston, MA"));
        res.getProjects().get(0).addBulletPoint("Used Android Studio and Java to develop the top-ranked app in stocks" +
                " and finance 2 years in a row.");
        res.displayResume();
    }

    public static Resume testCreateResume() {
        Resume res = new Resume();
        res.setContacts(new Contact("Stephanie", "111-111-1111", "Brooklyn, NY"));
        res.addClub(new Club("volleyball captain", "Jan 2002", "Iceland", "volleyball club"));
        res.addEducation(new Education("Harvard", "Aug 2001", "Jul 2003", "BS Nursing",
                "Minor in Mathematics", "3.63/4.0"));
        res.addExperience(new WorkExp("Nurse", "jul 2003",  "Sep 2010", "Boston, MA",
                "Big Hospital"));
        res.getWorkExps().get(0).addBulletPoint("Performed CPR and saved the lives of a million people");
        res.addSkill("Java");
        res.addProject(new Project("Stock trading mobile app", "Aug 2004", "Boston, MA"));
        res.getProjects().get(0).addBulletPoint("Used Android Studio and Java to develop the top-ranked app in stocks" +
                " and finance 2 years in a row.");
        res.displayResume();

        return res;
    }

    public void testExportPdf(Resume testResume) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        //testResume.exportPdf(DEST);
        testResume.exportPdf2();
    }


}
