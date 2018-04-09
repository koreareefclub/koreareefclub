package module9;

public class ArrayIndexOutOfBoundsExceptionCatch {
	 public static int[] array = new int[4];
	   public static void main(String[] args) {
	      
	       int index = 3;
	       System.out.println("calling with index=3");
	       checkArrayIndexOutOfBoundsException(index);
	      
	       index=10;
	       System.out.println("calling with index=10");
	       checkArrayIndexOutOfBoundsException(index);
	      
	   }
	   public static void checkArrayIndexOutOfBoundsException(int index){
	       try{
	           array[index]=50;
	           System.out.println("current index");
	      
	       }catch(ArrayIndexOutOfBoundsException e){
	           System.out.println("Exception caught ");
	           System.out.println("Localized Message :"+e.getLocalizedMessage());

	       }
	   }
}
