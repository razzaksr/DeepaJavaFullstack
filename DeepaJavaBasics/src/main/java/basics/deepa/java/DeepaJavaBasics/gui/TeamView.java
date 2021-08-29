package basics.deepa.java.DeepaJavaBasics.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import basics.deepa.java.DeepaJavaBasics.oop.Resource;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TeamView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { TeamView frame = new TeamView();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */

	/**
	 * Create the frame.
	 */
	public TeamView() {
		setTitle("View My team");
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
		
		
		List<Resource> tmp=new ArrayList<Resource>();
		try {
			//if(fis.read()!=-1)
			File file=new File("D:\\Course backups\\Java\\Deepa\\corp.doc");
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
		scrollPane.setViewportView(table);
	}

}
