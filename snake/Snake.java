package snake;

import java.util.ArrayList;
import java.awt.*;

public class Snake {

    ArrayList<int[]> cords = new ArrayList<int[]>();
    String direction = "r";
    int size = 4;

    public Snake() {

        cords.add(0, new int[] {3, 10});
        cords.add(1, new int[] {2, 10});
        cords.add(2, new int[] {1, 10});
        cords.add(2, new int[] {0, 10});
    }

    public void drawSnake(Graphics g, Apple apple) {

        moveSnake(apple);

        g.setColor(Color.GREEN);
        for (int i = 0; i < cords.size(); i++) {
            g.fillRect(cords.get(i)[0] * 20 + 3, cords.get(i)[1] * 20 + 3, 15, 15);
        }
    }

    public void moveSnake(Apple apple) {
        int[] head = {cords.get(0)[0], cords.get(0)[1]};

        switch (direction) {
            case "u":
                cords.add(0, new int[] {head[0], head[1] - 1});
                break;
            case "l":
                cords.add(0, new int[] {head[0] - 1, head[1]});
                break;
            case "r":
                cords.add(0, new int[] {head[0] + 1, head[1]});
                break;
            case "d":
                cords.add(0, new int[] {head[0], head[1] + 1});
                break;
        }

        if (hitApple(apple)) {
            size+=1;
            apple.move();
        }

        if (cords.size() > size) {
            cords.remove(cords.size() - 1);
        }
    }

    public boolean hitApple(Apple apple) {

        if (cords.get(0)[0] == apple.cord.get(0)[0] && cords.get(0)[1] == apple.cord.get(0)[1]) {
            return true;
        } else {
            return false;
        }
    }
}
