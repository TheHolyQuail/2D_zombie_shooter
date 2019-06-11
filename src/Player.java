import java.awt.event.*;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Player {
    int x = 250;
    int y = 600;
    int xa = 0;
    int ya = 0;
    int xaSTICKY = 0;
    int yaSTICKY = 0;
    int width = 50;
    int height = 50;
    boolean shooting = false;

    public Bullet[] bullets = new Bullet[100];
    public int bulletCount = 0;

    public Player() {
    }

    public void move() {
        if(x > 0 && xa < 0) {
            x = x + xa;
        }
        if(x < 950 && xa > 0) {
            x = x + xa;
        }
        if(y > 0 && ya < 0) {
            y = y + ya;
        }
        if(y < 950 && ya > 0) {
            y = y + ya;
        }
    }

    public void paint(Graphics2D g) {
        g.fillRect(x, y, width,height);
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            xa = -2;
            xaSTICKY = -2;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            xa = 2;
            xaSTICKY = 2;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            ya = -2;
            yaSTICKY = -2;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            ya = 2;
            yaSTICKY = 2;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if(!shooting){
                Bullet bullet = new Bullet(x, y, xa, ya);
                bullets[bulletCount] = bullet;
                bulletCount++;
                shooting = true;
            }
        }
    }
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            xa = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            xa = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            ya = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            ya = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            shooting = false;
        }
    }

    public Rectangle getRectangle(){
        return new Rectangle(x,y,width,height);
    }

}