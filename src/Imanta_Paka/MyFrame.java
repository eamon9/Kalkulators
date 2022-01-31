package Imanta_Paka;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {

    Color yellowBtnColor= new Color(196, 129, 24);
    Color silverBtnColor= new Color(130, 136, 147);
    Color lightBlackBtnColor= new Color(49, 49, 51);

    MyButton Btn0= new MyButton(30, 665, "0", lightBlackBtnColor);
    MyButton BtnComma= new MyButton(230, 665, ",", lightBlackBtnColor);
    MyButton BtnEqual= new MyButton(330, 665, "=", yellowBtnColor);

    MyButton Btn1= new MyButton(30, 565, "1", lightBlackBtnColor);
    MyButton Btn2= new MyButton(130, 565, "2", lightBlackBtnColor);
    MyButton Btn3= new MyButton(230, 565, "3", lightBlackBtnColor);
    MyButton BtnPlus= new MyButton(330, 565, "+", yellowBtnColor);

    MyButton Btn4= new MyButton(30, 465, "4", lightBlackBtnColor);
    MyButton Btn5= new MyButton(130, 465, "5", lightBlackBtnColor);
    MyButton Btn6= new MyButton(230, 465, "6", lightBlackBtnColor);
    MyButton BtnMinus= new MyButton(330, 465, "-", yellowBtnColor);

    MyButton Btn7= new MyButton(30, 365, "7", lightBlackBtnColor);
    MyButton Btn8= new MyButton(130, 365, "8", lightBlackBtnColor);
    MyButton Btn9= new MyButton(230, 365, "9", lightBlackBtnColor);
    MyButton BtnMulti= new MyButton(330, 365, "*", yellowBtnColor);

    MyButton BtnC= new MyButton(30, 265, "C", silverBtnColor);
    MyButton BtnPlussMinus= new MyButton(130, 265, "^", silverBtnColor);
    MyButton BtnPercent= new MyButton(230, 265, "%", silverBtnColor);
    MyButton BtnDivide= new MyButton(330, 265, "/", yellowBtnColor);

    JLabel resultscreen= new JLabel();

    String result= "";
    int firstNum;
    int secondNum;


    MyFrame() {
        this.setSize(440, 800);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.BLACK);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        resultscreen.setBounds(30, 30, 380, 205);
        resultscreen.setText(result);
        resultscreen.setLayout(new BorderLayout());
        //resultscreen.setHorizontalTextPosition(JLabel.RIGHT);
        resultscreen.setVerticalTextPosition(JLabel.CENTER);
        resultscreen.setFont(new Font("Times New Roman", Font.BOLD, 60));
        resultscreen.setForeground(Color.WHITE);
        resultscreen.setBackground(Color.lightGray);
        resultscreen.setVisible(true);
        resultscreen.setOpaque(true);

        Btn0.setSize(180, 80);
        Btn0.addActionListener(this);
        BtnComma.addActionListener(this);
        BtnEqual.addActionListener(this);
        Btn1.addActionListener(this);
        Btn2.addActionListener(this);
        Btn3.addActionListener(this);
        BtnPlus.addActionListener(this);
        Btn4.addActionListener(this);
        Btn5.addActionListener(this);
        Btn6.addActionListener(this);
        BtnMinus.addActionListener(this);
        Btn7.addActionListener(this);
        Btn8.addActionListener(this);
        Btn9.addActionListener(this);
        BtnMulti.addActionListener(this);
        BtnC.addActionListener(this);
        BtnPlussMinus.addActionListener(this);
        BtnPercent.addActionListener(this);
        BtnDivide.addActionListener(this);

        this.add(resultscreen);
        this.add(Btn0);
        this.add(BtnComma);
        this.add(BtnEqual);
        this.add(Btn1);
        this.add(Btn2);
        this.add(Btn3);
        this.add(BtnPlus);
        this.add(Btn4);
        this.add(Btn5);
        this.add(Btn6);
        this.add(BtnMinus);
        this.add(Btn7);
        this.add(Btn8);
        this.add(Btn9);
        this.add(BtnMulti);
        this.add(BtnC);
        this.add(BtnPlussMinus);
        this.add(BtnPercent);
        this.add(BtnDivide);



        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source= e.getSource();
        if(source.equals(Btn1)) {
            result+= "1";
            resultscreen.setText(result);
        }
        if(source.equals(Btn0)) {
            result+= "0";
            resultscreen.setText(result);
        }
        if(source.equals(BtnC)) {
            result= "";
            resultscreen.setText(result);
        }
        if(source.equals(BtnPlus)) {
            //result+= "1";
            firstNum= Integer.parseInt(result);
            result= "";
            resultscreen.setText(result);
        }
        if(source.equals(BtnEqual)) {
            secondNum= firstNum+Integer.parseInt(result);
            result= ""+secondNum;
            resultscreen.setText(result);
        }
    }
}
