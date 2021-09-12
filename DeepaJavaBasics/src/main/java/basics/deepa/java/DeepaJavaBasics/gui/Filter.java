package basics.deepa.java.DeepaJavaBasics.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import basics.deepa.java.DeepaJavaBasics.oop.Resource;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;

public class Filter extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	List<Resource> tmp,ntmp;
	File file=new File("D:\\Course backups\\Java\\Deepa\\corp.doc");

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { Filter frame = new Filter();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */

	/**
	 * Create the frame.
	 */
	public Filter() {
		setResizable(false);
		setTitle("Filter");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ADMIN\\git\\DeepaJavaFullstack\\DeepaJavaBasics\\src\\main\\java\\razak.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 357);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Shortlist");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(136, 10, 165, 49);
		contentPane.add(lblNewLabel);
		
		JLabel lblTechnology = new JLabel("Technology");
		lblTechnology.setHorizontalAlignment(SwingConstants.CENTER);
		lblTechnology.setForeground(Color.WHITE);
		lblTechnology.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTechnology.setBounds(10, 69, 165, 49);
		contentPane.add(lblTechnology);
		
		JLabel lblExperience = new JLabel("Experience");
		lblExperience.setHorizontalAlignment(SwingConstants.CENTER);
		lblExperience.setForeground(Color.WHITE);
		lblExperience.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblExperience.setBounds(10, 171, 165, 49);
		contentPane.add(lblExperience);
		
		textField = new JTextField();
		textField.setBackground(Color.DARK_GRAY);
		textField.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		textField.setForeground(Color.WHITE);
		textField.setBounds(204, 171, 191, 49);
		contentPane.add(textField);
		textField.setColumns(10);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(204, 69, 191, 78);
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
		skills.setBackground(Color.DARK_GRAY);
		scrollPane.setViewportView(skills);
		
		JButton btnNewButton = new JButton("Filter");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				tmp=new ArrayList<Resource>();
				ntmp=new ArrayList<Resource>();
				Object obj=skills.getSelectedValue();
				
				String txt=textField.getText();
				
				try {
					FileInputStream fis=new FileInputStream(file);
					ObjectInputStream ois=new ObjectInputStream(fis);
					tmp=(ArrayList<Resource>)ois.readObject();
					ois.close();fis.close();
					if(obj==null&&txt.equals("")) 
					{
						JOptionPane.showMessageDialog(Filter.this, "Valid credential expected");
					}
					else{
						if(obj==null && !txt.equals(""))
						{
							for(int pos=0;pos<tmp.size();pos++)
							{
								if((int)(tmp.get(pos).getExperience())>=Integer.parseInt(txt))
								{
									//System.out.println(tmp.get(pos).getName()+" gonna deleted");
									ntmp.add(tmp.get(pos));
								}
							}
						}
						else if(!txt.equals(""))
						{
							for(int pos=0;pos<tmp.size();pos++)
							{
								if(Arrays.toString(tmp.get(pos).getTech()).contains((String)obj))
								{
									//System.out.println(tmp.get(pos).getName()+" gonna deleted");
									ntmp.add(tmp.get(pos));
								}
							}
						}
						
						if(ntmp.size()!=0)
						{
							JOptionPane.showMessageDialog(Filter.this,"Shortlisted people are");
							TeamView view=new TeamView(ntmp);
							view.setVisible(true);
							Filter.this.dispose();
						}
						else {
							JOptionPane.showMessageDialog(Filter.this, "Nothing has matched");
						}
					}
				} catch (IOException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setBounds(136, 253, 165, 49);
		contentPane.add(btnNewButton);
	}
}
