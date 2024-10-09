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

public class Depertnment extends JFrame implements ActionListener {

	JLabel depert;
	JLabel fund ;
	JButton back;
	JTable table;
	Depertnment(){
		
		
		setBounds(200,150,700,590);
		setLayout(null);
	getContentPane().setBackground(Color.white);
	
	depert = new JLabel("Depertment");
	depert.setBounds(150,20,100,20);
	depert.setFont(new Font("Georgia",Font.BOLD,12));
	depert.setForeground(Color.red);
add(depert);


fund = new JLabel("Funds");
fund.setBounds(400,20,100,20);
fund.setFont(new Font("Georgia",Font.BOLD,12));
fund.setForeground(Color.red);
add(fund);
		



//table 
	 table = new JTable();
	 table.setBounds(50,50,550,450);
	 add(table);
	 
	 // taking data from database Rooms and placed that data on table 
	 
	 // connecting to database 
	 
	 try {
		Conn con = new Conn();
		
		ResultSet rs =con.stmt.executeQuery("select*from deprtfundsdetails");
		
		
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
	 back.setBounds(200,500,150,30);
	 back.setFont(new Font("Georgia",Font.PLAIN,15));
	 back.setBackground(Color.black);
	 back.setForeground(Color.white);
	 back.addActionListener(this);
	add(back);
	
	
	setVisible(true);
	
	}


	
	public static void main(String[] args) {
	new Depertnment();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==back) {
			setVisible(false);
			
			new Reception();
			
			}
	}

}
