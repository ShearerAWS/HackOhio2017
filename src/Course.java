import java.util.ArrayList;

public class Course {

    String Department;
    int CourseNumber;
    int SubNumber;
    int CreditHours;
    boolean IsHonors;
    Prereq requirements;

    public Course(String department, int courseNumber, int subNumber,
            int creditHours, boolean isHonors, Prereq requirements) {

        super();
        this.Department = department;
        this.CourseNumber = courseNumber;
        this.SubNumber = subNumber;
        this.CreditHours = creditHours;
        this.IsHonors = isHonors;
        this.requirements = requirements;
    }

    @Override
    public String toString() {
        String s = "";
        String h = "";
        if (this.SubNumber != -1) {
            s = "." + this.SubNumber;
        }
        if (this.IsHonors) {
            h = "(H)";
        }
        return this.Department + this.CourseNumber + s + h;
    }

    public static Course newCourse(String line) {
        String[] lineArray = line.split(" ");
        String dept = lineArray[0];
        int num = Integer.parseInt(lineArray[1]);
        int subNum = Integer.parseInt(lineArray[2]);
        int hour = Integer.parseInt(lineArray[3]);
        boolean hon = Integer.parseInt(lineArray[4]) == 1;
        String[] reqs = line.split(":");
        ArrayList<String> courses = new ArrayList<String>();
        ArrayList<Character> types = new ArrayList<Character>();
        for (int i = 0; i < reqs.length; i++) {
            String[] temp = reqs[i].split(",");
            for (int j = 0; j < temp.length; j++) {
                courses.add(temp[j]);
                types.add((char) (j + 94));

            }
        }

        Prereq pre = new Prereq(courses, types);

        Course c = new Course(dept, num, subNum, hour, hon, pre);

        return c;
    }

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
    public Prereq getRequirements() {
        return this.requirements;
    }

    /**
     * @param requirements
     *            the requirements to set
     */
    public void setRequirements(Prereq requirements) {
        this.requirements = requirements;
    }

    @Override
    public boolean equals(Object other) {
        boolean test = false;
        if (other instanceof Course) {
            Course c = (Course) other;
            if (c.getDepartment().equals(this.getDepartment())) {
                if (c.getCourseNumber() == this.getCourseNumber()) {
                    if (c.getSubNumber() == this.getSubNumber()) {
                        if (c.isIsHonors() == this.isIsHonors()) {
                            test = true;
                        }
                    }
                }
            }
        }
        return test;
    }

}
