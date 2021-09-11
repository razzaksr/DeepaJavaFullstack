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
import basics.deepa.java.DeepaJavaBasics.oop.ResourceException;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
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

public class Fire extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { Fire frame = new Fire();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */

	/**
	 * Create the frame.
	 */
	public Fire() {
		setBackground(Color.BLACK);
		setResizable(false);
		setTitle("Fire People");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 735, 392);
		contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Sack People");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(259, 23, 245, 55);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sack by skills");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(76, 142, 239, 39);
		contentPane.add(lblNewLabel_1);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ADMIN\\git\\DeepaJavaFullstack\\DeepaJavaBasics\\src\\main\\java\\razak.png"));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(401, 149, 191, 78);
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
		skills.setForeground(Color.RED);
		skills.setBackground(Color.BLACK);
		scrollPane.setViewportView(skills);
		
		JButton btnNewButton = new JButton("Fire");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object tech=skills.getSelectedValue();
				ArrayList<Resource> tmps=null;
				List<String> tmp=new ArrayList<String>();
				try
				{
					File file=new File("D:\\Course backups\\Java\\Deepa\\corp.doc");
					FileInputStream fis;
					ObjectInputStream ois;
					fis=new FileInputStream(file);
					ois=new ObjectInputStream(fis);
					tmps = (ArrayList<Resource>)ois.readObject();
					for(int index=0;index<tmps.size();index++)
					{
						if(Arrays.toString(tmps.get(index).getTech()).contains((String)tech))
						{
							tmp.add(tmps.get(index).getName());
							tmps.remove(index);
						}
					}
					if(tmp.isEmpty())
					{
						throw new ResourceException();
					}
					else {
						FileOutputStream fos=null;
						ObjectOutputStream oos=null;
						fos=new FileOutputStream(file); oos=new ObjectOutputStream(fos);
					 	oos.writeObject(tmps); oos.close(); fos.close();
						JOptionPane.showMessageDialog(Fire.this, "People those were fired "+Arrays.toString(tmp.toArray()));
					}
				}
				catch(ResourceException | ClassNotFoundException | IOException res)
				{
					JOptionPane.showMessageDialog(Fire.this, "Select valid skill to fire people");
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBounds(286, 276, 144, 39);
		contentPane.add(btnNewButton);
	}
}
