import javax.swing.*;
import java.awt.*;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        //Variables v = new Variables();
        Player player = new Player();
        Game game = new Game(player);

        long lastTime = 0;
        long startTime = System.currentTimeMillis();
        long elapsedTime = System.currentTimeMillis() - startTime;
        long elapsedSeconds = elapsedTime / 1000;
        long time = elapsedSeconds % 60;

        boolean alive = true;

        JFrame frame = new JFrame("Zombie run");
        frame.add(game);
        frame.setSize(1000, 1000);
        //frame.setBackground(Color.darkGray);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        while (alive == true) {
            elapsedTime = System.currentTimeMillis() - startTime;
            elapsedSeconds = elapsedTime / 1000;
            time = elapsedSeconds % 60;
            game.move();
            game.repaint();
            Thread.sleep(10);
            if(time > lastTime + 4){
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
            if(!game.pAlive){
                alive = false;
                JOptionPane.showMessageDialog(null, "YOU DIED","Message", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}