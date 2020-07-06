import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;


public class checkbox extends Application  {


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("CheckBox Experiment 1");

        getCells a = new getCells();
        a.charTypeListCreater();

        HBox hbox = new HBox();

        for (int q = 0; q < 10; q++){
            String string = a.charTypeList.get(q);
            System.out.println(string);
            CheckBox check = new CheckBox(string);
            hbox.getChildren().add(check);
        }
        Scene scene = new Scene(hbox, 1000, 100);

        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}