package syed.baqar.naqvi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class StudentFileData {
	public static final String FILE_PATH = "C:\\workspace\\Data";
	public static final String FILE_NAME = "StdData.txt";
	
	
	public static void Readfile(String filepath , String filename) {
		Path filePath = Paths.get(filepath, filename);
		 
		//try-with-resources
		try (Stream<String> lines = Files.lines( filePath )) 
		{
		   // lines.sorted().forEach(System.out::println);
		   // System.out.println(lines.count());
			lines.forEach(str -> 
			{
				StringTokenizer defaultTokenizer = new StringTokenizer(str);
				 
				System.out.println("Total number of tokens found : " + defaultTokenizer.countTokens());	
				while (defaultTokenizer.hasMoreTokens())
				{
				    System.out.println(defaultTokenizer.nextToken());
				}
				 
				System.out.println("Total number of tokens found : " + defaultTokenizer.countTokens());
			}
			);
		   
		} 
		catch (IOException e) 
		{
		    e.printStackTrace();
		}
	}
	public static void Writefile(String filepath , String filename, String studentRecord ) {
		Path filePath = Paths.get(filepath, filename);
		
		boolean fileExists = Files.exists(filePath);
		if(!fileExists) {
			 try {
				Files.write(filePath, studentRecord.getBytes(), StandardOpenOption.CREATE_NEW);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        if(fileExists) {
            try {
                // Appending The New Data To The Existing File
                Files.write(filePath, studentRecord.getBytes(), StandardOpenOption.APPEND);
                System.out.println("! Data Successfully Appended !");
            } catch (IOException ioExceptionObj) {
                System.out.println("Problem Occured While Writing To The File= " + ioExceptionObj.getMessage());
            }
        } else {
            System.out.println("File Not Present! Please Check!");
        }       
		}
}
