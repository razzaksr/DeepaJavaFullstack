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
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Hold extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	File file1=new File("D:\\Course backups\\Java\\Deepa\\jar\\corp.doc");
	File file2=new File("D:\\Course backups\\Java\\Deepa\\jar\\bench.doc");
	List<Resource> tmp,btmp;
	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { Hold frame = new Hold();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */

	/**
	 * Create the frame.
	 */
	public Hold() {
		setResizable(false);
		setTitle("Send to Bench");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 269);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Sending To Bench");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(88, 10, 299, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblTellUsExperience = new JLabel("Tell us Experience");
		lblTellUsExperience.setForeground(Color.WHITE);
		lblTellUsExperience.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblTellUsExperience.setBounds(10, 78, 299, 35);
		contentPane.add(lblTellUsExperience);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.BOLD, 25));
		textField.setForeground(Color.WHITE);
		textField.setBackground(Color.RED);
		textField.setBounds(250, 78, 186, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileInputStream fis;
				ObjectInputStream ois;
				
				tmp=new ArrayList<Resource>();
				btmp=new ArrayList<Resource>();
				try {
						fis=new FileInputStream(file1);
						ois=new ObjectInputStream(fis);
						tmp = (List<Resource>) ois.readObject();
						ois.close();
						fis.close();
						
						fis=new FileInputStream(file2);
						ois=new ObjectInputStream(fis);
						btmp = (List<Resource>) ois.readObject();
						ois.close();
						fis.close();
						
						for(int index=0;index<tmp.size();index++)
						{
							if((int)(tmp.get(index).getExperience())>=Integer.parseInt(textField.getText()))
							{
								btmp.add(tmp.get(index));
								//System.out.println(team.get(index).getName()+" moved to bench");
								//tmp.remove(index);
							}
						}
						
						
						tmp.removeAll(btmp);
						
						FileOutputStream fos=null;
						ObjectOutputStream oos=null;
						fos=new FileOutputStream(file1); oos=new ObjectOutputStream(fos);
					 	oos.writeObject(tmp); oos.close(); fos.close();
					 	fos=new FileOutputStream(file2); oos=new ObjectOutputStream(fos);
					 	oos.writeObject(btmp); oos.close(); fos.close();
					 	JOptionPane.showMessageDialog(Hold.this, "few moved to bench");
					 	textField.setText("");
				}
				catch(IOException | ClassNotFoundException io)
				{
					for(int index=0;index<tmp.size();index++)
					{
						if((int)(tmp.get(index).getExperience())>=Integer.parseInt(textField.getText()))
						{
							btmp.add(tmp.get(index));
							//System.out.println(team.get(index).getName()+" moved to bench");
							//tmp.remove(index);
						}
					}
					
					try
					{
						tmp.removeAll(btmp);
						FileOutputStream fos=null;
						ObjectOutputStream oos=null;
						fos=new FileOutputStream(file1); oos=new ObjectOutputStream(fos);
					 	oos.writeObject(tmp); oos.close(); fos.close();
					 	fos=new FileOutputStream(file2); oos=new ObjectOutputStream(fos);
					 	oos.writeObject(btmp); oos.close(); fos.close();
					 	JOptionPane.showMessageDialog(Hold.this, "few moved to bench");
					 	textField.setText("");
					}
					catch(IOException evv)
					{
						
					}
				}
			}
		});
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(185, 172, 85, 35);
		contentPane.add(btnNewButton);
		setIconImage(Toolkit.getDefaultToolkit().getImage(App.class.getResource("/razak.png")));
	}
}
