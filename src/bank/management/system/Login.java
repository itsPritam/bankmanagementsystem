package bank.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class Login extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	JButton signIn, signUp, clear;
	JTextField cardTextField;
	JPasswordField pinTextField;

	Login() {

		setTitle("ATM Simulator");
		setLayout(null);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
		Image i2 = i1.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);

		JLabel label = new JLabel(i3);
		label.setBounds(70, 40, 100, 100);
		getContentPane().setBackground(Color.white);
		add(label);

		JLabel text = new JLabel("Welcome To ATM");
		text.setBounds(180, 55, 300, 80);
		text.setFont(new Font("Osward", Font.BOLD, 30));
		add(text);

		JLabel cardno = new JLabel("Card No:");
		cardno.setBounds(180, 130, 300, 80);
		cardno.setFont(new Font("Osward", Font.BOLD, 30));
		add(cardno);

		cardTextField = new JTextField();
		cardTextField.setBounds(320, 160, 200, 25);
		cardTextField.setFont(new Font("Osward", Font.PLAIN, 18));
		add(cardTextField);

		JLabel pin = new JLabel("Pin:");
		pin.setBounds(180, 180, 300, 80);
		pin.setFont(new Font("Osward", Font.BOLD, 30));
		add(pin);

		pinTextField = new JPasswordField();
		pinTextField.setBounds(320, 210, 200, 25);
		pinTextField.setFont(new Font("Osward", Font.PLAIN, 18));
		add(pinTextField);

		signIn = new JButton("LogIn");
		signIn.setBounds(320, 250, 80, 30);
		signIn.setBackground(Color.black);
		signIn.setForeground(Color.white);
		signIn.addActionListener(this);
		add(signIn);

		signUp = new JButton("Sign Up");
		signUp.setBounds(440, 250, 80, 30);
		signUp.setBackground(Color.black);
		signUp.setForeground(Color.white);
		signUp.addActionListener(this);
		add(signUp);

		clear = new JButton("Clear");
		clear.setBounds(320, 285, 200, 30);
		clear.setBackground(Color.black);
		clear.setForeground(Color.white);
		add(clear);
		clear.addActionListener(this);

		setSize(600, 400);
		setLocation(500, 220);
		setResizable(false);
		setVisible(true);

	}

	public static void main(String[] args) {

		new Login();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("LogIn")) {

			Conn con = new Conn();
			String cardNumber = cardTextField.getText();
			@SuppressWarnings("deprecation")
			String pin = pinTextField.getText();

			String query = "select * from login where card_number = '" + cardNumber + "' and pin = '" + pin + "'";
			
			try {
				ResultSet rs = con.s.executeQuery(query);
				if(rs.next()) {
					new Transaction(pin);
				}
				else {
					 JOptionPane.showMessageDialog(null, "Incorrect Card or Pin Number");
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		} else if (e.getActionCommand().equals("Sign Up")) {

			setVisible(false);
			new SignUpOne();
		} else if (e.getActionCommand().equals("Clear")) {

			cardTextField.setText("");
			pinTextField.setText("");

		}

	}
}
