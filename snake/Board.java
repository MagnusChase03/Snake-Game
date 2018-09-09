package snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Thread;

public class Board extends JPanel implements Runnable {

    public static Snake snake;
    public static Apple apple;
    public boolean running = true;
    public int score = 0;

    @Override
    public void run() {

        while (running) {
            repaint();
            try {Thread.sleep(100);} catch (Exception e) {}
        }
    }

    public Board() {

        setFocusable(true);

        snake = new Snake();
        apple = new Apple();

        addKeyListener(new KeyListen());
    }

    @Override
    public void paint(Graphics g) {

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 800, 600);

        drawScore(g);

        apple.drawApple(g);
        snake.drawSnake(g, apple, this);
    }

    public void drawScore(Graphics g) {

        g.setColor(Color.WHITE);
        g.setFont(new Font("Times New Roman", Font.BOLD, 24));
        g.drawString("Score: " + score, 40, 40);
    }
}

class KeyListen extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {
        int keycode = e.getKeyCode();

        switch (keycode) {
            case 'W':
                Board.snake.direction = "u";
                break;
            case 'A':
                Board.snake.direction = "l";
                break;
            case 'D':
                Board.snake.direction = "r";
                break;
            case 'S':
                Board.snake.direction = "d";
                break;
        }
    }
}
