package module9;

public class ArrayIndexOutOfBoundExceptionThrown {
	public static int[] array = new int[5];
	   public static void main(String[] args) {
	      
	       int index = 2;
	       System.out.println("calling with index=3");
	       checkArrayIndexOutOfBoundsException(index);
	      
	       index=15;
	       System.out.println("calling with index=10");
	       checkArrayIndexOutOfBoundsException(index);
	      
	   }
	   public static void checkArrayIndexOutOfBoundsException(int index){
	       try{
	       if(index>array.length-1){
	           throw new ArrayIndexOutOfBoundsException();
	       }
	       else{
	           System.out.println("This is currect index");
	       }
	       }catch(ArrayIndexOutOfBoundsException e){
	           System.out.println("Exception caught ");
	           System.out.println("LocalizedMessage :"+e.getLocalizedMessage());
	           System.out.println("toString :"+e.toString());
	           System.out.println("Messag :"+e.getMessage());
	       }
	   }
}
