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

public class updateroomstatus extends JFrame implements ActionListener {

	JLabel heading,id ,roomnumber,avl,cln,image;
	Choice customerid;
	JTextField txtroom,txtavl,txtcln;
	JButton check,update,back;

	updateroomstatus(){
		
		
	getContentPane().setBackground(Color.white);
		
		setBounds(300,200,980,500);
		
		setLayout(null);
		
		heading = new JLabel("Update Room Status");
		heading.setBounds(100,20,600,50);
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
		
		roomnumber = new JLabel("Room Number");
		roomnumber.setBounds(60,150,150,30);
		roomnumber.setFont(new Font("Georgia",Font.BOLD,15));
		add(roomnumber);
		
		txtroom = new JTextField();
		txtroom.setBounds(240,150,150,30);
		txtroom.setFont(new Font("Georgia",Font.BOLD,15));
		add(txtroom);
		
		avl = new JLabel("Availability");
		avl.setBounds(60,200,150,30);
		avl.setFont(new Font("Georgia",Font.BOLD,15));
		add(avl);
		
		txtavl = new JTextField();
		txtavl.setBounds(240,200,150,30);
		txtavl.setFont(new Font("Georgia",Font.BOLD,15));
		add(txtavl);
		
		cln = new JLabel("Cleaning Status");
		cln.setBounds(60,250,150,30);
		cln.setFont(new Font("Georgia",Font.BOLD,15));
		add(cln);
		
		txtcln = new JTextField();
		txtcln.setBounds(240,250,150,30);
		txtcln.setFont(new Font("Georgia",Font.BOLD,15));
		add(txtcln);
	
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons1/seventh.jpg"));
         Image i2 = i1.getImage().getScaledInstance(400, 400,Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
		image = new JLabel(i3);	
	image.setBounds(450,60,500,350);
	add(image);
	
	
	
	
		
		
		check = new JButton ("Check");
		check.setBounds(40,340,100,30);
		check.setFont(new Font("Georgia",Font.BOLD,15));
		check.setBackground(Color.black);
		check.setForeground(Color.white);
		check.addActionListener(this);
		add(check);
		
		update = new JButton ("Update");
		update.setBounds(190,340,100,30);
		update.setFont(new Font("Georgia",Font.BOLD,15));
		update.setBackground(Color.black);
		update.setForeground(Color.white);
		update.addActionListener(this);
		add(update);
		
		back = new JButton ("Back");
		back.setBounds(340,340,100,30);
		back.setFont(new Font("Georgia",Font.BOLD,15));
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.addActionListener(this);
		add(back);
		setVisible(true);
	}
	public static void main(String[] args) {
		new updateroomstatus();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource()==check) {
			
			try {
		
				Conn conn = new Conn();
				
				 String query1 = "select*from newcustomer  where Number = '"+customerid.getSelectedItem()+"'";
				 ResultSet rs1 = conn.stmt.executeQuery(query1);
				
				while(rs1.next()) {
					 txtroom.setText(rs1.getString("AllocatedRooms"));
					
				}
				 
				ResultSet rs2 = conn.stmt.executeQuery("select*from rooms where RoomNumber = '"+txtroom.getText()+"'");
				while(rs2.next()) {
					String price = rs2.getString("Price");

					txtavl.setText(rs2.getString("Available"));
					txtcln.setText(rs2.getString("Status"));
			
					
				}
				
				 
			} catch (ClassNotFoundException e11) {
				// TODO Auto-generated catch block
				e11.printStackTrace();
			} catch (SQLException e11) {
				// TODO Auto-generated catch block
				e11.printStackTrace();
			}
			
			
		}
			else if(e.getSource()==update) {
				
				
				
				String avlable = txtavl.getText();
				String finalstatus = txtcln.getText();
				String room = txtroom.getText();
				
				try {
					Conn conn = new Conn();
					
					conn.stmt.executeUpdate("update rooms set Available = '"+avlable+"',Status = '"+finalstatus+"' where RoomNumber = '"+room+"'");
					JOptionPane.showMessageDialog(null, "Data Updated Successfully  ");
					
					setVisible(false); 
					new Reception();
					
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			
		
	}

		
			else if(e.getSource()==back) {
				setVisible(false); 
				new Reception();
				
			}
	}
	}
