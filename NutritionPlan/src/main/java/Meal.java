/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Thomas
 */
public class Meal {
    //instance variables
    int totalCalories;
    Date mealDate = new Date();
    String description;
    ArrayList<FoodObject> foods;
    
    //constructer
    public Meal() {
        totalCalories = 0;
        mealDate = null;
        description = "";
        foods = null;
    }
    
    //parameterized constructer
    public Meal(ArrayList<FoodObject> items, String des, int totalCal, Date d) {
        totalCalories = totalCal;
        description = des;
        foods = items;
        mealDate = d;
    }
    
    //methods
    public int getTotalCalories() {
        return totalCalories;
    }
    public Date getMealDate() {
        return mealDate;
    }
    public void setMealDate(Date date) {
        mealDate = date;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void addFood(FoodObject food) {
        foods.add(food);
        totalCalories = totalCalories + food.getCal();
    }
    public void removeFood(FoodObject food) {
        if (foods.contains(food)) {
            foods.remove(food);
            totalCalories = totalCalories - food.getCal();
        }else{
            System.out.println("Not part of meal");
        }
    }
    
}
