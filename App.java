import java.util.Random;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.stage.Stage;
import javafx.geometry.Insets;
//all imports

public class App extends Application {
    private Button[][] grid = new Button[5][5]; //creates map of buttons

    @Override
    public void start(Stage stage) {
        GridPane pane = new GridPane(); // map and spaciing for the map
        pane.setHgap(5);
        pane.setVgap(5);
        pane.setPadding(new Insets(10));

        for (int i = 0; i < 5; i++) { 
            for (int k = 0; k < 5; k++) {
                Button btn = new Button();
                Random random = new Random();
                Color randomColor = random.nextBoolean() ? Color.WHITE : Color.RED; //makes the button red or white to begin, randomly

                btn.setMinSize(60, 60); //sets button size
                btn.setBackground(new Background(new BackgroundFill(randomColor, CornerRadii.EMPTY, Insets.EMPTY))); //sets button color

                int row = i;
                int column = k;
                btn.setOnAction(e -> userInput(row, column)); //when button is clicked, userInput method plays

                grid[i][k] = btn;
                pane.add(btn, k, i); 
            }
        }

        stage.setScene(new Scene(pane));
        stage.setTitle("Lights Out");
        stage.show(); //displays map
    }

    private void toggle(int row, int column) {
        if (row < 0 || row >= 5 || column < 0 || column >= 5) return;
            Button btn = grid[row][column];
            Color color = (Color) btn.getBackground().getFills().get(0).getFill();
            Color newColor = color.equals(Color.RED) ? Color.WHITE : Color.RED;
            btn.setBackground(new Background(new BackgroundFill(newColor, CornerRadii.EMPTY, Insets.EMPTY)));
        } //method that changes color of all buttons under toggle method within userInput method
    
    private void userInput(int row, int column) {
        toggle(row, column);
        toggle(row - 1, column);
        toggle(row + 1, column);
        toggle(row, column - 1);
        toggle(row, column + 1);
    } //method that runs toggle method on the button pressed and each button around it

    public static void main(String[] args) {
        launch(args);
    }
}

