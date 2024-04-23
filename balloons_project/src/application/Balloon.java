package application;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineJoin;

public class Balloon extends Canvas {
    private Color color;
    private int x;
    private int y;
    private int speed;
    private GraphicsContext gc;
    private int radius;
    public Balloon(int x, int y, int speed, int radius, Color color) {
        super(radius, radius);
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.color = color;

        gc = getGraphicsContext2D();
        setTranslateX(x);
        setTranslateY(y);
    }

    public void draw() {
        gc.setLineWidth(1.5);
        gc.setLineJoin(StrokeLineJoin.ROUND);
        gc.setFill(color);
        gc.setStroke(Color.BLACK);
        gc.strokeOval(2, 2, radius-6, radius-6);
//        gc.strokeOval(x - radius, y - radius, radius, radius);
        gc.fillOval(2, 2, radius-6, radius-6);
    }

    public boolean isEnd() {
        return getTranslateY() <= 0;
    }

    public void move() {
        setTranslateY(getTranslateY() - speed);
    }
}
