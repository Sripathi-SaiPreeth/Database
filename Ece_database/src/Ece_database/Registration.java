package Ece_database;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Registration {

	private JFrame frame;
	private JTextField t1;
	private JTextField t2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 736, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel.setBounds(131, 11, 335, 49);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name: ");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblName.setBounds(63, 71, 143, 49);
		frame.getContentPane().add(lblName);
		
		JLabel lblRollNo = new JLabel("Roll No:  ");
		lblRollNo.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblRollNo.setBounds(63, 126, 143, 49);
		frame.getContentPane().add(lblRollNo);
		
		JLabel lblBranch = new JLabel("Branch: ");
		lblBranch.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblBranch.setBounds(63, 186, 143, 49);
		frame.getContentPane().add(lblBranch);
		
		t1 = new JTextField();
		t1.setBackground(Color.LIGHT_GRAY);
		t1.setBounds(232, 85, 200, 33);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setBackground(Color.LIGHT_GRAY);
		t2.setColumns(10);
		t2.setBounds(232, 140, 200, 33);
		frame.getContentPane().add(t2);
		
		JComboBox c1 = new JComboBox();
		c1.setBackground(new Color(0, 255, 255));
		c1.setModel(new DefaultComboBoxModel(new String[] {"Select", "ECE", "CSE", "IOT", "EEE"}));
		c1.setBounds(232, 201, 200, 30);
		frame.getContentPane().add(c1);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String n=t1.getText();
				String r=t2.getText();
				String d=(String) c1.getSelectedItem();
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sai","root","mrec");
					String q="insert into student values('"+n+"','"+r+"','"+d+"')";
					Statement sta=con.createStatement();
					sta.execute(q);
					con.close();
					JOptionPane.showMessageDialog(btnNewButton," Done ");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton.setBounds(116, 288, 161, 49);
		frame.getContentPane().add(btnNewButton);
	}
}
