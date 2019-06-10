import javax.swing.*;
import java.awt.*;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        //Variables v = new Variables();
        Player player = new Player();
        Game game = new Game(player);

        long time = 0;
        long lastTime = 0;

        boolean alive = true;

        JFrame frame = new JFrame("Our Game");
        frame.add(game);
        frame.setSize(1000, 1000);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        while (alive = true) {
            time = System.nanoTime() / 1000000000;
            game.move();
            game.repaint();
            Thread.sleep(10);
            if(time > lastTime + 10){
                lastTime = time;
                int x;
                int y;
                int randomA = (int)(Math.random() * 4);
                int randomB = (int)(Math.random() * 1000);
                if(randomA == 0){
                    x = randomB;
                    y = 0;
                } else if(randomA == 1){
                    x = randomB;
                    y = 1000;
                } else if(randomA == 2){
                    x = 0;
                    y = randomB;
                } else{
                    x = 1000;
                    y = randomB;
                }
                    Zombie zombie = new Zombie(x, y);
                game.zombies[game.zombieCount] = zombie;
                game.zombieCount++;
            }
        }
    }
}