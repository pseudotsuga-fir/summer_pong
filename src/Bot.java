import processing.core.PApplet;

public class Bot extends Paddle{
    private double botVelocity;

    public Bot(int x, PApplet p){
        super(x, p);
        botVelocity = -3;
    }

    public void move(Ball ball){
        if(y - HEIGHT/2 < 0){
            y = 0 + HEIGHT/2;
        }
        if(y + HEIGHT/2 > p.height){
            y = p.height - HEIGHT/2;
        }
        if(y + HEIGHT/2 - 50 >= ball.getY()){
            y += botVelocity;
        }
        else if(y - HEIGHT/2 + 50 <= ball.getY()){
            y -= botVelocity;
        }
    }
}
