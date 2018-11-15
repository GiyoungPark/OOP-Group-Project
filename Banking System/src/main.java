import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class SwingControlDemo{
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;

   public SwingControlDemo(){
      prepareGUI();
   }
   public static void main(String[] args){
      SwingControlDemo  swingControlDemo = new SwingControlDemo();     		// I think this needs a while loop: while(1) 
      swingControlDemo.showButtonDemo();
   }
   private void prepareGUI(){
      mainFrame = new JFrame("Main Console");
      mainFrame.setSize(400,400);
      mainFrame.setLayout(new GridLayout(3, 1));
      
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      headerLabel = new JLabel("", JLabel.CENTER);        
      statusLabel = new JLabel("",JLabel.CENTER);    
      statusLabel.setSize(350,100);

      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
   }
 
   private void showButtonDemo(){
      headerLabel.setText("Which best describes you?"); 

      JButton BankStaffButton = new JButton("Bank Staff");
      JButton CustomerButton = new JButton("Customer");

      BankStaffButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
		//BankStaff.BankStaff(); //<- I think this is how you call the bank staff file
            statusLabel.setText("Entering Bank Staff Console");		
         }
      });
      CustomerButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
		// Customer.StartMenu(acc);
            statusLabel.setText("Entering Customer Console");			
	 }
      });
      controlPanel.add(BankStaffButton);
      controlPanel.add(CustomerButton);       

      mainFrame.setVisible(true);  
   }
}
