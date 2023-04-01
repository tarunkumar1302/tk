package exam;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class marks {

	private JFrame frame;
	private JTextField s;
	private JTextField marks;
	private JTextField name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					marks window = new marks();
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
	public marks() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel t4t = new JLabel("Name");
		t4t.setFont(new Font("Tahoma", Font.BOLD, 20));
		t4t.setBounds(26, 131, 84, 25);
		frame.getContentPane().add(t4t);
		
		s = new JTextField();
		s.setBounds(120, 101, 135, 20);
		frame.getContentPane().add(s);
		s.setColumns(10);
		
		JLabel tff = new JLabel("Sno");
		tff.setFont(new Font("Tahoma", Font.BOLD, 20));
		tff.setBounds(26, 95, 46, 25);
		frame.getContentPane().add(tff);
		
		marks = new JTextField();
		marks.setBounds(120, 173, 135, 20);
		frame.getContentPane().add(marks);
		marks.setColumns(10);
		
		JLabel t4t4 = new JLabel("Marks");
		t4t4.setFont(new Font("Tahoma", Font.BOLD, 20));
		t4t4.setBounds(26, 167, 72, 25);
		frame.getContentPane().add(t4t4);
		
		name = new JTextField();
		name.setBounds(120, 137, 135, 20);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("REGISTER");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_3.setBounds(148, 23, 135, 36);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sn = s.getText();
				int s=Integer.parseInt(sn);
				String Name= name.getText();
				String Marks=marks.getText();
				
				float Ma=Float.parseFloat(Marks);
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tk","root","mrec");
					String q = "Insert into student value('"+s+"','"+Name+"','"+Ma+"')";
					Statement sta = con.createStatement();
					sta.executeUpdate(q);
					con.close();
					JOptionPane.showMessageDialog(btnNewButton, "Done");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
						}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(212, 215, 105, 35);
		frame.getContentPane().add(btnNewButton);
	}
}
