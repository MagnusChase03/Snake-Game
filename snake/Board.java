package snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Thread;

public class Board extends JPanel implements Runnable {

    public static Snake snake;
    public static Apple apple;

    @Override
    public void run() {

        while (true) {
            repaint();
            try {Thread.sleep(200);} catch (Exception e) {}
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

        makeGrid(g);
        snake.drawSnake(g, apple);
        apple.drawApple(g);
    }

    private void makeGrid(Graphics g) {

        g.setColor(Color.WHITE);
        for (int x = 0; x < 800; x+=20) {
            for (int y = 0; y < 560; y+=20) {
                g.drawRect(x, y, 20, 20);
            }
        }
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
