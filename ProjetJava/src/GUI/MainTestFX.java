package GUI;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainTestFX extends Application {

    public static final String CURRENCY = "$";

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("MainUser.fxml"));
        primaryStage.setTitle("TuniGreen");
       
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        primaryStage.setResizable(true);
        
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();
        primaryStage.setMinWidth(width);
        primaryStage.setMinWidth(height);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
