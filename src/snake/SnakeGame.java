package snake;

import javax.swing.*;

public class SnakeGame extends JFrame {

    public SnakeGame() {

        Game board = new Game();
        Thread game = new Thread(board, "game");
        add(board);
        game.start();

        setTitle("Snake");
        setSize(400, 435);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public static void main(String[] args) {

        SnakeGame game = new SnakeGame();

    }

}
