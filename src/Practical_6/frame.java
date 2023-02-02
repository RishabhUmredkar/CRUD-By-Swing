package Practical_6;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class frame
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		JFrame jf = new JFrame("Employee Entry");
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Registered");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Rishabh00","root","abc123");
		System.out.println("Connected");
		
		JLabel lb0 = new JLabel();
		lb0.setBounds(200, 280, 231, 20);
		
		JLabel lb1 = new JLabel("Enter Id ");
		lb1.setBounds(63, 90, 117, 35);
		JTextField tx1 = new JTextField();
		tx1.setBounds(208, 100, 231, 20);
		
		JLabel lb2 = new JLabel("Enter Name ");
		lb2.setBounds(63, 125, 117, 35);
		JTextField tx2 = new JTextField();
		tx2.setBounds(208, 135, 231, 20);

		JLabel lb3 = new JLabel("Enter Address ");
		lb3.setBounds(63, 170, 117, 35);
		JTextField tx3 = new JTextField();
		tx3.setBounds(208, 175, 231, 20);

		
		
		
		
		//////////////////// INSERT //////////////////////////
		
		
		
		JButton b1 = new JButton("click for Insert");
		b1.setBounds(50, 210, 150, 40);
	
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int empno = Integer.parseInt(tx1.getText());
				String empname = tx2.getText();
				String salary = tx3.getText();
				lb0.setText("Info  "+empno+"  "+empname+"   "+salary);
				try {
					PreparedStatement st = con.prepareStatement("insert into Rishabh00.tb values(?,?,?)");
					st.setInt(1, empno);
					st.setString(2, empname);
					st.setString(3, salary);
					
					int a = st.executeUpdate();
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
			}
		});

			
		
		
		
		
		
		////////////////// DELETE  ////////////////////////////
		
		
		JLabel lb4 = new JLabel("Enter Id");
		lb4.setBounds(63, 300, 140, 35);
		JTextField tx4 = new JTextField();
		tx4.setBounds(208, 310, 231, 20);

		JLabel lb00 = new JLabel();
		lb00.setBounds(50, 400, 140, 35);

		JButton b2 = new JButton("click for delete");
		b2.setBounds(50, 360, 150, 40);
		
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				lb00.setText("Data Deleted");
				 int empno = Integer.parseInt(tx4.getText());
				 try {
					PreparedStatement st = con.prepareStatement("delete from Rishabh00.tb where empno= ?");
					System.out.println("statement Created");
					st.setInt(1, empno);
					int a = st.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
			}
		});
	
		

		

		
		////////////////// UPDATE  ////////////////////////////


		JLabel lb001 = new JLabel();
		lb001.setBounds(50, 600, 140, 35);

		JButton b3 = new JButton("click for update");
		b3.setBounds(50, 631, 150, 40);

		JLabel lb5 = new JLabel("Enter Id");
		lb5.setBounds(63, 450, 140, 35);
		JTextField tx5 = new JTextField();
		tx5.setBounds(208, 460, 231, 20);

		JLabel lb6 = new JLabel("Enter New Id");
		lb6.setBounds(63, 500, 140, 35);
		JTextField tx6 = new JTextField();
		tx6.setBounds(208, 500, 231, 20);

		JLabel lb7 = new JLabel("Enter New Name");
		lb7.setBounds(63, 530, 140, 35);
		JTextField tx7 = new JTextField();
		tx7.setBounds(208, 530, 231, 20);

		JLabel lb8 = new JLabel("Enter New Address");
		lb8.setBounds(63, 560, 140, 35);
		JTextField tx8 = new JTextField();
		tx8.setBounds(208, 560, 231, 20);
		
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int empno1 = Integer.parseInt(tx6.getText());
				int empno = Integer.parseInt(tx5.getText());
				String empname = tx7.getText();
				String salary = tx8.getText();
				lb001.setText("Info  "+empno+"  "+empname+"   "+salary);
				try {
					PreparedStatement st = con.prepareStatement("update Rishabh00.tb set empno = ?,empname=?, salary=? where empno=?");
					System.out.println("statement Created");
					st.setInt(1, empno);
					st.setString(2, empname);
					st.setString(3, salary);
					st.setInt(4, empno1);
					
					int a = st.executeUpdate();
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
			}
		});
		
		

		
		////////////////// SEARCH  ////////////////////////////
		
		
		JLabel lb01 = new JLabel("Enter Id");
		lb01.setBounds(50, 720, 140, 35);
		JTextField tx01 = new JTextField();
		tx01.setBounds(210, 720, 231, 20);

		JLabel lb002 = new JLabel();
		lb002.setBounds(70, 820, 140, 35);

		JButton b4 = new JButton("click for Search");
		b4.setBounds(50, 780, 150, 40);
		
		b4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				lb002.setText("Data Search");
				 int empno = Integer.parseInt(tx01.getText());
				 try {
					PreparedStatement st = con.prepareStatement("select * from Rishabh00.tb where empno = ?");
					System.out.println("statement Created");
					st.setInt(1, empno);
					ResultSet r1 = null;
					r1 = st.executeQuery();
					while(r1.next())
					{
						System.out.println("empno : "+r1.getInt("empno")+"\nEmpname:"+r1.getString("empname")+"\nsal:"+r1.getString("salary"));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
			}
		});
	


		

		
		
		
		
		
		
		
		jf.setSize(500,1000);
		jf.setLayout(null);
		jf.setVisible(true);
		
		jf.add(lb0);
		jf.add(lb00);
		jf.add(lb001);
		jf.add(lb002);
		
		jf.add(lb1);
		jf.add(tx1);

		jf.add(lb01);
		jf.add(tx01);
		
		jf.add(lb2);
		jf.add(tx2);
		
		jf.add(lb3);
		jf.add(tx3);
		
		jf.add(b1);

		jf.add(lb4);
		jf.add(tx4);

		jf.add(lb5);
		jf.add(tx5);

		jf.add(lb6);
		jf.add(tx6);

		jf.add(lb7);
		jf.add(tx7);

		jf.add(lb8);
		jf.add(tx8);
		

		jf.add(b2);
		jf.add(b3);
		jf.add(b4);
			
}
}
