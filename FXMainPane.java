
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {
    // Declare components
    private Button btnHello, btnHowdy, btnChinese, btnClear, btnExit;
    private Label label;
    private TextField textField;
    private HBox hbox1, hbox2;
    private DataManager dataManager;

    // Constructor
    public FXMainPane() {
        // Instantiate components
        btnHello = new Button("Hello");
        btnHowdy = new Button("Howdy");
        btnChinese = new Button("Chinese");
        btnClear = new Button("Clear");
        btnExit = new Button("Exit");
        label = new Label("Feedback:");
        textField = new TextField();
        hbox1 = new HBox(10); // Spacing between components
        hbox2 = new HBox(10);

        // Instantiate DataManager
        dataManager = new DataManager();

        // Add buttons to hbox1
        hbox1.getChildren().addAll(btnHello, btnHowdy, btnChinese, btnClear, btnExit);

        // Add label and text field to hbox2
        hbox2.getChildren().addAll(label, textField);

        // Add HBoxes to VBox (FXMainPane)
        this.getChildren().addAll(hbox1, hbox2);

        // Set margins and alignment
        HBox.setMargin(btnHello, new Insets(10));
        HBox.setMargin(btnHowdy, new Insets(10));
        HBox.setMargin(btnChinese, new Insets(10));
        HBox.setMargin(btnClear, new Insets(10));
        HBox.setMargin(btnExit, new Insets(10));
        hbox1.setAlignment(Pos.CENTER);
        hbox2.setAlignment(Pos.CENTER);

        // Set event handlers
        ButtonHandler handler = new ButtonHandler();
        btnHello.setOnAction(handler);
        btnHowdy.setOnAction(handler);
        btnChinese.setOnAction(handler);
        btnClear.setOnAction(handler);
        btnExit.setOnAction(handler);
    }

    // Inner class to handle button clicks
    private class ButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            if (event.getSource() == btnHello) {
                textField.setText(dataManager.getHello());
            } else if (event.getSource() == btnHowdy) {
                textField.setText(dataManager.getHowdy());
            } else if (event.getSource() == btnChinese) {
                textField.setText(dataManager.getChinese());
            } else if (event.getSource() == btnClear) {
                textField.setText("");
            } else if (event.getSource() == btnExit) {
                Platform.exit();
                System.exit(0);
            }
        }
    }
}