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
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author DELL
 */
public class Clovers extends Application {

    @Override
    public void start(Stage primaryStage) {
        System.out.println("testing");
        // ImageView ghost = new ImageView(getClass().getResource("ghost.png").toExternalForm());
        Image ghostOg=new Image("file:///C://Users//DELL//Desktop//SE220//Game//clovers//src//clovers//ghost.png/");
      //  ImageView ghost = new ImageView(new Image("file:///C://Users//DELL//Desktop//SE220//Game//clovers//src//clovers//ghost.png/"));
      ImageView ghost=new ImageView(ghostOg);
        Image ghostRight= new Image("file:///C://Users//DELL//Desktop//SE220//Game//clovers//src//clovers//character//right.png/");
        Image ghostUp= new Image("file:///C://Users//DELL//Desktop//SE220//Game//clovers//src//clovers//character//up.png/");
        ghost.setFitWidth(400);
        ghost.setFitHeight(400);
        ghost.setLayoutX(20);
        ghost.setLayoutY(150);
        
        
        
        
        //""
        ImageView imageView = new ImageView(new Image("file:///C://Users//DELL//Desktop//SE220//Game//clovers//src//clovers//bg.png/"));
//       Image bg = new Image(getClass().getResourceAsStream("bg.png"));
//       ImageView imageView=new ImageView(bg);

imageView.setStyle("-fx-property:streached");
        imageView.setFitWidth(1300);
        imageView.setFitHeight(650);
        imageView.setX(0);
        imageView.setY(0);
       
        Pane pane = new Pane();

        pane.getChildren().addAll(imageView, ghost);

        Scene scene = new Scene(pane, 300, 250);
      
        
        ghost.setOnKeyPressed(e->{
    if(e.getCode()==KeyCode.ENTER){
        System.out.println("enter key is pressed"); 
    }
});
  
        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case DOWN:
                    
                    ghost.setY(ghost.getY() + 10);break;
                case UP:
                    ghost.setY(ghost.getY() - 10);  break;
                case LEFT:
                   
                    ghost.setX(ghost.getX() - 10); break;
                case RIGHT:
//                     ghost.setImage(ghostRight);
//                   ghost.setLayoutX(20);
//        ghost.setLayoutY(150);
                    ghost.setX(ghost.getX() + 10);  break;
                    

            }
        });
        
      
        primaryStage.setTitle("curses and clovers");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
