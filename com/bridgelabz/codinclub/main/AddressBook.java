/*Create an address book class
*@ author: Akshay
*/

//import the required classes
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;


public class AddressBook{

	public static List<HashMap<String,String>> Entries=new ArrayList<HashMap<String,String>>();
	public static List<HashMap<String,String>> newEntry(){
		Person p=new Person();
		p.getDetails();
		HashMap<String,String> entry=p.storeDetails();

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
			f.append("\n");
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

	public static List<HashMap<String,String>> editEntry(){
		List<HashMap<String,String>> ens=Entries;

		System.out.println("Enter the Name of the person to be changed");
		Scanner in=new Scanner(System.in);
		String initName=in.nextLine();

		System.out.println("Enter the updated value");
		String finalName=in.nextLine();
		Iterator itr=ens.iterator();
		while(itr.hasNext()){
			HashMap<String,String> hm=(HashMap) itr.next();
			Iterator itr2=hm.entrySet().iterator();
			while(itr2.hasNext()){

				Map.Entry mapElement=(Map.Entry)itr2.next();
				if(mapElement.getKey()=="FirstName" && mapElement.getValue()==initName){
					System.out.println(mapElement.getValue());
				}
			}
		}
		return(ens);
	}


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
				case "1":
					newEntry();
				break;
				case "2":
					editEntry();
				break;
				case "4":
					System.exit(0);
				break;
			}
		}
	}
}
