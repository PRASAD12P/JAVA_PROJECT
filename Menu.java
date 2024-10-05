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

            String[] items = {"Select Option","ElectricityBill","Employeedetails"};
            JComboBox<String> comboBox = new JComboBox<>(items);
           comboBox.setPreferredSize(new Dimension(200, 80));  
        
           comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedItem = (String) comboBox.getSelectedItem();
                if ("ElectricityBill".equals(selectedItem)) {
                    openElectricityBillFrame(); // Open the electricity bill frame
                } else if ("EmployeeDetails".equals(selectedItem)) {
                    JOptionPane.showMessageDialog(f, "EmployeeDetails feature is under construction.");
                }
            }
        });
           
         
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
         Frame3.setLayout(null);



         JLabel Input = new JLabel( "Input: ");
         JLabel Output = new JLabel("Output: ");
         JTextField InputField = new JTextField();
         JTextField OutputField = new JTextField();
         JButton ConvertBtn = new JButton("Convert");
         String[] options = {"Decimal to Binary", "Binary to Decimal"};
         JComboBox<String> ConversionType = new JComboBox<>(options);


         Input.setBounds(45, 10, 150, 50);
        Output.setBounds(50, 60, 150, 50);
        InputField.setBounds(100, 20, 250, 30);
        OutputField.setBounds(100, 70, 250, 30);
        OutputField.setEditable(false); 
        ConvertBtn.setBounds(100, 170, 120, 50);
        ConversionType.setBounds(100, 120, 150, 30);




        ConvertBtn.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              try {
                  String selectedConversion = (String) ConversionType.getSelectedItem();
                  if (selectedConversion.equals("Decimal to Binary")) {
                      int decimal = Integer.parseInt(InputField.getText());
                      String binary = Integer.toBinaryString(decimal);
                      OutputField.setText(binary);
                  } else if (selectedConversion.equals("Binary to Decimal")) {
                      String binary = InputField.getText();
                      int decimal = Integer.parseInt(binary, 2);
                      OutputField.setText(String.valueOf(decimal));
                  }
              } catch (NumberFormatException ex) {
                  OutputField.setText("Invalid Input");
              }
          }
      });





      Frame3.add(Input);
      Frame3.add(Output);
      Frame3.add(InputField);
      Frame3.add(OutputField);
      Frame3.add(ConvertBtn);
      Frame3.add(ConversionType);
      Frame3.setVisible(true);

      }

      private static void openElectricityBillFrame() {
        JFrame billFrame = new JFrame("Electricity Bill Calculator");
        billFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Allow only this frame to be closed
        billFrame.setSize(400, 400);
        billFrame.setLayout(null);

        JLabel consumer_no = new JLabel("Consumer No: ");
        JLabel consumer_name = new JLabel("Consumer name: ");
        JLabel previous_reading = new JLabel("Previous reading: ");
        JLabel current_reading = new JLabel("Current reading: ");
        JLabel connection_type = new JLabel("Connection type: ");

        JTextField c_no_input = new JTextField();
        JTextField c_name_input = new JTextField();
        JTextField previous_reading_input = new JTextField("0");
        JTextField current_reading_input = new JTextField("0");

        JRadioButton con_type_Domestic = new JRadioButton("Domestic");
        JRadioButton con_type_Commercial = new JRadioButton("Commercial");
        ButtonGroup group = new ButtonGroup();
        group.add(con_type_Domestic);
        group.add(con_type_Commercial);

        JButton button_display = new JButton("Display Bill");
        JButton button_cancel = new JButton("Cancel");

        JLabel amount = new JLabel();

        button_display.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double previous = Double.parseDouble(previous_reading_input.getText());
                    double current = Double.parseDouble(current_reading_input.getText());
                    double bill = current - previous;

                    if (bill < 0) {
                        amount.setText("Invalid readings!");
                        return;
                    }

                    if (con_type_Domestic.isSelected()) {
                        if (bill <= 100)
                            bill = bill * 1;
                        else if (bill <= 200)
                            bill = 100 * 1 + (bill - 100) * 2.5;
                        else if (bill <= 500)
                            bill = 100 * 1 + 100 * 2.5 + (bill - 200) * 4;
                        else
                            bill = 100 * 1 + 100 * 2.5 + 300 * 4 + (bill - 500) * 6;
                    } else if (con_type_Commercial.isSelected()) {
                        if (bill <= 100)
                            bill = bill * 2;
                        else if (bill <= 200)
                            bill = 100 * 2 + (bill - 100) * 4.5;
                        else if (bill <= 500)
                            bill = 100 * 2 + 100 * 4.5 + (bill - 200) * 6;
                        else
                            bill = 100 * 2 + 100 * 4.5 + 300 * 6 + (bill - 500) * 7;
                    }

                    amount.setText("Bill Amount: Rs. " + String.format("%.2f", bill));
                } catch (NumberFormatException ex) {
                    amount.setText("Invalid input!");
                }
            }
        });

        button_cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Reset all fields
                c_no_input.setText("");
                c_name_input.setText("");
                previous_reading_input.setText("0");
                current_reading_input.setText("0");
                group.clearSelection();
                amount.setText("");
            }
        });

        consumer_no.setBounds(0, 0, 200, 20);
        consumer_name.setBounds(0, 30, 200, 20);
        previous_reading.setBounds(0, 60, 200, 20);
        current_reading.setBounds(0, 90, 200, 20);
        connection_type.setBounds(0, 120, 200, 20);

        c_no_input.setBounds(110, 0, 200, 20);
        c_name_input.setBounds(110, 30, 200, 20);
        previous_reading_input.setBounds(110, 60, 200, 20);
        current_reading_input.setBounds(110, 90, 200, 20);

        con_type_Domestic.setBounds(110, 120, 100, 20);
        con_type_Commercial.setBounds(220, 120, 100, 20);

        button_display.setBounds(0, 150, 100, 20);
        button_cancel.setBounds(120, 150, 100, 20);

        amount.setBounds(0, 180, 200, 20);

        billFrame.add(consumer_no);
        billFrame.add(consumer_name);
        billFrame.add(previous_reading);
        billFrame.add(current_reading);
        billFrame.add(connection_type);

        billFrame.add(c_no_input);
        billFrame.add(c_name_input);
        billFrame.add(previous_reading_input);
        billFrame.add(current_reading_input);
        billFrame.add(con_type_Domestic);
        billFrame.add(con_type_Commercial);

        billFrame.add(button_display);
        billFrame.add(button_cancel);
        billFrame.add(amount);

        billFrame.setVisible(true);
    }

    
















      


    }