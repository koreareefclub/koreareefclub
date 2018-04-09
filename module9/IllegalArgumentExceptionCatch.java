package module9;

public class IllegalArgumentExceptionCatch {

	public static void throwsIllegalArgumentException()
	{
		Character.toChars(-1);
	}
	  
	public static void main(String[] args)
	{
		try
		{
			throwsIllegalArgumentException();
		}
		catch (IllegalArgumentException e){
			System.out.println("Illegal argument exception occured in IllegalArgumentExceptionCatch class in method throwsIllegalArgumentException");
		}
	}

}
