package cookieClicker;

import javax.swing.*;

public class CookieClicker extends JFrame {

    public CookieClicker() {

        GUI gui = new GUI();
        add(gui);

        setTitle("Cookie Clicker");
        setSize(400, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {

        CookieClicker game = new CookieClicker();
    }
}
