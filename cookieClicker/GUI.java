package cookieClicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JPanel {

    private int money = 0;
    private int moneyEarn = 1;
    private int upgradeCost = 100;
    private String[] titles = {"Rookie", "Apprentice", "Novice", "Journeyman", "Master", "god"};
    private Color[] colors = {new Color(255, 255, 255), new Color(0, 160, 190), new Color(0, 0, 190), new Color(160, 0, 190), new Color(0, 160, 0), new Color(90, 0, 0)};
    private int rank = 0;
    private int goal = 200;

    public GUI() {

        setBackground(colors[0]);
        setLayout(null);

        JLabel titleText = new JLabel("Title: " + titles[rank]);
        titleText.setBounds(150, 0, 300, 25);
        add(titleText);

        JLabel moneyText = new JLabel("$" + money);
        moneyText.setBounds(150, 30, 100, 25);
        moneyText.setForeground(new Color(0, 100, 0));
        add(moneyText);

        JButton cookie = new JButton("Cookies!");
        cookie.setBounds(100, 70, 200, 200);
        cookie.setContentAreaFilled(false);
        cookie.setOpaque(false);
        cookie.setFocusPainted(false);
        cookie.setBorderPainted(false);
        cookie.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getModifiers() == 16) {
                    money += moneyEarn;
                    moneyText.setText("$" + money);
                    if (money >= goal && rank < 5) {
                        rank++;
                        setBackground(colors[rank]);
                        cookie.setBackground(colors[rank]);
                        titleText.setText("Title: " + titles[rank]);
                        goal *= 2;
                    }
                }
            }
        });
        add(cookie);

        JButton upgrade = new JButton("Upgrade! $" + upgradeCost);
        upgrade.setBounds(100, 280, 200, 50);
        upgrade.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getModifiers() == 16) {
                    if (money >= upgradeCost) {
                        money -= upgradeCost;
                        moneyText.setText("$" + money);
                        moneyEarn += 1;
                        upgradeCost *= 2;
                        upgrade.setText("Upgrade! $" + upgradeCost);
                    }
                }
            }
        });
        add(upgrade);
    }

    @Override
    public void paintComponent(Graphics g) {

        g.setColor(colors[rank]);
        g.fillRect(0, 0, 500, 500);
        g.setColor(new Color(100, 50, 0));
        g.fillOval(100, 70, 200, 200);
    }
}
