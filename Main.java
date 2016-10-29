import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Jaapani mõistatus");
        primaryStage.show();


        VBox vbox = new VBox();
        Scene login = new Scene(vbox, 300, 250);
        primaryStage.setScene(login);
        primaryStage.show();

        Label pealkiri = new Label("Jaapani mõistatus");
        Button submitButton = new Button("Alusta!");
        Pane pane = new Pane();
        pane.getChildren().add(pealkiri);
        pealkiri.setTranslateX(100);
        pealkiri.setTranslateY(75);
        pane.getChildren().add(submitButton);
        submitButton.setTranslateX(100);
        submitButton.setTranslateY(100);


        vbox.getChildren().addAll(pealkiri, submitButton);

        submitButton.setText("Alusta mängu");

        StackPane stack = new StackPane();
        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);
        Scene mõistatus = new Scene(stack, 450, 550);


        submitButton.setOnAction((event) -> {
            primaryStage.setScene(mõistatus);


        });
    }
}