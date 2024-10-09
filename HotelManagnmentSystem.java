package hotel.managnment.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.Timer;

public class HotelManagnmentSystem extends JFrame  implements ActionListener{
	JLabel text;
	JButton next;
	
HotelManagnmentSystem(){
    
    setSize(1366,565);
    setLocation(100,100);
    setLayout(null); 
    
// set image on 

ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons1/first.jpg"));
JLabel image = new JLabel(i1);  
image.setBounds(0, 0, 1366, 565);

// set text on image 

text = new JLabel("Hotel Managnment System");
text.setFont(new Font("Georgia",Font.BOLD,30));
text.setBounds(20,470,450,30);
text.setForeground(Color.cyan);

image.add(text);

add(image);

// add a next button 
 next = new JButton("Next");
 next.setBackground(Color.green);
 next.setBounds(1150, 450, 150, 50);
 next.setFont(new Font("Georgia",Font.BOLD,30));  
 next.addActionListener(this);
 image.add(next);
     setVisible(true);
     
     

    
          }
    
    
    public static void main(String[] args) {
     new HotelManagnmentSystem();
    
    }


	@Override
	public void actionPerformed(ActionEvent e) {
	
		setVisible(false);
		new Login();
		
	}
           }

