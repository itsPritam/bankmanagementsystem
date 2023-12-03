package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {


	private static final long serialVersionUID = 6261715602813174650L;
	JButton cancel, deposit;
	JTextField amount;
	String pin;

	public Deposit(String pin) {

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

		JLabel text = new JLabel("Enter the amount you want to deposit");
		text.setForeground(Color.white);
		text.setFont(new Font("Monospaced", Font.BOLD, 20));
		text.setBounds(230, 290, 450, 30);
		image.add(text);

		amount = new JTextField();
		amount.setFont(new Font("Monospaced", Font.BOLD, 20));
		amount.setBounds(220, 350, 450, 30);
		amount.setBackground(Color.LIGHT_GRAY);
		amount.setForeground(Color.blue);
		image.add(amount);

		deposit = new JButton("Deposit");
		deposit.setBounds(520, 440, 150, 30);
		deposit.setBackground(Color.lightGray);
		deposit.setBorderPainted(false);
		deposit.addActionListener(this);
		image.add(deposit);

		cancel = new JButton("Cancel");
		cancel.setBounds(520, 480, 150, 30);
		cancel.setBackground(Color.lightGray);
		cancel.setBorderPainted(false);
		cancel.addActionListener(this);
		image.add(cancel);
	}

	public static void main(String[] args) {
		new Deposit(null);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == cancel) {
			setVisible(false);
			new Transaction(null);
			
		} else if (e.getSource() == deposit) {
			String num = amount.getText();
			Date date = new Date();
			if (num.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
			} else {
				try {
					Conn con = new Conn();
					String query = "insert into bank values('" + pin + "', '" + date + "', 'Deposit', '" + num + "')";

					con.s.executeUpdate(query);
					
					JOptionPane.showMessageDialog(null, "Rs."+num+" deposited Successfully");
					setVisible(false);
					new Transaction(pin);
					
				} catch (SQLException e1) {

					e1.printStackTrace();
				}
			}
		}
	}

}
