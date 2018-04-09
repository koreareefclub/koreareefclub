package module9;

public class IllegalArgumentExceptionThrown {
	public static void main(String[] args) {
	       int value = 3;
	       System.out.println("calling with value=3");
	       checkIllegalArgumentException(value);
	      
	       value = 200;
	       System.out.println("calling with value=200");
	       checkIllegalArgumentException(value);
	   }
	   public static void checkIllegalArgumentException(int value){
	       try{
	           if(value<0 || value >50){
	               throw new IllegalArgumentException();
	           }
	           else{
	               System.out.println("No exception");
	           }
	       }catch(IllegalArgumentException e){
	           System.out.println("Exception caught ");
	           System.out.println("LocalizedMessage :"+e.getLocalizedMessage());
	           System.out.println("toString :"+e.toString());
	           System.out.println("Message :"+e.getMessage());
	       }
	   }
}
