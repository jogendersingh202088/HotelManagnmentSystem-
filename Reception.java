package hotel.managnment.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Reception extends JFrame implements ActionListener {

	JButton newcustomerform,rooms,depertment,allemployees,customerinfo,managerinfo,checkout,updatestatus,updateroomstatus,pickupservice,searchroom,logout;
	JLabel image;
	Reception(){
		
		
		setBounds(350,200,800,590);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		newcustomerform = new JButton("New Customer Form");
		newcustomerform.setBounds(35,40,200,30);
		newcustomerform.setFont(new Font("Georgia",Font.PLAIN,15));
		newcustomerform.setBackground(Color.black);
		newcustomerform.setForeground(Color.white);
		newcustomerform.addActionListener(this);
		add(newcustomerform);
		
		
		rooms = new JButton("Rooms");
		rooms.setBounds(35,80,200,30);
		rooms.setFont(new Font("Georgia",Font.PLAIN,15));
		rooms.setBackground(Color.black);
		rooms.setForeground(Color.white);
		rooms.addActionListener(this);
		add(rooms);
		
		depertment = new JButton("Depertment");
		depertment.setBounds(35,120,200,30);
		depertment.setFont(new Font("Georgia",Font.PLAIN,15));
		depertment.setBackground(Color.black);
		depertment.setForeground(Color.white);
		depertment.addActionListener(this);
		add(depertment);
		
		allemployees = new JButton("All Employees");
		allemployees.setBounds(35,160,200,30);
		allemployees.setFont(new Font("Georgia",Font.PLAIN,15));
		allemployees.setBackground(Color.black);
		allemployees.setForeground(Color.white);
		allemployees.addActionListener(this);
		add(allemployees);
		
		customerinfo = new JButton("Customer Info");
		customerinfo.setBounds(35,200,200,30);
		customerinfo.setFont(new Font("Georgia",Font.PLAIN,15));
		customerinfo.setBackground(Color.black);
		customerinfo.setForeground(Color.white);
		customerinfo.addActionListener(this);
		add(customerinfo);
		
		managerinfo = new JButton("Manage Info");
		managerinfo.setBounds(35,240,200,30);
		managerinfo.setFont(new Font("Georgia",Font.PLAIN,15));
		managerinfo.setBackground(Color.black);
		managerinfo.setForeground(Color.white);
		managerinfo.addActionListener(this);
		add(managerinfo);
		
		checkout = new JButton("CheckOut");
		checkout.setBounds(35,280,200,30);
		checkout.setFont(new Font("Georgia",Font.PLAIN,15));
		checkout.setBackground(Color.black);
		checkout.setForeground(Color.white);
		checkout.addActionListener(this);
		add(checkout);
		
		updatestatus = new JButton("Update Status");
		updatestatus.setBounds(35,320,200,30);
		updatestatus.setFont(new Font("Georgia",Font.PLAIN,15));
		updatestatus.setBackground(Color.black);
		updatestatus.setForeground(Color.white);
		updatestatus.addActionListener(this);
		add(updatestatus);
		
		updateroomstatus = new JButton("Update Room Status");
		updateroomstatus.setBounds(35,360,200,30);
		updateroomstatus.setFont(new Font("Georgia",Font.PLAIN,15));
		updateroomstatus.setBackground(Color.black);
		updateroomstatus.setForeground(Color.white);
		updateroomstatus.addActionListener(this);
		add(updateroomstatus);
		
		pickupservice = new JButton("Pickup Service");
		pickupservice.setBounds(35,400,200,30);
		pickupservice.setFont(new Font("Georgia",Font.PLAIN,15));
		pickupservice.setBackground(Color.black);
		pickupservice.setForeground(Color.white);
		pickupservice.addActionListener(this);
		add(pickupservice);
		
		
		searchroom = new JButton("Serach Room");
		searchroom.setBounds(35,440,200,30);
		searchroom.setFont(new Font("Georgia",Font.PLAIN,15));
		searchroom.setBackground(Color.black);
		searchroom.setForeground(Color.white);
		searchroom.addActionListener(this);
		add(searchroom);
		
		logout = new JButton("Logout");
		logout.setBounds(35,480,200,30);
		logout.setFont(new Font("Georgia",Font.PLAIN,15));
		logout.setBackground(Color.black);
		logout.setForeground(Color.white);
		logout.addActionListener(this);
		add(logout);
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons1/fourth.jpg"));
		
		// saclling image
		
		Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		
		image = new JLabel(i3);
		image.setBounds(270,40,450,450);
		add(image);
		
		setVisible(true);
		
		
	}
	public static void main(String[] args) {
	
         new Reception();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource()==newcustomerform) {
		
			new addingnewcustomer();
			setVisible(false);
		}
		else if(e.getSource()==rooms) {
			new rooms();
			setVisible(false);
		}
		else if(e.getSource()==depertment) {
			new Depertnment();
			setVisible(false);
		}
		else if(e.getSource()==allemployees) {
			new AllEmployeeDetails();
			setVisible(false);
		}
		else if(e.getSource()==customerinfo) {
			new CustomerIngo();
			setVisible(false);
		}
		else if(e.getSource()==managerinfo) {
			new ManagerInfo();
			setVisible(false);
		}
		else if(e.getSource()==searchroom) {
			new searchroom();
			setVisible(false);
		}
		else if(e.getSource()==logout) {
			new HotelManagnmentSystem();
			setVisible(false);
		}
		
	}

}
