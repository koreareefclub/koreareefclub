package module9;

public class ClassCastExceptionThrown {
	public static void throwsClassCastException()
	{
		throw new ClassCastException("Class Cast exception.");
	}
	  
	public static void main(String[] args)
	{
		try
		{
			throwsClassCastException();
		}
		
		catch (ClassCastException e){
			System.out.println(e.getMessage());
		}
	}
}
