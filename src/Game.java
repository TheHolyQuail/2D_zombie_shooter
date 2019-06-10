import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game extends JPanel{
    public static Player ourplayer;
    public Zombie[] zombies = new Zombie[100];
    public int zombieCount = 0;

    public Game(Player player) {
        ourplayer = player;

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
                ourplayer.keyReleased(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                ourplayer.keyPressed(e);
            }
        });
        setFocusable(true);
    }
    public void move(){
        ourplayer.move();
        for(int i = 0; i < ourplayer.bullets.length;i++){
            if(ourplayer.bullets[i] != null){
                if(!ourplayer.bullets[i].stillIn()) {
                    ourplayer.bullets[i].move();
                } else{
                    ourplayer.bullets[i] = ourplayer.bullets[ourplayer.bulletCount - 1];
                    ourplayer.bullets[ourplayer.bulletCount - 1] = null;
                    ourplayer.bulletCount--;
                }
            }
        }
        for(int i = 0; i < zombies.length;i++){
            if(zombies[i] != null) {
                zombies[i].move(ourplayer.x, ourplayer.y);
            }
        }
    }
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.BLACK);

        ourplayer.paint(g2d);
        for(int i = 0; i < ourplayer.bullets.length;i++){
            if(ourplayer.bullets[i] != null) {
                ourplayer.bullets[i].paint(g2d);
            }
        }
        for(int i = 0; i < zombies.length;i++){
            if(zombies[i] != null) {
                zombies[i].paint(g2d);
            }
        }
    }
}