package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	JButton cancel, withdraw;
	JTextField amount;
	String pin;

	public Withdrawl(String pin) {

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

		JLabel text = new JLabel("Enter the amount you want to withdraw");
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

		withdraw = new JButton("Withdraw");
		withdraw.setBounds(520, 440, 150, 30);
		withdraw.setBackground(Color.lightGray);
		withdraw.setBorderPainted(false);
		withdraw.addActionListener(this);
		image.add(withdraw);

		cancel = new JButton("Cancel");
		cancel.setBounds(520, 480, 150, 30);
		cancel.setBackground(Color.lightGray);
		cancel.setBorderPainted(false);
		cancel.addActionListener(this);
		image.add(cancel);
	}

	public static void main(String[] args) {
		new Withdrawl(null);

	}

	@Override
	 public void actionPerformed(ActionEvent ae){
        try{        
            String num = amount.getText();
            Date date = new Date();
            if(ae.getSource()==withdraw){
                if(num.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
                }else{
                    Conn c1 = new Conn();
                    
                    ResultSet rs = c1.s.executeQuery("select * from bank where pin = '"+pin+"'");
                    int balance = 0;
                    while(rs.next()){
                       if(rs.getString("type").equals("Deposit")){
                           balance += Integer.parseInt(rs.getString("amount"));
                       }else{
                           balance -= Integer.parseInt(rs.getString("amount"));
                       }
                    }
                    if(balance < Integer.parseInt(num)){
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    }
                    
                    c1.s.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Withdrawl', '"+num+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+num+" Debited Successfully");
                    
                    setVisible(false);
                    new Transaction(pin).setVisible(true);
                }
            }else if(ae.getSource()==cancel){
                setVisible(false);
                new Transaction(pin).setVisible(true);
            }
        }catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
        }
            
    }

}
