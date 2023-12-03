package bank.management.system;

import javax.swing.*;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class MiniStatement extends JFrame implements ActionListener{
	String pin;
	Conn con = new Conn();
	JButton back;

	public MiniStatement(String pin) {
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

		JLabel text = new JLabel();
		text.setForeground(Color.white);
		text.setFont(new Font("Monospaced", Font.BOLD, 12));
		text.setBounds(230, 260, 450, 30);
		image.add(text);

		JTextArea jt = new JTextArea();
		jt.setForeground(Color.white);
		jt.setBackground(Color.black);
		jt.setFont(new Font("System", Font.BOLD, 14));
		jt.setEditable(false);
		jt.setBounds(220, 300, 450, 220);
		image.add(jt);

		JScrollPane pane = new JScrollPane(jt);
		pane.setBorder(BorderFactory.createEmptyBorder());
		pane.setBounds(220, 300, 450, 195);
		image.add(pane);
		
		back = new JButton("Back");
		back.setBounds(520, 500, 150, 30);
		back.setBackground(Color.lightGray);
		back.setBorderPainted(false);
		back.addActionListener(this);
		image.add(back);

		try {

			ResultSet rs = con.s.executeQuery("select * from login where pin = " + pin + ";");
			while (rs.next()) {
				text.setText("Dear, "+"Card Number:" + rs.getString("card_Number").substring(0, 4) + "XXXXXXXX"
						+ rs.getString("card_Number").substring(13, 16) + " Holder Your Mini-Statement");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {

			ResultSet rs = con.s.executeQuery("select *from bank where pin = " + pin + ";");
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			System.out.println(columnsNumber);

			int balance = 0;
			while (rs.next()) {
				jt.setText(jt.getText() + "  " + rs.getString("Date") + "         " + rs.getString("type") + "         "
						+ rs.getString("Amount") + "\n");
				if (rs.getString("type").equals("Deposit")) {
					balance += Integer.parseInt(rs.getString("amount"));
				} else {
					balance -= Integer.parseInt(rs.getString("amount"));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		new MiniStatement(null);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		setVisible(false);
		new Transaction(pin);
		
	}

}
