import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

//this class implements actionlistener interface and is basically logic and ui code for login form
class LoginForm implements ActionListener{
	//variable declaration
	private static JFrame frame;
	private static JPanel nPanel,cPanel;
	private static JPanel mPanel;
	private static JLabel username,password,blank1,blank2,title;
	private static JTextField userText;
	private static JPasswordField passText;
	private static JButton login,bjp,congress;
	
	public LoginForm()
	{
		frame = new JFrame("Login Page");
		mPanel = new JPanel();
		nPanel = new JPanel();
		cPanel = new JPanel();
		username = new JLabel("Username");
		password = new JLabel("Password");
		userText = new JTextField(100);
		passText = new JPasswordField();
		login = new JButton("Login");
		bjp = new JButton("Bhartiya Janta Party(BJP)");
		congress = new JButton("Indian National Congress");
		blank1 = new JLabel(new ImageIcon("src/download.png"));
		blank2 = new JLabel(new ImageIcon("src/hand.png"));
		title = new JLabel("Vote For Your Right");
		
		//mPanel
		mPanel.setLayout(new BorderLayout());
		mPanel.add(nPanel,BorderLayout.NORTH);
		mPanel.add(cPanel, BorderLayout.CENTER);
		
		//nPanel
		nPanel.setBackground(new Color(251,153,51));
		nPanel.setPreferredSize(new Dimension(0, 100));
		nPanel.setLayout(null);
		nPanel.add(username);
		username.setBounds(50,20,100,50);
		username.setFont(new Font("Calibri",Font.BOLD,22));
		username.setForeground(Color.WHITE);
		nPanel.add(userText);
		userText.setBounds(155,32,150,25);
		nPanel.add(password);
		password.setBounds(350,21,100,50);
		password.setFont(new Font("Calibri",Font.BOLD,22));
		password.setForeground(Color.WHITE);
		nPanel.add(passText);
		passText.setBounds(455,32,150,25);
		nPanel.add(login);
		login.setBounds(650,25,80,40);
		login.setBorder(BorderFactory.createLineBorder(Color.white, 5, true));
		login.setBackground(new Color(251,153,31));
		login.setForeground(Color.white);
		login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==login)
				{
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","admin");	
						PreparedStatement pr=con.prepareStatement("select * from vote_form where username=? and password=?");
						pr.setString(1,userText.getText());
						pr.setString(2,passText.getText());
						ResultSet rs=pr.executeQuery();
						if(rs.next())
						{
									JOptionPane.showConfirmDialog(frame, "Login Success!!!!");
									cPanel.setVisible(true);
									
						}
						else
						{
							JOptionPane.showConfirmDialog(frame, "Login UnSuccess!!!! Please Try Again");
							cPanel.setVisible(false);
						}
					}
					catch(Exception ee)
					{
								System.out.println(ee);
						
					}
			
				}
			}
		});
		
		//cPanel
		cPanel.setVisible(false);
		cPanel.setBackground(Color.BLUE);
		cPanel.setLayout(null);
		cPanel.add(blank1);
		blank1.setBounds(100, 200, 200, 200);
		cPanel.add(bjp);
		bjp.setBounds(500, 260, 350, 100);
		cPanel.add(blank2);
		blank2.setBounds(100, 500, 200, 200);
		cPanel.add(congress);
		congress.setBounds(500, 550, 350, 100);
		cPanel.add(title);
		title.setBounds(350, 50, 300, 50);
		title.setFont(new Font("Calibri",Font.BOLD,30));
		title.setForeground(Color.white);
		bjp.setFont(new Font("Calibri",Font.BOLD,30));
		congress.setFont(new Font("Calibri",Font.BOLD,30));
		bjp.setBackground(null);
		bjp.setForeground(Color.white);
		congress.setBackground(null);
		congress.setForeground(Color.white);
		bjp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","admin");	
					PreparedStatement pr=con.prepareStatement("insert into votes values(?,?)");
					pr.setString(1,"BJP");
					pr.setString(2,"1");
					pr.executeUpdate();
					JOptionPane.showConfirmDialog(frame, "vote registered");
					cPanel.setVisible(false);
				}
				catch(Exception ee)
				{
							System.out.println(ee);
					
				}
			}
		});
		congress.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","admin");	
					PreparedStatement pr=con.prepareStatement("insert into votes values(?,?)");
					pr.setString(1,"Congress");
					pr.setString(2,"1");
					pr.executeUpdate();
					JOptionPane.showConfirmDialog(frame, "vote registered");
					cPanel.setVisible(false);
				}
				catch(Exception ee)
				{
							System.out.println(ee);
					
				}
			}
		});
		
		
		
		//frame setup
		frame.add(mPanel);
		frame.setSize(1000,1000);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//memory allocation
		new LoginForm();



}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	}
