package Coursework2;

import java.io.*;
import java.util.Scanner;

public class newspellchecker {
	public static void main(String[] args) throws IOException{
		String path = "C:\\Users\\gspri\\eclipse-workspace\\Coursework2\\src\\Coursework2\\";
		String filename = "Dictionary.txt";
		//file of original dictionary
		File file = new File(path+filename);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
//		buffered reader.
		Scanner input = new Scanner(System.in);
		System.out.println("What file do you want to check");
		String checkFile = "Super";
		File filein = new File(path+checkFile+".txt");
		FileReader frin = new FileReader(filein);
		BufferedReader brin = new BufferedReader(frin);
		//file to be checked.
		String wordFFile = null,checkWord = null;
		String check = null;
		boolean exit = true;
		//initialise variables
		while(exit) {
			while((checkWord = brin.readLine()) !=null) {
				if(checkDictionary(fr, br, checkWord, wordFFile)) {
					//call check method
					//if check = true program terminated
					System.out.println();
					System.out.println(checkWord + " is in the dictionary");
					add(path,checkWord);
					exit = false;
				}
				else {
					//else program not terminated.
					System.out.println(checkWord + " is not in the dictionary.");
					System.out.println();
					System.out.println("Type 'add' if you want to add it to the dictionary anyway.");
					//add the word into the dictionary.
					System.out.println("Type 'exit' if you want to exit");
					//exit program

					check = input.nextLine();

					if(check.equals("exit")) {
						exit = false;
						//exit program
					}
					else if(check.equals("check")) {
						System.out.println("What word do you want to check");
						checkWord = input.nextLine();
						checkDictionary(fr, br, checkWord, wordFFile);
					}
					else if(check.equals("add")) {
						add(path, checkWord);
						//call add method
						exit = false;
						//exit program
					}
					
				else {
						System.out.println("Try again");
						check = input.nextLine();
					}
				}
			
		}
		System.out.println("Thank you...");
	}
	}

	public static boolean checkDictionary(FileReader fr,BufferedReader br, String checkword, String wordFFile) throws IOException {
		wordFFile = null;
		//refresh BufferedReader		
		boolean tof = false;
		while((wordFFile = br.readLine()) !=null && tof == false) {
			//iterate over dictionary checking every word.
			if(checkword.equals(wordFFile)) {
				tof = true;
				//if word found in dictionary exit.
			}
		}
		return tof;
	}

	public static void add(String path, String checkedWord) throws IOException {
		File file = new File(path + "Spellchecked.txt");
		PrintWriter print = new PrintWriter(file);
		//make copy of dictionary
		print.println(checkedWord);
		print.close();
	}

}

