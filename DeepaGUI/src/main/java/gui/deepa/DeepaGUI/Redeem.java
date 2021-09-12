package gui.deepa.DeepaGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
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

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Redeem extends JFrame {

	private JPanel contentPane;
	File file1=new File("D:\\Course backups\\Java\\Deepa\\jar\\corp.doc");
	File file2=new File("D:\\Course backups\\Java\\Deepa\\jar\\bench.doc");
	List<Resource> tmp,btmp;
	JList skills ;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { Redeem frame = new Redeem();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */

	/**
	 * Create the frame.
	 */
	public Redeem() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(App.class.getResource("/razak.png")));
		setBounds(100, 100, 577, 335);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		JLabel lblNewLabel = new JLabel("Redeem People");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setBounds(144, 10, 245, 55);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sack by skills");
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setForeground(Color.GREEN);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 129, 239, 39);
		contentPane.add(lblNewLabel_1);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(321, 118, 191, 78);
		contentPane.add(scrollPane);
		
		skills = new JList();
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
		skills.setForeground(Color.GREEN);
		skills.setBackground(Color.WHITE);
		scrollPane.setViewportView(skills);
		
		JButton btnNewButton = new JButton("Redeem");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object tech=skills.getSelectedValue();
				ArrayList<String> tmps=new ArrayList<String>();
				tmp=new ArrayList<Resource>();
				btmp=new ArrayList<Resource>();
				try
				{
					FileInputStream fis;
					ObjectInputStream ois;
					fis=new FileInputStream(file2);
					ois=new ObjectInputStream(fis);
					btmp = (ArrayList<Resource>)ois.readObject();
					ois.close();fis.close();
					fis=new FileInputStream(file1);
					ois=new ObjectInputStream(fis);
					tmp = (ArrayList<Resource>)ois.readObject();
					ois.close();fis.close();
					for(int index=0;index<btmp.size();index++)
					{
						if(Arrays.toString(btmp.get(index).getTech()).contains((String)tech))
						{
							tmp.add(btmp.get(index));
							tmps.add(btmp.get(index).getName());
						}
					}
					if(tmp.isEmpty())
					{
						throw new ResourceException();
					}
					else {
						//btmp.clear();
						btmp.removeAll(tmp);
						FileOutputStream fos=null;
						ObjectOutputStream oos=null;
						fos=new FileOutputStream(file1); oos=new ObjectOutputStream(fos);
					 	oos.writeObject(tmp); oos.close(); fos.close();
						fos=new FileOutputStream(file2); oos=new ObjectOutputStream(fos);
					 	oos.writeObject(btmp); oos.close(); fos.close();
						JOptionPane.showMessageDialog(Redeem.this, "People those were redeemed "+Arrays.toString(tmps.toArray()));
					}
				}
				catch(ResourceException | ClassNotFoundException | IOException res)
				{
					JOptionPane.showMessageDialog(Redeem.this, "Select valid skill to redeem people");
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.GREEN);
		btnNewButton.setBounds(194, 227, 144, 39);
		contentPane.add(btnNewButton);
	}

}
