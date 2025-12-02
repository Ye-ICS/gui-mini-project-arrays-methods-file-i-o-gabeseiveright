import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Template JavaFX application.
 */
public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    

    @Override
    public void start(Stage stage) {
        BorderPane groot = new BorderPane();
        VBox horizontal = new VBox();
        int [] Button = new int[10];
        Button redBtn = new Button();
        redBtn.setStyle("-fx-border-color: red; -fx-vgap: 20");
        


        Scene scene = new Scene(groot, 500, 250);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Handle the submission of a thought.
     * @param inputBox  The TextField where the user types their thought.
     * @param outputBox The TextArea where the submitted thoughts are displayed.
     */
    void onSubmitThought(TextField inputBox, TextArea outputBox) {
        String text = inputBox.getText();
        inputBox.clear();
        System.out.println("Interesting thought: " + text);
        outputBox.appendText("Interesting thought: " + text + "\n");
    }
}
