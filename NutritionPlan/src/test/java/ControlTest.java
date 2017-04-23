import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

/**
 * Test certain methods used in Control
 *
 */

public class ControlTest {
	
	
	Control c = new Control();
	
	//Test Lists
    ArrayList<String> list = new ArrayList<String>();
    ArrayList<FoodObject> foodList = new ArrayList<FoodObject>();
    
    //Test Foods
	FoodObject apple = new FoodObject("apple", "fruit", 100, list, 1);
	FoodObject banana = new FoodObject("banana", "fruit", 80, list, 1);
	

	@Test
	public void copyProfileTest(){

		c.getP1().getMeal("Other").addFood(apple);
		c.getP1().getMeal("Other").addFood(banana);
		System.out.println(c.getP1().getMeal("Other").toString());
		
		System.out.println("Copying profile...");
		c.copyProfile(1,2);
		System.out.println("Profile copied.\n");
		
		System.out.println(c.getP2().getMeal("Other").toString());
		
		System.out.println("\n" + c.getP1().getMeal("Other").toString());
	}
	


	
}
