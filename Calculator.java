package com.sunil.practic.app01;

/*public class Calculator {

	public static void main(String[] args) {*/
      //

			import javax.swing.*;
			import java.awt.*;
			import java.awt.event.ActionEvent;
			import java.awt.event.ActionListener;

			public class Calculator extends JFrame implements ActionListener {
			    // Create a frame
			    private JFrame frame;

			    // Create a textfield
			    private JTextField textField;

			    // Store operator and operands
			    private String operator;
			    private double num1, num2, result;

			    // Create constructor
			    public Calculator() {
			        frame = new JFrame("Calculator");
			        textField = new JTextField();

			        operator = "";
			        num1 = num2 = result = 0;

			        // Create number buttons and some operators
			        JButton[] numberButtons = new JButton[10];
			        for (int i = 0; i < 10; i++) {
			            numberButtons[i] = new JButton(String.valueOf(i));
			            numberButtons[i].addActionListener(this);
			        }

			        JButton addButton = new JButton("+");
			        JButton subButton = new JButton("-");
			        JButton mulButton = new JButton("*");
			        JButton divButton = new JButton("/");
			        JButton decButton = new JButton(".");
			        JButton equButton = new JButton("=");
			        JButton delButton = new JButton("Del");
			        JButton clrButton = new JButton("Clr");

			        // Add action listeners
			        addButton.addActionListener(this);
			        subButton.addActionListener(this);
			        mulButton.addActionListener(this);
			        divButton.addActionListener(this);
			        decButton.addActionListener(this);
			        equButton.addActionListener(this);
			        delButton.addActionListener(this);
			        clrButton.addActionListener(this);

			        // Create a panel
			        JPanel panel = new JPanel();
			        panel.setLayout(new GridLayout(4, 4, 10, 10));

			        // Add buttons to panel
			        panel.add(numberButtons[1]);
			        panel.add(numberButtons[2]);
			        panel.add(numberButtons[3]);
			        panel.add(addButton);
			        panel.add(numberButtons[4]);
			        panel.add(numberButtons[5]);
			        panel.add(numberButtons[6]);
			        panel.add(subButton);
			        panel.add(numberButtons[7]);
			        panel.add(numberButtons[8]);
			        panel.add(numberButtons[9]);
			        panel.add(mulButton);
			        panel.add(decButton);
			        panel.add(numberButtons[0]);
			        panel.add(equButton);
			        panel.add(divButton);

			        // Add components to frame
			        frame.add(textField, BorderLayout.NORTH);
			        frame.add(panel, BorderLayout.CENTER);
			        frame.add(delButton, BorderLayout.WEST);
			        frame.add(clrButton, BorderLayout.EAST);

			        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        frame.setSize(400, 500);
			        frame.setVisible(true);
			    }

			    @Override
			    public void actionPerformed(ActionEvent e) {
			        String command = e.getActionCommand();

			        // If the command is a number or a decimal point
			        if ((command.charAt(0) >= '0' && command.charAt(0) <= '9') || command.charAt(0) == '.') {
			            textField.setText(textField.getText() + command);
			        } else if (command.charAt(0) == 'C') {
			            // Clear the textfield
			            textField.setText("");
			        } else if (command.charAt(0) == 'D') {
			            // Delete the last character
			            String temp = textField.getText();
			            if (temp.length() > 0) {
			                temp = temp.substring(0, temp.length() - 1);
			                textField.setText(temp);
			            }
			        } else if (command.charAt(0) == '=') {
			            // Calculate the result
			            num2 = Double.parseDouble(textField.getText());

			            switch (operator) {
			                case "+":
			                    result = num1 + num2;
			                    break;
			                case "-":
			                    result = num1 - num2;
			                    break;
			                case "*":
			                    result = num1 * num2;
			                    break;
			                case "/":
			                    result = num1 / num2;
			                    break;
			            }

			            textField.setText(String.valueOf(result));
			            operator = "";
			        } else {
			            // Store the first number and the operator
			            if (!textField.getText().equals("")) {
			                num1 = Double.parseDouble(textField.getText());
			                operator = command;
			                textField.setText("");
			            }
			        }
			    }

			    public static void main(String[] args) {
			        new Calculator();
			    }
			}

		   
