import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorGUI extends JFrame {
    private JTextField resultBar;
    private JButton prev;
    private JButton next;
    private JButton add;
    private JButton sub;
    private JButton mul;
    private JButton div;
    private JButton equals;
    private JButton k0;
    private JButton k1;
    private JButton k2;
    private JButton k3;
    private JButton k4;
    private JButton k7;
    private JButton k5;
    private JButton k6;
    private JButton k8;
    private JButton k9;
    private JButton clean;
    private JButton fullClean;
    String numberText = "";
    char lastOp = '+';

    //numbers for calculation
    int num=0;

    public CalculatorGUI(String title) {
        super(title);
        setComponents();
        this.setBounds(300,100,650,350);
        this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void setComponents() {
        //construct components
        resultBar = new JTextField (5);
        prev = new JButton ("<");
        next = new JButton (">");
        add = new JButton ("+");
        sub = new JButton ("-");
        mul = new JButton ("x");
        div = new JButton ("%");
        equals = new JButton("=");
        k0 = new JButton ("0");
        k1 = new JButton ("1");
        k2 = new JButton ("2");
        k3 = new JButton ("3");
        k4 = new JButton ("4");
        k7 = new JButton ("7");
        k5 = new JButton ("5");
        k6 = new JButton ("6");
        k8 = new JButton ("8");
        k9 = new JButton ("9");
        clean = new JButton ("C");
        fullClean = new JButton ("AC");

        //adjust size and set layout
        setPreferredSize (new Dimension (624, 329));
        setLayout (null);

        //add components
        add (resultBar);
        add (prev);
        add (next);
        add (add);
        add (sub);
        add (mul);
        add (div);
        add (equals);
        add (k0);
        add (k1);
        add (k2);
        add (k3);
        add (k4);
        add (k5);
        add (k6);
        add (k7);
        add (k8);
        add (k9);
        add (clean);
        add (fullClean);

        //set component bounds (only needed by Absolute Positioning)
        resultBar.setBounds (30, 25, 565, 40);
        prev.setBounds (25, 90, 45, 35);
        next.setBounds (75, 90, 45, 35);
        add.setBounds (50, 265, 45, 40);
        add.addActionListener(new Handler());
        sub.setBounds (50, 220, 45, 40);
        sub.addActionListener(new Handler());
        mul.setBounds (50, 175, 45, 40);
        mul.addActionListener(new Handler());
        div.setBounds (50, 130, 45, 40);
        div.addActionListener(new Handler());
        equals.setBounds(200, 150, 45, 40);
        equals.addActionListener(new Handler());
        k0.setBounds (405, 260, 45, 40);
        k0.addActionListener(new Handler());
        k1.setBounds (350, 215, 45, 40);
        k1.addActionListener(new Handler());
        k2.setBounds (405, 215, 45, 40);
        k2.addActionListener(new Handler());
        k3.setBounds (460, 215, 45, 40);
        k3.addActionListener(new Handler());
        k4.setBounds (350, 165, 45, 40);
        k4.addActionListener(new Handler());
        k7.setBounds (350, 115, 45, 40);
        k7.addActionListener(new Handler());
        k5.setBounds (405, 165, 45, 40);
        k5.addActionListener(new Handler());
        k6.setBounds (460, 165, 45, 40);
        k6.addActionListener(new Handler());
        k8.setBounds (410, 115, 45, 40);
        k8.addActionListener(new Handler());
        k9.setBounds (460, 115, 45, 40);
        k9.addActionListener(new Handler());
        clean.setBounds (545, 130, 55, 45);
        clean.addActionListener(new Handler());
        fullClean.setBounds (545, 190, 55, 45);
        fullClean.addActionListener(new Handler());
        resultBar.setEditable(false);
    }


    class Handler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //number button actions
            if (e.getSource() == k0) {
                numberText += "0";
                resultBar.setText(numberText);
            }
            else if (e.getSource() == k1) {
                numberText += "1";
                resultBar.setText(numberText);
            }
            else if (e.getSource() == k2) {
                numberText += "2";
                resultBar.setText(numberText);
            }
            else if (e.getSource() == k3) {
                numberText += "3";
                resultBar.setText(numberText);
            }
            else if (e.getSource() == k4) {
                numberText += "4";
                resultBar.setText(numberText);
            }
            else if (e.getSource() == k5) {
                numberText += "5";
                resultBar.setText(numberText);
            }
            else if (e.getSource() == k6) {
                numberText += "6";
                resultBar.setText(numberText);
            }
            else if (e.getSource() == k7) {
                numberText += "7";
                resultBar.setText(numberText);
            }else if (e.getSource() == k8) {
                numberText += "8";
                resultBar.setText(numberText);
            }
            else if (e.getSource() == k9) {
                numberText += "9";
                resultBar.setText(numberText);
            }
            //clear button actions
            else if (e.getSource() == clean) {
                String temp = resultBar.getText();
                if(temp.length()!=0) {
                    numberText = temp.substring(0, temp.length() - 1);
                    resultBar.setText(numberText);
                }
            }
            else if (e.getSource() == fullClean) {
                numberText = "";
                num = 0;
                resultBar.setText(numberText);
            }
            //operation button actions

            else if(e.getSource() == add) {
                num += Integer.parseInt(numberText);
                numberText = "";
                System.out.println(num);
                resultBar.setText("+");
                lastOp = '+';
            }

            else if(e.getSource() == sub) {
                if(num==0) {num = Integer.parseInt(numberText);}
                else {num -= Integer.parseInt(numberText);}
                numberText = "";
                System.out.println(num);
                resultBar.setText("-");
                lastOp = '-';
            }

            else if(e.getSource() == mul) {
                num *= Integer.parseInt(numberText);
                numberText = "";
                System.out.println(num);
                resultBar.setText("x");
                lastOp = '*';
            }

            else if(e.getSource() == div) {
                if(num==0) {num = Integer.parseInt(numberText);}
                else {num /= Integer.parseInt(numberText);}
                numberText = "";
                System.out.println(num);
                resultBar.setText("%");
                lastOp = '/';
            }

            else if(e.getSource() == equals) {
                switch (lastOp) {
                    case '+':
                        resultBar.setText(Integer.toString(num+Integer.parseInt(numberText)));
                        break;
                    case '-':
                        resultBar.setText(Integer.toString(num-Integer.parseInt(numberText)));
                        break;
                    case '*':
                        resultBar.setText(Integer.toString(num*Integer.parseInt(numberText)));
                        break;
                    case '/':
                        resultBar.setText(Integer.toString(num/Integer.parseInt(numberText)));
                        break;
                }

                num = 0;
                numberText = "";
            }

            }

        }


    public static void main (String[] args) {
            new CalculatorGUI("Calculator");
    }
}
