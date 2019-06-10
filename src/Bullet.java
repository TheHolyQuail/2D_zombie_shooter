import java.awt.*;

public class Bullet {
    int ox = 250;
    int oy = 600;
    int x = 250;
    int y = 600;
    int xa = 0;
    int ya = 0;
    int width = 10;
    int height = 10;

    public Bullet(int posX, int posY, int directionX, int DirectionY) {
        xa = directionX;
        ya = DirectionY;
        x = posX;
        y = posY;
        ox = posX;
        oy = posY;
    }

    public void move() {
        x = x + xa;
        y = y + ya;
    }

    public boolean stillIn() {
        if(x > 1000 || x < - 1000 || y > 10000 || y < 1000){
            return false;
        } else{
            return true;
        }
    }

    public void paint(Graphics2D g) {
        g.fillRect(x, y, width,height);
    }

    public Rectangle getRectangle(){
        return new Rectangle(x,y,width,height);
    }

}