
package bank.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class SignUpTwo extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	ButtonGroup seniorCitizenGroup = new ButtonGroup();
	ButtonGroup extAccGroup = new ButtonGroup();

	long random;
	JTextField incomeTxtF, panTxtF, adharTxtF;
	JButton next;
	JRadioButton yes, no, extYes, extNo;
	String formno;

	JComboBox<String> religionCB, categoryCB, incomeCB, EduQualCB, occupationCB;


	public SignUpTwo(String formno) {
		this.formno = formno;
		setLayout(null);
		setSize(850, 700);
		setLocation(350, 60);
		setVisible(true);
		setTitle("New Account Appicaltion Form");
//        setResizable(false);
		getContentPane().setBackground(Color.WHITE);

		JLabel additionalDetails = new JLabel("Page 2: Additional Details");
		additionalDetails.setFont(new Font("Raleway", Font.BOLD, 20));
		additionalDetails.setBounds(290, 80, 400, 30);
		add(additionalDetails);

		JLabel rname = new JLabel("Religon:");
		rname.setFont(new Font("Raleway", Font.BOLD, 20));
		rname.setBounds(100, 120, 400, 30);
		add(rname);

		String religionValue[] = { "Hindu", "Sikh", "Christian", "Other" };
		religionCB = new JComboBox<String>(religionValue);
		religionCB.setBounds(270, 120, 400, 30);
		religionCB.setBackground(Color.WHITE);
		add(religionCB);

		JLabel categoryName = new JLabel("Category:");
		categoryName.setFont(new Font("Raleway", Font.BOLD, 20));
		categoryName.setBounds(100, 160, 400, 30);
		add(categoryName);

		String categoryValue[] = { "Open", "SC", "ST", "OBC", "Other" };
		categoryCB = new JComboBox<String>(categoryValue);
		categoryCB.setBounds(270, 160, 400, 30);
		categoryCB.setBackground(Color.WHITE);
		add(categoryCB);

		JLabel dob = new JLabel("Income:");
		dob.setFont(new Font("Raleway", Font.BOLD, 20));
		dob.setBounds(100, 200, 400, 30);
		add(dob);

		String incomeValue[] = { "Null", "< 1,50,000", "< 2,50,000", "Upto 10 Lakhs" };
		incomeCB = new JComboBox<String>(incomeValue);
		incomeCB.setBounds(270, 200, 400, 30);
		add(incomeCB);

		JLabel educational = new JLabel("Educational");
		educational.setFont(new Font("Raleway", Font.BOLD, 20));
		educational.setBounds(100, 240, 400, 30);
		add(educational);

		JLabel qualification = new JLabel("Qualification:");
		qualification.setFont(new Font("Raleway", Font.BOLD, 20));
		qualification.setBounds(100, 260, 400, 30);
		add(qualification);

		String educationValue[] = { "SSC", "HSC", "Graduation", "Post-Graduation", "Others" };
		EduQualCB = new JComboBox<String>(educationValue);
		EduQualCB.setBounds(270, 260, 400, 30);
		add(EduQualCB);

		JLabel maritalStatus = new JLabel("Occupation:");
		maritalStatus.setFont(new Font("Raleway", Font.BOLD, 20));
		maritalStatus.setBounds(100, 320, 400, 30);
		add(maritalStatus);

		String occupationValue[] = { "Salaried", "Self-Employed", "Business Owner", "Student", "Others" };
		occupationCB = new JComboBox<String>(occupationValue);
		occupationCB.setBounds(270, 320, 400, 30);
		occupationCB.setBackground(Color.white);
		add(occupationCB);

		JLabel address = new JLabel("PAN No:");
		address.setFont(new Font("Raleway", Font.BOLD, 20));
		address.setBounds(100, 360, 400, 30);
		add(address);

		panTxtF = new JTextField();
		panTxtF.setFont(new Font("Raleway", Font.BOLD, 20));
		panTxtF.setBounds(270, 360, 400, 30);
		add(panTxtF);

		JLabel adhar = new JLabel("AdharCard No:");
		adhar.setFont(new Font("Raleway", Font.BOLD, 20));
		adhar.setBounds(100, 400, 400, 30);
		add(adhar);

		adharTxtF = new JTextField();
		adharTxtF.setFont(new Font("Raleway", Font.BOLD, 14));
		adharTxtF.setBounds(270, 400, 400, 30);
		add(adharTxtF);

		JLabel state = new JLabel("Senior Citizen:");
		state.setFont(new Font("Raleway", Font.BOLD, 20));
		state.setBounds(100, 440, 400, 30);
		add(state);

		yes = new JRadioButton("Yes");
		yes.setBounds(270, 440, 60, 30);
		yes.setBackground(Color.white);

		no = new JRadioButton("No");
		no.setBounds(330, 440, 80, 30);
		no.setBackground(Color.white);

		seniorCitizenGroup.add(yes);
		seniorCitizenGroup.add(no);

		add(yes);
		add(no);

		JLabel pin = new JLabel("Existing Account:");
		pin.setFont(new Font("Raleway", Font.BOLD, 20));
		pin.setBounds(100, 480, 400, 30);
		add(pin);

		extYes = new JRadioButton("Yes");
		extYes.setBounds(270, 480, 60, 30);
		extYes.setBackground(Color.white);

		extNo = new JRadioButton("No");
		extNo.setBounds(330, 480, 80, 30);
		extNo.setBackground(Color.white);

		extAccGroup.add(extYes);
		extAccGroup.add(extNo);

		add(extYes);
		add(extNo);

		next = new JButton("Next");
		next.setBackground(Color.black);
		next.setForeground(Color.white);
		next.setFont(new Font("Raleway", Font.BOLD, 20));
		next.setBounds(590, 550, 80, 40);
		next.addActionListener(this);
		add(next);

	}

	public static void main(String[] args) {
		new SignUpTwo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String religion = (String) religionCB.getSelectedItem();
		String category = (String) categoryCB.getSelectedItem();

		String income = (String) incomeCB.getSelectedItem();

		String education = (String) EduQualCB.getSelectedItem();
		String occupation = (String) occupationCB.getSelectedItem();

		String seniorCitizen = null;

		if (yes.isSelected()) {
			seniorCitizen = "Yes";
		} else if (no.isSelected()) {
			seniorCitizen = "No";
		}

		String extAccount = null;

		if (extYes.isSelected()) {
			extAccount = "Yes";
		} else if (extNo.isSelected()) {
			extAccount = "No";
		}
		String pan = panTxtF.getText();
		String adhar = adharTxtF.getText();

		try {

			Conn c = new Conn();

			String query = "insert into singUpTwo values('" + formno + "','" + religion + "','" + category + "','" + income
					+ "','" + education + "','" + occupation + "','" + pan + "','" + adhar + "','" + seniorCitizen
					+ "','" + extAccount + "')";
			        c.s.executeUpdate(query);
			        setVisible(false);
			        new SignUpThree(formno).setVisible(true);

			// next create signUp3 Class

		} catch (Exception e2) {
			e2.printStackTrace();
		}

	}

}
