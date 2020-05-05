//imports go here

import java.io.*;

public class DeleteRecord{

	public static void removeRecord(String filepath,String removeTerm,int posTerm,String delim) {

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
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

}
