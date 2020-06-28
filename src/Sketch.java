import processing.core.PApplet;

import java.util.ArrayList;

public class Sketch extends PApplet {
    ArrayList<Paddle> paddles;
    Paddle p1;
    Bot bot;
    Ball ball;

    public void settings(){
        size(900, 700);
    }

    public void setup(){
        p1 = new Player(width-50, this);
        bot = new Bot(50, this);
        ball = new Ball(this);
        paddles = new ArrayList<Paddle>();
        paddles.add(p1);
        paddles.add(bot);
    }

    public void draw(){
        background(255);
        p1.draw();
        bot.draw();
        ball.draw();
        ball.move();
        bot.move(ball);
        collisions();
    }

    public void keyPressed(){
        if(key == CODED){
            if(keyCode == UP) p1.keyUp = 1;
            else if(keyCode == DOWN) p1.keyDown = 1;
        }
    }

    public void keyReleased() {
        if(key == CODED){
            if(keyCode == UP) p1.keyUp = 0;
            else if (keyCode == DOWN) p1.keyDown = 0;
        }
    }

    public void collisions(){
        //Top
        if(ball.getY() - ball.getSize()/2 <= 0){
            ball.setY(ball.getSize()/2);
            ball.setyVelocity(ball.getyVelocity()*-1);
        }
        //Bottom
        else if(ball.getY() + ball.getSize()/2 >= height){
            ball.setY(height - ball.getSize()/2);
            ball.setyVelocity(ball.getyVelocity()*-1);
        }
        //Left
        if(ball.getX() - ball.getSize()/2 <= 0){
            ball.setX(ball.getSize()/2);
            ball.setxVelocity(ball.getxVelocity()*-1);
        }
        //Right
        else if(ball.getX() + ball.getSize()/2 >= width){
            ball.setX(width - ball.getSize()/2);
            ball.setxVelocity(ball.getxVelocity()*-1);
        }
        //Right Paddle Collisions
        if(ball.getX() + ball.getSize()/2 >= p1.getLeft()){
            if(ball.getY() <= p1.getY() + p1.getHEIGHT()/2 && ball.getY() >= p1.getY() - p1.getHEIGHT()/2){
                System.out.println("Ball xvelocity and yvelocity before hit: " + ball.getxVelocity() + " " + ball.getyVelocity());
                ball.setyVelocity(map(ball.getY(),p1.getY()-p1.getHEIGHT()/2,p1.getY()+p1.getHEIGHT()/2,-5,5));
                ball.setxVelocity((Math.sqrt(50-Math.abs(ball.getyVelocity()*ball.getyVelocity())))*-1);
                System.out.println("Ball xvelocity and yvelocity After hit: " + ball.getxVelocity() + " " + ball.getyVelocity());

            }
        }
        //Left Paddle Collisions
        if(ball.getX() - ball.getSize()/2 <= 60){
            if(ball.getY() <= bot.getY() + bot.getHEIGHT()/2 && ball.getY() >= bot.getY() - bot.getHEIGHT()/2){
                System.out.println("Ball xvelocity and yvelocity before hit: " + ball.getxVelocity() + " " + ball.getyVelocity());
                ball.setyVelocity(map(ball.getY(),bot.getY()-bot.getHEIGHT()/2,bot.getY()+bot.getHEIGHT()/2,-5,5));
                ball.setX(ball.getSize()/2 + bot.getRight());
                ball.setxVelocity(Math.sqrt(Math.abs(-50 - (ball.getyVelocity()*ball.getyVelocity()))));
                System.out.println("Ball xvelocity and yvelocity After hit: " + ball.getxVelocity() + " " + ball.getyVelocity());

            }
        }
    }
}