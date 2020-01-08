/*
 * Program Explanation: 
 * This program finds the most frequent numbers in an input text file and displays them with their frequency. 
 * User has to choose one of two files when program asks for an input number (1 or 2). 
 * 
 */
package assignment;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class pınar_haskırış {

	public static void main(String[] args) {

		int[] numberArray= new int[1000]; //creating an array for the numbers
		int[] frequencyArray = new int [1000]; // creating an array to use in the calculation of the frequency
		int max; 
		int input; 
		Scanner reader = new Scanner(System.in); //creating a scanner to get input from the user

		System.out.println("Choose datafile to read:"); //Displaying the options for the user
		System.out.println("Enter 1 for data1.txt");
		System.out.println("Enter 2 for data2.txt");
		input = reader.nextInt(); //asking for the input
		if (input==1) //data1.txt selected
		{
			numberArray= loadNumbers("data1.txt"); //using loadNumbers method for the first file
			frequencyArray= computeFrequency(numberArray); //using computeFrequency method for the first file
			max = findMaxFrequency(frequencyArray); //using findMaxFrequency method for the first file
			outputMaxFrequency(frequencyArray, max); //using outputMaxFrequency method for the first file
		}
		else if (input==2) //data2.txt selected
		{
			numberArray= loadNumbers("data2.txt"); //using loadNumber method for the second file
			frequencyArray= computeFrequency(numberArray);//using computeFrequency method for the second file
			max = findMaxFrequency(frequencyArray);//using findMaxFrequency method for the second file
			outputMaxFrequency(frequencyArray, max);//using outputMaxFrequency method for the second file
		}
	}

	/**
	 * @param inputFile meaning the input file
	 * @return All the numbers in the input file as an array
	 */
	public static int[] loadNumbers(String inputFile) {

		try { //to see if there is any exception (beginning of try-catch)
			File myFile = new File(inputFile); //opening the text file
			Scanner first = new Scanner(myFile);
			int count = 0; //starting count from 0
			while (first.hasNextInt()) {
				count++; //increasing it as we go over the lines
				first.nextInt();
			}

			int[] array = new int[count]; //creating an array to load the numbers
			Scanner second = new Scanner(myFile); //creating a new scanner
			for (int i=0; i<array.length; i++)
				array[i] = second.nextInt(); //reading the integers and placing them in the array
			return array;
		}

		catch(Exception e){ //(the end of try-catch)
			return null; 
		}		

	}
	/**
	 * @param myArray meaning the input array
	 * @return a new array shaped by the input array (if input array has the integer 34 once, 
	 * return array(freqArray) has it's 34th index value as 1 and so on)
	 */
	public static int[] computeFrequency(int[] myArray)
	{
		int[]freqArray = new int[1000];
		for(int i=0; i<myArray.length;i++)
			freqArray[myArray[i]]++;
		return freqArray;
	}
	/**
	 * @param freqArray meaning the input array that we will use to find the maximum frequency
	 * @return most frequent number
	 */
	public static int findMaxFrequency(int[] freqArray)
	{
		int max = 0;
		for (int i=0;i<freqArray.length;i++)
		{
			if (freqArray[i]>max)
				max = freqArray[i];
		}
		return max;
	}
	/**
	 * @param Array meaning input array
	 * @param max meaning the maximum number as an input
	 */
	public static void outputMaxFrequency(int[] Array,int max)
	{
		for(int i=0;i<Array.length;i++)
		{
			if(max==Array[i])
				System.out.println("Number: " + i + "," + " Frequency: " + Array[i]);
		}

	}
}