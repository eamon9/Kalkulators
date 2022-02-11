package Imanta_Paka;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class Calculator extends JFrame implements ActionListener, MouseListener {

    int countIndex= 0;

    Random random= new Random();
    int R= random.nextInt(255);
    int G= random.nextInt(255);
    int B= random.nextInt(255);

    Color yellowBtnColor= new Color(196, 129, 24);
    Color silverBtnColor= new Color(130, 136, 147);
    Color lightBlackBtnColor= new Color(49, 49, 51);
    Color yellowBtnPressed= new Color(194, 164, 118);
    Color silverBtnPressed= new Color(224, 224, 229);
    Color lightBlackBtnPressed= new Color(82, 82, 86);


    JTextField textField;
    JTextField signatureText;
    String[] sigantureArrey= new String[10];
    //sigantureArrey= new String[] {"B"+"y"+" "+"E"+"a"+"m"+"o"+"n"+"9"};

    MyButton[] functionButtons= new MyButton[9];
    MyButton[] numberButtons= new MyButton[10];
    MyButton BtnEqual, BtnPlus, BtnMinus, BtnMulti, BtnDivide;
    MyButton BtnComma, BtnC, BtnColorChanger, BtnPercent;
    MyButton Btn0, Btn1, Btn2, Btn3, Btn4, Btn5, Btn6, Btn7, Btn8, Btn9;
    double num1=0, num2=0, result=0;
    char operator;

    Calculator() {

        this.setSize(440, 800);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.BLACK);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        textField= new JTextField();
        textField.setEditable(false);
        textField.setBounds(30, 135, 380, 100);
        textField.setFont(new Font("Times New Roman", Font.BOLD, 80));
        textField.setForeground(Color.WHITE);
        textField.setBackground(Color.black);
        textField.setVisible(true);
        textField.setOpaque(true);

        signatureText= new JTextField();
        signatureText.setEditable(false);
        signatureText.setBounds(320, 745, 100, 20);
        signatureText.setFont(new Font("Times New Roman", Font.BOLD, 14));
        signatureText.setForeground(silverBtnColor);
        signatureText.setBackground(Color.black);
        signatureText.setVisible(true);
        signatureText.setOpaque(true);

        BtnComma= new MyButton(230, 665, ",", lightBlackBtnColor);
        BtnEqual= new MyButton(330, 665, "=", yellowBtnColor);
        BtnPlus= new MyButton(330, 565, "+", yellowBtnColor);
        BtnMinus= new MyButton(330, 465, "-", yellowBtnColor);
        BtnMulti= new MyButton(330, 365, "*", yellowBtnColor);
        BtnC= new MyButton(30, 265, "C", silverBtnColor);
        BtnColorChanger = new MyButton(130, 265, "^", silverBtnColor);
        BtnPercent= new MyButton(230, 265, "%", silverBtnColor);
        BtnDivide= new MyButton(330, 265, "/", yellowBtnColor);

        Btn0= new MyButton(30, 665, "0", lightBlackBtnColor);
        Btn0.setSize(180, 80);
        Btn1= new MyButton(30, 565, "1", lightBlackBtnColor);
        Btn2= new MyButton(130, 565, "2", lightBlackBtnColor);
        Btn3= new MyButton(230, 565, "3", lightBlackBtnColor);
        Btn4= new MyButton(30, 465, "4", lightBlackBtnColor);
        Btn5= new MyButton(130, 465, "5", lightBlackBtnColor);
        Btn6= new MyButton(230, 465, "6", lightBlackBtnColor);
        Btn7= new MyButton(30, 365, "7", lightBlackBtnColor);
        Btn8= new MyButton(130, 365, "8", lightBlackBtnColor);
        Btn9= new MyButton(230, 365, "9", lightBlackBtnColor);

        functionButtons[0]= BtnComma;
        functionButtons[1]= BtnEqual;
        functionButtons[2]= BtnPlus;
        functionButtons[3]= BtnMinus;
        functionButtons[4]= BtnMulti;
        functionButtons[5]= BtnC;
        functionButtons[6]= BtnColorChanger;
        functionButtons[7]= BtnPercent;
        functionButtons[8]= BtnDivide;

        numberButtons[0]= Btn0;
        numberButtons[1]= Btn1;
        numberButtons[2]= Btn2;
        numberButtons[3]= Btn3;
        numberButtons[4]= Btn4;
        numberButtons[5]= Btn5;
        numberButtons[6]= Btn6;
        numberButtons[7]= Btn7;
        numberButtons[8]= Btn8;
        numberButtons[9]= Btn9;

        for (int i = 0; i < functionButtons.length; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].addMouseListener(this);
        }

        for (int i = 0; i < numberButtons.length; i++) {
            numberButtons[i].addActionListener(this);
            numberButtons[i].addMouseListener(this);
        }

        sigantureArrey[0]= "";
        sigantureArrey[1]= "B";
        sigantureArrey[2]= "y ";
        sigantureArrey[3]= "E";
        sigantureArrey[4]= "a";
        sigantureArrey[5]= "m";
        sigantureArrey[6]= "o";
        sigantureArrey[7]= "n ";
        sigantureArrey[8]= "9";
        sigantureArrey[9]= "                      ";

        this.add(signatureText);
        this.add(textField);
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
        this.add(BtnColorChanger);
        this.add(BtnPercent);
        this.add(BtnDivide);

        this.setVisible(true);
    }
    //izveidojam metodi, kas pārbauda, vai Stringā ir vēl viens simbols '.'
    //šo metodi vēlāk izmantosim pie pogas ","
    private static boolean decimalCheck(String s) {
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '.') {
                return true;
            }
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MyButton[] yellowButtons= new MyButton[5];
        yellowButtons[0]= BtnPlus;
        yellowButtons[1]= BtnMinus;
        yellowButtons[2]= BtnMulti;
        yellowButtons[3]= BtnDivide;
        yellowButtons[4]= BtnEqual;

        Object source= e.getSource();

        for (int i = 0; i < yellowButtons.length; i++) {
            if(source == yellowButtons[i]) {
                yellowButtons[i].setBackground(Color.WHITE);
                yellowButtons[i].setForeground(yellowBtnColor);
            }
        }

        //zemāk esošais loop iet cauri arrey numberButtons un attiecīgi uzrāda kalkulātorā, kurš skaitlis nospiest un katru nākamo pievieno klāt
        for (int i = 0; i < numberButtons.length; i++) {
            if(source == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        // šeit izmantojam iepriekš izveidotu metodi, kas pārbauda vai Stringā jau ir simbols "."
        if(source == BtnComma) {
            if(decimalCheck(textField.getText())) {
                return;
            }
            textField.setText(textField.getText().concat("."));
        }

        if(source == BtnPlus) {
            num1= Double.parseDouble(textField.getText());
            operator= '+';
            textField.setText("");
        }
        if(source == BtnMinus) {
            num1= Double.parseDouble(textField.getText());
            operator= '-';
            textField.setText("");
        }
        if(source == BtnMulti) {
            num1= Double.parseDouble(textField.getText());
            operator= '*';
            textField.setText("");
        }
        if(source == BtnDivide) {
            num1= Double.parseDouble(textField.getText());
            operator= '/';
            textField.setText("");
        }

        if(source == BtnEqual) {
            num2= Double.parseDouble(textField.getText());

            switch (operator) {
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case '*' -> result = num1 * num2;
                case '/' -> result = num1 / num2;
            }
            textField.setText(String.valueOf(result));
            if(textField.getText().length() > 9) {
                textField.setText(String.valueOf(result).substring(0, 9));
            }
            num1= result;
        }

        if(source == BtnC) {
            result= 0;
            num1= 0;
            num2= 0;
            textField.setText("");
        }

        if(source == BtnColorChanger) {
            textField.setForeground(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
            System.out.println(random.nextInt(255)+" "+random.nextInt(255)+" "+random.nextInt(255));
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object source= e.getSource();

        if(source.equals(BtnC)) {
            countIndex++;
            System.out.println(sigantureArrey[countIndex]);
            signatureText.setText(signatureText.getText().concat(sigantureArrey[countIndex]));
            if(countIndex == 9) {
                countIndex= 0;
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Object source= e.getSource();

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Object source= e.getSource();

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        MyButton[] silverButtons= new MyButton[3];
        silverButtons[0]= BtnC;
        silverButtons[1]= BtnColorChanger;
        silverButtons[2]= BtnPercent;
        MyButton[] yellowButtons= new MyButton[5];
        yellowButtons[0]= BtnPlus;
        yellowButtons[1]= BtnMinus;
        yellowButtons[2]= BtnMulti;
        yellowButtons[3]= BtnDivide;
        yellowButtons[4]= BtnEqual;

        Object source= e.getSource();

        for (int i = 0; i < numberButtons.length; i++) {
            if(source == numberButtons[i]) {
                numberButtons[i].setBackground(lightBlackBtnPressed);
            }
        }

        for (int i = 0; i < silverButtons.length; i++) {
            if(source == silverButtons[i]) {
                silverButtons[i].setBackground(silverBtnPressed);
            }
        }
        if(source == BtnComma) {
            BtnComma.setBackground(lightBlackBtnPressed);
        }
        for (int i = 0; i < yellowButtons.length; i++) {
            if(source == yellowButtons[i]) {
                yellowButtons[i].setBackground(yellowBtnPressed);
            }
        }



    }

    @Override
    public void mouseExited(MouseEvent e) {
        MyButton[] silverButtons= new MyButton[3];
        silverButtons[0]= BtnC;
        silverButtons[1]= BtnColorChanger;
        silverButtons[2]= BtnPercent;
        MyButton[] yellowButtons= new MyButton[5];
        yellowButtons[0]= BtnPlus;
        yellowButtons[1]= BtnMinus;
        yellowButtons[2]= BtnMulti;
        yellowButtons[3]= BtnDivide;
        yellowButtons[4]= BtnEqual;

        Object source= e.getSource();

        for (int i = 0; i < numberButtons.length; i++) {
            if(source == numberButtons[i]) {
                numberButtons[i].setBackground(lightBlackBtnColor);
            }
        }

        for (int i = 0; i < silverButtons.length; i++) {
            if(source == silverButtons[i]) {
                silverButtons[i].setBackground(silverBtnColor);
            }
        }
        if(source == BtnComma) {
            BtnComma.setBackground(lightBlackBtnColor);
        }
        for (int i = 0; i < yellowButtons.length; i++) {
            if(source == yellowButtons[i]) {
                yellowButtons[i].setBackground(yellowBtnColor);
                yellowButtons[i].setForeground(Color.WHITE);
            }
        }
    }
}
