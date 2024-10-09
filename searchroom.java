package hotel.managnment.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class searchroom extends JFrame implements ActionListener{
		JLabel heading ;
		
		JLabel searchbox , roomnumber,available,cleaningstatus,price,bed;
		JComboBox bedtype;
		JCheckBox display;
		JTable table;
		JButton submit , back;
		
		
	searchroom(){
		
		setLayout(null);
		setBounds(340,70,900,700);
		
		getContentPane().setBackground(Color.white);
		
		heading = new JLabel("Search For Room");
		heading.setBounds(320,30,600,50);
		heading.setForeground(Color.red);
		heading.setFont(new Font("Georgia",Font.BOLD,25));
		add(heading);
		
		
		searchbox = new JLabel("Room Bed Type");
		searchbox.setBounds(40,120,400,30);
		searchbox.setForeground(Color.black);
		searchbox.setFont(new Font("Georgia",Font.BOLD,15));
		add(searchbox);
		
		
		String box[] = {"Single Bed" ,"Double Bed"};
		
		
		
		bedtype = new JComboBox(box);
		bedtype.setBounds(200,123,160,25);
		bedtype.setForeground(Color.black);
		bedtype.setFont(new Font("Georgia",Font.BOLD,15));
		add(bedtype);
		
		
		display = new JCheckBox("Only Display Available");
		display.setBounds(550,120,400,30);
		display.setForeground(Color.black);
		display.setFont(new Font("Georgia",Font.BOLD,15));
		display.setBackground(Color.white);
		add(display);
		
		
		
		roomnumber = new JLabel("Room Number");
		roomnumber.setBounds(40,200,200,30);
		roomnumber.setForeground(Color.red);
		roomnumber.setFont(new Font("Georgia",Font.PLAIN,15));
		add(roomnumber);
		
		available = new JLabel("Availaiblity");
		available.setBounds(220,200,200,30);
		available.setForeground(Color.red);
		available.setFont(new Font("Georgia",Font.PLAIN,15));
		add(available);
		cleaningstatus = new JLabel("Cleaning Status");
		cleaningstatus.setBounds(370,200,200,30);
		cleaningstatus.setForeground(Color.red);
		cleaningstatus.setFont(new Font("Georgia",Font.PLAIN,15));
		add(cleaningstatus);
		
		price = new JLabel("Price");
		price.setBounds(570,200,200,30);
		price.setForeground(Color.red);
		price.setFont(new Font("Georgia",Font.PLAIN,15));
		add(price);
		bed = new JLabel("Bed Type");
		bed.setBounds(700,200,200,30);
		bed.setForeground(Color.red);
		bed.setFont(new Font("Georgia",Font.PLAIN,15));
		add(bed);
		
		
		// table 
   table = new JTable();
   table.setBounds(40,250,800,300);
   add(table);
   
   // get data from table
   
   try {
	Conn con = new Conn();
	
	
	String query = "select*from rooms ";
	
	ResultSet rs = con.stmt.executeQuery(query);
	
	table.setModel(DbUtils.resultSetToTableModel(rs));
	
	
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	
	
	
	submit = new JButton ("Submit");
	submit.setBounds(300,600,100,30);
	submit.setFont(new Font("Georgia",Font.BOLD,15));
	submit.setBackground(Color.black);
	submit.setForeground(Color.white);
	submit.addActionListener(this);
	add(submit);
	
	 back = new JButton("Back");
	 back.setBounds(420,600,100,30);
	 back.setFont(new Font("Georgia",Font.BOLD,15));
	 back.setBackground(Color.black);
	 back.setForeground(Color.white);
	 back.addActionListener(this);
	add(back);
		setVisible(true);
	
		
		
		
	}
	public static void main(String[]args){
		
		new searchroom();
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	
	if(e.getSource()==submit) {
		
		try {
			Conn conn = new Conn();
		
		
		String query1 = "select*from rooms where Type = '"+bedtype.getSelectedItem()+"'";
		String query2 =  "select*from rooms where Available = 'Avlaible' AND Type = '"+bedtype.getSelectedItem()+"'";
		ResultSet rs ;
		
		
		if(display.isSelected()) {
			
		 rs = conn.stmt.executeQuery(query2);
			
			
		}
		else {
		 rs = conn.stmt.executeQuery(query1);
		}
	
		table.setModel(DbUtils.resultSetToTableModel(rs));
		
		} 
		
		
		
		catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	else {
		setVisible(false);
		new Reception();
		
		
	}
		
		
	}

}
