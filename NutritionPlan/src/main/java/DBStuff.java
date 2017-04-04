/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Thomas
 */
public class DBStuff {
    
    // in class meal use this method
    public static void addNewFoodDB(FoodObject food) throws ClassNotFoundException, SQLException {
        PreparedStatement ps = null;
        String name = food.getName();
        String type = food.getType();
        int cal = food.getCal();
        int q = food.getQuantity();

        //loading drivers for mysql
        Class.forName("com.mysql.jdbc.Driver");

        //create string of sql query
        String query = "INSERT INTO Foods" + "(FoodName,FoodType,Calories,Quantity) VALUES" + "(?,?,?,?)";

        //connect to database
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/NutritionDB", "root", "1356999g");

        //prepare Statement for SQL Query
        ps = con.prepareStatement(query);
        ps.setString(1, name);
        ps.setString(2, type);
        ps.setInt(3, cal);
        ps.setInt(4, food.getQuantity());

        ps.executeUpdate();

        ArrayList<String> algs = food.getAlg();
        for (String alg : algs) {

            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            //create string of sql query
            query = "INSERT INTO FoodAlgs"
                    + "(IngName, FoodName) VALUES" + "(?,?)";

            //connect to database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/NutritionDB",
                    "root", "1356999g");

            //prepare Statement for SQL Query
            ps = con.prepareStatement(query);
            ps.setString(1, alg);
            ps.setString(2, food.getName());

            ps.executeUpdate();
        }
    }

    public static FoodObject getFoodDB(String name) throws ClassNotFoundException, SQLException {
        //make food object from db based on name
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean status = false;
        String type = "";
        int cal = 0;
        int q = 0;
        FoodObject food = new FoodObject();
        //get values of food from Foods table

        //loading drivers for mysql
        Class.forName("com.mysql.jdbc.Driver");

        //create string of sql query
        String query = "SELECT * FROM Foods WHERE FoodName = ?";

        //connect to database
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/NutritionDB", "root", "1356999g");

        //prepare Statement for SQL Query
        ps = con.prepareStatement(query);
        ps.setString(1, name);

        rs = ps.executeQuery();

        status = rs.next();
        if (status) {
            //get results
            type = rs.getString("FoodType");
            cal = rs.getInt("Calories");
            q = rs.getInt("Quantity");
            food.setCal(cal);
            food.setType(type);
            food.setQuantity(q);
            food.setName(name);
        } else {
            System.out.println("Food not available");
        }

        //get allergy array from FoodAlgs
        //loading drivers for mysql
        Class.forName("com.mysql.jdbc.Driver");

        //create string of sql query
        query = "SELECT * FROM FoodAlgs WHERE FoodName = ?";

        //connect to database
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/NutritionDB",
                "root", "1356999g");

        //prepare Statement for SQL Query
        ps = con.prepareStatement(query);
        ps.setString(1, name);

        rs = ps.executeQuery();
        String alg;
        while (rs.next()) {
            alg = rs.getString("IngName");
            food.addAlg(alg);
        }

        return food;
    }


    private static ArrayList<String> getAlgArray(String n) throws ClassNotFoundException, SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<String> algs = new ArrayList();
        //loading drivers for mysql
        Class.forName("com.mysql.jdbc.Driver");

        //create string of sql query
        String query = "SELECT * FROM FoodAlgs WHERE FoodName = ?";

        //connect to database
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/NutritionDB",
                "root", "1356999g");

        //prepare Statement for SQL Query
        ps = con.prepareStatement(query);
        ps.setString(1, n);

        rs = ps.executeQuery();
        String alg;
        while (rs.next()) {
            alg = rs.getString("IngName");
            algs.add(alg);
        }

        return algs;
    }

    //UPDATE method
    //parameter is foodobject (assumed to have same name as some food object already in db)
    //send as parameter new foodobject with same name but other values changed
    public static void UpdateFoodDB(FoodObject food) throws ClassNotFoundException, SQLException {
        PreparedStatement ps = null;
        String name = food.getName();
        String type = food.getType();
        int cal = food.getCal();
        int q = food.getQuantity();

        //loading drivers for mysql
        Class.forName("com.mysql.jdbc.Driver");

        //create string of sql query
        String query = "UPDATE Foods SET Calories = ?, FoodType = ?, Quantity = ? WHERE FoodName = ?";

        //connect to database
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/NutritionDB",
                "root", "1356999g");

        //prepare Statement for SQL Query
        ps = con.prepareStatement(query);
        ps.setInt(1, cal);
        ps.setString(2, type);
        ps.setInt(3, q);
        ps.setString(4, name);

        ps.executeUpdate();

        ArrayList<String> algs = food.getAlg();
        for (String alg : algs) {
            try{
            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            //create string of sql query
            query = "UPDATE FoodAlgs SET IngName = ?, FoodName = ? WHERE FoodName = ?";

            //connect to database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/NutritionDB",
                    "root", "1356999g");

            //prepare Statement for SQL Query
            ps = con.prepareStatement(query);
            ps.setString(1, alg);
            ps.setString(2, name);
            ps.setString(3, name);

            ps.executeUpdate();
            } catch (Exception e){
            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            //create string of sql query
            query = "INSERT INTO FoodAlgs"
                    + "(IngName, FoodName) VALUES" + "(?,?)";

            //connect to database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/NutritionDB",
                    "root", "1356999g");

            //prepare Statement for SQL Query
            ps = con.prepareStatement(query);
            ps.setString(1, alg);
            ps.setString(2, food.getName());

            ps.executeUpdate();
            }
        }
    }
}
