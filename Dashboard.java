package hotel.managnment.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Dashboard extends JFrame implements ActionListener {

	JLabel image,text;
	
	JMenuBar mb ;
	JMenu hotel,admin;
	JMenuItem reception , addemployee,addrooms,adddrivers;
	Dashboard(){
		
		setBounds(0,0,1550,1000);
		setLayout(null);
		
		// set image
		ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons1/third.jpg"));
		
		// scaling image 
		
		Image i2 = i1.getImage().getScaledInstance(1550,1000, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		image = new JLabel(i1);
		image.setBounds(0,0,1550,1000);
		add(image);
		
		text = new JLabel("THE DAGER GROUP WELCOMES YOU !");
		text.setBounds(400,80,1000,50);
		text.setFont(new Font("Tahoma",Font.PLAIN,46));
		text.setForeground(Color.white);
		image.add(text);
		
		// adding menu bar
		
		mb = new JMenuBar();
	
		mb.setBounds(0,0,1550,30);
		mb.setBackground(Color.black);
		image.add(mb);
		
		// adding menu in menubar
		
		hotel = new JMenu("HOTEL MANAGNMENT");
		
		hotel.setForeground(Color.orange);
		mb.add(hotel);
		
	admin = new JMenu("ADMIN");
		
		admin.setForeground(Color.RED);
	
		mb.add(admin);
		
		// adding menuitems
		
		reception = new JMenuItem("RECEPTION");
		hotel.add(reception);
	    reception.addActionListener(this);
	    
		addemployee = new JMenuItem("ADD EMPLOYEE");
		admin.add(addemployee);
		addemployee.addActionListener(this);
		
		addrooms = new JMenuItem("ADD ROOMS");
		admin.add(addrooms);
		addrooms.addActionListener(this);
		
		adddrivers = new JMenuItem("ADD DRIVERS");
		admin.add(adddrivers);
		adddrivers.addActionListener(this);
		
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		new Dashboard();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
if(e.getSource()==addemployee) {
	new Addemployee();
}
else if(e.getSource()==addrooms) {
	new Addrooms();
}
else if(e.getSource()==adddrivers) {
	
	new Adddrivers();
}
	else if(e.getSource()==reception) {
		new Reception();
	}
	
}
		
	}


