import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
        import javafx.scene.control.ComboBox;
        import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
        import javafx.scene.text.Text;
        import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;

public class selectCharacters extends Application {

    // Launch the application
    public void start(Stage stage) {

        // Create a label
        Label selected = new Label("Select a character");

        //Create text field
        Text text = new Text();

        // Get char type list list
        getCells a = new getCells();
        a.charTypeListCreater();
        ArrayList<String> charTypeList = a.charTypeList;

        // Create a combo box
        ComboBox<String> combo_box =
                new ComboBox<>(FXCollections.observableArrayList(charTypeList));



        // Create action event
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                //Gets user input
                String selectedCharType = String.valueOf(combo_box.getValue());
                selected.setText(selectedCharType + " selected");

                // create tick boxes for the characters present

                // get the plant family info
//                a.famInfo(selectedFam);
//                text.setText(a.pFI);
            }
        };

        // Set on action
        combo_box.setOnAction(event);


        // Create a tile pane
        TilePane tile_pane = new TilePane();
        tile_pane.getChildren().add(combo_box);
        tile_pane.getChildren().add(selected);
        tile_pane.getChildren().add(text);
        //tile_pane.getChildren().add();

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