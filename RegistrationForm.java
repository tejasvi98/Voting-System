import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class RegistrationForm  {
	
	private JFrame frame;
	private JPanel panel;
	private JTextField userText,mobileNumber;
	private JPasswordField passText;
	private JLabel label1,user,pass,mobNum,dob,gender;
	private JButton signUp;
	private JRadioButton male,female;
	private String month[] = {"Month","January","February","March","April","May","June","July","August","September","October","November","December"};
	private String date[]={"DATE","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	private String year[] = {"YEAR","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000"};
	private JComboBox dateBox,monthBox,yearBox;
	private ButtonGroup group;
	private String s;
	private JOptionPane msg;


	public RegistrationForm() {
		frame = new JFrame("Registration Page");
		panel = new JPanel();
		label1 = new JLabel("Enter Your Details");
		user = new JLabel("Username");
		userText = new JTextField(50);
		passText = new JPasswordField(50);
		pass = new JLabel("Password");
		mobNum = new JLabel("Mobile Number");
		mobileNumber = new JTextField(50);
		dateBox = new JComboBox(date);
		dob = new JLabel("Date Of Birth");
		monthBox = new JComboBox(month);
		yearBox = new JComboBox(year);
		gender = new JLabel("Gender");
		male = new JRadioButton("MALE");
		female = new JRadioButton("FEMALE");
		signUp = new JButton("SIGN UP");
		group = new ButtonGroup();
		panel.setLayout(null);
		
		
		panel.add(label1);
		label1.setForeground(Color.white);
		label1.setFont(new Font("Calibri", Font.BOLD, 40));
		panel.add(user);
		user.setForeground(Color.white);
		user.setFont(new Font("Calibri", Font.PLAIN,30));
		panel.add(userText);
		panel.add(pass);
		pass.setForeground(Color.white);
		pass.setFont(new Font("Calibri", Font.PLAIN,30));
		panel.add(passText);
		panel.add(mobNum);
		mobNum.setForeground(Color.white);
		mobNum.setFont(new Font("Calibri", Font.PLAIN,30));
		panel.add(mobileNumber);
		panel.add(dob);
		dob.setForeground(Color.white);
		dob.setFont(new Font("Calibri", Font.PLAIN,30));
		panel.add(dateBox);
		panel.add(monthBox);
		panel.add(yearBox);
		panel.add(gender);
		gender.setForeground(Color.white);
		gender.setFont(new Font("Calibri", Font.PLAIN,30));
		panel.add(male);
		male.setForeground(Color.white);
		male.setFont(new Font("Calibri", Font.PLAIN,20));
		male.setOpaque(false);
		panel.add(female);
		female.setForeground(Color.white);
		female.setFont(new Font("Calibri", Font.PLAIN,20));
		female.setOpaque(false);
		panel.add(signUp);
		signUp.setForeground(Color.white);
		signUp.setBackground(new Color(0,0,128));
		signUp.setBorder(BorderFactory.createEtchedBorder(Color.white, Color.WHITE));
		signUp.setFont(new Font("Calibri", Font.BOLD,20));
		group.add(male);
		group.add(female);


		signUp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","admin");
					PreparedStatement pr=con.prepareStatement("insert into vote_form values(?,?,?,?,?)");
					s = dateBox.getSelectedItem() + "/" + monthBox.getSelectedItem() + "/" + yearBox.getSelectedItem();
					pr.setString(1, userText.getText());
					pr.setString(2, passText.getText().toString());
					pr.setString(3, mobileNumber.getText());
					pr.setString(4, s);
					if(male.isSelected()) 
				        pr.setString(5, "Male");
				else if(female.isSelected()) 
				        pr.setString(5,  "Female");
					
					
					
					int res = pr.executeUpdate();
					if(res>0)
					{
						msg.showMessageDialog(frame, "Success  Registration ");
					}
				}
				catch(Exception ee)
				{
							System.out.println(ee);
				}
			}
		});
		
		
		panel.setBackground(new Color(0,0,128));
		label1.setBounds(50, 10,1000 ,120);
		user.setBounds(50, 115, 200, 100);
		userText.setBounds(200, 150, 200, 30);
		pass.setBounds(50, 165, 200, 100);
		passText.setBounds(200, 200, 200, 30);
		mobNum.setBounds(50,215,200,100);
		mobileNumber.setBounds(270, 250,200,30);
		dob.setBounds(50,270,200,100);
		dateBox.setBounds(240,305,100,30);
		monthBox.setBounds(350,305,100,30);
		yearBox.setBounds(460,305,100,30);
		gender.setBounds(50,320,200,100);
		male.setBounds(170,345,80,50);
		female.setBounds(260,345,100,50);
		signUp.setBounds(400,470,120,50);
		frame.setResizable(false);
		frame.setSize(1000,1000);
		frame.setVisible(true);
		frame.add(panel);
		frame.setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new RegistrationForm();
	}

	


}
