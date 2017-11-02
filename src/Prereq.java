import java.util.ArrayList;

public class Prereq {
    ArrayList<String> courses;
    ArrayList<Character> types;

    public Prereq(ArrayList<String> c, ArrayList<Character> types) {
        this.courses = c;
        this.types = types;
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
        /*
         * if (this.courses.size() == 1 && this.courses.get(0) == "%") { return
         * true; } else if (this.courses.size() == 1) { return
         * this.hasPrereq(this.courses.get(0), coursesTaken); } boolean hasAll =
         * false; char presentType = 96; ArrayList<String> temp = new
         * ArrayList<String>(); ArrayList<Boolean> finalResults = new
         * ArrayList<Boolean>(); for (int i = 0; i < this.courses.size(); i++) {
         * char type = this.types.get(i); if (presentType == type) {
         * temp.add(this.courses.get(i)); } else { if (temp.size() >= 1) {
         * finalResults.add(this.hasPrereqs(temp)); } } } if (temp.size() >= 1)
         * { finalResults.add(this.hasPrereqs(temp)); } hasAll = true; for (int
         * i = 0; i < finalResults.size(); i++) { if (finalResults.get(i) ==
         * false) { hasAll = false; } } return hasAll;
         */
        if (this.courses.size() == 0 || this.courses.get(0).equals("%")) {
            return true;
        }

        for (String s : this.courses) {
            if (!coursesTaken.contains(s)) {
                return false;
            }
        }
        return true;
    }

    public boolean hasPrereqs(ArrayList<String> coursesNeeded,
            ArrayList<String> coursesTaken) {
        if (coursesNeeded.size() == 1 && this.courses.get(0) == "%") {
            return true;
        } else if (coursesNeeded.size() == 1) {
            return this.hasPrereq(coursesNeeded.get(0), coursesTaken);
        }
        boolean hasAll = false;
        char presentType = 96;
        ArrayList<String> temp = new ArrayList<String>();
        ArrayList<Boolean> finalResults = new ArrayList<Boolean>();
        for (int i = 0; i < coursesNeeded.size(); i++) {
            char type = this.types.get(i);
            if (presentType == type) {
                temp.add(this.courses.get(i));
            } else {
                if (temp.size() >= 1) {
                    finalResults.add(this.hasPrereqs(temp));
                }
            }
        }
        if (temp.size() >= 1) {
            finalResults.add(this.hasPrereqs(temp));
        }
        hasAll = true;
        for (int i = 0; i < finalResults.size(); i++) {
            if (finalResults.get(i) == false) {
                hasAll = false;
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
