import java.util.ArrayList;

public class Prereq {
    ArrayList<String> courses;
    ArrayList<Character> types;

    public Prereq(ArrayList<String> c, ArrayList<Character> types) {

    }

    /**
     * @return the courses
     */
    public ArrayList<String> getCourses() {
        return this.courses;
    }

    /**
     * @param courses
     *            the courses to set
     */
    public void setCourses(ArrayList<String> courses) {
        this.courses = courses;
    }

    /**
     * @return the types
     */
    public ArrayList<Character> getTypes() {
        return this.types;
    }

    /**
     * @param types
     *            the types to set
     */
    public void setTypes(ArrayList<Character> types) {
        this.types = types;
    }

    /**
     * public boolean hasPrereqs(ArrayList<Course> coursesTaken) { boolean
     * hasAll = true; for (Prereq p : this.requirements) { char type =
     * p.getCategory(); if (type == 'a') { this.hasPrereq(p, coursesTaken); } }
     * return hasAll; }
     *
     * public boolean hasPrereq(Prereq p, ArrayList<Course> coursesTaken) {
     * boolean hasCourse = false; for (Course c : coursesTaken) { if
     * (p.getCourse().equals(c)) { hasCourse = true; } } return hasCourse; }
     */
    public boolean hasPrereqs(ArrayList<String> coursesTaken) {
        boolean hasAll = true;
        char presentType = 'a';
        for (int i = 0; i < this.courses.size(); i++) {
            String c = this.courses.get(i);
            char type = this.types.get(i);
            if (presentType == type) {

            }
        }
        return hasAll;
    }

    public boolean hasPrereq(String c, ArrayList<String> coursesTaken) {
        boolean hasP = false;
        for (String s : coursesTaken) {
            if (s.equals(c)) {
                hasP = true;
            }
        }
        return hasP;
    }
}
