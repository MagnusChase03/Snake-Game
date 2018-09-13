package snake;

import java.awt.*;
import java.util.ArrayList;

public class Apple {

    ArrayList<int[]> cord;

    public Apple() {

        cord = new ArrayList<int[]>();

        move();
    }

    public void move() {

        cord.add(0, new int[] {(int) Math.floor(Math.random() * 19 + 1), (int) Math.floor(Math.random() * 19 + 1)});

    }

    public void draw(Graphics g) {

        g.fillRect(cord.get(0)[0] * 20, cord.get(0)[1] * 20, 20, 20);

    }

    public int[] getLocation() {

        return cord.get(0);

    }

}
