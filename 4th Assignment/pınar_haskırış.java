/**
 * Main Class
 * 
 * Program Explanation: 
 * This program loads several functions from an input text file and compute their zero derivative points. 
 * (In the range -10 to 10.)
 * Afterwards the program draws the functions and puts a black dot where the derivative is zero.
 * (There might be more than one zero derivative point.)
 */


import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class pınar_haskırış {	

	public static void main(String[] args) {

		StdDraw.enableDoubleBuffering(); //to see the function graphs when the program is finished

		ArrayList<Polynomial> pols = new ArrayList<>(); //creating an ArrayList to store the functions
		pols = loadFunctions("functions4.txt"); //calling loadFunctions method to read the files
		System.out.println(pols); //printing out the functions
		System.out.println();

		ArrayList<Double> xValues = new ArrayList<>(); //creating an ArrayList to store x values where the derivative of the function is 0
		ArrayList<Double> yValues = new ArrayList<>();//creating an ArrayList to store y values where the derivative of the function is 0

		StdDraw.setXscale(-10,10); //setting the scales according to our range
		StdDraw.setYscale(-10,10);
		StdDraw.setPenColor(StdDraw.BLACK);

		System.out.println("Points where derivative is 0 (in order): " );
		for(int s =0; s<pols.size();s++) { //creating a for loop to go through the functions
			pols.get(s).derivative(-10, 10); //taking the derivative of each function

			pols.get(s).draw(); //calling the draw method to draw the functions

			xValues = pols.get(s).getX(); //storing the x values where the derivative is 0
			yValues = pols.get(s).getY(); //storing the y values where the derivative is 0

			StdDraw.setPenColor(StdDraw.LIGHT_GRAY); 

			//drawing the x and y axis
			StdDraw.line(-10, 0, 10, 0); 
			StdDraw.line(0, -10, 0, 10);

			//drawing small lines on the axis to create the coordinate system
			for (int o =-10; o<=10;o++) { 
				StdDraw.line(o+0.02, 0.02, o+0.02, 0.04);
				StdDraw.line(0.02, o+0.02, 0.04, o+0.04);
			}

			//drawing black dots where the derivative is zero
			if(xValues!=null) {
				for(int f =0; f<=xValues.size()-1;f++) {
					double xPoint = xValues.get(f);
					double yPoint = yValues.get(f);
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.filledCircle(xPoint, yPoint, 0.25);
				}
			}

			//printing out where the derivative is 0
			if(xValues!=null) {
				System.out.println("x(s): " +xValues); 
				System.out.println("y(s): " +yValues); 
				System.out.println();	
			}
			else
				System.out.println("There are no point with zero derivative in the range. ");
		}
		StdDraw.show();
	}

	/**
	 * @param file means the input file that we are going to load the functions from
	 * @return an ArrayList of the functions
	 */
	public static ArrayList<Polynomial> loadFunctions(String file) {

		String[] lineArray = new String[75]; //to store the lines in the file as a string

		ArrayList<Polynomial> p = new ArrayList<>(); //to store the functions in the file
		try { //beginning of try-catch (to see if there is any exception)

			File myFile = new File(file);
			Scanner first = new Scanner(myFile); //creating a scanner to read the file

			while(first.hasNext()){ //while there is a line to read
				String line = first.nextLine(); //take that line as a string
				String[] parts = line.split(","); //split the line by ","

				int count =0; //keeping a count to determine the type of functions later

				lineArray[count] = parts[0]; //storing the pieces of the line

				if(parts.length == 2) { // if there are 2 pieces, the function's degree is 1 so we add a function that has 1 as it's degree
					p.add(new Polynomial1D(Double.parseDouble(parts[0]),(Double.parseDouble(parts[1]))));
				}
				else if (parts.length == 3) {// if there are 3 pieces, the function's degree is 2 so we add a function that has 2 as it's degree
					p.add(new Polynomial2D(Double.parseDouble(parts[0]),(Double.parseDouble(parts[1])),(Double.parseDouble((parts[2])))));
				}
				else if (parts.length == 4) {// if there are 4 pieces, the function's degree is 3 so we add a function that has 3 as it's degree
					p.add(new Polynomial3D(Double.parseDouble(parts[0]),(Double.parseDouble(parts[1])),(Double.parseDouble((parts[2]))),(Double.parseDouble(parts[3]))));
				}
			}
		}

		catch(Exception e) { //end of try-catch
			return null;
		}
		return p;
	}
}
