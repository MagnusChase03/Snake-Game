package snake;

import java.util.ArrayList;
import java.awt.*;

public class Snake {

    private ArrayList<int[]> cords;
    private String direction;
    private int length;

    public Snake() {

        cords = new ArrayList<int[]>();
        direction = "right";
        length = 3;

        cords.add(0, new int[] {3, 9});
        cords.add(1, new int[] {2, 9});
        cords.add(2, new int[] {1, 9});

    }

    public void draw(Graphics g) {

        int[] cord;
        for (int i = 0; i < cords.size(); i++) {

            cord = cords.get(i);
            g.fillRect(cord[0] * 20, cord[1] * 20, 20, 20);

        }

    }

    public void move() {

        int[] head = cords.get(0);

        switch (direction) {

            case "up":
                cords.add(0, new int[] {head[0], head[1] - 1});
                break;

            case "left":
                cords.add(0, new int[] {head[0] - 1, head[1]});
                break;

            case "down":
                cords.add(0, new int[] {head[0], head[1] + 1});
                break;

            case "right":
                cords.add(0, new int[] {head[0] + 1, head[1]});
                break;

        }

        if (cords.size() > length) {
            cords.remove(cords.size() - 1);
        }

    }

    public boolean hittingSelf() {

        int[] head = cords.get(0);

        for (int i = 1; i < cords.size(); i++) {

            if (head[0] == cords.get(i)[0] && head[1] == cords.get(i)[1]) {

                return true;

            }

        }

        return false;

    }

    public boolean offEdge() {

        int[] head = cords.get(0);

        if (head[0] > 19 || head[0] < 0 || head[1] > 19 || head[1] < 0) {

            return true;

        }

        return false;

    }

    public void changeDirection(String dir) {

        direction = dir;

    }

    public String getDir() {

        return direction;

    }

    public int[] getLocation() {

        return cords.get(0);

    }

    public void increaseSize() {

        length++;

    }

}
