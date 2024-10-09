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

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class addingnewcustomer  extends JFrame implements ActionListener {

	JLabel newcustomer, id ,number,name , gender ,country ,allotedroom , checkintime , currentdate , deposit ,image;
	JComboBox  ids ;
	JTextField txtnumber,txtname ,txtcountry , txtdeposit;
	JRadioButton male , female ;
	ButtonGroup bg;
	Choice roomalloted;
	JButton addcustomer , back ;
	
	addingnewcustomer(){
		
		setTitle("AddingRooms");
		setLayout(null);
	 getContentPane().setBackground(Color.white);
		setBounds(350,150,800,600);
		
		
		newcustomer = new JLabel("New Customer Form  ");
		newcustomer.setBounds(200,40,300,30);
		newcustomer.setForeground(Color.blue);
		newcustomer.setFont(new Font("Georgia",Font.BOLD,20));
		add(newcustomer);
		
		id= new JLabel("ID");
		id.setBounds(50,100,170,30);
		id.setFont(new Font("Georgia",Font.BOLD,20));
		add(id);
		
		// combo box 
		String str[] = {"PassPort","Aadhar","Driving Licience","PAN Card"};
		ids = new JComboBox(str);
		ids.setBounds(230,100,170,30);
		ids.setFont(new Font("Georgia",Font.PLAIN,15));
		ids.setBackground(Color.white);
		
		add(ids);
		
		number= new JLabel("Number");
		number.setBounds(50,150,170,30);
		number.setFont(new Font("Georgia",Font.BOLD,20));
		add(number);
		
		txtnumber= new JTextField();
		txtnumber.setBounds(230,150,170,30);
		txtnumber.setFont(new Font("Georgia",Font.BOLD,15));
		add(txtnumber);
		
		
		name= new JLabel("Name");
		name.setBounds(50,200,170,30);
		name.setFont(new Font("Georgia",Font.BOLD,20));
		add(name);
		
		txtname= new JTextField();
		txtname.setBounds(230,200,170,30);
		txtname.setFont(new Font("Georgia",Font.BOLD,15));
		add(txtname);
		
		gender= new JLabel("Gender");
		gender.setBounds(50,250,170,30);
		gender.setFont(new Font("Georgia",Font.BOLD,20));
		add(gender);
		
			// radio button
		
		
		male = new JRadioButton("Male");
		male.setBounds(230,250,100,30);
		male.setFont(new Font("Georgia",Font.PLAIN,15));
		male.setBackground(Color.white);
		add(male);
		female = new JRadioButton("Female");
		female.setBounds(320,250,100,30);
		female.setFont(new Font("Georgia",Font.PLAIN,15));
		female.setBackground(Color.white);
		add(female);
		
		// buttonGrouping for selecting one of them 
		 bg = new ButtonGroup();
		bg.add(male);
		bg.add(female);
		
		
		country= new JLabel("Country");
		country.setBounds(50,300,170,30);
		country.setFont(new Font("Georgia",Font.BOLD,20));
		add(country);
		
		txtcountry= new JTextField();
		txtcountry.setBounds(230,300,170,30);
		txtcountry.setFont(new Font("Georgia",Font.BOLD,15));
		add(txtcountry);
		
		allotedroom= new JLabel("Alloted Room");
		allotedroom.setBounds(50,350,170,30);
		allotedroom.setFont(new Font("Georgia",Font.BOLD,20));
		add(allotedroom);
		
		
		roomalloted= new Choice();
		roomalloted.setBounds(230,350,170,30);
		roomalloted.setFont(new Font("Georgia",Font.PLAIN,15));
		add(roomalloted);
		
		// in alloted rooms we have to fill the value dynamically from the database ...that value is filled in addrooms section 
		// so connecting to the database 
		 try {
			Conn conn = new Conn();
			
			String query = "select*from rooms";
			ResultSet rs = conn.stmt.executeQuery(query);
			
			while(rs.next()) {
				
				roomalloted.add(rs.getString("RoomNumber"));
				
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 checkintime= new JLabel("Check-In-Time");
		 checkintime.setBounds(50,400,170,30);
		 checkintime.setFont(new Font("Georgia",Font.BOLD,20));
			add(checkintime);
			
			
			// to add current object 
			Date date = new Date();
			
			
			currentdate= new JLabel(""+date);
			currentdate.setBounds(230,400,210,30);
			currentdate.setFont(new Font("Georgia",Font.PLAIN,15));
				add(currentdate);
		 
		
				
				deposit= new JLabel("Deposit");
				deposit.setBounds(50,450,170,30);
				deposit.setFont(new Font("Georgia",Font.BOLD,20));
				add(deposit);
				
				txtdeposit= new JTextField();
				txtdeposit.setBounds(230,450,170,30);
				txtdeposit.setFont(new Font("Georgia",Font.PLAIN,15));
				add(txtdeposit);
				
				addcustomer = new JButton ("Add Customer");
				addcustomer.setBounds(130,510,150,30);
				addcustomer.setFont(new Font("Georgia",Font.BOLD,15));
				addcustomer.setBackground(Color.black);
				addcustomer.setForeground(Color.white);
				addcustomer.addActionListener(this);
				add(addcustomer);
				

				back = new JButton ("Back");
				back.setBounds(300,510,130,30);
				back.setFont(new Font("Georgia",Font.BOLD,15));
				back.setBackground(Color.black);
				back.setForeground(Color.white);
				back.addActionListener(this);
				add(back);
				
				
				//adding image icon
				
				ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons1/fifth.png"));
				
				// image scale 
				
				Image i2 = i1.getImage().getScaledInstance(350, 350,Image.SCALE_DEFAULT);
				
				ImageIcon i3 = new ImageIcon(i2);
					image = new JLabel(i3);	
				image.setBounds(450,70,350,350);
				add(image);
				
		setVisible(true);
		
		
		

		
	}
	
	public static void main(String[] args) {
	new addingnewcustomer();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		
		if(e.getSource()==addcustomer) {
			
			String ID = (String) ids.getSelectedItem();
			String Number = txtnumber.getText();
			String Name = txtname .getText();
			
			// get value from rdiobutton 
			
			String Gender = "";
			if(male.isSelected()) {
				Gender = "Male";
			}
			else if(female.isSelected()) {
				Gender = "Female";
			}
			
			
			String Country = txtcountry.getText();
			
			String AllocatedRooms = roomalloted.getSelectedItem();
			String CheckInTime = currentdate.getText();
			String Deposit = deposit.getText();

			
					
			// connecting to database 
			
			try {
				Conn con = new Conn();
				
				String query =  "insert into newcustomer values ('"+ID+"','"+Number+"','"+Name+"','"+Gender+"','"+Country+"','"+AllocatedRooms+"','"+CheckInTime+"','"+Deposit+"')";
				String query2 = "update rooms set Available = 'Occupied' where RoomNumber = '"+AllocatedRooms+"'";
				
				con.stmt.executeUpdate(query);
				con.stmt.executeUpdate(query2);
				
				JOptionPane.showMessageDialog(null,"New Customer Added Successfully !");
				
				setVisible(false);
				new Reception();
				
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
		else if(e.getSource()==back) {
			
			setVisible(false);
			new Reception();
		}
		
		
		
	}

}
