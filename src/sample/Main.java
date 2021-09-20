package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    public static int moveCount = 0;
    public static boolean takedGold = false;
    public static int goldCount = 0;
    public static int summaryGoldCount = 0;


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Octopus game");
        primaryStage.setScene(new Scene(root, Color.FIREBRICK));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);

    }

}
