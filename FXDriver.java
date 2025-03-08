
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class FXDriver extends Application {
    @Override
    public void start(Stage stage) {
        // Create an instance of FXMainPane
        FXMainPane root = new FXMainPane();

        // Set the scene with the root pane and dimensions
        Scene scene = new Scene(root, 400, 200); // Width: 400, Height: 200
        stage.setScene(scene);
        stage.setTitle("GUI Lab");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
