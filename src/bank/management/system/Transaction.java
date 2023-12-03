package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	JButton deposit, withdrawl, fastcash, help, miniStmt, pinChange, exit, balance;
	String pin;

	public Transaction(String pin) {
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

		JLabel text = new JLabel("Please select your Transcation");
		text.setForeground(Color.white);
		text.setFont(new Font("Monospaced", Font.BOLD, 22));
		text.setBounds(240, 270, 450, 30);
		image.add(text);

		deposit = new JButton("Deposit");
		deposit.setBounds(220, 360, 150, 30);
		deposit.setBackground(Color.LIGHT_GRAY);
		deposit.addActionListener(this);
		deposit.setBorderPainted(false);
		image.add(deposit);

		withdrawl = new JButton("Withdrawl");
		withdrawl.setBounds(520, 360, 150, 30);
		withdrawl.setBackground(Color.LIGHT_GRAY);
		withdrawl.setBorderPainted(false);
		withdrawl.addActionListener(this);
		image.add(withdrawl);

		fastcash = new JButton("FastCash");
		fastcash.setBounds(220, 400, 150, 30);
		fastcash.setBackground(Color.LIGHT_GRAY);
		fastcash.setBorderPainted(false);
		fastcash.addActionListener(this);
		image.add(fastcash);

		miniStmt = new JButton("Mini-Statement");
		miniStmt.setBounds(520, 400, 150, 30);
		miniStmt.setBackground(Color.LIGHT_GRAY);
		miniStmt.setBorderPainted(false);
		miniStmt.addActionListener(this);
		image.add(miniStmt);

		pinChange = new JButton("Pin Change");
		pinChange.setBounds(220, 440, 150, 30);
		pinChange.setBackground(Color.LIGHT_GRAY);
		pinChange.setBorderPainted(false);
		pinChange.addActionListener(this);
		image.add(pinChange);

		help = new JButton("Help?");
		help.setBounds(220, 480, 150, 30);
		help.setBackground(Color.LIGHT_GRAY);
		help.setBorderPainted(false);
		image.add(help);

		balance = new JButton("Balance Enquiry");
		balance.setBounds(520, 440, 150, 30);
		balance.setBackground(Color.LIGHT_GRAY);
		balance.setBorderPainted(false);
		balance.addActionListener(this);
		image.add(balance);

		exit = new JButton("Exit");
		exit.setBounds(520, 480, 150, 30);
		exit.setBackground(Color.LIGHT_GRAY);
		exit.setBorderPainted(false);
		exit.addActionListener(this);
		image.add(exit);
	}

	public static void main(String[] args) {
		new Transaction(null);

	}

	@Override
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == exit) {
			System.exit(ABORT);
		} else if (ae.getSource() == deposit) {	
			setVisible(false);
			new Deposit(pin);
		}else if(ae.getSource()==withdrawl) {
			setVisible(false);
			new Withdrawl(pin);
		}else if(ae.getSource() ==fastcash) {
			new Fastcash(pin);
		}else if(ae.getSource()==pinChange) {
			setVisible(false);
			new PinChange(pin);
		}else if(ae.getSource()==balance) {
			new BalanceEnquiry(pin);
		}else if(ae.getSource()==miniStmt) {
			new MiniStatement(pin);
		}
			

	}

}
