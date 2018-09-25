package snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Thread;

public class Game extends JPanel implements Runnable {

    private static Snake snake;
    private static Apple apple;
    private static boolean running;

    public Game() {

        setFocusable(true);
        snake = new Snake();
        apple = new Apple();
        addKeyListener(new KeyListen());
        running = true;

    }

    @Override
    public void run() {

        while (true) {

            System.out.print("");

            while (running) {

                snake.move();

                if (snake.hittingSelf() || snake.offEdge()) {

                    running = false;

                }

                if (snake.getLocation()[0] == apple.getLocation()[0] && snake.getLocation()[1] == apple.getLocation()[1]) {

                    snake.increaseSize();
                    apple.move();

                }

                repaint();

                try {

                    Thread.sleep(100);

                } catch (Exception e) {}
            }
        }

    }

    @Override
    public void paint(Graphics g) {

        g.clearRect(0, 0, 400, 435);
        makeGrid(g);
        apple.draw(g);
        snake.draw(g);

        if (!running) {

            g.drawString("Press R to restart", 150, 200);

        }

    }

    private void makeGrid(Graphics g) {

        for (int x = 0; x < 20; x++) {

            for (int y = 0; y < 20; y++) {

                g.drawRect(x * 20, y * 20, 20, 20);

            }

        }

    }

    private static void reset() {

        running = true;
        snake = new Snake();
        apple = new Apple();

    }

    public static Snake getSnake() {

        return snake;

    }

    public static boolean getRunning() {

        return running;

    }

    public static void setRunning() {

        reset();

    }

}

class KeyListen extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {

        int keycode = e.getKeyCode();
        Snake snake = Game.getSnake();

        switch (keycode) {

            case 'W':

                if (snake.getDir() != "down") {

                    snake.changeDirection("up");

                }

                break;

            case 'A':

                if (snake.getDir() != "right") {

                    snake.changeDirection("left");

                }

                break;

            case 'S':

                if (snake.getDir() != "up") {

                    snake.changeDirection("down");

                }

                break;

            case 'D':

                if (snake.getDir() != "left") {

                    snake.changeDirection("right");

                }

                break;

            case 'R':

                if (!Game.getRunning()) {

                    Game.setRunning();

                }

        }

    }

}
