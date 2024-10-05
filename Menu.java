import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Menu {
         public static void main(String[] args) {
            JFrame f = new JFrame("Menu");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setSize(500,600);
            f.setLayout(new FlowLayout(FlowLayout.LEFT));


            JButton button = new JButton("Calculator");            
         

            JPanel panel = new JPanel();
            JLabel label = new JLabel(":Lab Programs");

            String[] items = {"ElectricityBill","Employeedetails"};
            JComboBox<String> comboBox = new JComboBox<>(items);

            JButton button2 = new JButton("Binary To decimal");   



              button.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   NewFrame();
               }
           });


           f.add(button);
           f.add(button2);
           f.add(comboBox);
           f.add(label);
           f.setVisible(true);
         }
    
         private static void NewFrame(){
            JFrame Frame2 = new JFrame("Calculator");
             Frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
             Frame2.setSize(300,200);
             Frame2.setVisible(true);
         }






} 