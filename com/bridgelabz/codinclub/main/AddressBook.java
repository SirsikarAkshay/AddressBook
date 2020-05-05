/*Create an address book class
*@ author: Akshay
*/

//import the required classes
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class AddressBook{

		/**
		* Get the details of the new user
		*/

		public static HashMap<String,String> newEntry(){
		Person p=new Person();
		p.getDetails();
		HashMap<String,String> entry=p.storeDetails();
		System.out.println("Do you wish to save the file? y or n?");
		Scanner in=new Scanner(System.in);
		String choice=in.nextLine();
		if(choice.equals("y")){
      			fileWriter f=new fileWriter();
			f.writeFile(entry);
			return(entry);
		}
		else {
			return(entry);
		}
	}

	/** 
	* main function performing creating,editing and deleting of records
	*/

	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		String opt="0";
		while(opt!="4"){
		System.out.println("Choose the operation you want to perform\n"+
								"1. Create new Entry\n"+
								"2. Edit existing Entry\n"+
								"3. Delete a selected entry\n"+
								"4. Close the program\n");
		opt=in.nextLine();
			switch(opt){
				//create a new entry
				case "1":
					newEntry();
				break;
				//Edit the given entry else create new
				case "2":
					Scanner sup=new Scanner(System.in);
                                        System.out.println("Enter the id of the record you want to update");
                                        String upd=sup.nextLine();
                                        EditRecord edit=new EditRecord();
                                        edit.updateRecord("addressbook.csv",upd,6,",");
                                        System.out.println("Record with ID "+upd+" is updated");
				break;
				//Delete a given record
				case "3":
					Scanner s=new Scanner(System.in);
					System.out.println("Enter the id of the record you want to delete");
					String rem=s.nextLine();
					DeleteRecord del=new DeleteRecord();
					del.removeRecord("addressbook.csv",rem,6,",");
					System.out.println("Record with ID "+rem+" is deleted");
				break;
				//exit the program
				case "4":
					System.exit(0);
				break;
			}
		}
	}
}
