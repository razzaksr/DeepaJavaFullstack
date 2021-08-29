package basics.deepa.java.DeepaJavaBasics.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import basics.deepa.java.DeepaJavaBasics.oop.Resource;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;

public class Hire extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField exp;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { Hire frame = new Hire();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */

	/**
	 * Create the frame.
	 */
	public Hire() {
		setBackground(Color.BLUE);
		setResizable(false);
		setTitle("Hiring New Resource");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 806, 432);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("New Resource");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(285, 10, 239, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Resource Name");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_1.setBounds(131, 95, 259, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Resource Skills");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_1_1.setBounds(131, 158, 259, 30);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Resource Experience");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_1_2.setBounds(131, 262, 259, 30);
		contentPane.add(lblNewLabel_1_2);
		
		name = new JTextField();
		name.setBackground(Color.BLUE);
		name.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		name.setForeground(Color.WHITE);
		name.setBounds(475, 94, 191, 31);
		contentPane.add(name);
		name.setColumns(10);
		
		exp = new JTextField();
		exp.setForeground(Color.WHITE);
		exp.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		exp.setColumns(10);
		exp.setBackground(Color.BLUE);
		exp.setBounds(475, 262, 191, 31);
		contentPane.add(exp);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(475, 158, 191, 78);
		contentPane.add(scrollPane);
		
		JList skills = new JList();
		skills.setModel(new AbstractListModel() {
			String[] values = new String[] {"Select Any Skills", "Java", "C", "CPP", "Python", "Javascript", "Dot net", "Angular", "React", "Android", "Express", "PHP"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		skills.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		skills.setForeground(Color.WHITE);
		skills.setBackground(Color.BLUE);
		scrollPane.setViewportView(skills);
		
		JButton btnNewButton = new JButton("Hire");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file=new File("D:\\Course backups\\Java\\Deepa\\corp.doc");
				FileOutputStream fos=null;
				ObjectOutputStream oos=null;
				FileInputStream fis=null;
				ObjectInputStream ois=null;
				List<Resource> tmp=new ArrayList<Resource>();
				Resource resource=new Resource();
				resource.setName(name.getText());
				resource.setExperience(Integer.parseInt(exp.getText()));
				Object[] hai=skills.getSelectedValues();
				String[] yet=new String[hai.length];
				for(int index=0;index<hai.length;index++)
				{
					yet[index]=(String)hai[index];
				}
				resource.setTech(yet);
				System.out.println(resource);
				try 
				{ 
					fis=new FileInputStream(file); ois=new ObjectInputStream(fis); 
					tmp = (List<Resource>)ois.readObject(); ois.close();fis.close(); tmp.add(resource);
					fos=new FileOutputStream(file); oos=new ObjectOutputStream(fos);
				 	oos.writeObject(tmp); oos.close(); fos.close();
				 	JOptionPane.showMessageDialog(Hire.this, resource.getName()+" has recruited successfully");
				 	name.setText("");
					exp.setText("");
					skills.clearSelection();
				 } 
				catch (IOException | ClassNotFoundException ev) { // TODO Auto-generated catch block
				 ev.printStackTrace(); }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setBounds(215, 336, 113, 31);
		contentPane.add(btnNewButton);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name.setText("");
				exp.setText("");
				skills.clearSelection();
			}
		});
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		btnClear.setBackground(Color.BLUE);
		btnClear.setBounds(455, 336, 113, 31);
		contentPane.add(btnClear);
	}
}
