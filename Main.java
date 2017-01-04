import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Popup;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.w3c.dom.css.Rect;

import java.util.ArrayList;
import java.util.List;


public class Main extends Application {

    public static int PICTURE_SIZE = 5;  //see on konstant, tahan, et kõik saaksid seda kasutada
    public static int BLACK_TILE = 1;

    public static int Y_OFFSET = 3;
    public static int X_OFFSET = 3;

    public static GridPane grid = new GridPane();

    private int eeskuju [][] =
                    {{0,1,0,1,1},
                    {1,1,1,1,1},
                    {1,1,1,1,1},
                    {0,1,1,1,0},
                    {0,0,1,0,0}};

    private int activePicture[][]=
                    {{0,1,0,1,1},
                    {1,1,1,1,1},
                    {1,1,1,1,1},
                    {0,1,1,1,0},
                    {0,0,1,0,0}};

    private int syda [][]=
            {{0,1,0,1,0},
                    {1,1,1,1,1},
                    {1,1,1,1,1},
                    {0,1,1,1,0},
                    {0,0,1,0,0}};

    private int kass [][] =
                    {{1,0,0,0,1},
                    {1,1,1,1,1},
                    {1,0,1,0,1},
                    {1,1,1,1,1},
                    {0,1,1,1,0}};

    private int male [][] =
                     {{0,1,0,1,0},
                    {1,0,1,0,1},
                    {0,1,0,1,0},
                    {1,0,1,0,1},
                    {0,1,0,1,0}};

    private int maja [][]=
                  {{0,0,1,0,0},
                    {0,1,1,1,0},
                    {1,1,1,1,1},
                    {0,1,0,1,0},
                    {0,1,1,1,0}};

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

        Button submitButton4 = new Button("Mäng 4");
        submitButton4.setText("Mäng 4");

        Button submitButton5 = new Button("Mäng 5");
        submitButton5.setText("Mäng 5");



        vbox.getChildren().addAll(pealkiri, submitButton1, submitButton2, submitButton3, submitButton4); //kuvab boxi asjadega

        submitButton1.setOnAction((event) -> {
            setExample(syda);
            showGame(0);
        });
        submitButton2.setOnAction((event) -> {
            setExample(kass);
            showGame(1);
        });
        submitButton3.setOnAction((event) -> {
            setExample(male);
            showGame(2);
        });

        submitButton4.setOnAction((event) -> {
            setExample(maja);
            showGame(3);
        });

    }

    private void setExample(int[][] picture){
        for (int i = 0; i < PICTURE_SIZE; i++) {
            for (int j = 0; j < 5; j++) {
                eeskuju [i][j] = picture [i][j];       //teeb kõik nulliks
            }
        }
    }

    private void showGame(int nr) {

        grid.setAlignment(Pos.CENTER);

        grid.setGridLinesVisible(true);
        grid.setHgap(1);
        grid.setVgap(1);

        for (int i = 0; i < PICTURE_SIZE; i++) {
            for (int j = 0; j < 5; j++) {
                activePicture [i][j]=0;       //teeb kõik nulliks
            }
        }

        for (int i = 0; i < 8; i++) {                       //teeb 8x8 ruudustiku, millest 5x5 on mäng
            for (int j = 0; j < 8; j++) {
                Rectangle rectangle = new Rectangle(50, 50);
                rectangle.setFill(Color.BEIGE);
                grid.add(rectangle, i, j);          //teeb 50x50 pikslit suured ruudud

            }}
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                Rectangle rectangle = new Rectangle(50, 50);
                rectangle.setFill(Color.DARKGREY);
                grid.add(rectangle, i, j);
            }
        }

        this.setNumbers(eeskuju,grid);
            for (int i = 3; i < 8; i++){
                for (int j = 3; j < 8; j++)
                {Rectangle rectangle = new Rectangle(50, 50);
                    rectangle.setFill(Color.MAGENTA);               //algkuva on roosa
                rectangle.setOnMouseClicked ((event) -> {
                    if (event.getButton() == MouseButton.PRIMARY){  //vasak klikk teeb ruudu mustaks
                        rectangle.setFill(Color.BLACK);
                        activePicture [(int)rectangle.getX() - X_OFFSET][(int)rectangle.getY() - Y_OFFSET] = 1;
                    }
                    else {
                        rectangle.setFill(Color.WHITE);             //parem klikk teeb ruudu valgeks
                        activePicture [(int)rectangle.getX() - X_OFFSET][(int)rectangle.getY() - Y_OFFSET] = 0;

                    }
                    System.out.println("clicked " + rectangle.getY() + " " +rectangle.getX());

                    checkState();

                    System.out.println(event.getButton());
                } );
                    rectangle.setX(j);
                    rectangle.setY(i);
                grid.add(rectangle, i, j);
            }
        }

        Scene mõistatus = new Scene(grid, 450, 550);

        Stage stage2 = new Stage();
        stage2.setScene(mõistatus);
        stage2.setTitle("Uus mäng");
        stage2.show();

    }

    private void setNumbers(int[][] picture,GridPane grid){
        int i,j,k,tempNr=0,placement = 2;

        List<Integer> numbers = new ArrayList<>();      //paneb klikitud numbrid arraylisti, et neid hiljem võrrelda algsega

        for(i=0; i<this.PICTURE_SIZE; i++){
            numbers.clear();
            for(j=0; j<this.PICTURE_SIZE; j++){
                if(picture[i][j] == this.BLACK_TILE){
                    tempNr++;
                }else{
                    if(tempNr !=0 ) {
                        numbers.add(tempNr);
                        tempNr = 0;
                    }
                }
            }
            if(tempNr !=0 ) {
                numbers.add(tempNr);
                tempNr = 0;
            }
            placement = 2;                              //et lisaks numbrid kõige äärde, mänguväljale kõige lähemale
            for(k =numbers.size()-1; k>=0; k--){
                Text text = new Text(numbers.get(k).toString());
                text.setFont(Font.font(null, FontWeight.BOLD, 36)); //näitab, kui suured on kuvatavad numbrid
                grid.add(text,placement,i+this.Y_OFFSET);
                placement--;
            }
        }

        for(j=0; j<this.PICTURE_SIZE; j++){
            numbers.clear();
            for(i=0; i<this.PICTURE_SIZE; i++){
                if(picture[i][j] == this.BLACK_TILE){
                    tempNr++;
                }else{
                    if(tempNr !=0 ) {
                        numbers.add(tempNr);
                        tempNr = 0;
                    }
                }
            }
            if(tempNr !=0 ) {
                numbers.add(tempNr);
                tempNr = 0;
            }
            placement = 2;
            for(k =numbers.size()-1; k>=0; k--){
                Text text = new Text(numbers.get(k).toString());
                text.setFont(Font.font(null, FontWeight.BOLD, 36));
                grid.add(text,j+this.X_OFFSET,placement);
                placement--;
            }
        }
    }

    private boolean checkState(){
        int i,j;
        System.out.println(this.printPicture(eeskuju));
        System.out.println(this.printPicture(activePicture));
        for (i=0; i<PICTURE_SIZE; i++){
            for (j=0; j<PICTURE_SIZE; j++){
                if (activePicture[i][j] != eeskuju [i][j]) {

                    System.out.println("poolik");
                    return false;
                }
            }
        }

        System.out.println("õige");

        VBox vbox = new VBox();             //õige lahenduse korral tuleb nupp ÕIGE, mille saab kinni vajutada
        vbox.setSpacing(2);
        vbox.setAlignment(Pos.CENTER);
        Stage stage3 = new Stage();
        Scene lahendus = new Scene(vbox, 100, 100);
        stage3.setScene(lahendus);
        stage3.show();

        Button closebutton = new Button("Tubli!");
        Label pealkiri2 = new Label("Õige lahendus");
        vbox.getChildren().addAll(pealkiri2, closebutton);

        closebutton.setOnAction((event) -> {
            stage3.close();
            });

        return true;
        

    }
    private String printPicture(int[][] picture){
        String result = "";
        int i,j;
        for (i=0; i< PICTURE_SIZE; i++){
            for (j=0; j<PICTURE_SIZE; j++){
                result += picture[i][j] + " ";
            }
            result += "\n";
        }
        return result;
    }

}


