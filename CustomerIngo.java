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

public class CustomerIngo extends JFrame implements ActionListener {

	
	JLabel  deposit,id,number,name,gender,country,allocatedrooms,checkintime ;
	JTable table ;
	JButton back;
	CustomerIngo(){
		
	
	
			setBounds(20,70,1500,690);
			setLayout(null);
		getContentPane().setBackground(Color.white);
		
		id = new JLabel("ID");
		id.setBounds(85,20,100,20);
		id.setFont(new Font("Georgia",Font.BOLD,12));
		id.setForeground(Color.red);
	add(id);


	number = new JLabel("Number");
	number.setBounds(250,20,100,20);
	number.setFont(new Font("Georgia",Font.BOLD,12));
	number.setForeground(Color.red);
	add(number);
		
	name = new JLabel("Name");
	name.setBounds(430,20,100,20);
	name.setFont(new Font("Georgia",Font.BOLD,12));
	name.setForeground(Color.red);
	add(name);

	gender = new JLabel("Gender");
	gender.setBounds(600,20,100,20);
	gender.setFont(new Font("Georgia",Font.BOLD,12));
	gender.setForeground(Color.red);
	add(gender);

	country = new JLabel("Country");
	country.setBounds(800,20,100,20);
	country.setFont(new Font("Georgia",Font.BOLD,12));
	country.setForeground(Color.red);
	add(country);

	allocatedrooms = new JLabel("Allocated Room");
	allocatedrooms.setBounds(930,20,100,20);
	allocatedrooms.setFont(new Font("Georgia",Font.BOLD,12));
	allocatedrooms.setForeground(Color.red);
	add(allocatedrooms);

	checkintime = new JLabel("CheckInTime");
	checkintime.setBounds(1100,20,100,20);
	checkintime.setFont(new Font("Georgia",Font.BOLD,12));
	checkintime.setForeground(Color.red);
	add(checkintime);

	deposit = new JLabel("Deposite");
	deposit.setBounds(1300,20,100,20);
	deposit.setFont(new Font("Georgia",Font.BOLD,12));
	deposit.setForeground(Color.red);
	add(deposit);

		
		// table 
		 table = new JTable();
		 table.setBounds(20,60,1400,520);
		 add(table);
		 
		 // taking data from database Rooms and placed that data on table 
		 
		 // connecting to database 
		 
		 try {
			Conn con = new Conn();
			
			ResultSet rs =con.stmt.executeQuery("select*from newcustomer");
			
			
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
		new CustomerIngo();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back) {
			setVisible(false);
			
			new Reception();
			
			}
		
	}

}

