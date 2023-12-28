public class TestClass {
    public static void testDisplayResume() {
        Resume res = new Resume();
        res.setContacts(new Contact("Stephanie", "111-111-1111", "Brooklyn, NY"));
        res.addClub(new Club("volleyball captain", "Jan 2002", "Iceland", "volleyball club"));
        res.addEducation(new Education("Harvard", "Aug 2001", "Jul 2003", "BS Nursing",
                "Minor in Mathematics", "3.63/4.0"));
        res.addExperience(new WorkExp("Nurse", "jul 2003",  "Sep 2010", "Boston, MA",
                "Big Hospital"));
        res.addSkill("Java");
        res.addProject(new Project("Stock trading mobile app", "Aug 2004", "Boston, MA"));
        res.displayResume();
    }

}
