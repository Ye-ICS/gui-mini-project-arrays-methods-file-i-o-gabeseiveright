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

public class App extends Application {
private Button[][] grid = new Button[5][5];

@Override
public void start(Stage stage) {
GridPane pane = new GridPane();
pane.setHgap(5);
pane.setVgap(5);
pane.setPadding(new Insets(10));

for (int i = 0; i < 5; i++) {
    for (int k = 0; k < 5; k++) {
        Button btn = new Button();
        btn.setMinSize(60, 60);
        btn.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        int row = i;
        int col = k;
        btn.setOnAction(e -> handleClick(row, col));

        grid[i][k] = btn;
        pane.add(btn, k, i);
    }
}

stage.setScene(new Scene(pane));
stage.setTitle("Lights Out");
stage.show();
}

private void toggle(int row, int col) {
    if (row < 0 || row >= 5 || col < 0 || col >= 5) return;
    Button btn = grid[row][col];
    Color color = (Color) btn.getBackground().getFills().get(0).getFill();
    Color newColor = color.equals(Color.RED) ? Color.WHITE : Color.RED;
    btn.setBackground(new Background(new BackgroundFill(newColor, CornerRadii.EMPTY, Insets.EMPTY)));
}

private void handleClick(int row, int col) {
toggle(row, col);
toggle(row - 1, col);
toggle(row + 1, col);
toggle(row, col - 1);
toggle(row, col + 1);
}

public static void main(String[] args) {
launch(args);
}
}

