import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Major {

    private String name;
    private String department;
    private Requirement requirements;

    public Major(String filename) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(filename));
        this.name = in.readLine();
        this.department = in.readLine();
        in.readLine();
        this.requirements = this.generateRequirement(in);
    }

    private Requirement generateRequirement(BufferedReader in)
            throws IOException {
        String name = in.readLine();
        boolean allRequired = in.readLine().equals("true");
        String line = in.readLine();
        ArrayList<Course> courses = new ArrayList<Course>();
        ArrayList<Requirement> subReqs = new ArrayList<Requirement>();
        while (!line.equals("]")) {
            if (line.equals("[")) {
                subReqs.add(this.generateRequirement(in));
            } else {
                courses.add(Course.newCourse(line));
            }
            line = in.readLine();
        }
        return new Requirement(name, allRequired, courses, subReqs);
    }
}
