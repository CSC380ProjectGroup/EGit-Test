import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Thomas
 */
public class UploadFoodTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //note: this only works if a NEW food is being added.
        //if the name of the food is already in the database it will not work
        
        ArrayList<String> a1 = new ArrayList();
        a1.add("appleseeds");
        FoodObject food1 = new FoodObject("apple","fruit",100,a1,1);
        ArrayList<String> a2 = new ArrayList();
        a2.add("gluten");
        a2.add("shellfish");
        FoodObject food2 = new FoodObject("Crab Cakes","seafood",150,a2,1);
        ArrayList<String> a3 = new ArrayList();
        FoodObject food3 = new FoodObject("Taco","mexican",120,a3,1);
        
        DBStuff.addNewFoodDB(food1);
        DBStuff.addNewFoodDB(food2);
        DBStuff.addNewFoodDB(food3);
        
        System.out.println(DBStuff.getFoodDB(food1.getName()));     
        System.out.println(DBStuff.getFoodDB(food2.getName())); 
        System.out.println(DBStuff.getFoodDB(food3.getName())); 
    }
    
}
