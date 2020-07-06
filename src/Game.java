import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;


import static com.sun.javafx.fxml.expression.Expression.add;
import static java.awt.image.BufferedImage.TYPE_3BYTE_BGR;
import static java.awt.image.BufferedImage.TYPE_CUSTOM;

public class Game extends Application {
    double pointsEarned = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setScene(rateAMemoryPalace());
        primaryStage.show();
    }

    public Scene points() {
        BorderPane bp = new BorderPane();
        Button addPoint = new Button("+1");
        bp.setLeft(addPoint);
        Text text = new Text();

        bp.setCenter(text);
        Scene scene = new Scene(bp, 500, 500);
        addPoint.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                pointsEarned++;
                lvlUP();
            }
        });

        return scene;
    }
    public Scene images() throws FileNotFoundException {
        //get the image
        BufferedImage img = new BufferedImage(400, 400, TYPE_3BYTE_BGR);
        Image i;
        try {
            img = ImageIO.read(getClass().getResource("Pictures4Game//0text.png"));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        i = SwingFXUtils.toFXImage(img, null);
        ImageView iv = new ImageView(i);
        //scene things
        VBox gameVB = new VBox();
        gameVB.getChildren().add(iv);
        //button things
        Button b = new Button("Next");
        // action event
        EventHandler<ActionEvent> event9 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                try {
                    BufferedImage bi = ImageIO.read(getClass().getResource("Pictures4Game//9text.png"));
                    Image g = SwingFXUtils.toFXImage (bi, null);
                    ImageView v = new ImageView(g);
                    gameVB.getChildren().clear();
                    gameVB.getChildren().add(v);

                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        };
        EventHandler<ActionEvent> event8 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                try {
                    BufferedImage bi = ImageIO.read(getClass().getResource("Pictures4Game//8text.png"));
                    Image g = SwingFXUtils.toFXImage (bi, null);
                    ImageView v = new ImageView(g);
                    gameVB.getChildren().clear();
                    gameVB.getChildren().add(v);
                    Button one  = new Button("Next");
                    gameVB.getChildren().add(one);
                    one.setOnAction(event9);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        };
        EventHandler<ActionEvent> event7 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                try {
                    BufferedImage bi = ImageIO.read(getClass().getResource("Pictures4Game//7text.png"));
                    Image g = SwingFXUtils.toFXImage (bi, null);
                    ImageView v = new ImageView(g);
                    gameVB.getChildren().clear();
                    gameVB.getChildren().add(v);
                    Button one  = new Button("Next");
                    gameVB.getChildren().add(one);
                    one.setOnAction(event8);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        };
        EventHandler<ActionEvent> event6 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                try {
                    BufferedImage bi = ImageIO.read(getClass().getResource("Pictures4Game//6text.png"));
                    Image g = SwingFXUtils.toFXImage (bi, null);
                    ImageView v = new ImageView(g);
                    gameVB.getChildren().clear();
                    gameVB.getChildren().add(v);
                    Button one  = new Button("Next");
                    gameVB.getChildren().add(one);
                    one.setOnAction(event7);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        };
        EventHandler<ActionEvent> event5 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                try {
                    BufferedImage bi = ImageIO.read(getClass().getResource("Pictures4Game//6text.png"));
                    Image g = SwingFXUtils.toFXImage (bi, null);
                    ImageView v = new ImageView(g);
                    gameVB.getChildren().clear();
                    gameVB.getChildren().add(v);
                    Button one  = new Button("Next");
                    gameVB.getChildren().add(one);
                    one.setOnAction(event6);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        };
        EventHandler<ActionEvent> event4 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                try {
                    BufferedImage bi = ImageIO.read(getClass().getResource("Pictures4Game//5text.png"));
                    Image g = SwingFXUtils.toFXImage (bi, null);
                    ImageView v = new ImageView(g);
                    gameVB.getChildren().clear();
                    gameVB.getChildren().add(v);
                    Button one  = new Button("Next");
                    gameVB.getChildren().add(one);
                    one.setOnAction(event5);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        };
        EventHandler<ActionEvent> event3 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                try {
                    BufferedImage bi = ImageIO.read(getClass().getResource("Pictures4Game//4text.png"));
                    Image g = SwingFXUtils.toFXImage (bi, null);
                    ImageView v = new ImageView(g);
                    gameVB.getChildren().clear();
                    gameVB.getChildren().add(v);
                    Button one  = new Button("Next");
                    gameVB.getChildren().add(one);
                    one.setOnAction(event4);
                } catch (Exception ex) {
                    System.out.println(ex);
                }

            }
        };
        EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                try {
                    BufferedImage bi = ImageIO.read(getClass().getResource("Pictures4Game//3text.png"));
                    Image g = SwingFXUtils.toFXImage (bi, null);
                    ImageView v = new ImageView(g);
                    gameVB.getChildren().clear();
                    gameVB.getChildren().add(v);

                    Button one  = new Button("Next");
                    gameVB.getChildren().add(one);
                    one.setOnAction(event3);

                } catch (Exception ex) {
                    System.out.println(ex);
                }

            }
        };
        EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                try {
                    BufferedImage bi = ImageIO.read(getClass().getResource("Pictures4Game//2text.png"));
                    Image g = SwingFXUtils.toFXImage (bi, null);
                    ImageView v = new ImageView(g);
                    gameVB.getChildren().clear();
                    gameVB.getChildren().add(v);

                    Button one  = new Button("Next");
                    gameVB.getChildren().add(one);
                    one.setOnAction(event2);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
                System.out.println("action event");

            }
        };

        b.setOnAction(event1);
        gameVB.getChildren().add(b);

        Scene gameScene = new Scene(gameVB);
        return gameScene;
    }

//    public Scene makeGame(){
//        // has the image and a text field, list of characteristics
//        BorderPane bp = new BorderPane();
//        ImageView v = new ImageView();
//        try {
//            BufferedImage bi = ImageIO.read(getClass().getResource("Pictures4Game//0.png"));
//            Image g = SwingFXUtils.toFXImage (bi, null);
//            v = new ImageView(g);
//
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }
//        VBox vbox = new VBox();
//        vbox.getChildren().add(v);
//
//        //Textfield
//        //What family was the memory palace?
//        TextField tf = new TextField("Family Name _ _ _ _ ...aceae, Make sure to capitalise 1st letter");
//        tf.setPrefColumnCount(10);
//        Button tfButton = new Button("Enter");
//        Text output = new Text();
//        HBox hb = new HBox(tf, tfButton);
//        bp.setCenter(hb);
//
//        VBox vb = new VBox();
//
//        tfButton.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
//            @Override
//            public void handle(javafx.event.ActionEvent event) {
//                String tfText = tf.getText();
//
//                // Plant families list
//                getCells a = new getCells();
//                a.famListCreater();
//                ArrayList<String> families = a.famList;
//                ArrayList<String> char4Chekcbox = a.famInfoGame(tfText);
//                if (families.contains(tfText)) {
//                    //a.famInfo(tfText);
//
//
//                    EventHandler<javafx.event.ActionEvent> addCharPoints = new EventHandler<javafx.event.ActionEvent>() {
//                        public void handle(javafx.event.ActionEvent eG) {
//                            CheckBox box = (CheckBox) eG.getSource();
//                            if (box.isSelected()) {
//                                pointsEarned = pointsEarned + 1;
//                                bp.setBottom(lvlUP());
//                                // System.out.println(pointsEarned);
//                            } else {
//                                pointsEarned = pointsEarned - 1;
//                                bp.setBottom(lvlUP());
//                                // System.out.println(pointsEarned);
//                            }
//
//                        }
//                    };
////plant fam info print out
//                    String string = char4Chekcbox.toString();
//                    Text faminfotext = new Text(string);
//                    bp.setRight(faminfotext);
//                    // display info of family as a series of checkboxes to be ticked
//                } else {
//                    String spelling = "Check spelling";
//                    output.setText(spelling);
//                    bp.setRight(output);
//                }
//            }
//        });
//        bp.setTop(vbox);
//    Scene scene = new Scene(bp);
//    return scene;
//    }
//
////    public Scene testGame (){
////        //sees what cahracteristics are remembered
////        try {
////            BufferedImage bi = ImageIO.read(getClass().getResource("Pictures4Game//9text.png"));
////            Image g = SwingFXUtils.toFXImage (bi, null);
////            ImageView v = new ImageView(g);
////
////        } catch (Exception ex) {
////            System.out.println(ex);
////        }
////    }

    public Text lvlUP() {
        String s = String.valueOf(pointsEarned);
        Text text = new Text("Your score is: " + s);
//        int[] numberss = {1, 2, 4, 8, 16, 32, 64, 128};
//        for (int i = 0; i < numberss.length; i++) {
//            if (pointsEarned == numberss[i]) {
//                text.setText("You leveled up :)");
//                return text;
//            }
//        }
//        text.setText("keep going!");
//        return text;
        return text;
    }

    public Scene rateAMemoryPalace() {
        BorderPane bp = new BorderPane();

        //What family was the memory palace?
        TextField tf = new TextField("Family Name");
        tf.setPrefColumnCount(10);
        Button tfButton = new Button("Enter");
        Text output = new Text();
        HBox hb = new HBox(tf, tfButton);
        bp.setCenter(hb);

        VBox vb = new VBox();

        tfButton.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                String tfText = tf.getText();

                // Plant families list
                getCells a = new getCells();
                a.famListCreater();
                ArrayList<String> families = a.famList;
                ArrayList<String> char4Chekcbox = a.famInfoGame(tfText);
                if (families.contains(tfText)) {
                    //a.famInfo(tfText);


                    EventHandler<javafx.event.ActionEvent> addCharPoints = new EventHandler<javafx.event.ActionEvent>() {
                        public void handle(javafx.event.ActionEvent eG) {
                            CheckBox box = (CheckBox) eG.getSource();
                            if (box.isSelected()) {
                                pointsEarned = pointsEarned + 1;
                                bp.setTop(lvlUP());
                               // System.out.println(pointsEarned);
                            } else {
                                pointsEarned = pointsEarned - 1;
                                bp.setTop(lvlUP());
                               // System.out.println(pointsEarned);
                            }

                        }
                    };

                    for (int i = 0; i < char4Chekcbox.size(); i++) {
                        String check = char4Chekcbox.get(i);
                        CheckBox cbChar = new CheckBox(check);
                        cbChar.setId(check);
                        vb.getChildren().add(cbChar);

                        cbChar.setOnAction(addCharPoints);
                    }


                    bp.setRight(output);
                    // display info of family as a series of checkboxes to be ticked
                } else {
                    String spelling = "Check spelling";
                    output.setText(spelling);
                    bp.setRight(output);
                }
            }
        });

        //Bonus points: rhyme, a joke, and a helping hand
        CheckBox bonusPointsRhyming = new CheckBox("Was there a rhyme?");
        CheckBox bonusPointsJoking = new CheckBox("Did it make you laugh?");
        CheckBox bonusPointsHelping = new CheckBox("Did they get a helping hand?");

        EventHandler<javafx.event.ActionEvent> addOnePoint = new EventHandler<javafx.event.ActionEvent>() {
            public void handle(javafx.event.ActionEvent e) {
                CheckBox box = (CheckBox) e.getSource();
                String id = box.getId();
                //decides what to do if checkbox is selected or unselected
                if (box.isSelected()) {
                    pointsEarned++;

                    bp.setTop(lvlUP());
                } else {
                    pointsEarned--;
                    bp.setTop(lvlUP());

                }
            }
        };

        bonusPointsHelping.setOnAction(addOnePoint);
        bonusPointsJoking.setOnAction(addOnePoint);
        bonusPointsRhyming.setOnAction(addOnePoint);

        vb.getChildren().addAll(bonusPointsHelping, bonusPointsJoking, bonusPointsRhyming);
        bp.setLeft(vb);
        GUI a = new GUI();
        Button b2m = a.back2mainStageless();
        bp.setBottom(b2m);
        Scene scene = new Scene(bp, 500, 500);
        return scene;

    }

    public Scene videoPlayer() {
        BorderPane bp = new BorderPane();
        URL resource = getClass().getResource("YTMemoryPalace.mp4");
        Media pick = new Media(resource.toString());
        MediaPlayer player = new MediaPlayer(pick);

        MediaView mediaView = new MediaView(player);

        // Add to scene
        Group root = new Group(mediaView);
        bp.setCenter(root);

        GUI g = new GUI();
        bp.setBottom(g.back2mainStageless());
        Scene scene = new Scene(bp, 1000, 1000);

        // Play the media once the stage is shown
        player.play();

        return scene;
    }
}
