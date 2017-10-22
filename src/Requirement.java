import java.util.ArrayList;

public class Requirement {

    private String description;
    private boolean allRequired;
    private ArrayList<Course> courses;
    private ArrayList<Requirement> subReqs;

    public Requirement(String description, boolean allRequired,
            ArrayList<Course> courses) {
        this.description = description;
        this.allRequired = allRequired;
        this.courses = courses;
    }

    public Requirement(String description, boolean allRequired,
            ArrayList<Course> courses, ArrayList<Requirement> subReqs) {
        this.description = description;
        this.allRequired = allRequired;
        this.courses = courses;
        this.subReqs = subReqs;
    }

    public boolean meetsRequirements(ArrayList<Course> taken) {
        if (this.allRequired) {
            for (Course c : this.courses) {
                if (!taken.contains(c)) {
                    return false;
                }
            }
            for (Requirement r : this.subReqs) {
                if (!r.meetsRequirements(taken)) {
                    return false;
                }
            }
            return true;
        }
        for (Course c : this.courses) {
            if (taken.contains(c)) {
                return true;
            }
        }
        for (Requirement r : this.subReqs) {
            if (r.meetsRequirements(taken)) {
                return true;
            }
        }
        return false;
    }

    public String getDescription() {
        return this.description;
    }

    public ArrayList<Course> getCourses() {
        return this.courses;
    }

    public ArrayList<Requirement> getSubReqs() {
        return this.subReqs;
    }
}
