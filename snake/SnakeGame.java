package snake;

import javax.swing.*;

public class SnakeGame extends JFrame {

    public SnakeGame() {

        Board drawBoard = new Board();
        Thread board = new Thread(drawBoard, "board");
        add(drawBoard);

        setTitle("Snake");
        setSize(800, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        board.start();
    }

    public static void main(String[] agrs) {

        SnakeGame game = new SnakeGame();
    }
}
