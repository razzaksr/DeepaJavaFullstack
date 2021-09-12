package gui.deepa.DeepaGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Update extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel_1_1;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_1_2;
	private JTextField textField_1;
	private JButton btnUpdate;
	private JButton btnClear;
	private JList skills;
	File file=new File("D:\\Course backups\\Java\\Deepa\\jar\\corp.doc");
	List<Resource> tmp;
	int pos,who;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { Update frame = new Update();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */

	/**
	 * Create the frame.
	 */
	public Update() {
		setBackground(Color.ORANGE);
		setResizable(false);
		setTitle("Update");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 749, 410);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblUpdateResource = new JLabel("Update Resource");
		lblUpdateResource.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateResource.setForeground(Color.BLACK);
		lblUpdateResource.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblUpdateResource.setBounds(254, 10, 239, 41);
		contentPane.add(lblUpdateResource);
		
		JLabel lblNewLabel_1 = new JLabel("Resource Name");
		lblNewLabel_1.setBackground(Color.ORANGE);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_1.setBounds(91, 86, 259, 30);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				//JOptionPane.showMessageDialog(Update.this, textField.getText()+" has choosen");
				String name=textField.getText();
				FileInputStream fis;
				ObjectInputStream ois;
				
				tmp=new ArrayList<Resource>();
				try {
					//if(fis.read()!=-1)
						fis=new FileInputStream(file);
						ois=new ObjectInputStream(fis);
						tmp = (List<Resource>) ois.readObject();
						ois.close();
						fis.close();
						
						for(pos=0;pos<tmp.size();pos++)
						{
							//System.out.println(name+" and "+tmp.get(pos).getName());
							if(tmp.get(pos).getName().equals(name))
							{
								//JOptionPane.showMessageDialog(Update.this, textField.getText()+" has choosen");
								textField_1.setText(tmp.get(pos).getExperience()+"");
								skills.setModel(new AbstractListModel() {
									String[] values = new String[] {"Select Any Skills", "Java", "C", "CPP", "Python", "Javascript", "Dot net", "Angular", "React", "Android", "Express", "PHP"};
									public int getSize() {
										return values.length;
									}
									public Object getElementAt(int index) {
										return values[index];
									}
								});
								who=pos;
								break;
							}
						}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		textField.setColumns(10);
		textField.setBackground(Color.ORANGE);
		textField.setBounds(435, 85, 191, 31);
		contentPane.add(textField);
		
		lblNewLabel_1_1 = new JLabel("Resource Skills");
		lblNewLabel_1_1.setBackground(Color.ORANGE);
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_1_1.setBounds(91, 140, 259, 30);
		contentPane.add(lblNewLabel_1_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(435, 140, 191, 78);
		contentPane.add(scrollPane);
		
		skills = new JList();
		scrollPane.setViewportView(skills);
		skills.setForeground(Color.BLACK);
		skills.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		skills.setBackground(Color.ORANGE);
		
		lblNewLabel_1_2 = new JLabel("Resource Experience");
		lblNewLabel_1_2.setBackground(Color.ORANGE);
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_1_2.setBounds(91, 244, 259, 30);
		contentPane.add(lblNewLabel_1_2);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.BLACK);
		textField_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		textField_1.setColumns(10);
		textField_1.setBackground(Color.ORANGE);
		textField_1.setBounds(435, 244, 191, 31);
		contentPane.add(textField_1);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileOutputStream fos=null;
				ObjectOutputStream oos=null;
				FileInputStream fis=null;
				ObjectInputStream ois=null;
				Resource resource=new Resource();
				resource.setName(textField.getText());
				resource.setExperience(Integer.parseInt(textField_1.getText()));
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
					fos=new FileOutputStream(file); oos=new ObjectOutputStream(fos);
					tmp.set(who, resource);
				 	oos.writeObject(tmp); 
				 	oos.close(); fos.close();
				 	JOptionPane.showMessageDialog(Update.this, resource.getName()+" has updated successfully");
				 	textField.setText("");
				 	textField_1.setText("");
					skills.clearSelection();
				 } 
				catch (IOException ev) { // TODO Auto-generated catch block
				 ev.printStackTrace(); }
			}
		});
		btnUpdate.setForeground(Color.BLACK);
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		btnUpdate.setBackground(Color.ORANGE);
		btnUpdate.setBounds(126, 318, 179, 31);
		contentPane.add(btnUpdate);
		
		btnClear = new JButton("Clear");
		btnClear.setForeground(Color.BLACK);
		btnClear.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		btnClear.setBackground(Color.ORANGE);
		btnClear.setBounds(415, 318, 113, 31);
		contentPane.add(btnClear);
		setIconImage(Toolkit.getDefaultToolkit().getImage(App.class.getResource("/razak.png")));
	}
}
