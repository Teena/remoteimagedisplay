import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.rmi.*;


public class GUI_Image extends JFrame implements ActionListener
{
	JPanel pnl_top,pnl_middle,pnl_bottom;
	JButton connect_but,load_but,disp_but,exit_but;
	JTextField text1;
	JList list;
	JScrollPane jsp;
	Container cp;
	
	Image_Interface img_ser;
	
	GUI_Image()
	{
		cp = new Container();
		pnl_top = new JPanel();
		pnl_middle = new JPanel();
		pnl_bottom = new JPanel();
		connect_but = new JButton("Connect");
		load_but = new JButton("Load");
		disp_but = new JButton("Display");
		exit_but = new JButton("Exit");
		text1 = new JTextField(20);
		list = new JList();
		
		cp = getContentPane();		
		cp.setLayout(new BorderLayout());
		
		/**************Panel  1*********/
		
		cp.add(pnl_top,BorderLayout.NORTH);
		pnl_top.setLayout(new FlowLayout());		
		pnl_top.add(text1);
		pnl_top.add(connect_but);
		connect_but.addActionListener(this);
		
		/********** Panel 2 **********/
		
		cp.add(pnl_middle,BorderLayout.CENTER);
		pnl_middle.setLayout(new FlowLayout());
		jsp = new JScrollPane(list);
		pnl_middle.add(jsp);
		pnl_middle.add(load_but);
		load_but.addActionListener(this);
		
		/*********Panel 3*********/
		
		cp.add(pnl_bottom,BorderLayout.SOUTH);
		pnl_bottom.setLayout(new FlowLayout());
		pnl_bottom.add(disp_but);
		pnl_bottom.add(exit_but);			
		disp_but.addActionListener(this);
		exit_but.addActionListener(this);
		
		
		setSize(350,300);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String arg = ae.getActionCommand();
		
		if(arg.equals("Connect"))
		{
			try
			{
				String ip_add=text1.getText();
				img_ser = (Image_Interface)Naming.lookup("rmi://"+ip_add+"/ImageRMI");
				System.out.println("Conncted to server");
			}catch(Exception ex2)
			{
				System.out.println(ex2);
			}
		}
		
		else if(arg.equals("Load"))
		{
			try
			{
			
				String[] listdata = img_ser.getFileName();
				list.setListData(listdata);
			}catch(Exception ex3)
			{
				System.out.println("In load: " +ex3);
			}
		}
		
		//else if(arg.equals)
		
	}
	
	public static void main(String args[])
	{
		new GUI_Image();
		
		try
		{
			Image_Interface client_obj = (Image_Interface)Naming.lookup("ImageRMI");
			
	
						
		}catch(Exception e1)
		{
			System.out.println(e1);
			//e1.printlnStackTrace();
		}
	}
	
}