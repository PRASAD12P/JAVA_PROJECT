import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Menu {
         public static void main(String[] args) {
            JFrame f = new JFrame("Menu");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setSize(1000,600);
            f.setLayout(new FlowLayout(FlowLayout.LEFT));


            JButton button = new JButton("Calculator");
            button.setPreferredSize(new Dimension(100, 80));          
         

            JPanel panel = new JPanel();
            JLabel label = new JLabel(":Lab Programs");
            panel.add(label);

            String[] items = {"ElectricityBill","Employeedetails"};
            JComboBox<String> comboBox = new JComboBox<>(items);
           comboBox.setPreferredSize(new Dimension(200, 80));  
            

            JButton button2 = new JButton("Binary To decimal");   
            button2.setPreferredSize(new Dimension(200, 80));  


              button.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   NewFrame();
               }
           });


           
           button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewFrame2();
            }
        });


           f.add(button);
           f.add(button2);
           f.add(comboBox);
           f.add(label);
           f.add(panel);
           f.setVisible(true);
         }
    
         private static void NewFrame(){
            JFrame Frame2 = new JFrame("Calculator");
             Frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
             Frame2.setSize(500,500);
             Frame2.setLayout(new BorderLayout());

              JTextField Calci_display = new JTextField();
              Calci_display.setEditable(false);
              Calci_display.setHorizontalAlignment(SwingConstants.RIGHT);
              Calci_display.setFont(new Font("Arial", Font.BOLD, 50));
              Calci_display.setPreferredSize(new Dimension(400, 100));
              Frame2.add(Calci_display, BorderLayout.NORTH);



            JPanel btnPanel = new JPanel();
            btnPanel.setLayout(new GridLayout(4,4,20,20));

            String[] buttons = {
              "7", "8", "9", "/",
              "4", "5", "6", "*",
              "1", "2", "3", "-",
              "0", "C", "=", "+"
          };


          final String[] currentOp = {""};
          final double[] operand1 = {0};
          final boolean[] newOperand = {true};


          for (String text : buttons) {
            JButton btn2 = new JButton(text);
            btn2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String cmd = btn2.getText();

                    
                    if (cmd.equals("C")) {
                        Calci_display.setText("");
                        operand1[0] = 0;
                        currentOp[0] = "";
                        newOperand[0] = true;
                    } 
                    
                    else if (cmd.equals("=")) {
                        if (!currentOp[0].isEmpty()) {
                            double operand2 = Double.parseDouble(Calci_display.getText());
                            double result = calculate(operand1[0], operand2, currentOp[0]);
                            Calci_display.setText(String.valueOf(result));
                            currentOp[0] = "";
                            newOperand[0] = true;
                        }
                    }
                  
                    else if ("+-*/".contains(cmd)) {
                        operand1[0] = Double.parseDouble(Calci_display.getText());
                        currentOp[0] = cmd;
                        newOperand[0] = true; 
                    } 
                   

                    else {
                        if (newOperand[0]) {
                            Calci_display.setText(cmd);
                            newOperand[0] = false;
                        } else {
                            Calci_display.setText(Calci_display.getText() + cmd);
                        }
                    }
                }
            });
            btnPanel.add(btn2);
        }
        Frame2.add(btnPanel, BorderLayout.CENTER);
        Frame2.setVisible(true);
    }


         private static double calculate(double operand1, double operand2, String operator) {
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
                      JOptionPane.showMessageDialog(null, "Cannot divide by Zero");
                      return 0;
                  }
              default:
                  return 0;
          }
      }




      private static void NewFrame2(){
        JFrame Frame3 = new JFrame("Binary To decimal");
         Frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         Frame3.setSize(500,500);
         Frame3.setLayout(new BorderLayout());
          Frame3.setVisible(true);

      }


    }