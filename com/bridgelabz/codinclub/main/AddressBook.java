/*Create an address book class
*@ author: Akshay
*/

//import the required classes
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;


public class AddressBook{
	public static List<HashMap> newEntry(){
		Person p=new Person();
		p.getDetails();
		HashMap<String,String> entry=p.storeDetails();

		List<HashMap> Entries=new ArrayList<HashMap>();
		Entries.add(entry);
		
		FileWriter f=null;
		try{
			f=new FileWriter("addressbook.csv",true);
			for(Map.Entry<String,String> m:entry.entrySet()){
				f.append(m.getKey());
				f.append(",");
			}
			f.append("\n");
			for(Map.Entry<String,String> m:entry.entrySet()){    
      	 	f.append(m.getValue());
				f.append(',');
			}
			System.out.println("Saved entry to the address book");

		}catch (Exception e){
			System.out.println("error");
			e.printStackTrace();
		} finally {
			try{
				f.flush();
				f.close();
			}catch (IOException e){
				System.out.println("error");
				e.printStackTrace();
		}

	}
	return(Entries);

	}
		

	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		String opt;
		System.out.println("Choose the operation you want to perform\n"+
								"1. Create new Entry\n"+
								"2. Edit existing Entry\n"+
								"3. Delete a selected entry\n"+
								"4. Close the program\n");
		opt=in.nextLine();

			switch(opt){
				case "1": 
					newEntry();
				break;
				case "4":
					System.exit(0);
			}
	}
}
