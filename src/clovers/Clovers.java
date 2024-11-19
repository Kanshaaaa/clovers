/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package clovers;

import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import static javafx.scene.input.KeyCode.DOWN;
import static javafx.scene.input.KeyCode.ESCAPE;
import static javafx.scene.input.KeyCode.LEFT;
import static javafx.scene.input.KeyCode.RIGHT;
import static javafx.scene.input.KeyCode.UP;
import static javafx.scene.input.KeyCode.X;
import static javafx.scene.input.KeyCode.Z;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author DELL
 */
public class Clovers extends Application {

    private double screenWidth = 1000; // Width of visible area
    private double screenHeight = 800; // Height of visible area
    private double bgWidth = 1746;     // Width of kitchen background
    private double bgHeight = 1166;    // Height of kitchen background
    private double ghostStep = 10;     // Step size for ghost movement
    private int currentImg = 0;
    Image safeImg = new Image("file:///C://Users//DELL//Desktop//Game//clovers//src//clovers//safe_input.png/");
    Image safeOpen = new Image("file:///C://Users//DELL//Desktop//Game//clovers//src//clovers//safe_open.png/");
    Image safeWrong = new Image("file:///C://Users//DELL//Desktop//Game//clovers//src//clovers//safe_wrong.png/");
    Image book = new Image("file:///C://Users//DELL//Desktop//Game//clovers//src//clovers//recipe_book.png/");

    TextField safeInput = new TextField();
    ImageView safe = new ImageView(safeImg);

//    private double offsetY = 80;
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setMaximized(true);
        System.out.println("testing");
//jumans 
//        Image ghostOg = new Image("file:///C://Users//quikm//Desktop//SE220//Game//clovers//src//clovers//left1.png/");
//        Image lifeImg = new Image("file:///C:/Users/quikm/Desktop/SE220/Game/clovers/src/clovers/lives.png");
//        Image menuImg = new Image("file:///C:/Users/quikm/Desktop/SE220/Game/clovers/src/clovers/menu.png");
//        Image timerImg = new Image("file:///C://Users//quikm//Desktop//SE220//Game//clovers//src//clovers//timer.png/");
//        //  ImageView ghost = new ImageView(new Image("file:///C://Users//DELL//Desktop//SE220//Game//clovers//src//clovers//ghost.png/"));
//        Image ghostRight = new Image("file:///C://Users//quikm//Desktop//SE220//Game//clovers//src//clovers//right1.png/");
//        Image ghostUp = new Image("file:///C://Users//quikm//Desktop//SE220//Game//clovers//src//clovers//up1.png/");
//        Image ghostDown = new Image("file:///C://Users//quikm//Desktop//SE220//Game//clovers//src//clovers//down2.png/");
//        ImageView imageView = new ImageView(new Image("file:///C://Users//quikm//Desktop//SE220//Game//clovers//src//clovers//bg.png/"));

        //kanzahs 
        Image ghostOg = new Image("file:///C://Users//DELL//Desktop//Game//clovers//src//clovers//left1.png/");
        Image lifeImg = new Image("file:///C://Users//DELL//Desktop//Game//clovers//src//clovers/life.png/");
        Image menuImg = new Image("file:///C://Users//DELL//Desktop//Game//clovers//src//clovers//menu4.png/");
        Image timerImg = new Image("file:///C://Users//DELL//Desktop//Game//clovers//src//clovers//timer.png/");
        //  ImageView ghost = new ImageView(new Image("file:///C://Users//DELL//Desktop//SE220//Game//clovers//src//clovers//ghost.png/"));
        Image ghostRight = new Image("file:///C://Users//DELL//Desktop//Game//clovers//src//clovers//right1.png/");
        Image ghostUp = new Image("file:///C://Users//DELL//Desktop//Game//clovers//src//clovers//up1.png/");
        Image ghostDown = new Image("file:///C://Users//DELL//Desktop//Game//clovers//src//clovers//down2.png/");
        Image pic1 = new Image("file:///C://Users//DELL//Desktop//Game//clovers//src//clovers//polaroid_one.png/");
        Image pic2 = new Image("file:///C://Users//DELL//Desktop//Game//clovers//src//clovers//polaroid_two.png/");
        Image pic3 = new Image("file:///C://Users//DELL//Desktop//Game//clovers//src//clovers//polaroid_three.png/");
        Image pic4 = new Image("file:///C://Users//DELL//Desktop//Game//clovers//src//clovers//polaroid_four.png/");

        Font font = Font.loadFont("file:///C:/Users/DELL/Desktop/Game/clovers/resources/Pixellari.ttf/", 40);
        Font bFont = Font.loadFont("file:///C:/Users/DELL/Desktop/Game/clovers/resources/Pixellari.ttf/", 12);
        Button b1 = new Button("1");
        Button b2 = new Button("2");
        Button b3 = new Button("3");
        Button b4 = new Button("4");
        Button b5 = new Button("5");
        Button b6 = new Button("6");
        Button b7 = new Button("7");
        Button b8 = new Button("8");
        Button b9 = new Button("9");
        Button b0 = new Button("0");

//        Label label = new Label("TESTING FONT PLZ WORK");
//        label.setFont(font);
        Text text = new Text("TESTING");
        text.setFont(font);
        text.setFill(Color.WHITE);
//        text.setStroke(Color.WHITE);

        ImageView polaroid = new ImageView();
        polaroid.setFitWidth(300);
        polaroid.setFitHeight(400);

        Image bgCabinet = new Image("file:///C://Users//DELL//Desktop//Game//clovers//src//clovers//cabinet_interaction.png/");
        Image bg = new Image("file:///C://Users//DELL//Desktop//Game//clovers//src//clovers//bg.png/");
        ImageView imageView = new ImageView(bg);
        ImageView ghost = new ImageView(ghostOg);
        ImageView menu = new ImageView(menuImg);
        ImageView life = new ImageView(lifeImg);
        ImageView life2 = new ImageView(lifeImg);
        ImageView life3 = new ImageView(lifeImg);
        ImageView timer = new ImageView(timerImg);

        imageView.setFitWidth(1746);
        imageView.setFitHeight(1166);
        imageView.setX(0);
        imageView.setY(0);

        ghost.setFitWidth(400);
        ghost.setFitHeight(400);
        ghost.setLayoutX(20);
        ghost.setX(0);
        ghost.setY(0);

        life.setFitWidth(80);
        life.setFitHeight(80);
        life2.setFitWidth(80);
        life2.setFitHeight(80);
        life3.setFitWidth(80);
        life3.setFitHeight(80);

        timer.setFitWidth(180);
        timer.setFitHeight(70);
        menu.setFitWidth(70);
        menu.setFitHeight(70);

        life.setX(100);
        life2.setX(200);
        life3.setX(300);

        menu.setY(10);
        menu.setX(10);
        timer.setX(570);
        timer.setY(0);

        polaroid.setFitWidth(280);
        polaroid.setFitHeight(340);
        polaroid.setX(500);
        polaroid.setY(100);

        ArrayList<Image> img = new ArrayList<>(3);
        img.add(0, pic1);
        img.add(1, pic2);
        img.add(2, pic3);
        img.add(3, pic4);

        Button next = new Button(">");
        Button prev = new Button("<");
        next.setLayoutX(850);
        next.setLayoutY(300);
        prev.setLayoutX(450);
        prev.setLayoutY(300);

        safe.setFitWidth(510);
        safe.setFitHeight(510);
        safe.setX(400);
        safe.setY(50);

        safeInput.setLayoutX(687);
        safeInput.setLayoutY(194);

        safeInput.setPrefWidth(119);
        safeInput.setPrefHeight(32);

        safeInput.setStyle("-fx-background-color:transparent;");

        Rectangle dialogue = new Rectangle(250, 470, 800, 160);
        dialogue.setFill(Color.BLACK);
        dialogue.setStroke(Color.WHITE);
        dialogue.setStrokeWidth(5);
        int[] lives = {3};
        int mtlh = 2; //MinsToLoseHearts
        Timeline timerAnim = new Timeline();
        Text timerText = new Text("00:00");
        //timerText.setFont(font);
        timerText.setX(610);
        timerText.setY(52);
        timerText.setFont(font);

        timerText.setFill(Color.DARKGREEN);
        KeyFrame timerFrame = new KeyFrame(Duration.seconds(1), (e -> {
            int mins = Integer.parseInt(timerText.getText().substring(0, 2));
            int secs = Integer.parseInt(timerText.getText().substring(3, 5));

            if (secs == 59) {
                mins++;
                secs = 0;
            } else {
                secs++;
            }
            String minS = String.valueOf(mins);
            String secS = String.valueOf(secs);

            if (minS.length() == 1) {
                minS = "0" + minS;
            }

            if (secS.length() == 1) {
                secS = "0" + secS;
            }

            timerText.setText(minS + ":" + secS);
            if (mins != 0 && mins % mtlh == 0) {
                //lifeLost.play() //spund when life lost
                lives[0]--;
                switch (mins / mtlh) {
                    case 1:
                        life3.setVisible(false);
                        break;
                    case 2:
                        life2.setVisible(false);
                        break;
                    case 3:
                        life.setVisible(false);
                        break;
                }
                if (mins / mtlh == 3) {
                    timerAnim.stop();
                }
            }
        }));
        timerAnim.getKeyFrames().add(timerFrame);
        timerAnim.setCycleCount(Timeline.INDEFINITE);
        timerAnim.play();

        Pane topBar = new Pane(menu, life, life2, life3, timer, timerText);
        Pane pane = new Pane();

        pane.getChildren().addAll(imageView, ghost, topBar);
      
                               
        
        StackPane stack = new StackPane();
        Pane pane2 = new Pane();

        Pane pane3 = new Pane();
        pane3.getChildren().addAll(safe, safeInput);

        pane2.getChildren().addAll(prev, polaroid, next);
        stack.getChildren().addAll(pane, topBar);

        // stack.setClip(rectangle);
        // stack.setLayoutX(0);
        //  pane.getChildren().addAll(imageView, ghost);
        Scene scene = new Scene(stack, 1746, 1166);

        scene.setOnMousePressed(e -> {

            System.out.println("X: " + e.getX() + "Y: " + e.getY());
        });

        b1.setOnAction(e2 -> {
            safeInput.setText(safeInput.getText() + "1       ");
        });
        b2.setOnAction(e2 -> {
            safeInput.setText(safeInput.getText() + "2       ");
        });
        b3.setOnAction(e2 -> {
            safeInput.setText(safeInput.getText() + "3       ");
        });
        b4.setOnAction(e2 -> {
            safeInput.setText(safeInput.getText() + "4       ");
        });
        b5.setOnAction(e2 -> {
            safeInput.setText(safeInput.getText() + "5       ");
        });
        b6.setOnAction(e2 -> {
            safeInput.setText(safeInput.getText() + "6       ");
        });
        b7.setOnAction(e2 -> {
            safeInput.setText(safeInput.getText() + "7       ");
        });
        b8.setOnAction(e2 -> {
            safeInput.setText(safeInput.getText() + "8       ");
        });
        b9.setOnAction(e2 -> {
            safeInput.setText(safeInput.getText() + "9       ");
        });
        b0.setOnAction(e2 -> {
            safeInput.setText(safeInput.getText() + "0       ");
        });
        GridPane dial = new GridPane();
        scene.setOnKeyPressed(e -> {

            switch (e.getCode()) {
                case DOWN:
                    ghost.setImage(ghostDown);
                    if (!(ghost.getY() + 10 > imageView.getY() + imageView.getFitHeight() - ghost.getFitHeight())) {
                        ghost.setY(ghost.getY() + 10);
                    }
                    break;
                case UP:
                    ghost.setImage(ghostUp);
                    if (!(ghost.getY() - 10 < imageView.getY())) {

                        ghost.setY(ghost.getY() - 10);
                    }
                    break;

                case LEFT:
                    ghost.setImage(ghostOg);
                    if (!(ghost.getX() - 10 < imageView.getX())) {

                        ghost.setX(ghost.getX() - 10);
                    }
                    break;
                case RIGHT:
                    ghost.setImage(ghostRight);
                    if (!(ghost.getX() + 10 > imageView.getX() + imageView.getFitWidth() - ghost.getFitWidth())) {

                        ghost.setX(ghost.getX() + 10);
                    }
                    break;

                case Z:
                    System.out.println("z key is pressed");
                    //all interactions with a z
//                     
//
//                    //fridge interaction
                    if (ghost.getX() >= 430.0 && ghost.getX() <= 680.0 && ghost.getY() <= 250.0 && ghost.getY() >= 0.0) {
                        System.out.println("near fridge");
                        polaroid.setImage(img.get(currentImg));

                        stack.getChildren().addAll(pane2);

                    }
//cabinet interaction
                    if (ghost.getX() >= 50 && ghost.getX() <= 280 && ghost.getY() <= 250 && ghost.getY() >= 230) {
                        
                        if (imageView.getImage() != bg && imageView.getImage() == bgCabinet) {//cabinet open
                             if (safe.getImage() == safeOpen) {//if the safe is open
                                safe.setImage(book);
                                safe.setY(40);
                                 safe.setX(500);
                                safe.setFitHeight(410);
                                safe.setFitWidth(410);
                                //stack.getChildren().remove(pane3);
                            }
                             else{// if the safe is closed
                            safe.setImage(safeImg);

                            dial.addRow(0, b1, b2, b3);
                            dial.addRow(1, b4, b5, b6);
                            // dial.addRow(2, b7, b8, b9);
                            // dial.add(b0, 1, 3);

                            dial.setLayoutX(695);
                            dial.setLayoutY(235);

                            b0.setLayoutX(738);
                            b0.setLayoutY(359);
                            b7.setLayoutX(696);
                            b7.setLayoutY(322);
                            b8.setLayoutX(738);
                            b8.setLayoutY(322);
                            b9.setLayoutX(780);
                            b9.setLayoutY(322);

                            b1.setFont(bFont);
                            b2.setFont(bFont);
                            b3.setFont(bFont);
                            b4.setFont(bFont);
                            b5.setFont(bFont);
                            b6.setFont(bFont);
                            b7.setFont(bFont);
                            b8.setFont(bFont);
                            b9.setFont(bFont);
                            b0.setFont(bFont);

                            dial.setHgap(20);
                            dial.setVgap(20);
                            pane3.getChildren().addAll(dial, dialogue, b0, b7, b8, b9);
                            stack.getChildren().add(pane3);
                             }
                           
                        } 
                        else {
                            imageView.setImage(bgCabinet);
                        }

                    }

                    break;

                case X:
                    if (stack.getChildren().contains(pane2)) {
                        stack.getChildren().remove(pane2);
                    }

                    if (stack.getChildren().contains(pane3)) {
                        stack.getChildren().remove(pane3);
                    }

                case ENTER:
                    if (safeInput.getText().equals("1       9       5       8       ")) {

                        // safeInput.setStyle("-fx-border-color:green;-fx-border-width:2");
                        safeInput.setBorder(new Border(new BorderStroke(
                                Color.GREEN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3)
                        )));
                        safe.setImage(safeOpen);
                        pane3.getChildren().removeAll(dial, b0, b7, b8, b9, safeInput);
                    } else {
                        //   safeInput.setStyle("-fx-border-color:red;-fx-border-width:2");
                        safeInput.setBorder(new Border(new BorderStroke(
                                Color.RED, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3)
                        )));
                        safe.setImage(safeWrong);
                    }

                    break;

            }
            scrollBackground(imageView, ghost);

        });
        next.setOnAction(e -> {

            try {
                if (currentImg < 3) {

                    System.out.println("next clicked");
                    polaroid.setImage(img.get(currentImg + 1));
                    currentImg++;
                }

            } catch (ArrayIndexOutOfBoundsException e2) {
                System.out.println("no more images" + e2.getMessage());
            }

        });
        prev.setOnAction(e -> {
            try {
                System.out.println("prev clicked");
                polaroid.setImage(img.get(currentImg - 1));
                currentImg--;

            } catch (ArrayIndexOutOfBoundsException e2) {
                System.out.println("no more images" + e2.getMessage());
            }

        });

        primaryStage.setTitle("curses and clovers");
        primaryStage.setScene(scene);
        primaryStage.show();
        ghost.requestFocus();
    }

    public void checkInput() {
        while (safeInput.getText().equals("1985") == false) {
            safe.setImage(safeWrong);
        }
        safe.setImage(safeOpen);

    }

    private void scrollBackground(ImageView background, ImageView ghost) {
        double ghostX = ghost.getX();
        double ghostY = ghost.getY();

        // Check if the ghost is near the right edge
        if (ghostX > screenWidth * 0.7 && background.getX() - 290 > screenWidth - bgWidth) {// 290 being the width of the weird white part
            background.setX(background.getX() - ghostStep);
            ghost.setX(ghostX - ghostStep); // Move ghost with background
        }
        // Check if the ghost is near the left edge
        if (ghostX < screenWidth * 0.3 && background.getX() < 0) {
            background.setX(background.getX() + ghostStep);
            ghost.setX(ghostX + ghostStep);
        }
        // Check if the ghost is near the bottom edge
        if (ghostY > screenHeight * 0.3 && background.getY() > screenHeight - bgHeight) {
            background.setY(background.getY() - ghostStep);
            ghost.setY(ghostY - ghostStep);
        }
        // Check if the ghost is near the top edge
        if (ghostY < screenHeight * 0.3 && background.getY() < 0) {
            background.setY(background.getY() + ghostStep);
            ghost.setY(ghostY + ghostStep);
        }

        if (ghostX == 1746) {
            background.setX(1746);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
//for the cabinet add a loop for invalid answer,fix the x y options for open safe, fix x y positions for te actual book