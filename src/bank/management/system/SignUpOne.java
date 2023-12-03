
package bank.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

import com.toedter.calendar.JDateChooser;

public class SignUpOne extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	ButtonGroup genderbtnGroup = new ButtonGroup();
	ButtonGroup marriageStatusGroup = new ButtonGroup();

	long random;
	JTextField nameTxtF, fnameTxtF, emailTxtF, addressTxtF, stateTxtF, pinTxtF, cityTxtF;
	JButton next;
	JRadioButton male, female, married, unmarried, other;
	JDateChooser dateChooser;
	

	public SignUpOne() {

		setLayout(null);
		setSize(850, 700);
		setLocation(350, 60);
		setVisible(true);
//        setResizable(false);
		getContentPane().setBackground(Color.WHITE);

		Random ran = new Random();
		random = Math.abs((ran.nextLong() % 9000L) + 1000L);

		JLabel formno = new JLabel("APPLICATION FORM NO." + random);
		formno.setFont(new Font("Raleway", Font.BOLD, 38));
		formno.setBounds(140, 20, 600, 40);
		add(formno);

		JLabel personDetails = new JLabel("Page 1: Personal Details");
		personDetails.setFont(new Font("Raleway", Font.BOLD, 20));
		personDetails.setBounds(290, 80, 400, 30);
		add(personDetails);

		JLabel name = new JLabel("Name:");
		name.setFont(new Font("Raleway", Font.BOLD, 20));
		name.setBounds(100, 120, 400, 30);
		add(name);

		nameTxtF = new JTextField();
		nameTxtF.setFont(new Font("Raleway", Font.BOLD, 14));
		nameTxtF.setBounds(270, 120, 400, 30);
		add(nameTxtF);

		JLabel fname = new JLabel("Father's Name:");
		fname.setFont(new Font("Raleway", Font.BOLD, 20));
		fname.setBounds(100, 160, 400, 30);
		add(fname);

		fnameTxtF = new JTextField();
		fnameTxtF.setFont(new Font("Raleway", Font.BOLD, 14));
		fnameTxtF.setBounds(270, 160, 400, 30);
		add(fnameTxtF);

		JLabel dob = new JLabel("Date of Birth:");
		dob.setFont(new Font("Raleway", Font.BOLD, 20));
		dob.setBounds(100, 200, 400, 30);
		add(dob);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(270, 200, 400, 30);
		add(dateChooser);

		JLabel gender = new JLabel("Gender:");
		gender.setFont(new Font("Raleway", Font.BOLD, 20));
		gender.setBounds(100, 240, 400, 30);
		add(gender);

		male = new JRadioButton("Male");
		male.setBounds(270, 240, 60, 30);
		male.setBackground(Color.white);

		female = new JRadioButton("Female");
		female.setBounds(330, 240, 80, 30);
		female.setBackground(Color.white);

		genderbtnGroup.add(male);
		genderbtnGroup.add(female);

		add(male);
		add(female);

		 JLabel email = new JLabel("Email Address:");
		email.setFont(new Font("Raleway", Font.BOLD, 20));
		email.setBounds(100, 280, 400, 30);
		add(email);

		emailTxtF = new JTextField();
		emailTxtF.setFont(new Font("Raleway", Font.BOLD, 14));
		emailTxtF.setBounds(270, 280, 400, 30);
		add(emailTxtF);

		JLabel maritalStatus = new JLabel("Marital Status:");
		maritalStatus.setFont(new Font("Raleway", Font.BOLD, 20));
		maritalStatus.setBounds(100, 320, 400, 30);
		add(maritalStatus);

		married = new JRadioButton("Married");
		married.setBounds(270, 320, 100, 30);
		married.setBackground(Color.white);

		unmarried = new JRadioButton("Unmarried");
		unmarried.setBounds(370, 320, 100, 30);
		unmarried.setBackground(Color.white);

		other = new JRadioButton("Other");
		other.setBounds(470, 320, 100, 30);
		other.setBackground(Color.white);

		marriageStatusGroup.add(married);
		marriageStatusGroup.add(unmarried);
		marriageStatusGroup.add(other);

		add(married);
		add(unmarried);
		add(other);

		JLabel address = new JLabel("Address:");
		address.setFont(new Font("Raleway", Font.BOLD, 20));
		address.setBounds(100, 360, 400, 30);
		add(address);

		addressTxtF = new JTextField();
		address.setFont(new Font("Raleway", Font.BOLD, 14));
		addressTxtF.setBounds(270, 360, 400, 30);
		add(addressTxtF);

		JLabel city = new JLabel("City:");
		city.setFont(new Font("Raleway", Font.BOLD, 20));
		city.setBounds(100, 400, 400, 30);
		add(city);

		cityTxtF = new JTextField();
		cityTxtF.setFont(new Font("Raleway", Font.BOLD, 14));
		cityTxtF.setBounds(270, 400, 400, 30);
		add(cityTxtF);

		JLabel state = new JLabel("State:");
		state.setFont(new Font("Raleway", Font.BOLD, 20));
		state.setBounds(100, 440, 400, 30);
		add(state);

		stateTxtF = new JTextField();
		stateTxtF.setFont(new Font("Raleway", Font.BOLD, 14));
		stateTxtF.setBounds(270, 440, 400, 30);
		add(stateTxtF);

		JLabel pin = new JLabel("Pin:");
		pin.setFont(new Font("Raleway", Font.BOLD, 20));
		pin.setBounds(100, 480, 400, 30);
		add(pin);

		pinTxtF = new JTextField();
		pinTxtF.setFont(new Font("Raleway", Font.BOLD, 14));
		pinTxtF.setBounds(270, 480, 400, 30);
		add(pinTxtF);

		next = new JButton("Next");
		next.setBackground(Color.black);
		next.setForeground(Color.white);
		next.setFont(new Font("Raleway", Font.BOLD, 20));
		next.setBounds(590, 550, 80, 40);
		next.addActionListener(this);
		add(next);

	}

	public static void main(String[] args) {
		new SignUpOne();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String formno = " " + random;
		String name = nameTxtF.getText();
		String fname = fnameTxtF.getText();

		String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
		String gender = null;
		if (male.isSelected()) {
			gender = "Male";
		} else if (female.isSelected()) {
			gender = "Female";
		}

		String marital = null;
		if (married.isSelected()) {
			marital = "Married";
		} else if (unmarried.isSelected()) {
			marital = "Unmarried";
		} else if (other.isSelected()) {
			marital = "Other";
		}
		String email = emailTxtF.getText();
		String address = addressTxtF.getText();
		String city = cityTxtF.getText();
		String state = stateTxtF.getText();
		String pin = pinTxtF.getText();

		try {

			if (name.equals("")) {
				JOptionPane.showMessageDialog(null, "Name is Required");
			} else {
				Conn c = new Conn();
				
				String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
				c.s.executeUpdate(query);
				
				setVisible(false);
				new SignUpTwo(formno).setVisible(true);
			}
			

		} catch (Exception e2) {
			e2.printStackTrace();
		}

	}

}
