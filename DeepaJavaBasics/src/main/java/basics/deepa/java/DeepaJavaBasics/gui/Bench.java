package basics.deepa.java.DeepaJavaBasics.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import basics.deepa.java.DeepaJavaBasics.oop.Resource;
import java.awt.Font;

public class Bench extends JFrame {

	private JPanel contentPane;
	File file=new File("D:\\Course backups\\Java\\Deepa\\bench.doc");
	List<Resource> tmp;
	private JTable table;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { Bench frame = new Bench();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */

	/**
	 * Create the frame.
	 */
	public Bench() {
		setTitle("View My bench");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ADMIN\\git\\DeepaJavaFullstack\\DeepaJavaBasics\\src\\main\\java\\razak.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		model=new DefaultTableModel();
		
		model.addColumn("Resource Name");
		model.addColumn("Resource Skill sets");
		model.addColumn("Resource Experience");
		
		try {
			//if(fis.read()!=-1)
			FileInputStream fis=new FileInputStream(file);
			ObjectInputStream ois=new ObjectInputStream(fis);
				tmp = (List<Resource>) ois.readObject();
				ois.close();
				fis.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int index=0;index<tmp.size();index++)
		{
			Vector obj=new Vector();
			obj.add(tmp.get(index).getName());
			obj.add(Arrays.toString(tmp.get(index).getTech()));
			obj.add(tmp.get(index).getExperience());
			model.addRow(obj);
		}
		
		table = new JTable(model);
		table.setFont(new Font("Times New Roman", Font.BOLD, 20));
		scrollPane.setViewportView(table);
	}

}
