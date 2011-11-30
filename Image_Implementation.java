import java.rmi.server.*;
import java.rmi.*;
import javax.swing.*;
import java.io.*;
public class Image_Implementation extends UnicastRemoteObject implements Image_Interface
{
	Image_Implementation()throws RemoteException
	{
		System.out.println("Server up.........");
		
	}
	
	public String[] getFileName()throws RemoteException
	{
		File f = new File("C:/Images");
		String[] fName = f.list();
		return fName;
	}
	public ImageIcon display(String fileName) throws RemoteException
	{
		ImageIcon img_icon = new ImageIcon("C:/Images"+fileName);
		return img_icon;
		
	}
	
}