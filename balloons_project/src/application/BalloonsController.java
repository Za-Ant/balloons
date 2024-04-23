package application;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.util.ArrayList;

public class BalloonsController {
    private ArrayList<Color> balloonsColors;
    private int counter = 0;
    private int screenSizeX;
    private int screenSizeY;
    private int maxBaloonSpeed = 2;
    private int maxRadius = 200;
    private int minRadius = 100;
    private Group group;
    BalloonsController(Group group, int color_count, int screenSizeX, int screenSizeY) {
        this.group = group;
        this.screenSizeX = screenSizeX;
        this.screenSizeY = screenSizeY;
        balloonsColors = new ArrayList<>();

        for (int i = 0; i < color_count; ++i) {
            balloonsColors.add(Color.rgb(
                    (int)(Math.random() * 128) + 128,
                    (int)(Math.random() * 128) + 128,
                    (int)(Math.random() * 128) + 128
            ));
        }
    }

    public void addBalloon() {
        Balloon b = new Balloon(
                (int)(Math.random() * this.screenSizeX),
                this.screenSizeY,
                (int)(Math.random() * maxBaloonSpeed) + 1,
                (int)(Math.random() * (maxRadius - minRadius) + minRadius),
                this.balloonsColors.get((counter++) % balloonsColors.size())
        );
        b.draw();

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20), event -> {
            if (b.isEnd()) {
                group.getChildren().remove(b);
            }
            b.move();
        }));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        b.setOnMouseClicked(event -> {
            group.getChildren().remove(b);
        });

        group.getChildren().add(b);
    }
}
