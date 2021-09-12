package gui.deepa.DeepaGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class App extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public App() {
		setResizable(false);
		setTitle("Login to Deepa Resources");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(App.class.getResource("/razak.png")));
		setBounds(100, 100, 556, 384);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(contentPane);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JLabel lblNewLabel = new JLabel("Deepa Resource Login");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(90, 25, 360, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblUsername.setBounds(22, 113, 189, 42);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblPassword.setBounds(22, 216, 189, 42);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBackground(Color.GRAY);
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		textField.setBounds(310, 113, 174, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		passwordField.setEchoChar('#');
		passwordField.setForeground(Color.WHITE);
		passwordField.setBackground(Color.GRAY);
		passwordField.setBounds(310, 216, 174, 35);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("deepa")&&passwordField.getText().equals("resource"))
				{
					Home home=new Home();
					home.setVisible(true);
					JOptionPane.showMessageDialog(App.this, "Login success");
					App.this.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(App.this, "Login failed");
				}
			}
		});
		btnNewButton.setForeground(Color.GRAY);
		btnNewButton.setBounds(142, 302, 97, 35);
		contentPane.add(btnNewButton);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				passwordField.setText("");
			}
		});
		btnClear.setForeground(Color.GRAY);
		btnClear.setBounds(310, 302, 97, 35);
		contentPane.add(btnClear);
	}
}
