package pack1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileIO {

	public static void main(String[] args) throws IOException {
		
		/*
		 * File
		 * FileWriter
		 * BufferedWriter
		 * 
		 * File
		 * FileReader
		 * BufferedReader
		 * *Scanner
		 */
		
		File file = new File("C:/Users/selcuksener/workspace/Project/data.txt");
		//file.createNewFile();
		//System.out.println(file.exists());
		
		FileWriter fwriter = new FileWriter(file);
		BufferedWriter bfwriter = new BufferedWriter(fwriter);
		
		bfwriter.write("First Content");
		bfwriter.newLine();
		bfwriter.write("Second Content");
		bfwriter.newLine();
		bfwriter.write("Third Content");
		bfwriter.newLine();
		
		bfwriter.close();
		
		
		/*FileReader freader = new FileReader(file);
		BufferedReader bfreader = new BufferedReader(freader);
		
		while(bfreader.ready()){
			System.out.println(bfreader.readLine());	
		}*/
		
		Scanner scan = new Scanner(file);
		while(scan.hasNext()){
			System.out.println(scan.nextLine());
		}
		
		
		
		

	}

}
