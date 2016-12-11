import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.*;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.w3c.dom.css.Rect;


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

        Button submitButton1 = new Button("Mäng 1");        //teeb 3 nuppu, 3 mängu
        submitButton1.setText("Mäng 1");

        Button submitButton2 = new Button("Mäng 2");
        submitButton2.setText("Mäng 2");

        Button submitButton3 = new Button("Mäng 3");
        submitButton3.setText("Mäng 3");

        vbox.getChildren().addAll(pealkiri, submitButton1, submitButton2, submitButton3); //kuvab boxi asjadega


       /* Esimese mõistatuse numbrid
        1,1
        5
        5
        3
        1

        2, 4, 4, 4, 2
        */

        submitButton1.setOnAction((event) -> {
            showGame(0);
        });
        submitButton1.setOnAction((event) -> {
            showGame(1);
        });
        submitButton1.setOnAction((event) -> {
            showGame(2);
        });

    }

    private void showGame(int nr) {
        int pilt1 [][] =
                {{0,1,0,1,0},
                {1,1,1,0,1},
                {1,1,1,1,1},
                {0,1,1,1,0},
                {0,0,1,0,0}};

        /** see peaks olema mustade ja valgete ruutude
         * lahenduse skeem**/

   /** public int black = 1;

    public int white = 0;

    public int[][] row_rules =
            {{0,1,0,1,0},
            {1,1,1,1,1},
            {1,1,1,1,1},
            {0,1,1,1,0},
            {0,0,1,0,0}};

         }**/

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);

        grid.setGridLinesVisible(true);
        grid.setHgap(1);
        grid.setVgap(1);

        for (int i = 0; i < 8; i++) {                       //teeb 8x8 ruudustiku, millest 5x5 on mäng
            for (int j = 0; j < 8; j++) {
                Rectangle rectangle = new Rectangle(50, 50);
                rectangle.setFill(Color.BEIGE);
                grid.add(rectangle, i, j);
                //teeb 50x50 pikslit suured ruudud
            }}
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                Rectangle rectangle = new Rectangle(50, 50);
         /**Image pildike = new Image("Pilt/cat-150x150.jpg");
         grid.getChildren().add(new ImageView(pildike));}}**/
                rectangle.setFill(Color.DARKMAGENTA);
                grid.add(rectangle, i, j);
            }}

            for (int i =3; i < 8; i++){
                for (int j = 3; j < 8; j++)
                {Rectangle rectangle = new Rectangle(50, 50);
                    rectangle.setFill(Color.MAGENTA);               //algkuva on heleoranž
                rectangle.setOnMouseClicked ((event) -> {
                    if (event.getButton() == MouseButton.PRIMARY){  //vasak klikk teeb ruudu mustaks
                        rectangle.setFill(Color.BLACK);
                    }
                    else {
                        rectangle.setFill(Color.WHITE);             //parem klikk teeb ruudu valgeks
                    }
                    //kontrolliSeisu();

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
