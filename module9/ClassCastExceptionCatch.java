package module9;

public class ClassCastExceptionCatch {
	public static void main(String[] args) {
	       Object obj = new String("test");
	       System.out.println("calling with obj=new String");
	       checkClassCastException(obj);
	       obj = new Integer(4);
	       System.out.println("calling with obj=new Integer");
	       checkClassCastException(obj);

	   }
	   public static void checkClassCastException(Object obj){
	       try{
	           if(obj instanceof String){
	               System.out.println("No exception");
	           }
	           else
	               throw new ClassCastException();
	       }
	       catch(ClassCastException e){
	           System.out.println("Exception caught ");
	           System.out.println("LocalizedMessag :"+e.getLocalizedMessage());
	           System.out.println("toString :"+e.toString());
	           System.out.println("Messag :"+e.getMessage());
	           System.out.println("StackTrace :");
	           //e.printStackTrace();
	       }
	   }
}
