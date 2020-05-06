
//import statements go here

import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
/**
* Write a record to a file
*@ author Akshay
*/

public class WriteRecord{
	public static void update(String Zip,String Address,String FirstName,String State,String Phone,String ID,String LastName,String City){
		FileWriter f=null;
                try{
                        f=new FileWriter("addressbook.csv",true);
                        f.append(Zip);
                        f.append(",");
			f.append(Address);
			f.append(",");
                        f.append(FirstName);
			f.append(",");
			f.append(State);
			f.append(",");
			f.append(Phone);
			f.append(",");
			f.append(ID);
			f.append(",");
			f.append(LastName);
			f.append(",");
			f.append(City);
			f.append(",");
                }
                catch (Exception e){
                        System.out.println("Error");
                        e.printStackTrace();
		}finally {
                try{
                        f.flush();
                        f.close();
                }catch (IOException e){
                        System.out.println("error");
                        e.printStackTrace();
                        }
                }
	}
}
