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

public class Addemployee extends JFrame implements ActionListener{
	
	
	
	JLabel emp, name , age , gender,job ,salary , phone , email ,aadhar ,image ;
	JTextField txtname , txtage, txtsalary,txtphone,txtemail,txtaadhar;
	JButton submit ;
	JRadioButton male ,female;
	JComboBox services;
	ButtonGroup bg;
	
	Addemployee(){
		 getContentPane().setBackground(Color.white);
		 
		setTitle("AddingEmployee");
		setLayout(null);
			
		setBounds(350,150,850,640);
		
		emp = new JLabel("ADD EMPLOYEE DETAILS ");
		
		emp.setBounds(250,20,300,30);
		emp.setFont(new Font("Georgia",Font.ITALIC,20));
		add(emp);
		
		
		name = new JLabel("Name");
		name.setBounds(60,80,100,30);
		name.setFont(new Font("Georgia",Font.BOLD,20));
		add(name);
		
		txtname = new JTextField();
		txtname.setBounds(200,80,200,30);
		txtname.setFont(new Font("Georgia",Font.BOLD,15));
		add(txtname);
		
		age = new JLabel("Age");
		age.setBounds(60,130,100,30);
		age.setFont(new Font("Georgia",Font.BOLD,20));
		add(age);
		
		txtage = new JTextField();
		txtage.setBounds(200,130,200,30);
		txtage.setFont(new Font("Georgia",Font.BOLD,15));
		add(txtage);
		
		gender = new JLabel("Gender");
		gender.setBounds(60,180,100,30);
		gender.setFont(new Font("Georgia",Font.BOLD,20));
		add(gender);
		
	
		// radio buttons 
		
		
		male = new JRadioButton("Male");
		male.setBounds(200,180,70,30);
		male.setFont(new Font("Georgia",Font.ITALIC,15));
		male.setBackground(Color.white);
		add(male);
		female= new JRadioButton("Female");
		female.setBounds(270,180,150,30);
		female.setFont(new Font("Georgia",Font.ITALIC,15));
		female.setBackground(Color.white);
		add(female);
		
		// button group foe selecting one among male or female 
		 bg = new ButtonGroup();
		 bg.add(male);
		 bg.add(female);
		 
		
		
		// combo box 
		
		job = new JLabel("Job");
		job.setBounds(60,230,100,30);
		job.setFont(new Font("Georgia",Font.BOLD,20));
		job.setBackground(Color.white);
		add(job);
		
		String str[] = {"Front Desk Clerks ","Porters","House Keeping","Kitchen Staff","Room Services","Chefs","Manager","Waiters/Waiteress","Accountant"};
		services = new JComboBox(str);
		services.setBounds(200,230,150,30);
		services.setBackground(Color.white);
		services.setFont(new Font("Georgia",Font.BOLD,10));
		add(services);
		
		salary = new JLabel("Salary");
		salary.setBounds(60,285,100,30);
		salary.setFont(new Font("Georgia",Font.BOLD,20));
		add(salary);
		
		txtsalary = new JTextField();
		txtsalary.setBounds(200,285,200,30);
		txtsalary.setFont(new Font("Georgia",Font.BOLD,15));
		add(txtsalary);
		
		phone = new JLabel("Phone");
		phone.setBounds(60,340,100,30);
		phone.setFont(new Font("Georgia",Font.BOLD,20));
		add(phone);
		
		txtphone = new JTextField();
		txtphone.setBounds(200,340,200,30);
		txtphone.setFont(new Font("Georgia",Font.BOLD,15));
		add(txtphone);
		
		email = new JLabel("Email");
		email.setBounds(60,395,100,30);
		email.setFont(new Font("Georgia",Font.BOLD,20));
		add(email);
		
		txtemail = new JTextField();
		txtemail.setBounds(200,395,200,30);
		txtemail.setFont(new Font("Georgia",Font.BOLD,15));
		add(txtemail);
		
		
		 aadhar= new JLabel("Aadhar");
		 aadhar.setBounds(60,450,100,30);
		 aadhar.setFont(new Font("Georgia",Font.BOLD,20));
		add(aadhar);
		
		txtaadhar = new JTextField();
		txtaadhar.setBounds(200,450,200,30);
		txtaadhar.setFont(new Font("Georgia",Font.BOLD,15));
		add(txtaadhar);
		
		
		
		submit = new JButton ("Submit");
		submit.setBounds(330,530,100,30);
		submit.setFont(new Font("Georgia",Font.BOLD,15));
		submit.setBackground(Color.black);
		submit.setForeground(Color.white);
		submit.addActionListener(this);
		add(submit);
		
		
		//adding image icon
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons1/tenth.jpg"));
		
		// image scale 
		
		Image i2 = i1.getImage().getScaledInstance(350, 350,Image.SCALE_DEFAULT);
		
		ImageIcon i3 = new ImageIcon(i2);
			image = new JLabel(i3);	
		image.setBounds(450,70,350,350);
		add(image);
		
		
		
		
		
		setVisible(true);
		
	}
	
	

	public static void main(String[] args) {
	
new Addemployee();
	}



	@Override
	public void actionPerformed(ActionEvent e) {
	
		String Namee = txtname.getText();
		String Age = txtage.getText();
		String Salary = txtsalary.getText();
		String Phone = txtphone.getText();
		String Email = txtemail.getText();
		String Aadhar = txtaadhar.getText();
		
		// get value from radio button 
		
		String Gender = null;
		
		if(male.isSelected()) {
			Gender = "Male";
			
		}
		else if(female.isSelected()) {
			Gender = "Female";
		}
		
		// get value from combo box
		
		String Job = (String) services.getSelectedItem();
		
		// connecting to database 
		
		try {
			Conn conn = new Conn();
			
			String query = "insert into employee values ('"+Namee+"','"+Age+"','"+Salary+"','"+Phone+"','"+Email+"','"+Aadhar+"','"+Gender+"','"+Job+"')";
			
			conn.stmt.executeUpdate(query);
			
			JOptionPane.showMessageDialog(null, "Congrulation ! Employee Added Successfully . ");
			
			setVisible(false);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
