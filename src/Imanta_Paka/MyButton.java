package Imanta_Paka;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class MyButton extends JButton {



    MyButton(int x, int y, String name,  Color color) {

        this.setBounds(x, y, 80, 80);
        this.setFont(new Font("Times New Roman", Font.BOLD, 30));
        this.setOpaque(true);
        this.setText(name);
        this.setBackground(color);
        this.setForeground(Color.WHITE);
        this.setFocusPainted(false);
        this.setBorderPainted(false);

    }
}
