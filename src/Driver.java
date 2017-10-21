
import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Driver extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Major CSE = new Major("doc/CourseTemplate.txt");

        Accordion reqAccordion = new Accordion();
        for (Requirement r : CSE.getRequirements().getSubReqs()) {
            VBox courseList = new VBox();
            for (Course c : r.getCourses()) {
                Label classLabel = new Label(
                        c.getDepartment() + " " + c.getCourseNumber());
                courseList.getChildren().add(classLabel);
            }

            TitledPane reqCategory = new TitledPane(r.getDescription(),
                    courseList);
            reqAccordion.getPanes().add(reqCategory);
        }

        primaryStage.setTitle("OSU Schedule Planner");
        GridPane mainPanel = new GridPane();
        GridPane requirementsPanel = new GridPane();
        GridPane schedulePanel = new GridPane();

        requirementsPanel.add(new Button(), 0, 0);
        schedulePanel.add(new Button(), 0, 0);

        mainPanel.add(requirementsPanel, 0, 0);
        mainPanel.add(schedulePanel, 1, 0);

        Label class1 = new Label("CSE 3242");
        Label class2 = new Label("CSE 3242");
        VBox cat1 = new VBox();
        cat1.getChildren().addAll(class1, class2);
        TitledPane t1 = new TitledPane("Computer Science Core", cat1);
        TitledPane t2 = new TitledPane("Other", new Button("B1"));

        Accordion accordion = new Accordion();
        accordion.getPanes().addAll(t1, t2);

        StackPane root = new StackPane();
        root.getChildren().add(reqAccordion);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}
