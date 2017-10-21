import java.util.ArrayList;

public class Course {

    String courseID;
    //Strings in prereq include tag letter at beginning for parsing
    ArrayList<String> prereq = new ArrayList<String>();

    public String getCourseID() {
        return this.courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public ArrayList<String> getPrereq() {
        return this.prereq;
    }

    public void setPrereq(ArrayList<String> prereq) {
        this.prereq = prereq;
    }

}
