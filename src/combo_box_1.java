import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.collections.*;
import javafx.stage.Stage;
import javafx.scene.text.*;
import java.util.ArrayList;

public class combo_box_1 extends Application {

    // Launch the application
    public void start(Stage stage) {
        // Create a label
        Label selected = new Label("Select a family");
        //Create text field
        Text text = new Text();
        // Plant families list
       getCells a = new getCells();
       a.famListCreater();
       ArrayList<String> families = a.famList;
        // Create a combo box
        ComboBox<String> combo_box =
                new ComboBox<>(FXCollections.observableArrayList(families));

        // Create action event
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e) {
                        //Gets user input
                        String selectedFam = String.valueOf(combo_box.getValue());
                        selected.setText(selectedFam + " selected");
                        // get the plant family info
                        a.famInfo(selectedFam);
                        text.setText(a.pFI);
                    }
                };
        // Set on action
        combo_box.setOnAction(event);
        // Create a tile pane
        TilePane tile_pane = new TilePane(combo_box, selected, text);
        //Setting the orientation for the Tile Pane
        tile_pane.setOrientation(Orientation.HORIZONTAL);
        //Setting the alignment for the Tile Pane
        tile_pane.setTileAlignment(Pos.CENTER_LEFT);
        //Setting the preferred columns for the Tile Pane
        tile_pane.setPrefRows(20);
        //Setting background colour
        tile_pane.setStyle("-fx-background-color: DAE6F3;");
        // Create a scene
        Scene scene = new Scene(tile_pane, 300, 300);

        // Set title for the stage
        stage.setTitle("Plant families of the Netherlands");

        // Adding scene to stage
        stage.setScene(scene);

        //Displaying contents of the stage
        stage.show();
    }
}