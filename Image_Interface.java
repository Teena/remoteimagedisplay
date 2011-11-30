import java.rmi.*;
import javax.swing.*;

public  interface Image_Interface extends Remote
{
	
//	public String toUpper(String arg_upper)throws RemoteException;
//	public double addition(double d1,double d2)throws RemoteException;

	public String[] getFileName()throws RemoteException;
	public ImageIcon display(String fileName) throws RemoteException;


}