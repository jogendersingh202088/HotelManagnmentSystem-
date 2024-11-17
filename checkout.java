package hotel.managnment.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.jar.JarException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class checkout  extends JFrame implements ActionListener{

	JLabel heading,id,image,roomnumber,txtroomnumber, checkin,checkintime,checkouttime,checkout;
	Choice customerid;
	JButton checkOut,back;
	
	checkout(){
		
		 getContentPane().setBackground(Color.white);
		 
			setTitle("CheckinOut");
			setLayout(null);
				
			setBounds(400,150,800,440);
		
			
			heading = new JLabel("CHECK OUT");
			
			heading.setBounds(280,20,300,30);
			heading.setForeground(Color.red);
			heading.setFont(new Font("Georgia",Font.ITALIC,20));
			add(heading);
			
			
			id= new JLabel("ID");
			id.setBounds(60,80,100,30);
			id.setFont(new Font("Georgia",Font.BOLD,15));
			add(id);
			
			customerid = new Choice();
			customerid.setBounds(240,80,200,32);
			customerid.setFont(new Font("Georgia",Font.BOLD,15));
			add(customerid);
			
			// calling database
			
			
			
			// image and its scalling 
			
			ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons1/tick.png"));
			Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
			ImageIcon i3 = new ImageIcon(i2);
			
			image = new JLabel(i3);
			image.setBounds(450,80,20,20);
			add(image);
			
			
			roomnumber = new JLabel("Room Number");
			roomnumber.setBounds(60,130,150,30);
			roomnumber.setFont(new Font("Georgia",Font.BOLD,15));
			add(roomnumber);
			
			txtroomnumber = new JLabel();
			txtroomnumber.setBounds(240,130,100,30);
			txtroomnumber.setFont(new Font("Georgia",Font.BOLD,15));
			add(txtroomnumber);
			
		
			checkin = new JLabel("Check In");
			checkin.setBounds(60,180,150,30);
			checkin.setFont(new Font("Georgia",Font.BOLD,15));
			add(checkin);
			
			checkintime = new JLabel();
			checkintime.setBounds(240,180,100,30);
			checkintime.setFont(new Font("Georgia",Font.BOLD,15));
			add(checkintime);
			
			checkout = new JLabel("Check Out");
			checkout.setBounds(60,230,150,30);
			checkout.setFont(new Font("Georgia",Font.BOLD,15));
			add(checkout);
			
			
			
	// adding current date on lable
			
			Date date = new Date();
			
			
			checkouttime = new JLabel(""+date);
			checkouttime.setBounds(240,230,220,30);
			checkouttime.setFont(new Font("Georgia",Font.PLAIN,15));
			add(checkouttime);
			
		
			checkOut = new JButton ("Check Out");
			checkOut.setBounds(80,320,150,30);
			checkOut.setFont(new Font("Georgia",Font.BOLD,15));
			checkOut.setBackground(Color.black);
			checkOut.setForeground(Color.white);
			checkOut.addActionListener(this);
			add(checkOut);
			
			back = new JButton ("Back");
			back.setBounds(280,320,130,30);
			back.setFont(new Font("Georgia",Font.BOLD,15));
			back.setBackground(Color.black);
			back.setForeground(Color.white);
			back.addActionListener(this);
			add(back);
			
			
			
			// image and its scalling 
			
			ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons1/sixth.jpg"));
			Image i5 = i4.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
			ImageIcon i6 = new ImageIcon(i5);
			
			image = new JLabel(i6);
			image.setBounds(480,40,300,300);
			add(image);
			
			try {
				Conn con = new Conn();
				
				String query = "select*from newcustomer";
				
				ResultSet rs = con.stmt.executeQuery(query);
				
				while(rs.next()) {
					customerid.add(rs.getString("Number"));
		            txtroomnumber.setText(rs.getString("AllocatedRooms"));
		            
		            checkintime.setText(rs.getString("CheckInTime"));
					
				}
				
				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		setVisible(true);
		
		
	}
	public static void main(String[] args) {

           new checkout();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==checkOut) {
			
			String query1 = "delete from newcustomer where Number = '"+customerid.getSelectedItem()+"'";
			String query2 = "update rooms set Available = 'Avlaible' where RoomNumber = '"+txtroomnumber.getText()+"'";
		
			
			try {
					
			Conn  con = new Conn();
				
			con.stmt.executeUpdate(query1);
			con.stmt.executeUpdate(query2);
			
			
			JOptionPane.showMessageDialog(null, "Check out Successfully  ");
				
		setVisible(false);
		
			new Reception();
			
			}catch(Exception ee){
				ee.printStackTrace();
				
			}
				
		}
		else {
			setVisible(false);
			
			new Reception();
		}
		
	}

}
