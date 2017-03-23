import java.util.*;

public class Main {

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

	
	static void viewMeal(Meal m){
		System.out.println("** Displaying Meal Info **");
		System.out.println(m.toString());
		Scanner s = new Scanner(System.in);
		for(;;){
			System.out.println("\nEnter 'back' to return to profile");
			String in = s.nextLine();
			System.out.println("");
			if(in.equals("back")) {
				break;
			}
			else {
				System.out.println("Try again.");
			}
		}
		
	}
	
	public static void main(String[] args) {
		
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
		
    //Food Objects (for testing)
		ArrayList<String> allerg = new ArrayList<String>();
		allerg.add("peanut");
		FoodObject f1 = new FoodObject("Peanut Butter", "snack", 180, allerg, 1);
		//System.out.println(f1.toString());
		
	//Launch
		System.out.println("Nutrition Planner: By Daniel, Thomas, and Brandon");
	    changeProfile(p1,p2,p3);
		System.out.println("Exiting program...");
		
		}
}
	

