import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.w3c.dom.css.Rect;

import javax.swing.*;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Jaapani mõistatus");
        primaryStage.show();


        VBox vbox = new VBox();
        vbox.setSpacing(2);
        vbox.setAlignment(Pos.CENTER);
        Scene start = new Scene(vbox, 300, 250);
        primaryStage.setScene(start);
        primaryStage.show();

        Label pealkiri = new Label("Tere tulemast mängu!");

        Button submitButton = new Button("Alusta!");
        //Pane pane1 = new Pane();
        //vbox.getChildren().add(pealkiri);
        //pealkiri.setTranslateX(100);
        //pealkiri.setTranslateY(75);
        //vbox.getChildren().add(submitButton);
        //submitButton.setTranslateX(100);
        //submitButton.setTranslateY(100);

        vbox.getChildren().addAll(pealkiri, submitButton);

        submitButton.setText("Alusta");


       /* Esimese mõistatuse numbrid
        1,1
        5
        5
        3
        1

        2, 4, 4, 4, 2
        */

        submitButton.setOnAction((event) -> {
            showGame();
        });


       /** public int black = 1;

        public int white = 0;

        public int[][] row_rules = {}**/

        /** see peaks olema mustade ja valgete ruutude
         * lahenduse skeem**/

        /**if (timeTaken < fastestTime) {

            fastestTime = timeTaken;

        see võiks olla aja võtmise jaoks,
         annaks eraldi teate, kui on uus high score**/


    }

    private void showGame() {
        int pilt [][] = {{0,1,0,1,0},
        {1,1,1,1,1},
        {1,1,1,1,1},
        {0,1,1,1,0},
        {0,0,1,0,0}};

        GridPane grid = new GridPane();

        //grid.setGridLinesVisible(true);
        grid.setHgap(1);
        grid.setVgap(1);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++){
                Rectangle rectangle = new Rectangle(50, 50);
                rectangle.setFill(Color.LIGHTCORAL);
                rectangle.setOnMouseClicked ((event) -> {
                    if (event.getButton() == MouseButton.PRIMARY){
                        rectangle.setFill(Color.BLACK);
                    }
                    else {
                        rectangle.setFill(Color.WHITE);
                    }


                    System.out.println(event.getButton());
                } );
                grid.add(rectangle, i, j);
            }
        }

        Scene mõistatus = new Scene(grid, 450, 550);

        Stage stage2 = new Stage();
        stage2.setScene(mõistatus);
        stage2.setTitle("Uus mäng");
        stage2.show();


    }
}