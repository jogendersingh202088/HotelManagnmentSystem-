package hotel.managnment.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class pick extends JFrame implements ActionListener {

	
	JLabel heading , searchbox ,name ,age ,gender, company,model,avl,loc ;
	
	JTable table;
	JButton submit , back;
	Choice cartype;
	
	
	
	pick(){
		
		
		setBounds(340,70,900,700);
		setLayout(null);
		getContentPane().setBackground(Color.white);
		
		heading = new JLabel("Pick up Service");
		heading.setBounds(320,30,600,50);
		heading.setForeground(Color.red);
		heading.setFont(new Font("Georgia",Font.BOLD,25));
		add(heading);
		
		
		

		searchbox = new JLabel("Car Type");
		searchbox.setBounds(40,120,100,30);
		searchbox.setForeground(Color.black);
		searchbox.setFont(new Font("Georgia",Font.BOLD,15));
		add(searchbox);
		
		
		cartype = new Choice();
		cartype.setBounds(140,123,200,50);
		cartype.setForeground(Color.black);
		cartype.setFont(new Font("Georgia",Font.BOLD,15));
		add(cartype);
		
		
		// adding valur into choice 
		 try {
				Conn conn = new Conn();
				
				String query = "select*from drivers";
				ResultSet rs = conn.stmt.executeQuery(query);
				
				while(rs.next()) {
					
					cartype.add(rs.getString("CarModel"));
					
				}
				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		 
		 
		 
		 
		 
		 
		
		name = new JLabel("Name ");
		name.setBounds(55,200,200,30);
		name.setForeground(Color.red);
		name.setFont(new Font("Georgia",Font.PLAIN,15));
		add(name);
		
		
		
		age = new JLabel("Age");
		age.setBounds(190,200,200,30);
		age.setForeground(Color.red);
		age.setFont(new Font("Georgia",Font.PLAIN,15));
		add(age);
		
		
		
		gender = new JLabel("Gender ");
		gender.setBounds(290,200,200,30);
		gender.setForeground(Color.red);
		gender.setFont(new Font("Georgia",Font.PLAIN,15));
		add(gender);
		
 
		
		company = new JLabel("Company ");
		company.setBounds(400,200,200,30);
		company.setForeground(Color.red);
		company.setFont(new Font("Georgia",Font.PLAIN,15));
		add(company);
		
		
		
		model = new JLabel("Model");
		model.setBounds(520,200,200,30);
		model.setForeground(Color.red);
		model.setFont(new Font("Georgia",Font.PLAIN,15));
		add(model);
		
		
		
		avl = new JLabel("Availability ");
		avl.setBounds(610,200,200,30);
		avl.setForeground(Color.red);
		avl.setFont(new Font("Georgia",Font.PLAIN,15));
		add(avl);
		
		
		loc = new JLabel("Location ");
		loc.setBounds(750,200,200,30);
		loc.setForeground(Color.red);
		loc.setFont(new Font("Georgia",Font.PLAIN,15));
		add(loc);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		// table 
		   table = new JTable();
		   table.setBounds(40,250,800,300);
		   add(table);
		   
		   // get data from table
		   
		   try {
			Conn con = new Conn();
			
			
			String query = "select*from drivers ";
			
			ResultSet rs = con.stmt.executeQuery(query);
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		} catch (ClassNotFoundException ee) {
			// TODO Auto-generated catch block
			ee.printStackTrace();
		} catch (SQLException ee) {
			// TODO Auto-generated catch block
			ee.printStackTrace();
		}
			
		submit = new JButton ("Submit");
		submit.setBounds(300,600,100,30);
		submit.setFont(new Font("Georgia",Font.BOLD,15));
		submit.setBackground(Color.black);
		submit.setForeground(Color.white);
		submit.addActionListener(this);
		add(submit);
		
		 back = new JButton("Back");
		 back.setBounds(420,600,100,30);
		 back.setFont(new Font("Georgia",Font.BOLD,15));
		 back.setBackground(Color.black);
		 back.setForeground(Color.white);
		 back.addActionListener(this);
		add(back);
		setVisible(true);
		
		
		
		
	}
	public static void main(String[] args) {
	new pick();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==submit) {
			
			try {
				Conn conn = new Conn();
			
			
			String query1 = "select*from drivers where CarModel = '"+cartype.getSelectedItem()+"'";
			
			ResultSet rs ;
			
			
		
			 rs = conn.stmt.executeQuery(query1);
			
		
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			} 
			
			
			
			catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		else {
			setVisible(false);
			new Reception();
			
			
		}
			
			
		}


}
