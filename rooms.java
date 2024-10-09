package hotel.managnment.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import net.proteanit.sql.*;


public class rooms extends JFrame implements ActionListener{

	
	JLabel image , roomnumber , status , clean ,price,type ;
	JTable table ;
	
	JButton back;
	rooms(){
		setBounds(200,150,1100,590);
		setLayout(null);
	getContentPane().setBackground(Color.white);
	
	roomnumber = new JLabel("Room Number");
	roomnumber.setBounds(25,20,100,20);
	roomnumber.setFont(new Font("Georgia",Font.BOLD,12));
	roomnumber.setForeground(Color.red);
add(roomnumber);


status = new JLabel("Availability");
status.setBounds(140,20,100,20);
status.setFont(new Font("Georgia",Font.BOLD,12));
status.setForeground(Color.red);
add(status);
	
clean = new JLabel("Status");
clean.setBounds(260,20,100,20);
clean.setFont(new Font("Georgia",Font.BOLD,12));
clean.setForeground(Color.red);
add(clean);

price = new JLabel("Price");
price.setBounds(380,20,100,20);
price.setFont(new Font("Georgia",Font.BOLD,12));
price.setForeground(Color.red);
add(price);

type = new JLabel("Type");
type.setBounds(480,20,100,20);
type.setFont(new Font("Georgia",Font.BOLD,12));
type.setForeground(Color.red);
add(type);
	
	
	ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons1/eight.jpg"));
	
	// saclling image
	
	Image i2 = i1.getImage().getScaledInstance(450, 500, Image.SCALE_DEFAULT);
	ImageIcon i3 = new ImageIcon(i2);
	
	image = new JLabel(i3);
	image.setBounds(600,25,450,500);
	add(image);
	
	// table 
	 table = new JTable();
	 table.setBounds(20,50,550,450);
	 add(table);
	 
	 // taking data from database Rooms and placed that data on table 
	 
	 // connecting to database 
	 
	 try {
		Conn con = new Conn();
		
		ResultSet rs =con.stmt.executeQuery("select*from rooms");
		
		
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
		
		new rooms();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back) {
		setVisible(false);
		
		new Reception();
		
		}
	}

}
