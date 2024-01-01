package main.java;

import java.util.ArrayList;

public class Project extends AbstractExperience{
    public Project(String title, String startDate, String location) {
        super(title, startDate, location);
    }

    public Project(String title, String startDate, String endDate, String location) {
        super(title, startDate, endDate, location);
    }
}
