
public class Prereq {
    char Category;
    Course course;

    public Prereq(Course c, char cat) {
        this.course = c;
        this.Category = cat;
    }

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
