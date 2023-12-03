package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUpThree extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	JRadioButton savingAcc, currentAcc, fDAcc, reccuringAcc;
	ButtonGroup accBtnGrp;
	JCheckBox c1, c2, c3, c4, c5, c6, c7;
	JButton submit, cancel;
	String formno;

	public SignUpThree(String formno) {
		
		this.formno = formno;
		setVisible(true);
		setSize(800, 700);
		setLocation(350, 60);
		setLayout(null);
		getContentPane().setBackground(Color.white);
		setTitle("Account Section");

		JLabel l1 = new JLabel("Page 3: Account Details");
		l1.setFont(new Font("Raleway", Font.BOLD, 22));
		l1.setBounds(290, 80, 400, 30);
		add(l1);

		JLabel l2 = new JLabel("Account");
		l2.setFont(new Font("Raleway", Font.BOLD, 22));
		l2.setBounds(100, 130, 200, 30);
		add(l2);

		savingAcc = new JRadioButton("Saving Account");
		savingAcc.setFont(new Font("Raleway", Font.BOLD, 14));
		savingAcc.setBackground(Color.white);
		savingAcc.setBounds(100, 160, 150, 30);
		add(savingAcc);

		currentAcc = new JRadioButton("Current Account");
		currentAcc.setFont(new Font("Raleway", Font.BOLD, 14));
		currentAcc.setBackground(Color.white);
		currentAcc.setBounds(300, 160, 150, 30);
		add(currentAcc);

		fDAcc = new JRadioButton("FD Account");
		fDAcc.setFont(new Font("Raleway", Font.BOLD, 14));
		fDAcc.setBackground(Color.white);
		fDAcc.setBounds(100, 190, 150, 30);
		add(fDAcc);

		reccuringAcc = new JRadioButton("Reccuring Account");
		reccuringAcc.setFont(new Font("Raleway", Font.BOLD, 14));
		reccuringAcc.setBackground(Color.white);
		reccuringAcc.setBounds(300, 190, 160, 30);
		add(reccuringAcc);

		accBtnGrp = new ButtonGroup();
		accBtnGrp.add(currentAcc);
		accBtnGrp.add(savingAcc);
		accBtnGrp.add(fDAcc);
		accBtnGrp.add(reccuringAcc);

		JLabel card = new JLabel("Card Number");
		card.setFont(new Font("Raleway", Font.BOLD, 22));
		card.setBounds(100, 230, 200, 30);
		add(card);

		JLabel cardNum = new JLabel("XXXX-XXXX-XXXX-3245");
		cardNum.setFont(new Font("Raleway", Font.BOLD, 22));
		cardNum.setBounds(300, 230, 300, 30);
		add(cardNum);

		JLabel cardHint = new JLabel("(Your 16-Digit Card Number)");
		cardHint.setFont(new Font("Raleway", Font.BOLD, 15));
		cardHint.setForeground(Color.red);
		cardHint.setBounds(100, 260, 300, 30);
		add(cardHint);

		JLabel pin = new JLabel("PIN:");
		pin.setFont(new Font("Raleway", Font.BOLD, 22));
		pin.setBounds(100, 300, 300, 30);
		add(pin);

		JLabel pinNum = new JLabel("XXXX");
		pinNum.setFont(new Font("Raleway", Font.BOLD, 22));
		pinNum.setBounds(300, 300, 300, 30);
		add(pinNum);

		JLabel pinHint = new JLabel("(Yout 4-Digit Password)");
		pinHint.setFont(new Font("Raleway", Font.BOLD, 15));
		pinHint.setForeground(Color.red);
		pinHint.setBounds(100, 330, 300, 30);
		add(pinHint);

		JLabel services = new JLabel("Services Reqired:");
		services.setFont(new Font("Raleway", Font.BOLD, 22));
		services.setBounds(100, 360, 300, 30);
		add(services);

		c1 = new JCheckBox("ATM Card");
		c1.setFont(new Font("Raleway", Font.BOLD, 12));
		c1.setBackground(Color.white);
		c1.setBounds(300, 360, 100, 30);
		add(c1);

		c2 = new JCheckBox("Internet Banking");
		c2.setFont(new Font("Raleway", Font.BOLD, 12));
		c2.setBackground(Color.white);
		c2.setBounds(400, 360, 150, 30);
		add(c2);

		c3 = new JCheckBox("Mobile Banking");
		c3.setFont(new Font("Raleway", Font.BOLD, 12));
		c3.setBackground(Color.white);
		c3.setBounds(550, 360, 150, 30);
		add(c3);

		c4 = new JCheckBox("SMS Alerts");
		c4.setFont(new Font("Ralway", Font.BOLD, 12));
		c4.setBackground(Color.white);
		c4.setBounds(300, 390, 100, 30);
		add(c4);

		c5 = new JCheckBox("Cheque Book");
		c5.setFont(new Font("Ralway", Font.BOLD, 12));
		c5.setBackground(Color.white);
		c5.setBounds(400, 390, 150, 30);
		add(c5);

		c6 = new JCheckBox("e-Statement");
		c6.setFont(new Font("Ralway", Font.BOLD, 12));
		c6.setBackground(Color.white);
		c6.setBounds(550, 390, 150, 30);
		add(c6);

		c7 = new JCheckBox("I hereby declares that the above entered details correct to th best of my knowledge.");
		c7.setFont(new Font("Ralway", Font.BOLD, 14));
		c7.setBackground(Color.white);
		c7.setBounds(100, 450, 700, 30);
		add(c7);

		submit = new JButton("Submit");
		submit.setBackground(Color.black);
		submit.setForeground(Color.white);
		submit.setFont(new Font("Raleway", Font.BOLD, 20));
		submit.setBounds(270, 500, 100, 40);
		submit.addActionListener(this);
		add(submit);

		cancel = new JButton("Cancel");
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		cancel.setFont(new Font("Raleway", Font.BOLD, 20));
		cancel.setBounds(400, 500, 100, 40);
		cancel.addActionListener(this);
		add(cancel);

	}

	public static void main(String[] args) {

		new SignUpThree(null);

	}

	@Override
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == submit) {
			String accountType = "";
			if (savingAcc.isSelected()) {
				accountType = "Saving Account";

			} else if (currentAcc.isSelected()) {
				accountType = "Current Account";

			} else if (fDAcc.isSelected()) {
				accountType = "FD Account";
			} else if (reccuringAcc.isSelected()) {
				accountType = "Reccuring Account";
			}
			
			long l;
			Random r = new Random();
			l = r.nextLong()%90000000 + 5423904400000000L;
			String cardNumber = ""+l;
			
			long l2 = r.nextLong(0,9999)+100;
			String pin = ""+l2;
			
			String facility = "";
			
			 if(c1.isSelected()){ 
		            facility = facility + " ATM Card";
		        }
		        if(c2.isSelected()){ 
		            facility = facility + " Internet Banking";
		        }
		        if(c3.isSelected()){ 
		            facility = facility + " Mobile Banking";
		        }
		        if(c4.isSelected()){ 
		            facility = facility + " EMAIL Alerts";
		        }
		        if(c5.isSelected()){ 
		            facility = facility + " Cheque Book";
		        }
		        if(c6.isSelected()){ 
		            facility = facility + " E-Statement";
		        }
		        
		        boolean b= false;
		        if(c7.isSelected()) {
		        	b= false;
		        }else {
		        	b= true;
		        }
		        
		        try {
		        	if(accountType.equals("")) {
		        		
		        		JOptionPane.showMessageDialog(null,"Account type is required");
		        	
		        		
		        	}else if(facility.equals("")) {
		        		JOptionPane.showMessageDialog(null,"Please select at least one banking facility");
		        	}
		        	else if(b) {
		        		
		        		JOptionPane.showMessageDialog(null,"Please accept the terms and condition");
		        	
		        	}
		        	else 
		        	{
		        		Conn conn = new Conn();
		        		String q1 = "insert into signup3 values('"+formno+"','"+accountType+"','"+cardNumber+"','"+pin+"','"+facility+"')";  
		        		String q2 = "insert into login values('"+formno+"','"+cardNumber+"','"+pin+"')";
		        		conn.s.executeUpdate(q1);
		        		conn.s.executeUpdate(q2);
		        		
		        		JOptionPane.showMessageDialog(null, "Card Number: "+cardNumber+"\n Pin: "+ pin);
		        		setVisible(false);
		        		new Transaction(pin);
		        		
		        	}
		        }
		        catch(Exception e) {
		        	e.printStackTrace();
		        }
			
		}

		else if (ae.getSource() == cancel) {
			setVisible(false);
			new Login();
			

		}

	}

}
