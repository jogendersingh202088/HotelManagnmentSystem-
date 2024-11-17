package hotel.managnment.system;

import java.awt.Choice;
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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mysql.cj.protocol.Resultset;

public class updatestatus extends JFrame implements ActionListener {

	JLabel heading ,id ,roomnumber,checkin,pending,paid,image ;
	Choice customerid ;
	JTextField txtroom,checkintime,txtpending,txtpaid;
	JButton check,update,back;
	
	updatestatus(){
		
		getContentPane().setBackground(Color.white);
		
		setBounds(300,200,980,500);
		
		setLayout(null);
		
		heading = new JLabel("Update Status");
		heading.setBounds(400,20,600,50);
		heading.setForeground(Color.red);
		heading.setFont(new Font("Georgia",Font.BOLD,20));
		add(heading);
		
		id= new JLabel("Customer ID ");
		id.setBounds(60,100,170,30);
		id.setFont(new Font("Georgia",Font.BOLD,15));
		add(id);
		
		customerid = new Choice();
		customerid.setBounds(240,100,150,32);
		customerid.setFont(new Font("Georgia",Font.PLAIN,15));
		add(customerid);
		
		
		roomnumber = new JLabel("Room Number");
		roomnumber.setBounds(60,150,150,30);
		roomnumber.setFont(new Font("Georgia",Font.BOLD,15));
		add(roomnumber);
		
		txtroom = new JTextField();
		txtroom.setBounds(240,150,150,30);
		txtroom.setFont(new Font("Georgia",Font.BOLD,15));
		add(txtroom);
		
		
		
		checkin = new JLabel("Check In");
		checkin.setBounds(60,200,150,30);
		checkin.setFont(new Font("Georgia",Font.BOLD,15));
		add(checkin);
		
		checkintime = new JTextField();
		checkintime.setBounds(240,200,150,30);
		checkintime.setFont(new Font("Georgia",Font.BOLD,15));
		add(checkintime);
		
		
		paid = new JLabel("Amount Paid");
		paid.setBounds(60,250,150,30);
		paid.setFont(new Font("Georgia",Font.BOLD,15));
		add(paid);
		
		txtpaid = new JTextField();
		txtpaid.setBounds(240,250,150,30);
		txtpaid.setFont(new Font("Georgia",Font.BOLD,15));
		add(txtpaid);
		
		 pending= new JLabel("Amount Pending");
		 pending.setBounds(60,300,150,30);
		 pending.setFont(new Font("Georgia",Font.BOLD,15));
		add(pending);
		
		txtpending = new JTextField();
		txtpending.setBounds(240,300,150,30);
		txtpending.setFont(new Font("Georgia",Font.BOLD,15));
		add(txtpending);
		
		
		
		check = new JButton ("Check");
		check.setBounds(60,370,100,30);
		check.setFont(new Font("Georgia",Font.BOLD,15));
		check.setBackground(Color.black);
		check.setForeground(Color.white);
		check.addActionListener(this);
		add(check);
		
		
		update = new JButton ("Update");
		update.setBounds(210,370,100,30);
		update.setFont(new Font("Georgia",Font.BOLD,15));
		update.setBackground(Color.black);
		update.setForeground(Color.white);
		update.addActionListener(this);
		add(update);
		
		back = new JButton ("Back");
		back.setBounds(360,370,100,30);
		back.setFont(new Font("Georgia",Font.BOLD,15));
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.addActionListener(this);
		add(back);
		
		try {
			Conn conn = new Conn();
		   
			String query = "select*from newcustomer";
			
			ResultSet rs = conn.stmt.executeQuery(query);
		
			while(rs.next()) {
				customerid.add(rs.getString("Number"));
				
				
			}
		
		
		}
		
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons1/nine.jpg"));

			image = new JLabel(i1);	
		image.setBounds(450,60,500,300);
		add(image);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		setVisible(true);
		
		
		
	}
	public static void main(String[] args) {
		 new  updatestatus();

	}

	@Override
	public void actionPerformed(ActionEvent e1) {
	if(e1.getSource()==check) {
		
		try {
	
			Conn conn = new Conn();
			
			 String query1 = "select*from newcustomer  where Number = '"+customerid.getSelectedItem()+"'";
			 ResultSet rs1 = conn.stmt.executeQuery(query1);
			
			while(rs1.next()) {
				 txtroom.setText(rs1.getString("AllocatedRooms"));
				 checkintime.setText(rs1.getString("CheckInTime"));
				 txtpaid.setText(rs1.getString("Deposit"));
				
			}
			 
			ResultSet rs2 = conn.stmt.executeQuery("select*from rooms where RoomNumber = '"+txtroom.getText()+"'");
			while(rs2.next()) {
				String price = rs2.getString("Price");
				// change into number beacuse canot calculation with string 
				
				
				int amountpaid = Integer.parseInt(price) - Integer.parseInt(txtpaid.getText());
				txtpending.setText(""+amountpaid);
				
				
			}
			
			 
		} catch (ClassNotFoundException e11) {
			// TODO Auto-generated catch block
			e11.printStackTrace();
		} catch (SQLException e11) {
			// TODO Auto-generated catch block
			e11.printStackTrace();
		}
		
		
		
		
	}else if(e1.getSource()==update) {
		
		
		
		String paidamount = txtpending.getText();
		String room = txtroom.getText();
		
		
		try {
			Conn conn = new Conn();
			
			conn.stmt.executeUpdate("update newcustomer set Deposit = '"+paidamount+"' where Number = '"+room+"'");
			JOptionPane.showMessageDialog(null, "Data Updated Successfully  ");
			
			setVisible(false); 
			new Reception();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	else if(e1.getSource()==back){
		setVisible(false);
		new Reception();
	}
		
	}

	
	
	
	
}
