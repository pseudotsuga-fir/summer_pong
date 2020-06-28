import processing.core.PApplet;

import java.util.ArrayList;

public class Ball {
    private int x;
    private int y;
    private double xVelocity;
    private double yVelocity;
    private int size;
    private PApplet p;

    public Ball(PApplet p){
        this.p = p;
        x = p.width/2;
        y = p.height/2;
        size = 30;
        xVelocity = 3;
        yVelocity = 3;
        initVel();
    }

    public void initVel(){
        x = p.width/2;
        y = p.height/2;
        if(p.random(1) >= 0.5){
            xVelocity *= -1;
        }
        if(p.random(1) >= 0.5){
            yVelocity *= -1;
        }
    }

    public void draw(){
        p.fill(255);
        p.strokeWeight(4);
        p.stroke(0);
        p.circle(x,y,size);
    }

    public void move(){
        x += xVelocity;
        y += yVelocity;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getxVelocity() {
        return xVelocity;
    }

    public void setxVelocity(double xVelocity) {
        this.xVelocity = xVelocity;
    }

    public double getyVelocity() {
        return yVelocity;
    }

    public void setyVelocity(double yVelocity) {
        this.yVelocity = yVelocity;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void reset(){
        yVelocity = 3;
        xVelocity = 3;
        initVel();
        draw();
        p.delay(500);
    }
}
