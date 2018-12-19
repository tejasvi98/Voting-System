import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.sql.*;

public class Result {

	//object and variable declaration
	JFrame frame;
	JPanel panel;
	JTable table;
	JScrollPane sp;
	DefaultTableModel model;
	String ColsStr[]={"party","votes"};
	
	public Result()
	{
		//memory allocation
		frame = new JFrame("Result");
		panel = new JPanel();			
		model=new DefaultTableModel(ColsStr, 0);
		table=new JTable(model);
		sp=new JScrollPane(table);
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","admin");	
			PreparedStatement pr=con.prepareStatement("select sum(number_of_votes),party from votes group by party");
			ResultSet rs=pr.executeQuery();
			while(rs.next())
			{
							String party=rs.getString(2);
							String votes=rs.getString(1);
							model.addRow(new String[]{party,votes});	
			}
		}
		catch(Exception ee)
		{
					System.out.println(ee);
			
		}
		
		
		//frame setup
		frame.add(panel);
		panel.add(sp);
		frame.setVisible(true);
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Result();
	}

}
