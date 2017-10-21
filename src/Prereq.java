import java.util.ArrayList;

public class Prereq {
    ArrayList<Course> courses;
    ArrayList<Character> types;

    /**
     * @return the courses
     */
    public ArrayList<Course> getCourses() {
        return this.courses;
    }

    /**
     * @param courses
     *            the courses to set
     */
    public void setCourses(ArrayList<Course> courses) {
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

}
