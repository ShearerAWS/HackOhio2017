import java.util.ArrayList;

public class Course {

    String Department;
    int CourseNumber;
    int SubNumber;
    boolean IsHonors;
    ArrayList<Prereq> requirements = new ArrayList<Prereq>();

    /**
     * @return the department
     */
    public String getDepartment() {
        return this.Department;
    }

    /**
     * @param department
     *            the department to set
     */
    public void setDepartment(String department) {
        this.Department = department;
    }

    /**
     * @return the courseNumber
     */
    public int getCourseNumber() {
        return this.CourseNumber;
    }

    /**
     * @param courseNumber
     *            the courseNumber to set
     */
    public void setCourseNumber(int courseNumber) {
        this.CourseNumber = courseNumber;
    }

    /**
     * @return the subNumber
     */
    public int getSubNumber() {
        return this.SubNumber;
    }

    /**
     * @param subNumber
     *            the subNumber to set
     */
    public void setSubNumber(int subNumber) {
        this.SubNumber = subNumber;
    }

    /**
     * @return the isHonors
     */
    public boolean isIsHonors() {
        return this.IsHonors;
    }

    /**
     * @param isHonors
     *            the isHonors to set
     */
    public void setIsHonors(boolean isHonors) {
        this.IsHonors = isHonors;
    }

    /**
     * @return the requirements
     */
    public ArrayList<Prereq> getRequirements() {
        return this.requirements;
    }

    /**
     * @param requirements
     *            the requirements to set
     */
    public void setRequirements(ArrayList<Prereq> requirements) {
        this.requirements = requirements;
    }

}
