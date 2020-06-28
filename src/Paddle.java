import processing.core.PApplet;

public abstract class Paddle {
    protected int x;
    protected int y;
    protected final int HEIGHT = 150;
    protected final int WIDTH = 30;
    protected int top, bottom, left, right;
    protected double velocity;
    protected PApplet p;
    public float keyDown = 0;
    public float keyUp = 0;

    public Paddle(int x, PApplet p){
        this.x = x;
        this. p = p;
        y = p.height/2;
        top = y - HEIGHT/2;
        bottom = y + HEIGHT/2;
        left = x - WIDTH/2;
        right = x + WIDTH/2;
        velocity = -5;
    }

    public void draw(){
        p.fill(0);
        p.noStroke();
        p.rect(left, y-HEIGHT/2, WIDTH, HEIGHT);
        move();
    }

    public void move(){
        y += (keyUp - keyDown) * velocity;
        if(y - HEIGHT/2 < 0){
            y = 0 + HEIGHT/2;
        }
        if(y + HEIGHT/2 > p.height){
            y = p.height - HEIGHT/2;
        }

    }

    public void setVelocity(double velocity){
        this.velocity = velocity;
    }

    public int getY() {
        return y;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    public int getHEIGHT(){
        return HEIGHT;
    }
}
