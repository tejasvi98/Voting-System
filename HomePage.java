import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

class HomePage extends JPanel implements ActionListener {
//object and variable declaration
// home page of application voting system
	private JFrame frame;
	private JPanel mPanel,cPanel;
	private MyPanel nPanel;
	private JButton bLogin,bRegister,bResult,bContact;
	JOptionPane msg;
	public void createLayout()
	{
		//memory allocation of objects
		frame = new JFrame("VOTING SYSTEM");
		mPanel = new JPanel();
		nPanel = new MyPanel("src/download.jpg",800,480);
		cPanel = new JPanel();
		bLogin = new JButton("LOGIN");
		bRegister = new JButton("REGISTER");
		bResult = new JButton("VIEW RESULT");
		bContact = new JButton("CONTACT");
		

		
		//setting panels
		//mPanel
		mPanel.setLayout(new BorderLayout());
		mPanel.setBackground(Color.blue);
		
		//nPanel
		mPanel.add(nPanel, BorderLayout.NORTH);
		//nPanel.setBackground(Color.GREEN);
		nPanel.setPreferredSize(new Dimension(640, 480));
		nPanel.setLayout(null);

		
		
		//cPanel
		mPanel.add(cPanel, BorderLayout.CENTER);
		cPanel.setBackground(Color.orange);
		cPanel.setLayout(null);
		cPanel.add(bLogin);
		cPanel.add(bRegister);
		cPanel.add(bResult);
		bResult.setBounds(330, 200, 130, 50);
		bResult.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, Color.WHITE, new Color(0,0,128)));
		bResult.setBackground(Color.WHITE);
		bResult.setFont(new Font("Calibri",Font.BOLD,20));
		bResult.setForeground(new Color(0,0,128));
		bResult.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Result();
			}
		});
		cPanel.add(bContact);
		bContact.setBounds(330, 270, 130, 50);
		bContact.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, Color.GREEN, Color.BLACK));
		bContact.setBackground(Color.GREEN);
		bContact.setFont(new Font("Calibri",Font.BOLD,20));
		bContact.setForeground(new Color(0,0,128));
		bContact.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				msg.showMessageDialog(frame, "Contact Tejasvi Gupta", "Contact us:- ", UNDEFINED_CONDITION);
			}
		});
		
		//for login button
		bLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new LoginForm();
			}
		});
		bLogin.setBounds(330, 60, 130, 50);
		bLogin.setFont(new Font("Calibri",Font.BOLD,20));
		bLogin.setBackground(new Color(255,153,51));
		bLogin.setForeground(new Color(0,0,128));
		bLogin.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new Color(255,153,51), Color.BLACK));
		
		//register button
		bRegister.setBounds(330, 130, 130, 50);
		bRegister.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, Color.WHITE, new Color(0,0,128)));
		bRegister.setBackground(Color.WHITE);
		bRegister.setFont(new Font("Calibri",Font.BOLD,20));
		bRegister.setForeground(new Color(0,0,128));
		bRegister.addActionListener(this);
		
		
		//frame setup
		frame.setVisible(true);
		frame.add(mPanel);
		frame.setSize(800, 1000);
		frame.setLocationRelativeTo(null);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HomePage hm = new HomePage();
		hm.createLayout();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == bRegister)
		{
			new RegistrationForm();
		}
		
	}

}
