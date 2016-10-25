import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by Marilyn on 25.10.2016.
 */
public class Main extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {

        VBox vbox = new VBox();
        Scene login = new Scene(vbox, 200, 100);
        primaryStage.setScene(login);
        primaryStage.show();

        Label pealkiri = new Label("Mis on parool?");
        TextField paroolField = new TextField();
        Button submitButton = new Button("Login");

        vbox.getChildren().addAll(pealkiri, paroolField, submitButton);

        Circle ring = new Circle(150);
        Pane pane = new Pane();
        ring.setCenterX(175);
        ring.setCenterY(200);
        pane.getChildren().add(ring);
        Scene seesStseen = new Scene(pane, 350, 350);

        submitButton.setOnAction(event -> {
            String parool = paroolField.getText();
            if (parool.equals("pass")){
                System.out.println("õige!");
                primaryStage.setScene(seesStseen);
            } else {
                System.out.println("proovi uuesti!");
            }

        });




        /*Pane pane = new Pane();
        Scene scene = new Scene(pane, 350, 350);
        primaryStage.setScene(scene);

        primaryStage.show();

        /*System.out.println("Tere tulemast mängu!");*/

        /*GridPane grid = new GridPane();
        grid.add(rect, 1, 5);
        grid.setGridLinesVisible(true);
        stack.getChildren().add(grid);*/


        /*Circle ring = new Circle(100);
        ring.setCenterX(175);
        ring.setCenterY(200);
        pane.getChildren().add(ring);

        ring.setOnMouseClicked(event -> {
            System.out.println("KLIKK");
            ring.setCenterY(175);

        });*/
    }

}
