//import statement
import java.util.*;

/** Person class
@ author: Akshay
*/

public class Person{

	public static String firstName;
	public static String lastName;
	public static String address;
	public static String city;
	public static String state;
	public static String zip;
	public static String phone;

	/**
	*Get the details of a person
	*return void
	*/

	public static void getDetails(){
		Scanner in=new Scanner(System.in);
		
		System.out.println("Enter the first name of the person");
		firstName=in.nextLine();
		
		System.out.println("Enter the last name of the person");
		lastName=in.nextLine();
		
		System.out.println("Enter the address of the person");
		address=in.nextLine();

		System.out.println("Enter the city of the person");
		city=in.nextLine();
		
		System.out.println("Enter the state of the person");
		state=in.nextLine();

		System.out.println("Enter the zip of the person");
		zip=in.nextLine();

		System.out.println("Enter the phone number of the person");
		phone=in.nextLine();
	}

	/**
	* Create a HashMap to store the person details
	* return Person Hashmap
	*/
	
	public static HashMap<String,String> storeDetails(){
		HashMap<String,String> person=new HashMap<String,String>();
		person.put("FirstName",firstName);
		person.put("LastName",lastName);
		person.put("Address",address);
		person.put("City",city);
		person.put("State",state);
		person.put("Zip",zip);
		person.put("Phone",phone);

		System.out.println("The details of the user are as follows: ");
		System.out.println(person);
		return(person);
	}


	
	/**
	*Main method
	*/

	public static void main(String args[]){
		getDetails();
		storeDetails();
	}
}
