package firstProject;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class LockedMeCom {
	public static final String projectFilesPath = "D:\\lockedmefiles";
	public static final String errorMessage="\tContact admin of LockedMe.com at admin@lockedme.com ";
	public static void main(String[] args) {
		
		createFile();

	}
	public static void showMenu() {
		System.out.println("**********************************************************");
		System.out.println("\t\t Welcomes You LockedMe.Com");
		System.out.println("**********************************************************");
		System.out.println("\n\n\t\t   @Developed by Krishan@");
		System.out.println("**********************************************************");
		System.out.println("\n\n\t 1. Display all the Files");
		System.out.println("\t 2. Add a new File");
		System.out.println("\t 3. Delete a File");
		System.out.println("\t 4. Search a File");
		System.out.println("\t 5. Exit");
		System.out.println("**********************************************************");
		
	}
	
	public static void getFiles() {
		try {
		File folder=new File(projectFilesPath);
		File[] fileList = folder.listFiles();
		if(fileList.length==0)
			System.out.println("\tNo files exist in File directory ");
		else{
			for(var f:fileList) {
			System.out.println(f.getName());
			}
		}
	}
	
	catch(Exception Ex) {
		System.out.println(errorMessage);
	}
	}	
	public static void createFile() {
		Scanner obj = new Scanner(System.in);
		try {
		System.out.println("\tEnter file name :");
		
		String fileName=obj.nextLine();
		File file=new File(projectFilesPath+"\\"+ fileName);
		if(file.exists()) {
			
			System.out.println("\tSame name File already exist in directory. Choose other name or delete first that file.");
		}
		else {
			
		
		System.out.println("\tEnter how many lines you want to write in file");
		int linesCount=Integer.parseInt(obj.nextLine());
		FileWriter myWriter=new FileWriter(projectFilesPath+"\\"+ fileName);
		for(int i = 1;i<=linesCount;i++) {
			System.out.println("\tEnter Line "+i+" in file");
			myWriter.write(obj.nextLine()+"\n");
		}
		System.out.println("\tFile successfully Added to the directory.");
		
		myWriter.close();
		}
		}
		catch(Exception Ex){
		System.out.println(errorMessage);	
		}
		finally {
			obj.close();
		
		}
	}
	public static void deleteFile() {
		System.out.println("\tEnter the name of file to be deleted");
		Scanner obj=new Scanner(System.in);
		String fileName=obj.nextLine();
		try {
		File file=new File(projectFilesPath+"\\"+ fileName);
		if(file.exists()) {
			file.delete();
			System.out.println("\tFile successfully deleted");
		}
		else
			System.out.println("\tFile do not exist in directory ");
		}
		catch(Exception Ex)	{
			System.out.println(errorMessage);
		}
		finally {
			obj.close();
		}
		
		
		
	}
	public static void searchFile() {
		System.out.println("\tEnter the name of file you want to search");
		Scanner obj=new Scanner(System.in);
		String fileName=obj.nextLine();
		try {
		File file=new File(projectFilesPath+"\\"+ fileName);
		if(file.exists()) {
			
			System.out.println("\tFile found");
		}
		else
			System.out.println("\tFile do not exist in directory ");
		}
		catch(Exception Ex)	{
			System.out.println(errorMessage);
		}
		finally {
			obj.close();
		}
	}
}
