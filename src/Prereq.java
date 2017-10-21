public class Prereq {
    char Category;
    Course course;

    public Prereq(Course c, char cat) {
        this.course = c;
        this.Category = cat;
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

    /**
     * @return the category
     */
    public char getCategory() {
        return this.Category;
    }

    /**
     * @param category
     *            the category to set
     */
    public void setCategory(char category) {
        this.Category = category;
    }

    /**
     * @return the course
     */
    public Course getCourse() {
        return this.course;
    }

    /**
     * @param course
     *            the course to set
     */
    public void setCourse(Course course) {
        this.course = course;
    }

}
