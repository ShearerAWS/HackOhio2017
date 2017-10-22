
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Driver extends Application {

    private Stage stage;
    private SchedulePanel schedulePanel;
    private Major CSE;
    private GridPane requirementsPanel;

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.stage = primaryStage;
        primaryStage.setTitle("OSU Schedule Planner");
        this.CSE = new Major("doc/CourseTemplate.txt");

        GridPane mainPanel = new GridPane();
        this.requirementsPanel = new GridPane();
        this.schedulePanel = new SchedulePanel();

        this.updateRequirementPanel();

        mainPanel.add(this.requirementsPanel, 0, 0);
        mainPanel.add(this.schedulePanel, 1, 0);

        StackPane root = new StackPane();
        root.getChildren().add(mainPanel);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

    private BorderPane createCourseLabel(Course c, boolean sub, boolean taken,
            boolean meetsReq) {
        BorderPane bp = new BorderPane();
        String space = sub ? "      " : "";
        String req = meetsReq ? "" : "XXX ";
        Label l = new Label(space + req + c.getDepartment() + " "
                + c.getCourseNumber() + ": " + c.getTitle());
        bp.setLeft(l);

        if (!taken) {
            Button b = this.createAddCourseButton(c);
            bp.setRight(b);
        }
        return bp;
    }

    private Button createAddCourseButton(Course c) {
        Button btn = new Button();
        btn.setUserData(c);
        btn.setText("add");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Course c = (Course) ((Button) event.getSource()).getUserData();
                Driver.this.schedulePanel.addCourseToSchedule(c);
            }
        });
        return btn;
    }

    private void updateRequirementPanel() {
        this.requirementsPanel.getChildren().clear();
        Accordion reqAccordion = new Accordion();
        ArrayList<Course> taken = this.schedulePanel.getSchedule().getTaken();
        for (Requirement r : this.CSE.getRequirements().getSubReqs()) {
            VBox courseList = new VBox();
            for (Course c : r.getCourses()) {
                boolean meetsReq = taken.contains(c);
                courseList.getChildren().add(this.createCourseLabel(c, false,
                        taken.contains(c), meetsReq));
            }
            for (Requirement subR : r.getSubReqs()) {
                String failedStr = subR.meetsRequirements(taken) ? "" : "XXX ";
                System.out.println(subR.meetsRequirements(taken));
                Label subReqLabel = new Label(
                        failedStr + subR.getDescription().trim());
                courseList.getChildren().add(subReqLabel);

                for (Course c : subR.getCourses()) {
                    courseList.getChildren().add(this.createCourseLabel(c, true,
                            taken.contains(c), true));
                }
            }
            TitledPane reqCategory = new TitledPane(r.getDescription(),
                    courseList);
            reqAccordion.getPanes().add(reqCategory);
        }

        ScrollPane courseViewerScroll = new ScrollPane();
        courseViewerScroll.setContent(reqAccordion);
        courseViewerScroll.setHbarPolicy(ScrollBarPolicy.NEVER);
        this.requirementsPanel.getChildren().add(courseViewerScroll);
    }

    private class SchedulePanel extends BorderPane {
        private VBox scheduleTable;
        private Schedule schedule;
        private ComboBox semesterSelect;
        private final String[] semesters = { "EM Credits", "Autumn Year 1",
                "Spring Year 1", "Autumn Year 2", "Spring Year 2",
                "Autumn Year 3", "Spring Year 3", "Autumn Year 4",
                "Spring Year 4" };

        public SchedulePanel() {
            super();
            this.scheduleTable = new VBox();
            this.schedule = new Schedule(
                    new ArrayList<>(Arrays.asList(this.semesters)));
            this.semesterSelect = new ComboBox<String>();
            for (String name : this.semesters) {
                this.semesterSelect.getItems().add(name);
            }
            this.semesterSelect.valueProperty()
                    .addListener(new ChangeListener<String>() {
                        @Override
                        public void changed(ObservableValue ov, String t,
                                String t1) {
                            Driver.this.schedulePanel.updateSchedule(t1);
                        }
                    });
            //this.updateSchedule(this.semesters[0]);
            this.setTop(this.semesterSelect);
            this.setCenter(this.scheduleTable);
        }

        public Schedule getSchedule() {
            return this.schedule;
        }

        private void updateSchedule(String title) {
            this.scheduleTable.getChildren().clear();
            Driver.this.updateRequirementPanel();
            for (Course c : this.schedule.getSemester(title)) {
                this.scheduleTable.getChildren()
                        .add(this.createCourseLabel(c, false));
            }
        }

        private void addCourseToSchedule(Course c) {
            String title = (String) this.semesterSelect.getValue();
            this.schedule.addCourse(title, c);
            this.updateSchedule(title);
        }

        private BorderPane createCourseLabel(Course c, boolean sub) {
            BorderPane bp = new BorderPane();
            String space = sub ? "      " : "";
            Label l = new Label(space + c.getDepartment() + " "
                    + c.getCourseNumber() + ": " + c.getTitle());
            bp.setLeft(l);
            bp.setRight(this.createRemoveCourseButton(c));
            return bp;
        }

        private Button createRemoveCourseButton(Course c) {
            Button btn = new Button();
            btn.setUserData(c);
            btn.setText("remove");
            btn.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    Course c = (Course) ((Button) event.getSource())
                            .getUserData();
                    Driver.this.schedulePanel.removeCourseFromSchedule(c);
                }
            });
            return btn;
        }

        private void removeCourseFromSchedule(Course c) {
            String title = (String) this.semesterSelect.getValue();
            this.schedule.removeCourse(title, c);
            this.updateSchedule(title);

        }
    }
}
