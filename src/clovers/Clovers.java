/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package clovers;

import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
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
    Media button = new Media("file:///C://Users//DELL//Desktop//Game//clovers//src//clovers//button.mp3/");
    MediaPlayer buttonPlayer = new MediaPlayer(button);
    TextField safeInput = new TextField();
    ImageView safe = new ImageView(safeImg);
     Scanner scan;

//    private double offsetY = 80;
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException, IOException {
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

        Media rain = new Media("file:///C://Users//DELL//Desktop//Game//clovers//src//clovers//rain.mp4/");
        MediaPlayer rainPlayer = new MediaPlayer(rain);
        MediaView rainView = new MediaView(rainPlayer);

        Media entry = new Media("file:///C://Users//DELL//Desktop//Game//clovers//src//clovers//entry.mp3/");
        MediaPlayer entryPlayer = new MediaPlayer(entry);
        MediaView entryView = new MediaView(entryPlayer);

        Media firstSecond = new Media("file:///C://Users//DELL//Desktop//Game//clovers//src//clovers//rain.mp4/");

        MediaPlayer firstSecondPlayer = new MediaPlayer(firstSecond);
        MediaView firstSecondView = new MediaView(firstSecondPlayer);

        Media third = new Media("file:///C://Users//DELL//Desktop//Game//clovers//src//clovers//third.mp3/");
        MediaPlayer thirdPlayer = new MediaPlayer(third);
        MediaView thirdView = new MediaView(thirdPlayer);

        Media safeBeep = new Media("file:///C://Users//DELL//Desktop//Game//clovers//src//clovers//safePress.mp3/");
        MediaPlayer safeBeepPlayer = new MediaPlayer(safeBeep);
        MediaView safeBeepView = new MediaView(safeBeepPlayer);

        Media correct = new Media("file:///C://Users//DELL//Desktop//Game//clovers//src//clovers//correct.mp3/");
        MediaPlayer correctPlayer = new MediaPlayer(correct);
        MediaView correctView = new MediaView(correctPlayer);

        Media wrong = new Media("file:///C://Users//DELL//Desktop//Game//clovers//src//clovers//wrong1.mp3/");
        MediaPlayer wrongPlayer = new MediaPlayer(wrong);
        MediaView wrongPlayerView = new MediaView(wrongPlayer);

        Media cabinetOpen = new Media("file:///C://Users//DELL//Desktop//Game//clovers//src//clovers//cabinetOpen.mp4/");
        MediaPlayer cabinetOpenPlayer = new MediaPlayer(cabinetOpen);

        Media safeReach = new Media("file:///C://Users//DELL//Desktop//Game//clovers//src//clovers//safeReach.mp3/");
        MediaPlayer safeReachPlayer = new MediaPlayer(safeReach);

        Media bookGrab = new Media("file:///C://Users//DELL//Desktop//Game//clovers//src//clovers//bookGrab.mp3/");
        MediaPlayer bookGrabPlayer = new MediaPlayer(bookGrab);

        rainPlayer.setCycleCount(rainPlayer.INDEFINITE);
        // rainPlayer.stop();
        rainPlayer.play();

        firstSecondPlayer.setCycleCount(firstSecondPlayer.INDEFINITE);
        // firstSecondPlayer.setVolume(10);
        firstSecondPlayer.play();
        firstSecondPlayer.stop();

        Font font = Font.loadFont("file:///C:/Users/DELL/Desktop/Game/clovers/resources/Pixellari.ttf/", 40);
        Font bFont = Font.loadFont("file:///C:/Users/DELL/Desktop/Game/clovers/resources/Pixellari.ttf/", 12);//button fonts
        Font dialogueFont=Font.loadFont("file:///C:/Users/DELL/Desktop/Game/clovers/resources/Pixellari.ttf/", 20);
      
                
//        File scanner = new File("file:///C://Users//DELL//Desktop//Game//clovers//src//clovers//me.txt/");
//        FileInputStream input = new FileInputStream(scanner);
//        int value;
//        while ((value = input.read()) != -1) {
//            System.out.print((char) value);
//        }
//        input.close();

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
        menu.setFitWidth(50);
        menu.setFitHeight(50);

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
        safeInput.setLayoutY(192);

        safeInput.setPrefWidth(119);
        safeInput.setPrefHeight(32);

        safeInput.setFont(bFont);
        safeInput.setStyle("-fx-background-color:#7393B3;-fx-text-fill: white;");

        GridPane dial = new GridPane();

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

        Rectangle dialogue = new Rectangle(250, 470, 800, 160);
        dialogue.setFill(Color.BLACK);
        dialogue.setStroke(Color.WHITE);
        dialogue.setStrokeWidth(5);
        
        HBox hb = new HBox();
        hb.setLayoutX(275);
        hb.setLayoutY(500);
        hb.setSpacing(30);
        
        Rectangle charImg = new Rectangle(100, 100);
        charImg.setFill(Color.ANTIQUEWHITE);
        charImg.setX(266);
        charImg.setLayoutY(500);
        
          Label skip=new Label("skip");
          skip.setFont(dialogueFont);
        skip.setStyle("-fx-text-fill:white;");
        skip.setLayoutX(1000);
        skip.setLayoutY(600);
        
        
        Label speaker = new Label("testing");
        speaker.setLayoutX(276);
        speaker.setLayoutY(500);
        speaker.setFont(dialogueFont);
      
        speaker.setStyle("-fx-text-fill:white;");
        
        Rectangle nameTag=new Rectangle(295,455,100,30);
        speaker.setLayoutX(276);
        speaker.setLayoutY(500);
        
        Label name=new Label("Genvieve");
         name.setStyle("-fx-text-fill:white;");
        name.setFont(dialogueFont);
        name.setLayoutX(300);
        
         name.setLayoutY(457);
         nameTag.setFill(Color.BLACK);
        nameTag.setStroke(Color.WHITE);
        nameTag.setStrokeWidth(2);
        
        Group dialogueBox=new Group(dialogue,nameTag,name);
        
        hb.getChildren().addAll(charImg,speaker);
        
        try {
            File file = new File("C://Users//DELL//Desktop//Game//clovers//src//clovers//mainScript.txt");
            scan = new Scanner(file);
          

        } catch (IOException e) {
            System.out.println("IOException" + e);
        }

        
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

        Rectangle safeTest = new Rectangle(196, 94);
        safeTest.setLayoutX(310);
        safeTest.setLayoutY(517);
        safeTest.setFill(Color.TRANSPARENT);
        safeTest.setStroke(Color.RED);
        Rectangle fridge = new Rectangle(838, 120, 214, 484);

        fridge.setFill(Color.TRANSPARENT);
        fridge.setStroke(Color.RED);

        Pane topBar = new Pane(menu, life, life2, life3, timer, timerText);

        fridge.setLayoutX(838);
        fridge.setLayoutY(120);
      
        
        Pane pane = new Pane();

        //fridge.layoutXProperty().bind(observable);
        pane.getChildren().addAll(imageView, ghost, topBar);

        StackPane stack = new StackPane();
        Pane pane2 = new Pane();
         pane2.getChildren().addAll(prev, polaroid, next);

        Pane pane3 = new Pane();
        pane3.getChildren().addAll(safe, dial, b0, b7, b8, b9, safeInput);
        
        Pane pane4=new Pane();//putting dialogue box in here
        pane4.getChildren().addAll(dialogueBox,hb,skip);
        

       
        stack.getChildren().addAll(pane, topBar,pane4);
        Slider s1 = new Slider(0, 1, 0.1);
        Slider s2 = new Slider(0, 1, 0.1);

        Rectangle menuBox = new Rectangle(450, 160, 500, 400);
        menuBox.setFill(Color.BURLYWOOD);

        Label resume = new Label("Resume");
        resume.setLayoutX(500);
        resume.setLayoutY(190);
        resume.setFont(font);

        Label map = new Label("Level map");
        map.setLayoutX(500);
        map.setLayoutY(290);
        map.setFont(font);

        Label manual = new Label("Game Manual");
        manual.setLayoutX(500);
        manual.setLayoutY(390);
        manual.setFont(font);

        Label settingsBtn = new Label("Settings");
        settingsBtn.setLayoutX(500);
        settingsBtn.setLayoutY(490);
        settingsBtn.setFont(font);

        Button back2 = new Button("<");
        back2.setLayoutX(470);
        back2.setLayoutY(170);
        back2.setFont(bFont);

        Pane gameMenu = new Pane(menuBox, back2, resume, map, manual, settingsBtn);
        gameMenu.setLayoutX(700);
        gameMenu.setLayoutY(190);

        Label amb = new Label("Ambience");
        Label music = new Label("Music");
        Label credits = new Label("Credits");
        Button back = new Button("<");
        back.setLayoutX(470);
        back.setLayoutY(170);
        back.setFont(bFont);

        s1.setLayoutX(700);
        s1.setLayoutY(190);
        s2.setLayoutX(700);
        s2.setLayoutY(290);
        amb.setLayoutX(500);
        music.setLayoutX(500);
        credits.setLayoutX(500);
        amb.setLayoutY(180);
        music.setLayoutY(280);
        credits.setLayoutY(380);

        s1.setMajorTickUnit(0.1);
        s1.setValue(0.1);
//        s1.setShowTickMarks(true);
//        s1.setShowTickLabels(true);

        s2.setMajorTickUnit(0.1);
        s2.setValue(0.1);
//        s2.setShowTickLabels(true);
//        s2.setShowTickMarks(true);

        amb.setFont(font);
        music.setFont(font);
        credits.setFont(font);
        Rectangle settingsBox = new Rectangle(450, 160, 500, 300);

        settingsBox.setFill(Color.BURLYWOOD);

        Pane settings = new Pane(settingsBox, back, amb, s1, music, s2, credits);
        settings.setLayoutY(470);
        settings.setLayoutX(470);

        s1.valueProperty().addListener(e -> {
            rainPlayer.setVolume(s1.getValue());
        });

        s2.valueProperty().addListener(e -> {
            firstSecondPlayer.setVolume(s2.getValue());
            firstSecondPlayer.play();
//            if (firstSecondPlayer.isMute() == false) {
//                firstSecondPlayer.setVolume(s1.getValue());
//            } else {
//                thirdPlayer.setVolume(s2.getValue());
//            }

        });

        // stack.getChildren().add(settings);
        menu.setOnMousePressed(e -> {
            stack.getChildren().add(gameMenu);
            buttonNoise();

        });

        settingsBtn.setOnMousePressed(e -> {
            stack.getChildren().remove(gameMenu);
            stack.getChildren().add(settings);
            buttonNoise();
        });
//        menu
        // stack.setClip(rectangle);
        // stack.setLayoutX(0);
        //  pane.getChildren().addAll(imageView, ghost);
        Scene scene = new Scene(stack, 1746, 1166);

        scene.setOnMousePressed(e -> {

            System.out.println("X: " + e.getX() + "Y: " + e.getY());
            System.out.println("ghostX: " + ghost.getLayoutX() + "ghostY: " + ghost.getLayoutY());
        });

        back.setOnMousePressed(e -> {//back button on the settings menu
            stack.getChildren().remove(settings);
            stack.getChildren().add(gameMenu);
            buttonNoise();
        });

        back2.setOnMousePressed(e -> {//the back button on the game menu
            stack.getChildren().remove(gameMenu);

            buttonNoise();
        });

        b1.setOnAction(e2 -> {
            safeInput.setText(safeInput.getText() + "1       ");
            safeBeepPlayer.stop();
            safeBeepPlayer.seek(javafx.util.Duration.ZERO);
            safeBeepPlayer.play();
        });
        b2.setOnAction(e2 -> {
            safeInput.setText(safeInput.getText() + "2       ");
            safeBeepPlayer.stop();
            safeBeepPlayer.seek(javafx.util.Duration.ZERO);
            safeBeepPlayer.play();
        });
        b3.setOnAction(e2 -> {
            safeInput.setText(safeInput.getText() + "3       ");
            safeBeepPlayer.stop();
            safeBeepPlayer.seek(javafx.util.Duration.ZERO);
            safeBeepPlayer.play();
        });
        b4.setOnAction(e2 -> {
            safeInput.setText(safeInput.getText() + "4       ");
            safeBeepPlayer.stop();
            safeBeepPlayer.seek(javafx.util.Duration.ZERO);
            safeBeepPlayer.play();
        });
        b5.setOnAction(e2 -> {
            safeInput.setText(safeInput.getText() + "5       ");
            safeBeepPlayer.stop();
            safeBeepPlayer.seek(javafx.util.Duration.ZERO);
            safeBeepPlayer.play();
        });
        b6.setOnAction(e2 -> {
            safeInput.setText(safeInput.getText() + "6       ");
            safeBeepPlayer.stop();
            safeBeepPlayer.seek(javafx.util.Duration.ZERO);
            safeBeepPlayer.play();
        });
        b7.setOnAction(e2 -> {
            safeInput.setText(safeInput.getText() + "7       ");
            safeBeepPlayer.stop();
            safeBeepPlayer.seek(javafx.util.Duration.ZERO);
            safeBeepPlayer.play();
        });
        b8.setOnAction(e2 -> {
            safeInput.setText(safeInput.getText() + "8       ");
            safeBeepPlayer.stop();
            safeBeepPlayer.seek(javafx.util.Duration.ZERO);
            safeBeepPlayer.play();
        });
        b9.setOnAction(e2 -> {
            safeInput.setText(safeInput.getText() + "9       ");
            safeBeepPlayer.stop();
            safeBeepPlayer.seek(javafx.util.Duration.ZERO);
            safeBeepPlayer.play();
        });
        b0.setOnAction(e2 -> {
            safeInput.setText(safeInput.getText() + "0       ");
            safeBeepPlayer.stop();
            safeBeepPlayer.seek(javafx.util.Duration.ZERO);
            safeBeepPlayer.play();
        });

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
                    System.out.println("Z key is pressed");
                    System.out.println("z key is pressed");
                    //all interactions with a z

//                     
//
//                    //fridge interaction
                    if (ghost.getX() + 20 >= 530.0 && ghost.getX() + 20 <= 820.0 && ghost.getY() <= 523.0 && ghost.getY() >= 120.0) {
                        //if (ghost.getBoundsInParent().intersects(fridge.getBoundsInParent())) {
                        System.out.println("near fridge");
                        polaroid.setImage(img.get(currentImg));
                        //  stack.getChildren().remove(safeInput);

                        stack.getChildren().addAll(pane2);

                    }
                    // Safe interaction
                    if (ghost.getX() + 20 >= 50 && ghost.getX() + 20 <= 280 && ghost.getY() <= 250 && ghost.getY() >= 230) {
                        if (imageView.getImage() == bgCabinet) {
                            if (safe.getImage() == book) {
                                bookGrabPlayer.stop();
                                bookGrabPlayer.seek(Duration.ZERO);
                                bookGrabPlayer.play();
                                // Exit book view (end interaction)
                                stack.getChildren().removeAll(pane3);
                            } else if (safe.getImage() == safeOpen) {
                                bookGrabPlayer.play();
                                // Transition to the book view
                                safe.setImage(book);
                                safe.setY(30);
                                safe.setX(450);
                                safe.setFitHeight(410);
                                safe.setFitWidth(410);
                            } else {
                                // Show safe UI with dials if not already showing book or safeOpen
                                safeReachPlayer.stop();
                                safeReachPlayer.seek(Duration.ZERO);
                                safeReachPlayer.play();

                                safe.setImage(safeImg);
                                safe.setFitWidth(510);
                                safe.setFitHeight(510);
                                safe.setX(400);
                                safe.setY(50);

                                // Ensure all UI components are visible and added to the pane
                                safeInput.setVisible(true);
                                b0.setVisible(true);
                                b7.setVisible(true);
                                b8.setVisible(true);
                                b9.setVisible(true);
                                dial.setVisible(true);
                                if (!pane3.getChildren().contains(dial)) {
                                    pane3.getChildren().addAll(dial, b0, b7, b8, b9, safeInput);
                                }
                                stack.getChildren().add(pane3);
                            }
                        } else if (imageView.getImage() == bg) {
                            // Change to cabinet background
                            imageView.setImage(bgCabinet);
                            cabinetOpenPlayer.stop();
                            cabinetOpenPlayer.seek(Duration.ZERO);
                            cabinetOpenPlayer.play();
                        }
                    }
                    break;

                case X:
                    if (stack.getChildren().contains(pane3)) {
                        // Instead of removing the components entirely, just hide them
                        safeInput.setVisible(false);
                        b0.setVisible(false);
                        b7.setVisible(false);
                        b8.setVisible(false);
                        b9.setVisible(false);
                        dial.setVisible(false);
                        stack.getChildren().remove(pane3);
                    }
                    if (stack.getChildren().contains(pane2)) {
                        stack.getChildren().remove(pane2);
                    }
                     if (stack.getChildren().contains(pane4)) {
                       stack.getChildren().remove(pane4);
                    }
                    break;
                   

                case ENTER:
//                    

                    if (safeInput.getText().equals("1       9       5       8       ")) {

                        // safeInput.setStyle("-fx-border-color:green;-fx-border-width:2");
                        correctPlayer.play();
                        safe.setY(35);
                        safe.setImage(safeOpen);

                        pane3.getChildren().removeAll(dial, b0, b7, b8, b9, safeInput);
                    } else {//wrong input
                        wrongPlayer.play();
                        safeInput.setStyle("-fx-border-color:#ff6961;-fx-border-width:2;-fx-background-color:#7393B3;-fx-text-fill: white;-fx-padding:0;");
                        // safeInput.setStyle("-fx-background-color:grey;-fx-text-fill: green;");
                        safeInput.setText("");
//                      
                        stack.getChildren().add(pane3);

                        safe.setImage(safeWrong);
                    }
                    break;
                case SPACE:
                     if (scan != null && scan.hasNextLine()) {
                String line = scan.nextLine();
                if (line.equals("-----")==false) {
                  
                    speaker.setText(line);
                    
                }
                else{
                   // label.setText("dashedLineReached");
                     line = scan.nextLine();
                    speaker.setText(line);
                    stack.getChildren().remove(pane4);
                   
                }

            } else {
                speaker.setText("End of file reached!");
                  stack.getChildren().remove(pane4);
                  closeScanner();
                //label.setDisable(true); // Disable button when no more lines
            }
                    break;

            }
            scrollBackground(imageView, ghost);

        });
        skip.setOnMousePressed(e4->{
   while (scan != null && scan.hasNextLine()) {
                String line = scan.nextLine();
                if (line.equals("-----")) {
                    line = scan.nextLine();
                    speaker.setText(line);
                    stack.getChildren().remove(pane4);
                    break; 
                }
                stack.getChildren().remove(pane4);
            }
            closeScanner();
});
        next.setOnAction(e -> {

            try {
                if (currentImg < 3) {

                    System.out.println("next clicked");
                    polaroid.setImage(img.get(currentImg + 1));
                    currentImg++;
                    buttonNoise();
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
                buttonNoise();

            } catch (ArrayIndexOutOfBoundsException e2) {
                System.out.println("no more images" + e2.getMessage());
            }

        });

        primaryStage.setTitle("curses and clovers");
        primaryStage.setScene(scene);
        primaryStage.show();
        ghost.requestFocus();
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

    private void buttonNoise() {
        buttonPlayer.stop();
        buttonPlayer.seek(javafx.util.Duration.ZERO);
        buttonPlayer.play();
    }
private void closeScanner() {
        if (scan != null) {
            scan.close();
            scan = null; // Set to null to avoid closing it multiple times
        }
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
