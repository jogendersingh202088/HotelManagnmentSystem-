package hotel.managnment.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class ManagerInfo extends JFrame implements ActionListener {

	
	JLabel  name , age , salary ,phone,email,aadhar,gender,job ;
	JTable table ;
	JButton back;
	ManagerInfo(){
		
	
	
			setBounds(20,70,1500,690);
			setLayout(null);
		getContentPane().setBackground(Color.white);
		
		name = new JLabel("Name");
		name.setBounds(85,20,100,20);
		name.setFont(new Font("Georgia",Font.BOLD,12));
		name.setForeground(Color.red);
	add(name);


	age = new JLabel("Age");
	age.setBounds(250,20,100,20);
	age.setFont(new Font("Georgia",Font.BOLD,12));
	age.setForeground(Color.red);
	add(age);
		
	salary = new JLabel("Salary");
	salary.setBounds(430,20,100,20);
	salary.setFont(new Font("Georgia",Font.BOLD,12));
	salary.setForeground(Color.red);
	add(salary);

	phone = new JLabel("Phone");
	phone.setBounds(600,20,100,20);
	phone.setFont(new Font("Georgia",Font.BOLD,12));
	phone.setForeground(Color.red);
	add(phone);

	email = new JLabel("Email");
	email.setBounds(800,20,100,20);
	email.setFont(new Font("Georgia",Font.BOLD,12));
	email.setForeground(Color.red);
	add(email);

	aadhar = new JLabel("AAdhar");
	aadhar.setBounds(930,20,100,20);
	aadhar.setFont(new Font("Georgia",Font.BOLD,12));
	aadhar.setForeground(Color.red);
	add(aadhar);

	gender = new JLabel("Gender");
	gender.setBounds(1100,20,100,20);
	gender.setFont(new Font("Georgia",Font.BOLD,12));
	gender.setForeground(Color.red);
	add(gender);

	job = new JLabel("Job");
	job.setBounds(1300,20,100,20);
	job.setFont(new Font("Georgia",Font.BOLD,12));
	job.setForeground(Color.red);
	add(job);

		
		// table 
		 table = new JTable();
		 table.setBounds(20,60,1400,520);
		 add(table);
		 
		 // taking data from database Rooms and placed that data on table 
		 
		 // connecting to database 
		 
		 try {
			Conn con = new Conn();
			
			ResultSet rs =con.stmt.executeQuery("select*from employee where job = 'Manager'");
			
			
			// taking data to database and set into table lable 
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		}
		
		 back = new JButton("Back");
		 back.setBounds(650,590,100,40);
		 back.setFont(new Font("Georgia",Font.PLAIN,15));
		 back.setBackground(Color.black);
		 back.setForeground(Color.white);
		 back.addActionListener(this);
		add(back);
		
		
		setVisible(true);
		
		}
		
	
	public static void main(String[] args) {
		new ManagerInfo();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back) {
			setVisible(false);
			
			new Reception();
			
			}
		
	}

}
