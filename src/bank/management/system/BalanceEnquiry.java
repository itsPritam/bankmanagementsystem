package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class BalanceEnquiry extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7376768983367646846L;
	String pin;
	JButton back;

	public BalanceEnquiry(String pinChange) {

		pin = pinChange;
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

	

		back = new JButton("Back");
		back.setBounds(520, 480, 150, 30);
		back.setBackground(Color.lightGray);
		back.setBorderPainted(false);
		back.addActionListener(this);
		image.add(back);

		int balance = 0;
		Conn con = new Conn();
		try {
			ResultSet rs = con.s.executeQuery("select * from bank where pin = '" + pin + "'");

			while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }

		} catch (Exception e) {
			e.printStackTrace();

		}
		
		JLabel text = new JLabel("Your Current Balance is "+balance);
		text.setForeground(Color.white);
		text.setFont(new Font("Monospaced", Font.BOLD, 20));
		text.setBounds(290, 380, 450, 30);
		image.add(text);
		

	}

	public static void main(String[] args) {

		new BalanceEnquiry(null);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		setVisible(false);
		new Transaction(pin);

	}

}
