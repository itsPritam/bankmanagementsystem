package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	JTextField pinTextF, rePinTextF;
	JButton changePin, cancel;
	String pin;

	public PinChange(String pin) {

		this.pin = pin;
		setSize(900, 800);
		setLocation(350, 10);
		setResizable(false);
		setVisible(true);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm1.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 800, Image.SCALE_SMOOTH);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 0, 0);
		add(image);

		JLabel text = new JLabel("Change Your Pin Number");
		text.setForeground(Color.white);
		text.setFont(new Font("Monospaced", Font.BOLD, 20));
		text.setBounds(300, 270, 450, 30);
		image.add(text);

		JLabel pinText = new JLabel("New Pin");
		pinText.setForeground(Color.white);
		pinText.setFont(new Font("Monospaced", Font.BOLD, 18));
		pinText.setBounds(220, 380, 150, 30);
		image.add(pinText);

		pinTextF = new JTextField();
		pinTextF.setForeground(Color.blue);
		pinTextF.setBackground(Color.LIGHT_GRAY);
		pinTextF.setFont(new Font("Monospaced", Font.BOLD, 20));
		pinTextF.setBounds(400, 380, 200, 30);
		image.add(pinTextF);

		JLabel repinText = new JLabel("Re-Enter New Pin");
		repinText.setForeground(Color.white);
		repinText.setFont(new Font("Monospaced", Font.BOLD, 18));
		repinText.setBounds(220, 420, 200, 30);
		image.add(repinText);

		rePinTextF = new JTextField();
		rePinTextF.setForeground(Color.blue);
		rePinTextF.setBackground(Color.LIGHT_GRAY);
		rePinTextF.setFont(new Font("Monospaced", Font.BOLD, 20));
		rePinTextF.setBounds(400, 420, 200, 30);
		image.add(rePinTextF);

		changePin = new JButton("Change Pin");
		changePin.setBounds(520, 460, 150, 30);
		changePin.setBackground(Color.lightGray);
		changePin.setBorderPainted(false);
		changePin.addActionListener(this);
		image.add(changePin);

		cancel = new JButton("Cancel");
		cancel.setBounds(520, 500, 150, 30);
		cancel.setBackground(Color.lightGray);
		cancel.setBorderPainted(false);
		cancel.addActionListener(this);
		image.add(cancel);

	}

	public static void main(String[] args) {

		new PinChange(null);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		   try{        
	            String npin = pinTextF.getText();
	            String rpin = rePinTextF.getText();
	            
	            if(!npin.equals(rpin)){
	                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
	                return;
	            }
	            
	            if(e.getSource()==changePin){
	                if (pinTextF.getText().equals("")){
	                    JOptionPane.showMessageDialog(null, "Enter New PIN");
	                }
	                if (rePinTextF.getText().equals("")){
	                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
	                }
	                
	                Conn c1 = new Conn();
	                String q1 = "update bank set pin = '"+rpin+"' where pin = '"+pin+"' ";
	                String q2 = "update login set pin = '"+rpin+"' where pin = '"+pin+"' ";
	                String q3 = "update signup3 set pin = '"+rpin+"' where pin = '"+pin+"' ";

	                c1.s.executeUpdate(q1);
	                c1.s.executeUpdate(q2);
	                c1.s.executeUpdate(q3);

	                JOptionPane.showMessageDialog(null, "PIN changed successfully");
	                setVisible(false);
	                new Transaction(rpin).setVisible(true);
	            
	            }else if(e.getSource()==cancel){
	            	setVisible(false);
	                new Transaction(pin).setVisible(true);
	                
	            }
	        }catch(Exception e2){
	            e2.printStackTrace();
	        }
	
	}

}
