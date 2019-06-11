import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game extends JPanel{
    public static Player ourplayer;
    public Zombie[] zombies = new Zombie[50];
    public int zombieCount = 0;

    public boolean pAlive = true;

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
                    for(int ii = 0; ii < zombies.length;ii++){
                        boolean yTrue = false;
                        boolean xTrue = false;
                        if(zombies[i].y - ourplayer.bullets[i].y > - 30 && zombies[i].y - ourplayer.bullets[i].y < 3){
                            yTrue = true;
                        }
                        if(zombies[i].x - ourplayer.bullets[i].x > - 30 && zombies[i].x - ourplayer.bullets[i].x < 3){
                            xTrue = true;
                        }
                        if(yTrue && xTrue) {
                            zombies[i] = zombies[zombieCount - 1];
                            zombies[zombieCount - 1] = null;
                            zombieCount--;
                        }
                    }
                } else{
                    ourplayer.bullets[i] = ourplayer.bullets[ourplayer.bulletCount - 1];
                    ourplayer.bullets[ourplayer.bulletCount - 1] = null;
                    ourplayer.bulletCount--;
                }
            }
        }
        for(int i = 0; i < zombies.length;i++){
            if(zombies[i] != null) {
                int x;// = (zombies[i].x - ourplayer.x / 8);
                int y;// = (zombies[i].y - ourplayer.y / 9);

                if(zombies[i].x - ourplayer.x > 0){
                    x = -1;
                }else if(zombies[i].x - ourplayer.x < 0){
                    x = 1;
                }else{
                    x = 0;
                }

                if(zombies[i].y - ourplayer.y > 0){
                    y = -1;
                }else if(zombies[i].y - ourplayer.y < 0){
                    y = 1;
                }else{
                    y = 0;
                }

                //collision sensing
                boolean yTrue = false;
                boolean xTrue = false;
                if(zombies[i].y - ourplayer.y > - 50 && zombies[i].y - ourplayer.y < 5){
                    yTrue = true;
                }
                if(zombies[i].x - ourplayer.x > - 50 && zombies[i].x - ourplayer.x < 5){
                    xTrue = true;
                }
                if(yTrue && xTrue){
                    pAlive = false;
                }

                zombies[i].move(x, y);
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