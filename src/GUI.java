import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;



public class GUI extends Application {

    //what you need for a scene, allows makeItPretty to be called when not all layouts have changed:

    @Override
    public void start(Stage s) throws Exception {
        s.setScene(mainScene(s));
        s.show();
    }

    //creates mainScene
    public Scene mainScene (Stage s){
        Button bb = new Button("go to specialcheckbox");
        bb.setOnAction(e -> s.setScene(charTypeCombibox(s)));

        Button ee = new Button("go to combobox1");
        ee.setOnAction(e -> s.setScene(combobox1(s)));

        BorderPane bp = new BorderPane();

        VBox mainLayout = new VBox();
        mainLayout.getChildren().addAll(bb,ee);

        bp.setCenter(mainLayout);

        bp.setBottom(back2main(s));

        Scene mainScene = new Scene(bp, 500, 500);

        return mainScene;
    }

    //creates return button
    public Button back2main(Stage s){
        Button b = new Button("back to main");
        b.setOnAction(e -> s.setScene(mainScene(s)));
        return b;
    }

    //creates checkbox scene
    public Scene checkbox (Stage s){
        s.setTitle("CheckBox Experiment 1");
        getCells a = new getCells();
        a.charTypeListCreater();
        HBox hbox = new HBox();
        hbox.getChildren().add(back2main(s));

        //create a combobox to get chartype

        //----------
        charTypeCombibox(s);
        //ArrayList<CheckBox> c = charCheckbox("Inflorsence type");
        //hbox.getChildren().addAll(c);
        Scene scene = new Scene(hbox, 1000, 100);
        return scene;

    }

    //creates combobox1 scene
    public Scene combobox1 (Stage s){
        // Create a label
        Label selected = new Label("Select a family");

        //Create text field
        Text text = new Text();

        // Plant families list
        getCells a = new getCells();
        a.famListCreater();
        ArrayList<String> families = a.famList;

//        a.charListCreater();
//       ArrayList<String> characters = a.charList;
//       System.out.println(characters);

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
        TilePane tile_pane = new TilePane(combo_box, selected, text, back2main(s));

        //Setting the orientation for the Tile Pane
        tile_pane.setOrientation(Orientation.HORIZONTAL);

        //Setting the alignment for the Tile Pane
        tile_pane.setTileAlignment(Pos.CENTER_LEFT);

        //Setting the preferred columns for the Tile Pane
        tile_pane.setPrefRows(20);

        //Setting background colour
        tile_pane.setStyle("-fx-background-color: DAE6F3;");

        // Create a scene
        Scene scene = new Scene(tile_pane, 500, 500);

        // Set title for the stage
        s.setTitle("Plant families of the Netherlands");

        return scene;
    }

    public Scene charCheckbox (String CharType, VBox vbCTC, Probability p, Scene scene, Stage s) {
        //something which makes checkboxes in a layout, triggered by charTypeCombibox, triggers probability

        //gets data from excel
        getCells a = new getCells();
        a.charTypeListCreater();
        ArrayList<String> cLC = a.charListCreater();

        // the layout for borderpane center
        VBox v = new VBox();
        ScrollPane sp = new ScrollPane();
        BorderPane bp = new BorderPane();
        bp.setBottom(back2main(s));
        bp.setLeft(vbCTC);

        //int for knowing which cells to read
        int i = a.charTypeList.indexOf(CharType);
        int start = a.charTypeListPosition.get(i) - 2;
        int end = a.charTypeListPosition.get(i + 1) - 2;

        //array for all the checkboxes to be displayed
        ArrayList<CheckBox> cbArray = new ArrayList<>();
        //deletes prior characteristic type checkboxes
        v.getChildren().clear();

        // Create action event
        EventHandler<ActionEvent> eventABC = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                //gets user input
                CheckBox box = (CheckBox) e.getSource();
                String id = box.getId();
                //decides what to do if checkbox is selected or unselected
                if (box.isSelected()) {
                    //updates the probability, produces a string containing an 'lack of input message' or the most likely family
                    p.allTheCharsChosen.add(id);
                    String strNeedInput = p.charWeight(id, true);
                    Label label = new Label(strNeedInput);
                    bp.setRight(label);
                    // Create a scene
                    scene.setRoot(bp);
                    s.setScene(scene);

                    ;
                } else {
                    p.allTheCharsChosen.remove(id);
                    //updates the probability, produces a string containing an 'lack of input message' or the most likely family
                    String strNeedInput = p.charWeight(id, false);
                    Label label = new Label(strNeedInput);
                    bp.setRight(label);
                    // Create a scene
                    scene.setRoot(bp);
                    s.setScene(scene);
                }
            }
        };

        //loop for creating checkboxes for selected characteristic type
        for (int q = start; q < end; q++) {
            String string = cLC.get(q);
            CheckBox check = new CheckBox(string);
            check.setId(string);
            cbArray.add(check);
            //stopping a char being selected twice, ticks stay when flipping through combibox options
            if (p.allTheCharsChosen.contains(string)) {
                check.setSelected(true);
            }

            //triggers action event
            check.setOnAction(eventABC);
        }

        //adds checkboxes to the layout
        v.getChildren().addAll(cbArray);
        //adds scrollbar to the layout
        sp.setContent(v);
        bp.setCenter(sp);

        bp.setStyle("-fx-background-color: DAE6F3;");

        // Create a scene
        scene.setRoot(bp);

        // Set title for the stage
        s.setTitle("Plant families of the Netherlands");
        s.setScene(scene);
        return scene;
    }


    public Scene charTypeCombibox (Stage s){
        //creates charateristic type combobox in a layout (VBox), triggers charCheckbox

        //gets data from excel
        getCells a = new getCells();
        a.charTypeListCreater();
        ArrayList charType; //Arraylist to be made into a combobox
        charType = a.charTypeList;

        //needs not to be new when different checkboxes are made so it was made here,
        // also resets when back to main is triggered
        Probability p = new Probability();

        //layout
        VBox v = new VBox(20);
        BorderPane bp = new BorderPane();
        bp.setBottom(back2main(s));
        Scene scene = new Scene(bp, 500, 500);


        //creates the combobox
        ComboBox<String> combo_box =
                new ComboBox<>(FXCollections.observableArrayList(charType));
        // Create action event
            EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                //Gets user input
                String selectedCT = String.valueOf(combo_box.getValue());
                charCheckbox(selectedCT, v, p, scene, s);
                //updating scene

               //sp.setContent(charCheck);
            }
        };
        // Set on action
        combo_box.setOnAction(event);

        //adds combobox to layout
        v.getChildren().add(combo_box);
        bp.setLeft(v);

        bp.setStyle("-fx-background-color: DAE6F3;");

        // Create a scene
        scene.setRoot(bp);

        // Set title for the stage
        s.setTitle("Plant families of the Netherlands");
        s.setScene(scene);

        // returns layout (before checkboxes are added)
        return scene;
    }


}


