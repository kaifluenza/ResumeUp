import java.util.ArrayList;

public class Skills {
    private ArrayList<String> skill;

    public Skills(){
        this.skill = new ArrayList<String>();
    }

    public void addSkill(String s){
        skill.add(s);
    }

    public Boolean removeSkill(String s){
        if(skill.contains(s)){
            skill.remove(s);
            return true;
        }else return false;
    }
}
