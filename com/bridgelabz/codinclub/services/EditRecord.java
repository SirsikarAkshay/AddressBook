//imports go here

import java.io.*;
import java.util.*;
/**
* Edit the existing record else create a new
* author @Akshay
*/

public class EditRecord{

	public static void updateRecord(String filepath,String removeTerm,int posTerm,String delim) {

		int pos=posTerm-1;
		String tempFile="temp.csv";
		File oldFile=new File(filepath);
		File newFile=new File(tempFile);

		String currentLine;
		String data[];

		try{
			FileWriter fw=new FileWriter(tempFile,true);
			BufferedWriter bw=new BufferedWriter(fw);
			PrintWriter pw=new PrintWriter(bw);

			FileReader fr=new FileReader(filepath);
			BufferedReader br=new BufferedReader(fr);

			while((currentLine=br.readLine()) != null)
			{
				data=currentLine.split(",");
				if(!(data[pos].equalsIgnoreCase(removeTerm))){
					pw.println(currentLine);
				}
			}
			pw.flush();
			pw.close();
			fr.close();
			br.close();
			bw.close();
			fw.close();

			oldFile.delete();
			File dump=new File(filepath);
			newFile.renameTo(dump);

			// Enter the updated details of the user

			Scanner in = new Scanner(System.in);
			System.out.println("Enter the new id of the person");
                	String id=in.nextLine();

                	System.out.println("Enter the new first name of the person");
                	String firstName=in.nextLine();

                	System.out.println("Enter the last new name of the person");
                	String lastName=in.nextLine();

                	System.out.println("Enter the new address of the person");
                	String address=in.nextLine();

                	System.out.println("Enter the new city of the person");   
                        String city=in.nextLine();

                	System.out.println("Enter the new state of the person");
                	String state=in.nextLine();

                	System.out.println("Enter the new zip of the person");
                	String zip=in.nextLine();

                	System.out.println("Enter the new phone number of the person");
                	String phone=in.nextLine();

			WriteRecord wr=new WriteRecord();
			wr.update(zip,address,firstName,state,phone,id,lastName,city);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

}
