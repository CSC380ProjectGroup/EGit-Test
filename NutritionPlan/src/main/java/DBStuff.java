/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author Thomas
 */
public class DBStuff {
    // in class meal use this method
    public static void addFoodDB(FoodObject food) {
        PreparedStatement ps = null;
        String name = food.getName();
        String type = food.getType();
        int cal = food.getCal();
        try{
            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");
            
            //create string of sql query
            String query = "INSERT INTO Foods"+ 
                    "(FoodName,FoodType,Calories) VALUES"+ "(?,?,?)";
            
            //connect to database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/NutritionDB",
                    "root","1356999g");
            
            //prepare Statement for SQL Query
            ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, type);
            ps.setInt(3, cal);
            
            ps.executeUpdate();
            
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
    public static FoodObject getFoodDB(String name) {
        //name is primary key
        //should return food if there (without allergies) and null if not there
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean status = false;
        String type = "";
        int cal = 0;
        FoodObject food = new FoodObject();
        try{
            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");
            
            //create string of sql query
            String query = "SELECT * FROM Foods WHERE FoodName = ?";
            
            //connect to database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/NutritionDB",
                    "root","1356999g");
            
            //prepare Statement for SQL Query
            ps = con.prepareStatement(query);
            ps.setString(1, name);
            
            rs = ps.executeQuery();
            
            status = rs.next();
            if (status) {
                //get results
                type = rs.getString("FoodType");
                cal = rs.getInt("Calories");
                food.setCal(cal);
                food.setType(type);
                food.setName(name);
            }else{
                System.out.println("Food not available");
            }
            
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return food;
    }
    
    
    public static void listFoodsDB() {
        //list food names as primary key
        PreparedStatement ps = null;
        ResultSet rs = null;
        String n = "";
        String t = "";
        int c = 0;
        int i = 0;
        try{
            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");
            
            //create string of sql query
            String query = "SELECT * FROM Foods";
            
            //connect to database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/NutritionDB",
                    "root","1356999g");
            
            //prepare Statement for SQL Query
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                n = rs.getString("FoodName");
                t = rs.getString("FoodType");
                c = rs.getInt("Calories");
                System.out.println(i + ": " + "name->" + n + ", type->" + t + ", calories->" + c);
                i++;
            }
            
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
