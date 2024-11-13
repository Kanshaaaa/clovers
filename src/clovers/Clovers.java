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
    private double screenHeight = 600; // Height of visible area
    private double bgWidth = 1746;     // Width of kitchen background
    private double bgHeight = 1166;    // Height of kitchen background
    private double ghostStep = 10;     // Step size for ghost movement
    private double offsetY = 80;  
    @Override
    public void start(Stage primaryStage) {
        System.out.println("testing");
        // ImageView ghost = new ImageView(getClass().getResource("ghost.png").toExternalForm());
        Image ghostOg = new Image("file:///C://Users//DELL//Desktop//SE220//Game//clovers//src//clovers//ghost.png/");
        Image lifeImg = new Image("file:///C:/Users/DELL/Desktop/SE220/Game/clovers/src/clovers/lives.png");
        Image menuImg = new Image("file:///C:/Users/DELL/Desktop/SE220/Game/clovers/src/clovers/menu.png");
        Image timerImg = new Image("file:///C://Users//DELL//Desktop//SE220//Game//clovers//src//clovers//timer.png/");
        ImageView menuView = new ImageView(menuImg);
        ImageView life = new ImageView(lifeImg);
        ImageView life2 = new ImageView(lifeImg);
        ImageView life3 = new ImageView(lifeImg);
        ImageView timer = new ImageView(timerImg);
        
        Rectangle rectangle=new Rectangle(0,0,1746,80);
        rectangle.setFill(Color.ANTIQUEWHITE);

        life.setFitWidth(80);
        life.setFitHeight(80);
        life2.setFitWidth(80);
        life2.setFitHeight(80);
        life3.setFitWidth(80);
        life3.setFitHeight(80);
        
        timer.setFitWidth(120);
        timer.setFitHeight(80);
        menuView.setFitWidth(70);
        menuView.setFitHeight(70);

        life.setX(100);
        life2.setX(200);
        life3.setX(300);
      
        menuView.setY(10);
        timer.setX(600);

        Pane topBar = new Pane(rectangle,menuView, life, life2, life3,timer);

        //  ImageView ghost = new ImageView(new Image("file:///C://Users//DELL//Desktop//SE220//Game//clovers//src//clovers//ghost.png/"));
        ImageView ghost = new ImageView(ghostOg);
        Image ghostRight = new Image("file:///C://Users//DELL//Desktop//SE220//Game//clovers//src//clovers//right.png/");
        Image ghostUp = new Image("file:///C://Users//DELL//Desktop//SE220//Game//clovers//src//clovers//up.png/");
        ghost.setFitWidth(400);
        ghost.setFitHeight(400);
        ghost.setLayoutX(20);
        ghost.setY(offsetY + 150);
        

//        GridPane lives=new GridPane();
//        lives.addRow(0, lifeview,lifeview,lifeview);
        //""
        ImageView imageView = new ImageView(new Image("file:///C://Users//DELL//Desktop//SE220//Game//clovers//src//clovers//bg.png/"));
        
//       Image bg = new Image(getClass().getResourceAsStream("bg.png"));
//       ImageView imageView=new ImageView(bg);

        imageView.setStyle("-fx-property:streached");
        imageView.setFitWidth(1746 );
       imageView.setFitHeight(1166 );
        imageView.setX(0);
        imageView.setY(0);

        Pane pane = new Pane();

           pane.getChildren().addAll(imageView, ghost,topBar);
      //  pane.getChildren().addAll(imageView, ghost);

        Scene scene = new Scene(pane, 1746, 1166);

        ghost.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                System.out.println("enter key is pressed");
            }
        });

        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case DOWN:
//                    ghost.setImage(ghostOg);
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

        ghost.setOnMousePressed(e->{
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

          if (ghostX > screenWidth * 0.7 && background.getX() > screenWidth - bgWidth) {
            background.setX(background.getX() - ghostStep);
            ghost.setX(ghostX - ghostStep); // Move ghost with background
        }
        // Check if the ghost is near the left edge
        if (ghostX < screenWidth * 0.3 && background.getX() < 0) {
            background.setX(background.getX() + ghostStep);
            ghost.setX(ghostX + ghostStep);
        }
        // Check if the ghost is near the bottom edge (adjusted for offsetY)
        if (ghostY > (screenHeight - offsetY) * 0.7 + offsetY && background.getY() > screenHeight - bgHeight) {
            background.setY(background.getY() - ghostStep);
            ghost.setY(ghostY - ghostStep); // Keep ghost fully visible when moving down
        }

        // Top edge (adjusted for offsetY)
        if (ghostY < (screenHeight - offsetY) * 0.3 + offsetY && background.getY() < offsetY) {
            background.setY(background.getY() + ghostStep);
            ghost.setY(ghostY + ghostStep); // Keep ghost fully visible when moving up
        }

        // Optional: Prevent the background from moving too far beyond its boundaries (use conditions to set max/min values for Y)
        background.setY(Math.max(Math.min(background.getY(), offsetY), screenHeight - bgHeight));
   
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
