package snake;

import java.awt.*;
import java.util.ArrayList;

public class Apple {

    ArrayList<int[]> cord = new ArrayList<int[]>();

    public Apple() {

        cord.add(new int[] {(int) Math.floor(Math.random() * 39 + 1), (int) Math.floor(Math.random() * 27 + 1)});
    }

    public void drawApple(Graphics g) {

        g.setColor(Color.RED);
        g.fillRect(cord.get(0)[0] * 20 + 3, cord.get(0)[1] * 20 + 3, 15, 15);
    }

    public void move() {

        cord.set(0, new int[] {(int) Math.floor(Math.random() * 39 + 1), (int) Math.floor(Math.random() * 27 + 1)});
    }
}
