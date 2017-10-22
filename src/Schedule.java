import java.util.ArrayList;
import java.util.List;

public class Schedule {
    private List<ArrayList<Course>> semesters = new ArrayList<ArrayList<Course>>();
    private List<String> semesterNames = new ArrayList<String>();

    public Schedule(ArrayList<String> semesterNms) {
        this.semesterNames = semesterNms;
        for (int i = 0; i < semesterNms.size(); i++) {
            this.semesters.add(new ArrayList<Course>());
        }
    }

    /**
     * @return the semesters
     */
    public List<ArrayList<Course>> getSemesters() {
        return this.semesters;
    }

    /**
     * @param semesters
     *            the semesters to set
     */
    public void setSemesters(List<ArrayList<Course>> semesters) {
        this.semesters = semesters;
    }

    public ArrayList<Course> getSemester(String name) {
        for (int i = 0; i < this.semesterNames.size(); i++) {
            if (this.semesterNames.get(i).equals(name)) {
                return this.semesters.get(i);
            }
        }
        return this.semesters.get(0);
    }

    /**
     * @return the semsterNames
     */
    public List<String> getSemesterNames() {
        return this.semesterNames;
    }

    /**
     * @param semsterNames
     *            the semsterNames to set
     */
    public void setSemesterNames(List<String> semsterNames) {
        this.semesterNames = semsterNames;
    }

    public void addCourse(String name, Course c) {
        for (int i = 0; i < this.semesterNames.size(); i++) {
            if (this.semesterNames.get(i).equals(name)) {
                this.semesters.get(i).add(c);
            }
        }

    }

    public void removeCourse(String title, Course c) {
        for (int i = 0; i < this.semesterNames.size(); i++) {
            if (this.semesterNames.get(i).equals(title)) {
                for (int j = 0; j < this.semesters.get(i).size(); j++) {
                    if (this.semesters.get(i).get(j).equals(c)) {
                        this.semesters.get(i).remove(j);
                    }
                }
            }
        }
    }

    public ArrayList<Course> getTakenBefore(String title) {
        ArrayList<Course> courses = new ArrayList<Course>();
        int index = 0;
        for (int i = 0; i < this.semesterNames.size(); i++) {
            if (this.semesterNames.get(i).equals(title)) {
                index = i;
            }
        }
        for (int i = 0; i <= index; i++) {
            for (Course c : this.semesters.get(i)) {
                courses.add(c);
            }
        }
        return courses;
    }

    public ArrayList<Course> getTaken() {
        ArrayList<Course> courses = new ArrayList<Course>();
        for (int i = 0; i < this.semesterNames.size(); i++) {
            for (Course c : this.semesters.get(i)) {
                courses.add(c);
            }
        }
        return courses;
    }
}
