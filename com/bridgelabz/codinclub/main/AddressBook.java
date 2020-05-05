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

	/*public static List<String[]> editEntry() throws IOException,FileNotFoundException{
		String file="addressbook.csv";
		List<String[]> content = new ArrayList<>();
	
		System.out.println("Enter the Name of the person to be changed");
		Scanner in=new Scanner(System.in);
		String initName=in.nextLine();

		System.out.println("Enter the updated value");
		String finalName=in.nextLine();


		try(BufferedReader br=new BufferedReader(new FileReader(file))) {
			String line="";
			while ((line=br.readLine()) != null) {
				content.add(line.split(","));
			}
		} catch (FileNotFoundException e) {
		}
		System.out.println(content);
		return content;
	}*/


	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		String opt="0";
		while(opt!="4"){
		System.out.println("Choose the operation you want to perform\n"+
								"1. Create new Entry\n"+
								"2. Write to file\n"+
								"3. Edit existing Entry\n"+
								"3. Delete a selected entry\n"+
								"4. Close the program\n");
		opt=in.nextLine();
			switch(opt){
				case "1":
					newEntry();
				break;
				case "2":
				break;
				case "4":
					System.exit(0);
				break;
			}
		}
	}
}
