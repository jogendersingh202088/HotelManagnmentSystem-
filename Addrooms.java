package hotel.managnment.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Addrooms extends JFrame implements ActionListener{

	JLabel roomheading , roomnumber ,available ,status ,price , type,image;
	JTextField txtroomnumber , txtprice  ;
	JButton addrooms , cancle;
	JComboBox avl , cln ,sng ;

	
	Addrooms(){
		
		setTitle("AddingRooms");
		setLayout(null);
	 getContentPane().setBackground(Color.white);
		setBounds(350,150,950,500);
		
		roomheading = new JLabel("ROOMS RECORD ");
		
		roomheading.setBounds(350,40,300,30);
		roomheading.setForeground(Color.red);
		roomheading.setFont(new Font("Georgia",Font.ITALIC,20));
		add(roomheading);
		
		roomnumber= new JLabel("Room Number");
		roomnumber.setBounds(50,100,170,30);
		roomnumber.setFont(new Font("Georgia",Font.BOLD,20));
		add(roomnumber);
		
		txtroomnumber = new JTextField();
		txtroomnumber.setBounds(280,100,200,30);
		txtroomnumber.setFont(new Font("Georgia",Font.BOLD,15));
		add(txtroomnumber);
		
		
		available= new JLabel("Available");
		available.setBounds(50,160,170,30);
		available.setFont(new Font("Georgia",Font.BOLD,20));
		add(available);
		
		// jCombobox
		String str[] = {"Avlaible","Occupied"};
		avl = new JComboBox(str);
		avl.setBounds(280,160,200,30);
		avl.setBackground(Color.white);
		avl.setForeground(Color.red);
		avl.setFont(new Font("Georgia",Font.PLAIN,15));
		add(avl);
		
		status= new JLabel("Cleaning Status");
		status.setBounds(50,210,170,30);
		status.setFont(new Font("Georgia",Font.BOLD,20));
		add(status);
		
		// jCombobox
		String str1[] = {"Cleaned","Dirty"};
		cln = new JComboBox(str1);
		cln.setBounds(280,210,200,30);
		cln.setBackground(Color.white);
		cln.setForeground(Color.red);
		cln.setFont(new Font("Georgia",Font.PLAIN,15));
		add(cln);
		
		
		
		price= new JLabel("Price");
		price.setBounds(50,260,170,30);
		price.setFont(new Font("Georgia",Font.BOLD,20));
		add(price);
		
		txtprice = new JTextField();
		txtprice.setBounds(280,260,200,30);
		txtprice.setFont(new Font("Georgia",Font.BOLD,15));
		add(txtprice);
		
		
		
		type= new JLabel("Bed Type");
		type.setBounds(50,310,170,30);
		type.setFont(new Font("Georgia",Font.BOLD,20));
		add(type);
		
		// jCombobox
		String str2[] = {"Single Bed","Double Bed "};
		sng = new JComboBox(str2);
		sng.setBounds(280,310,200,30);
		sng.setBackground(Color.white);
		sng.setForeground(Color.red);
		sng.setFont(new Font("Georgia",Font.PLAIN,15));
		add(sng);
		
		

		addrooms = new JButton ("Add Rooms");
		addrooms.setBounds(200,380,130,30);
		addrooms.setFont(new Font("Georgia",Font.BOLD,15));
		addrooms.setBackground(Color.black);
		addrooms.setForeground(Color.white);
		addrooms.addActionListener(this);
		add(addrooms);
		

		cancle = new JButton ("Cancle");
		cancle.setBounds(350,380,130,30);
		cancle.setFont(new Font("Georgia",Font.BOLD,15));
		cancle.setBackground(Color.black);
		cancle.setForeground(Color.white);
		cancle.addActionListener(this);
		add(cancle);
		
		// adding image and scale it 
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons1/eight.jpg"));
		
		// scale image 
		
		Image i2 = i1.getImage().getScaledInstance(340, 340, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		
		image = new JLabel(i3);
		image.setBounds(550,80,340,340);
		
		
		add(image);
		
		setVisible(true);
		
	}
	public static void main(String[] args) {
	new Addrooms();
    
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
	if(e.getSource()==addrooms) {
		String RoomNumber = txtroomnumber.getText();
		
		String Available = (String) avl.getSelectedItem();
		String Status = (String) cln.getSelectedItem();
		
		String Price = txtprice.getText();
		String Type = (String) sng.getSelectedItem();
		
		try {
			Conn conn = new Conn();
			
			String query =  "insert into rooms values ('"+RoomNumber+"','"+Available+"','"+Status+"','"+Price+"','"+Type+"')";
			conn.stmt.executeUpdate(query);
			
JOptionPane.showMessageDialog(null, "New Room Added Successfully . ");
			
			setVisible(false);
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}else if(e.getSource()==cancle) {
		
		new Dashboard();
		
	}
	
	}

}
