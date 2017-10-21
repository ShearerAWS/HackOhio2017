import java.util.ArrayList;
import java.util.List;

public class Schedule {
    private List<ArrayList<Course>> semesters = new ArrayList<ArrayList<Course>>();
    private List<String> semsterNames = new ArrayList<String>();

    public Schedule(ArrayList<String> semesterNms) {
        this.semsterNames = semesterNms;
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

    /**
     * @return the semsterNames
     */
    public List<String> getSemsterNames() {
        return this.semsterNames;
    }

    /**
     * @param semsterNames
     *            the semsterNames to set
     */
    public void setSemsterNames(List<String> semsterNames) {
        this.semsterNames = semsterNames;
    }
}
