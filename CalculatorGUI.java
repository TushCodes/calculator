package damn420;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class CalculatorGUI extends JFrame {
    private JTextField resultBar;
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
    String operand = "";
    ArrayList<String> expression = new ArrayList<String>();

    //numbers for calculation
    int num = 0;

    public CalculatorGUI() {}
    public CalculatorGUI(String title) {
        super(title);
        setComponents();
        this.setBounds(300, 100, 650, 350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void setComponents() {
        //construct components
        resultBar = new JTextField(5);
        add = new JButton("+");
        sub = new JButton("-");
        mul = new JButton("x");
        div = new JButton("%");
        equals = new JButton("=");
        k0 = new JButton("0");
        k1 = new JButton("1");
        k2 = new JButton("2");
        k3 = new JButton("3");
        k4 = new JButton("4");
        k7 = new JButton("7");
        k5 = new JButton("5");
        k6 = new JButton("6");
        k8 = new JButton("8");
        k9 = new JButton("9");
        clean = new JButton("C");
        fullClean = new JButton("AC");

        //adjust size and set layout
        setPreferredSize(new Dimension(624, 329));
        setLayout(null);

        //add components
        add(resultBar);
        add(add);
        add(sub);
        add(mul);
        add(div);
        add(equals);
        add(k0);
        add(k1);
        add(k2);
        add(k3);
        add(k4);
        add(k5);
        add(k6);
        add(k7);
        add(k8);
        add(k9);
        add(clean);
        add(fullClean);

        //set component bounds (only needed by Absolute Positioning)
        resultBar.setBounds(30, 25, 565, 40);
        add.setBounds(50, 250, 45, 40);
        add.addActionListener(new Handler());
        sub.setBounds(50, 205, 45, 40);
        sub.addActionListener(new Handler());
        mul.setBounds(50, 160, 45, 40);
        mul.addActionListener(new Handler());
        div.setBounds(50, 115, 45, 40);
        div.addActionListener(new Handler());
        equals.setBounds(200, 150, 45, 40);
        equals.addActionListener(new Handler());
        k0.setBounds(405, 260, 45, 40);
        k0.addActionListener(new Handler());
        k1.setBounds(350, 215, 45, 40);
        k1.addActionListener(new Handler());
        k2.setBounds(405, 215, 45, 40);
        k2.addActionListener(new Handler());
        k3.setBounds(460, 215, 45, 40);
        k3.addActionListener(new Handler());
        k4.setBounds(350, 165, 45, 40);
        k4.addActionListener(new Handler());
        k7.setBounds(350, 115, 45, 40);
        k7.addActionListener(new Handler());
        k5.setBounds(405, 165, 45, 40);
        k5.addActionListener(new Handler());
        k6.setBounds(460, 165, 45, 40);
        k6.addActionListener(new Handler());
        k8.setBounds(410, 115, 45, 40);
        k8.addActionListener(new Handler());
        k9.setBounds(460, 115, 45, 40);
        k9.addActionListener(new Handler());
        clean.setBounds(545, 130, 55, 45);
        clean.addActionListener(new Handler());
        fullClean.setBounds(545, 190, 55, 45);
        fullClean.addActionListener(new Handler());
        resultBar.setEditable(false);
    }

    private int evaluateExpression(ArrayList<String> e) {
        int index = 0;
        while (expression.size() > 1) {
            int operand1 = Integer.parseInt(expression.get(index));
            String operator = expression.get(index + 1);
            int operand2 = Integer.parseInt(expression.get(index + 2));

            int result = this.performOperation(operand1, operator, operand2);

            // Replace evaluated elements with the result
            expression.set(index, String.valueOf(result));
            expression.remove(index + 2); // Remove the operand2
            expression.remove(index + 1); // Remove the operator
        }

        return Integer.parseInt(expression.get(0)); // Return the final result
    }

    private int performOperation(int operand1, String operator, int operand2) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 != 0) {
                    return operand1 / operand2;
                } else {
                    throw new ArithmeticException("Division by zero is not allowed.");
                }
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }


    class Handler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //number button actions
            if (e.getSource() == k0 || e.getSource() == k1 || e.getSource() == k2 || e.getSource() == k3 || e.getSource() == k4 || e.getSource() == k5 || e.getSource() == k6 || e.getSource() == k7 || e.getSource() == k8 || e.getSource() == k9) {
              JButton button = (JButton) e.getSource();
              operand += button.getText();
              resultBar.setText(operand);
            }

            //clear button actions
            else if (e.getSource() == clean) {
                String temp = resultBar.getText();
                if (temp.length() > 0) {
                    // Remove the last character from the text
                    String updatedText = temp.substring(0, temp.length() - 1);
                    resultBar.setText(updatedText);

                    // Update the expression ArrayList and operand string
                    if (expression.size() > 0) {
                        expression.remove(expression.size() - 1);
                    }
                    operand = updatedText;
                }
            }
            else if (e.getSource() == fullClean) {
                operand = "";
                expression.clear();
                resultBar.setText(operand);
            }

            //operation button actions

            else if (e.getSource() == add) {
                expression.add(operand);
                resultBar.setText("+");
                operand = "";
                expression.add("+");
            } else if (e.getSource() == sub) {
                expression.add(operand);
                resultBar.setText("-");
                operand = "";
                expression.add("-");
            } else if (e.getSource() == mul) {
              expression.add(operand);
              resultBar.setText("x");
              operand = "";
              expression.add("*");
            } else if (e.getSource() == div) {
                expression.add(operand);
                System.out.println(expression);
                resultBar.setText("/");
                operand = "";
                expression.add("/");
                System.out.println(expression);
            } else if (e.getSource() == equals) {
                expression.add(operand);
                int res = evaluateExpression(expression);
                resultBar.setText(Integer.toString(res));
            }


        }
    }

    public static void main(String[] args) {
        new CalculatorGUI("Calculator");
    }

}