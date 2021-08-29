package basics.deepa.java.DeepaJavaBasics.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;

public class Basic extends JFrame implements ItemListener
{
	Container container;
	JRadioButton radio1,radio2,radio3;
	ButtonGroup bg;
	public static void main(String[] args) 
	{
		Basic base=new Basic();
	}
	public Basic()
	{
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		this.setTitle("Basic window");
		this.setSize(300, 100);
		this.setVisible(true);
		
		
		container=this.getContentPane();
		container.setLayout(null);
		
		/*this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
					SwingUtilities.updateComponentTreeUI(container);
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException ev) {
					// TODO Auto-generated catch block
					ev.printStackTrace();
				}
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});*/
		
		bg=new ButtonGroup();
		radio1=new JRadioButton("Motif");
		radio1.setBounds(100,200,100,20);
		radio1.addItemListener(this);
		bg.add(radio1);
		radio2=new JRadioButton("Metal");
		radio2.setBounds(100,230,100,20);
		radio2.addItemListener(this);
		bg.add(radio2);
		radio3=new JRadioButton("Windows");
		radio3.setBounds(100,260,100,20);
		/*radio3.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				SwingUtilities.updateComponentTreeUI(container);
			}
		});*/
		bg.add(radio3);
		//System.out.println("val="+bg.getSelection());
		//radio1.getModel().setSelected(true);
		
		container.add(radio1);container.add(radio2);container.add(radio3);
		
		JButton button=new JButton("JUST");
		button.setBounds(100, 10, 100, 20);
		container.add(button);
		JButton button1=new JButton("Upside");
		button1.setBounds(100, 40, 100, 20);
		container.add(button);
		JButton button2=new JButton("Down");
		button2.setBounds(100, 70, 100, 20);
		container.add(button2);
		JButton button3=new JButton("Left");
		button3.setBounds(100, 100, 100, 20);
		container.add(button3);
		JButton button4=new JButton("Right");
		button4.setBounds(100, 130, 100, 20);
		container.add(button4);
		/*
		 * container.setLayout(new FlowLayout()); JButton button=new JButton("JUST");
		 * container.add(button); JButton button1=new JButton("Upside");
		 * container.add(button); JButton button2=new JButton("Down");
		 * container.add(button2); JButton button3=new JButton("Left");
		 * container.add(button3); JButton button4=new JButton("Right");
		 * container.add(button4);
		 */
		/*
		 * JButton button=new JButton("JUST"); container.add(button); JButton
		 * button1=new JButton("Upside"); container.add(button1,BorderLayout.NORTH);
		 * JButton button2=new JButton("Down");
		 * container.add(button2,BorderLayout.SOUTH); JButton button3=new
		 * JButton("Left"); container.add(button3,BorderLayout.WEST); JButton
		 * button4=new JButton("Right"); container.add(button4,BorderLayout.EAST);
		 */
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		try {
			if(radio1.getModel().isSelected())
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
			else if(radio2.getModel().isSelected())
				UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			else {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

			}
			SwingUtilities.updateComponentTreeUI(container);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException ev) {
			// TODO Auto-generated catch block
			ev.printStackTrace();
		}
	}
}
