
//import goes here

import java.util.*;
import java.io.*;
import java.io.IOException;

/**
* Write to a file from the Hashmap stored
*@author Akshay
*/

public class FileWrite{
	
	public void writeHeader(){
	        FileWriter f=null;
		try{
			f=new FileWriter("addressbook.csv",true);
                	f.append("Zip,Address,FirstName,State,Phone,ID,LastName,City,");
                        f.append("\n");
		}
		catch (Exception e){
			System.out.println("Error");
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
	}

	public void writeFile(HashMap<String,String> entry){
	FileWriter f=null;
      	try{
         	f=new FileWriter("addressbook.csv",true);
         	for(Map.Entry<String,String> m:entry.entrySet()){
                	  f.append(m.getValue());
            	f.append(",");
         	}
         	f.append("\n");
         	System.out.println("Saved entry to the address book");
	}
	catch (Exception e){
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

}
		public static void main(String args[]){
		}
}
