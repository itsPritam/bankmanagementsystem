package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Fastcash extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	JButton hundred, twoHundred, fiveHundred, twoThous, fiveThous, tenThous, back, help;
	String pin;

	public Fastcash(String pin) {
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

		JLabel text = new JLabel("Please select your fastcash amount");
		text.setForeground(Color.white);
		text.setFont(new Font("Monospaced", Font.BOLD, 20));
		text.setBounds(240, 270, 450, 30);
		image.add(text);

		hundred = new JButton("Rs.100");
		hundred.setBounds(220, 360, 150, 30);
		hundred.setBackground(Color.LIGHT_GRAY);
		hundred.setBorderPainted(false);
		hundred.addActionListener(this);
		image.add(hundred);

		twoHundred = new JButton("Rs.200");
		twoHundred.setBounds(520, 360, 150, 30);
		twoHundred.setBackground(Color.LIGHT_GRAY);
		twoHundred.setBorderPainted(false);
		twoHundred.addActionListener(this);
		image.add(twoHundred);

		twoThous = new JButton("Rs.2000");
		twoThous.setBounds(220, 400, 150, 30);
		twoThous.setBackground(Color.LIGHT_GRAY);
		twoThous.setBorderPainted(false);
		twoThous.addActionListener(this);
		image.add(twoThous);

		fiveThous = new JButton("Rs.5000");
		fiveThous.setBounds(520, 400, 150, 30);
		fiveThous.setBackground(Color.LIGHT_GRAY);
		fiveThous.setBorderPainted(false);
		fiveThous.addActionListener(this);
		image.add(fiveThous);

		tenThous = new JButton("Rs.10000");
		tenThous.setBounds(220, 440, 150, 30);
		tenThous.setBackground(Color.LIGHT_GRAY);
		tenThous.setBorderPainted(false);
		tenThous.addActionListener(this);
		image.add(tenThous);

		help = new JButton("Help?");
		help.setBounds(220, 480, 150, 30);
		help.setBackground(Color.LIGHT_GRAY);
		help.setBorderPainted(false);
		image.add(help);

		fiveHundred = new JButton("Rs.500");
		fiveHundred.setBounds(520, 440, 150, 30);
		fiveHundred.setBackground(Color.LIGHT_GRAY);
		fiveHundred.setBorderPainted(false);
		fiveHundred.addActionListener(this);
		image.add(fiveHundred);

		back = new JButton("Back");
		back.setBounds(520, 480, 150, 30);
		back.setBackground(Color.LIGHT_GRAY);
		back.setBorderPainted(false);
		back.addActionListener(this);
		image.add(back);
	}

	public static void main(String[] args) {
		new Fastcash(null);

	}

	@Override
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == back) {
			new Transaction(pin);
		} else {
			String amount = ((JButton) ae.getSource()).getText().substring(3);
		
			Conn con = new Conn();
			try {
				ResultSet rs = con.s.executeQuery("select * from bank where pin = '" + pin + "'");
				int balance = 0;
				while (rs.next()) {
					if (rs.getString("type").equals("Deposit")) {
						balance += Integer.parseInt(rs.getString("amount"));
					} else {
						balance -= Integer.parseInt(rs.getString("amount"));
					}
				}

				if (ae.getSource() != back && balance < Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(null, "Insufficient Balance");
					setVisible(false);
				}else {
				Date date = new Date();
				String query = "insert into bank values('" + pin + "', '" + date + "', 'Withdrawl', '" + amount + "')";
				con.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Rs." + amount + " Debited Successfully");
				setVisible(false);
				
				}
				new Transaction(pin);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
