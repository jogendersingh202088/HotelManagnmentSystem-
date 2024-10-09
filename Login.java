package hotel.managnment.system;

import java.awt.Color;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.TabSet;

public class Login extends JFrame implements ActionListener {
	JLabel user , pass , image ;
	JTextField username ;
	JPasswordField password;
	JButton login , cancle ;

	Login(){
		setTitle("LoginPage");
		getContentPane().setBackground(Color.white);
	
		setLayout(null);
		
	 user = new JLabel("User Name ");
	user.setBounds(40, 20, 100, 30);
	pass = new JLabel("Password");
	pass.setBounds(40,80,100,30);
	
	
	username = new JTextField();
	username.setBounds(150,20,150,30);

	password = new JPasswordField();
	password.setBounds(150,80,150,30);
	
	
	login = new JButton("Login");
	login.setBounds(40,150,120,30);
	login.setBackground(Color.black);
	login.setForeground(Color.white);
	login.addActionListener(this);
	
	cancle = new JButton("Cancle");
	cancle.setBounds(180,150,120,30);
	cancle.setBackground(Color.black);
	cancle.setForeground(Color.white);
	cancle.addActionListener(this);
	
	// set image 
	
	ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons1/second.jpg"));
		
	
	
	// scale AN IMAGE 
	
	Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
	ImageIcon i3 = new ImageIcon(i2);
	
	image = new JLabel(i3);
image.setBounds(350,10,200,200);
	add(image);
	
	add(user);
	     add(pass);
	     add(username);
	     add(password);
	     add(login);
	     add(cancle);
	     
	     	setBounds(500,200,600,300);
	     setVisible(true);
	     
	     
	     
	     
	}
	

	public static void main(String[] args) {
		
        new Login();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==login) {
			
		String user = 	username.getText();
		char[] pass = password.getPassword();
		String Passw = String.valueOf(pass) ;
		
		
		
		// check weather it exist in database or not 
		
		try {
			Conn c = new Conn();
			
			String query = "select * from login where username = '"+user+"' and password = '" +Passw+"'";
			
			
			ResultSet rs = c.stmt.executeQuery(query);
			
			if(rs.next()) {
				
				setVisible(false);
				new Dashboard();
				
			}
			else {
				
				JOptionPane.showMessageDialog(null, "Invalid username or password ");
			}
			
			
			
			
			
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		}
		else if (e.getSource()==cancle) {
			
			setVisible(false);
		}
		
		
	}

}
