//An Animal class will be used to model some basic characteristics of animals for the application. An

package module8;

public class ManipulateAnimals {
	public static void main(String[]args)
	   {
	       All[]objects = {new Vehicle("Honda",16), new Animal("Cat"), new Vehicle("Toyota",9), new Animal("Dog")};
	       for(All object: objects)
	       {
	           object.drawObjects();
	           object.playSound();
	           object.resizeObject();
	           object.rotateObject();
	       }
	   }
}
