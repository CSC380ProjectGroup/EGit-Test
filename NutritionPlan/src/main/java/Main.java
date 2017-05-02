import java.util.*;

/**
* A "Main" class containing a text-based testing interface. Runs a SwingGui object.
* @author Brandon
*/

public class Main {

	// Check if a given input is an integer
	public static boolean isInteger(String s){
		try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    return true;
	}
	
/**
 * Text-based interface 
 */
	
	// Select one of three test profile objects
	static void changeProfile(Profile p1, Profile p2, Profile p3) {
		Scanner s = new Scanner(System.in);
		for(;;){
			System.out.println("Select a Profile: [p1] [p2] [p3]");
			System.out.println("(Or enter 'exit' to close the program)");
			String in = s.nextLine();
			System.out.println("");

			if(in.equals("p1")){
				viewProfile(p1);
			}
			else if(in.equals("p2")){
				viewProfile(p2);
			}
			else if(in.equals("p3")){
				viewProfile(p3);
			}
			else if(in.equals("exit")){
				break;
			}
			else{
				System.out.println("'" + in + "' " + "is not a valid option");
			}
		}
	}
	
	// Select one of four test meal objects for the selected test profile
	static void viewProfile(Profile p){
		Scanner s = new Scanner(System.in);
		for(;;){
			System.out.println("Select a meal for " + p.getName() + ":");
			System.out.println("[breakfast] [lunch] [dinner] [other]");
			System.out.println("(Or enter 'back' to return to profiles)");
			String in = s.nextLine();
			System.out.println("");
			
			if(in.equals("breakfast")){
				viewMeal(p.getMeal("Breakfast"));
			}
			else if(in.equals("lunch")){
				viewMeal(p.getMeal("Lunch"));
			}
			else if(in.equals("dinner")){
				viewMeal(p.getMeal("Dinner"));
			}
			else if(in.equals("other")){
				viewMeal(p.getMeal("Other"));
			}
			else if(in.equals("back")){
				break;
			}
			else{
				System.out.println("'" + in + "' " + "is not a valid option");
			}		
		}
	}

	// Print the given test meal's information
	static void viewMeal(Meal m){
		Scanner s = new Scanner(System.in);
		for(;;){
			System.out.println("Meal Info:");
			System.out.println(m.toString());
			System.out.println("- - - - - - - -");
			System.out.println("Enter a food name to view that food's info");
			System.out.println("'add' = add a Food object"); 
			System.out.println("'note' = change the notes");
			System.out.println("...or enter 'back' to return to profile");
			String in = s.nextLine();
			System.out.println("");
			
			if(in.equals("back")) {
				break;
			}
			else if(in.equals("add")){
				addFood(m);
			}
			else if(in.equals("note")){
				System.out.print("Enter note: ");
				in = s.nextLine();
				m.setNotes(in);
			}
			else if(m.scanFood(in) != null){
				System.out.println("** Displaying Info for '" + m.scanFood(in).getName() + "' **");
				System.out.println(m.scanFood(in).toString() + "\n"); //print toString() of food, if meal has it 
			}
			else {
				System.out.println("Invalid Command: " + in);
			}
		}
	}
	
	// Create a new Food object to store into the meal
	static void addFood(Meal l){
		Scanner s = new Scanner(System.in);
		FoodObject fo = new FoodObject();

		System.out.print("Enter a food name: ");
		String in = s.nextLine();
		fo.setName(in);
		System.out.print("Enter a food type: ");
		in = s.nextLine();
		fo.setType(in);
		System.out.print("Enter a number of calories per serving: ");
		in = s.nextLine();
		if(!isInteger(in)){ 
			// if given string is not an integer, set cal to zero
		}
		else{
			fo.setCal(Integer.parseInt(in));
		}
		System.out.print("Enter a quantity (adjusts calories accordingly): ");
		in = s.nextLine();
		if(!isInteger(in)){ 
			// if given string is not an integer, set quantity to zero
		}
		else{
			fo.setQuantity(Integer.parseInt(in));
		}

		for (;;) {
			System.out.print("Enter an allergen (or 'stop' to finish): ");
			in = s.nextLine();

			if (in.equals("stop")) {
				break;
			} else {
				fo.addAlg(in);
				System.out.println("\nAllergies: " + fo.printAlg());
			}
		}

		l.addFood(fo);
		System.out.println("Food object '" + fo.getName() + "' had been added to '" + l.getType() + "'\n");
	}
	
	public static void main(String[] args) {
		
	/**
	 * Test Interface
	 */
	//Profile Options
		Profile p1 = new Profile("Profile 1");
		Profile p2 = new Profile("Profile 2");
		Profile p3 = new Profile("Profile 3");
	//Meal Options
		Meal b = new Meal("Breakfast"); 
		Meal l = new Meal("Lunch"); 
		Meal d = new Meal("Dinner");
		Meal o = new Meal("Other"); 
	//Gives profiles meals
		p1.addMeal(b); p1.addMeal(l); p1.addMeal(d); p1.addMeal(o);
		p2.addMeal(b); p2.addMeal(l); p2.addMeal(d); p2.addMeal(o);
		p3.addMeal(b); p3.addMeal(l); p3.addMeal(d); p3.addMeal(o);

	//Launch
//		System.out.println("Nutrition Planner: By Daniel, Thomas, and Brandon");
//	    changeProfile(p1,p2,p3); // method (AKA text interface) finishes when user enters 'exit'
//		System.out.println("Exiting program..."); 
		
	/**
	 * Run Program (GUI Interface)
	 */
		SwingGui GUI = new SwingGui();
	}
}