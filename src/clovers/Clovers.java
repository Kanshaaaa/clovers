/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package clovers;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import static javafx.scene.input.KeyCode.DOWN;
import static javafx.scene.input.KeyCode.LEFT;
import static javafx.scene.input.KeyCode.RIGHT;
import static javafx.scene.input.KeyCode.UP;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

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
//    private double offsetY = 80;

    @Override
    public void start(Stage primaryStage) {
        System.out.println("testing");
        // ImageView ghost = new ImageView(getClass().getResource("ghost.png").toExternalForm());
        Image ghostOg = new Image("file:///C://Users//DELL//Desktop//SE220//Game//clovers//src//clovers//left1.png/");

        Image lifeImg = new Image("file:///C:/Users/DELL/Desktop/SE220/Game/clovers/src/clovers/lives.png");
        Image menuImg = new Image("file:///C:/Users/DELL/Desktop/SE220/Game/clovers/src/clovers/menu.png");
        Image timerImg = new Image("file:///C://Users//DELL//Desktop//SE220//Game//clovers//src//clovers//timer.png/");
        //  ImageView ghost = new ImageView(new Image("file:///C://Users//DELL//Desktop//SE220//Game//clovers//src//clovers//ghost.png/"));
        
        Image ghostRight = new Image("file:///C://Users//DELL//Desktop//SE220//Game//clovers//src//clovers//right1.png/");
        Image ghostUp = new Image("file:///C://Users//DELL//Desktop//SE220//Game//clovers//src//clovers//up1.png/");
        Image ghostDown = new Image("file:///C://Users//DELL//Desktop//SE220//Game//clovers//src//clovers//down2.png/");
        ImageView imageView = new ImageView(new Image("file:///C://Users//DELL//Desktop//SE220//Game//clovers//src//clovers//bg.png/"));

//       Image bg = new Image(getClass().getResourceAsStream("bg.png"));
//       ImageView imageView=new ImageView(bg);
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
//        ghost.setY(offsetY + 150);

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
        timer.setX(570);
        timer.setY(0);

        Rectangle rectangle = new Rectangle(0, 0, 1500, 800);
        Pane topBar = new Pane(menu, life, life2, life3, timer);
        Pane pane = new Pane();
        pane.getChildren().addAll(imageView, ghost, topBar);
        StackPane stack = new StackPane();

        stack.getChildren().addAll(pane, topBar);
        stack.setClip(rectangle);
        stack.setLayoutX(0);

        //  pane.getChildren().addAll(imageView, ghost);
        Scene scene = new Scene(stack, 1746, 1166);

        ghost.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                System.out.println("enter key is pressed");
            }
        });

        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case DOWN:
                    ghost.setImage(ghostDown);
                    ghost.setY(ghost.getY() + 10);
                    break;
                case UP:
                    ghost.setImage(ghostUp);
                    ghost.setY(ghost.getY() - 10);
                    break;

                case LEFT:
                    ghost.setImage(ghostOg);
                    ghost.setX(ghost.getX() - 10);
                    break;
                case RIGHT:
                    ghost.setImage(ghostRight);
//                  
                    ghost.setX(ghost.getX() + 10);
                    break;

            }
            scrollBackground(imageView, ghost);

        });

//        if(ghost.getX()==260){
//            imageView.setY(400);
//        }
        ghost.setOnMousePressed(e -> {
            System.out.println(ghost.getY());
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
        if (ghostX > screenWidth * 0.7 && background.getX() > screenWidth - bgWidth) {
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
        
        if(ghostX==1746){
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
