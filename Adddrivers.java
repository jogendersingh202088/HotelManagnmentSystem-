package hotel.managnment.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;



public class Adddrivers extends JFrame implements ActionListener {

	JLabel   dri ,name , age , gender , carcompany,carmodel , available , location , image ;
	JTextField txtname , txtage , txtcarcompany ,txtcarmodel,txtavailable, txtlocation;
	JRadioButton male ,female;
	JButton adddriver ,cancle ;
	ButtonGroup bg;
	JComboBox avl;
	
	
	Adddrivers(){
		
		 getContentPane().setBackground(Color.white);
		 
			setTitle("AddingDrivers");
			setLayout(null);
				
			setBounds(350,150,900,560);
			
			dri = new JLabel("ADD Driver Details ");
			
			dri.setBounds(250,20,300,30);
			dri.setFont(new Font("Georgia",Font.ITALIC,20));
			add(dri);
			
			
			name = new JLabel("Name");
			name.setBounds(60,80,100,30);
			name.setFont(new Font("Georgia",Font.BOLD,20));
			add(name);
			
			txtname = new JTextField();
			txtname.setBounds(250,80,200,30);
			txtname.setFont(new Font("Georgia",Font.BOLD,15));
			add(txtname);
			
			age = new JLabel("Age");
			age.setBounds(60,130,100,30);
			age.setFont(new Font("Georgia",Font.BOLD,20));
			add(age);
			
			txtage = new JTextField();
			txtage.setBounds(250,130,200,30);
			txtage.setFont(new Font("Georgia",Font.BOLD,15));
			add(txtage);
		
			
			gender = new JLabel("Gender");
			gender.setBounds(60,180,100,30);
			gender.setFont(new Font("Georgia",Font.BOLD,20));
			add(gender);
			
			male = new JRadioButton("Male");
			male.setBounds(250,180,70,30);
			male.setFont(new Font("Georgia",Font.ITALIC,15));
			male.setBackground(Color.white);
			add(male);
			female= new JRadioButton("Female");
			female.setBounds(350,180,100,30);
			female.setFont(new Font("Georgia",Font.ITALIC,15));
			female.setBackground(Color.white);
			add(female);
			
			// button group foe selecting one among male or female 
			 bg = new ButtonGroup();
			 bg.add(male);
			 bg.add(female);
			
			 
				carcompany = new JLabel("Car Company");
				carcompany.setBounds(60,230,150,30);
				carcompany.setFont(new Font("Georgia",Font.BOLD,20));
				carcompany.setBackground(Color.white);
	           add(carcompany);
				
				
				txtcarcompany = new JTextField();
				txtcarcompany.setBounds(250,230,200,30);
				txtcarcompany.setBackground(Color.white);
				txtcarcompany.setFont(new Font("Georgia",Font.BOLD,15));
				add(txtcarcompany);
			
				
				carmodel = new JLabel("Car Model");
				carmodel.setBounds(60,285,150,30);
				carmodel.setFont(new Font("Georgia",Font.BOLD,20));
				carmodel.setBackground(Color.white);
	           add(carmodel);
				
				
				txtcarmodel = new JTextField();
				txtcarmodel.setBounds(250,285,200,30);
				txtcarmodel.setBackground(Color.white);
				txtcarmodel.setFont(new Font("Georgia",Font.BOLD,15));
				add(txtcarmodel);
				
				available= new JLabel("Available");
				available.setBounds(60,340,100,30);
				available.setFont(new Font("Georgia",Font.BOLD,20));
				add(available);
				
				// jCombobox
				String str[] = {"Available","Not Available"};
				avl = new JComboBox(str);
				avl.setBounds(250,340,200,30);
				avl.setBackground(Color.white);
				avl.setForeground(Color.red);
				avl.setFont(new Font("Georgia",Font.PLAIN,15));
				add(avl);
				
				location = new JLabel("Location");
				location.setBounds(60,395,100,30);
				location.setFont(new Font("Georgia",Font.BOLD,20));
				add(location);
				
				txtlocation = new JTextField();
				txtlocation.setBounds(250,395,200,30);
				txtlocation.setFont(new Font("Georgia",Font.BOLD,15));
				add(txtlocation);
				
				adddriver = new JButton ("Add Driver");
				adddriver.setBounds(200,450,130,30);
				adddriver.setFont(new Font("Georgia",Font.BOLD,15));
				adddriver.setBackground(Color.black);
				adddriver.setForeground(Color.white);
				adddriver.addActionListener(this);
				add(adddriver);
				

				cancle = new JButton ("Cancle");
				cancle.setBounds(350,450,130,30);
				cancle.setFont(new Font("Georgia",Font.BOLD,15));
				cancle.setBackground(Color.black);
				cancle.setForeground(Color.white);
				cancle.addActionListener(this);
				add(cancle);
				
				//adding and scalling image 
				
				ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons1/eleven.jpg"));
			// scalling 
				
				Image i2 = i1.getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT);
				ImageIcon i3 = new ImageIcon(i2);
				
				image = new JLabel(i3);
				image.setBounds(510,70,350,350);
				add(image);
				 
			setVisible(true);
		
	}
	public static void main(String[] args) {
		
		new Adddrivers();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// selection the button on which action is performed 
		
		if(e.getSource()==adddriver) {
			
			String Name = txtname.getText();
			String Age = txtage.getText();
			
			// select value from radiobutton
			String Gender = null;
			if(male.isSelected()) {
				Gender = "Male";
			}
			else if(female.isSelected()) {
				Gender = "Female";
			}
			
			String CarCompany = txtcarcompany.getText();
			
			String CarModel = txtcarmodel.getText();
			
			String Available = (String) avl.getSelectedItem();
			
			String Location = txtlocation.getText();
			
			
			
			// connecting to database 
			
			try {
				Conn conn = new Conn();
				
				String query =  "insert into drivers values ('"+Name+"','"+Age+"','"+Gender+"','"+CarCompany+"','"+CarModel+"','"+Available+"','"+Location+"')";
				
				conn.stmt.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "Congrulation ! Driver Added Successfully . ");
				
				setVisible(false);
				
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		else if(e.getSource()==cancle) {
			
			new Dashboard();
		}
		
		
		
	}

}
