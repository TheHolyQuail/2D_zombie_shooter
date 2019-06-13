import java.awt.*;

public class Zombie {
    int x = 250;
    int y = 600;
    int width = 40;
    int height = 40;

    public Zombie(int posX, int posY) {
        x = posX;
        y = posY;
    }

    public void move(int xa, int ya) {
        x = x + xa;
        y = y + ya;
    }

    public void paint(Graphics2D g) {
        g.setColor(Color.red);
        g.fillRect(x, y, width,height);
    }

    public Rectangle getRectangle(){
        return new Rectangle(x,y,width,height);
    }

}
