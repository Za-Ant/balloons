package application;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
//import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Group root = new Group();
        Scene scene = new Scene(root,600, 800);
        stage.setTitle("Balloons");
        stage.setScene(scene);
        stage.show();

        BalloonsController bc = new BalloonsController(root, 9, 600, 800);

        Timeline t = new Timeline(new KeyFrame(Duration.seconds(1), actionEvent -> {
            bc.addBalloon();
        }));

        t.setCycleCount(Timeline.INDEFINITE);
        t.play();
    }

    public static void main(String[] args) {
        launch();
    }
}