package module9;

public class NullPointerExceptionCatch {
	public static void main(String[] args) {
	       String str = "test";
	       System.out.println("calling with str=\"test\"");
	       checkNullPointerException(str);
	       str = null;
	       System.out.println("calling with str=null");
	       checkNullPointerException(str);
	   }
	   public static void checkNullPointerException( String str){
	       try{
	           str.charAt(2);
	           System.out.print("No exception \n");
	       }catch(java.lang.NullPointerException e){
	           System.out.println("Exception caught ");
	           System.out.println("LocalizedMessage :"+e.getLocalizedMessage());
	           System.out.println("toString :"+e.toString());
	           System.out.println("Message :"+e.getMessage());
	       }
	   }
}
