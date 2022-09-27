package in.sts.stsproject.singleFileRead;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class SingleFileReader {
	final static Logger log=Logger.getLogger(SingleFileReader.class);
	static	Scanner scanner=null;
	public static void singleFileRead()  {

		scanner=new Scanner(System.in);
		System.out.println("Enter the drive name");
		String Drive=scanner.nextLine();
		System.out.println("Enter the file name");
		String fileInput=scanner.nextLine();
		String path=""+Drive+":\\"+fileInput+".txt";

		FileReader fileRead = null;
		try {
			fileRead = new FileReader(path);
		} catch (FileNotFoundException e) {
			log.error("Cannot Read File Properly");
		}
		@SuppressWarnings("resource")
		BufferedReader bufferRead=new BufferedReader(fileRead);
		String line;
		int count=0;
		try {
			while((line=bufferRead.readLine())!=null) {
				String words[]=line.split(" ");
				count=count+words.length;
				log.debug(count);


			}


		}catch(IOException ioException) {
			log.error("Cannot Read file Properly");
		}


	} 

	public static void main(String[] args) {
		BasicConfigurator.configure();

		SingleFileReader.singleFileRead();


	}
}
