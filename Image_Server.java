import java.rmi.Naming;


public class Image_Server
{
	public static void main(String args[])
	{
		try
		{
			Image_Implementation obj = new Image_Implementation();
			
			Naming.rebind("ImageRMI",obj);
			
			System.out.println("Server started and active");
			
		}catch(Exception e)
		{
			System.out.println(e);
		//	e.printlnStackTrace();
		}
	}
}