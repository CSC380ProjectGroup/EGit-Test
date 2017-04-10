import java.sql.SQLException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bolen
 */
public class UpdateFoodTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        ArrayList<String> a1 = new ArrayList();
        a1.add("appleseeds");
        FoodObject food1 = new FoodObject("apple","fruit",100,a1,1);
        ArrayList<String> a2 = new ArrayList();
        a2.add("gluten");
        a2.add("shellfish");
        a2.add("test");
        FoodObject food2 = new FoodObject("Crab Cakes","seafood",150,a2,1);
        ArrayList<String> a3 = new ArrayList();
        a3.add("cheese");
        FoodObject food3 = new FoodObject("Taco","Mexican",120,a3,2);
        
        DBStuff.UpdateFoodDB(food1);
        DBStuff.UpdateFoodDB(food2);
        DBStuff.UpdateFoodDB(food3);
        
        System.out.println(DBStuff.getFoodDB(food1.getName()));
        System.out.println(DBStuff.getFoodDB(food2.getName()));
        System.out.println(DBStuff.getFoodDB(food3.getName()));
    }
    
}
