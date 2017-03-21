
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thomas
 */
public class UploadFoodTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //upload food and test output
        ArrayList<String> a = new ArrayList<String>();
        FoodObject food1 = new FoodObject("apple","fruit",100,a,1);
        FoodObject food2 = new FoodObject("salmon","fish",120,a,1);
        FoodObject food3 = new FoodObject("angel hair","pasta",180,a,1);
        
        DBStuff.addFoodDB(food1);
        DBStuff.addFoodDB(food2);
        DBStuff.listFoodsDB();
        DBStuff.addFoodDB(food3);
        DBStuff.listFoodsDB();
        
        FoodObject food4 = DBStuff.getFoodDB("apple"); //food4 should equal food1 except for allergies
        
        System.out.println("should be FRUIT" + " " + food4.type);
    }
    
}
