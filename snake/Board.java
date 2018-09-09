package snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Thread;

public class Board extends JPanel implements Runnable {

    public static Snake snake;
    public static Apple apple;
    public boolean running = true;

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

        snake.drawSnake(g, apple, this);
        apple.drawApple(g);
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
