/**
 * Main Class
 * Program Explanation:
 * This program generates a map with seas, walls, food and a cat. Cat is randomly moving with one step at a time.
 * If the cat is near the food, it eats the food. Then the food disappears. Cat doesn't leave any traces.
 * Also cat can not step into the seas or the walls.
 * When the program is finished, the amount of food that the cat has eaten is displayed.
 * 
 */

import java.util.Random;
import java.awt.Color;
import java.io.File;
import java.util.Scanner;

public class pınar_haskırış { 
	public static void main(String[] args) { 

		int worldSize = 45; //determining the world size
		int timeCounter = 500; //determining how many times the cat will move
		int [][] worldArray = new int[40][40]; //creating a world array to store integers from the txt file

		worldArray= loadNumbers("world.txt"); //storing integers from the txt file to world array


		StdDraw.clear(StdDraw.BLACK); //setting the background color to black
		StdDraw.enableDoubleBuffering();
		StdDraw.setXscale(0, 40); //setting x and y scales
		StdDraw.setYscale(0, 40); 


		// drawing the world
		drawWorld(worldArray);

		Cat[] cats = new Cat[10]; //creating a cat array in case we have more than one cats, even though in this case we have only one

		cats[0] = new Cat(10,10,StdDraw.ORANGE); //creating a cat

		Random r = new Random(); //to have random numbers
		int i=0;
		for (int k = 0; k < timeCounter; k++) {

			// if there is a cat, then draw
			if (cats[i] != null) {

				
				boolean foodEaten =false; //food has not been eaten
				int direction = r.nextInt(4); //taking a random number between 0 to 3 to decide the direction

				if(worldArray[cats[i].getX()-1][cats[i].getY()]==3) { //if the food is eaten
					 
					StdDraw.setPenColor(StdDraw.WHITE); 
					StdDraw.filledSquare(cats[i].getY()+0.425, 40- (cats[i].getX()+0.425), 0.425); //draw white to remove the food from the map
					cats[i].move(2); //move the cat (up)
					cats[i].incFood(); //increase the amount of food that is been eaten
					worldArray[cats[i].getX()][cats[i].getY()]=0; //in the array 3 meant food, now the food is gone, 3 becomes 0 (white square)
					foodEaten = true; //food has eaten

				}
				if(worldArray[cats[i].getX()][cats[i].getY()+1]==3) { //if the food is eaten
					 
					StdDraw.setPenColor(StdDraw.WHITE);
					StdDraw.filledSquare(cats[i].getY()+0.425, 40- (cats[i].getX()+0.425), 0.425); //draw white to remove the food from the map
					cats[i].move(3); //move the cat (right)
					cats[i].incFood(); //increase the amount of food that is been eaten
					worldArray[cats[i].getX()][cats[i].getY()]=0; //in the array 3 meant food, now the food is gone, 3 becomes 0 (white square)
					foodEaten = true; //food has eaten


				}	
				if(worldArray[cats[i].getX()+1][cats[i].getY()]==3) { //if the food is eaten
					 
					StdDraw.setPenColor(StdDraw.WHITE);
					StdDraw.filledSquare(cats[i].getY()+0.425, 40- (cats[i].getX()+0.425), 0.425); //draw white to remove the food from the map
					cats[i].move(0); //move the cat (down)
					cats[i].incFood();//increase the amount of food that is been eaten
					worldArray[cats[i].getX()][cats[i].getY()]=0; //in the array 3 meant food, now the food is gone, 3 becomes 0 (white square)
					foodEaten = true; //food has eaten


				}	
				if(worldArray[cats[i].getX()][cats[i].getY()-1]==3) { //if the food is eaten
					
					StdDraw.setPenColor(StdDraw.WHITE);
					StdDraw.filledSquare(cats[i].getY()+0.425, 40- (cats[i].getX()+0.425), 0.425); //draw white to remove the food from the map
					cats[i].move(1); //move the cat(left)
					cats[i].incFood(); //increase the amount of food that is been eaten
					worldArray[cats[i].getX()][cats[i].getY()]=0; //in the array 3 meant food, now the food is gone, 3 becomes 0 (white square)
					foodEaten = true; //food has eaten


				}	
				if(!foodEaten) { //if the food is NOT eaten

					if(direction==0) // and if the direction equals to 0 (down)
						if(worldArray[cats[i].getX()+1][cats[i].getY()]==1 || worldArray[cats[i].getX()+1][cats[i].getY()]==2)
							continue; //and if there is no wall or sea near the cat continue
						else 
						{
							StdDraw.setPenColor(StdDraw.WHITE); //every time the cat moves, we draw white to get rid of the traces of the cat
							StdDraw.filledSquare(cats[i].getY()+0.425, 40- (cats[i].getX()+0.425), 0.425);
							cats[i].move(direction); } //move the cat 

					else if (direction==1) //if the direction equals to 1 (left)
						if(worldArray[cats[i].getX()][cats[i].getY()-1]==1 || worldArray[cats[i].getX()][cats[i].getY()-1]==2)
							continue; //and if there is no wall or sea near the cat continue
						else {
							StdDraw.setPenColor(StdDraw.WHITE); //every time the cat moves, we draw white to get rid of the traces of the cat
							StdDraw.filledSquare(cats[i].getY()+0.425, 40- (cats[i].getX()+0.425), 0.425);
							cats[i].move(direction);}//move the cat 

					else if (direction==2) //if the direction equals to 2 (up)
						if(worldArray[cats[i].getX()-1][cats[i].getY()]==1 || worldArray[cats[i].getX()-1][cats[i].getY()]==2)
							continue; //and if there is no wall or sea near the cat continue
						else {
							StdDraw.setPenColor(StdDraw.WHITE); //every time the cat moves, we draw white to get rid of the traces of the cat
							StdDraw.filledSquare(cats[i].getY()+0.425, 40- (cats[i].getX()+0.425), 0.425);
							cats[i].move(direction);} //move the cat 
					
					else //if  the direction equals to 3 (right)
						if(worldArray[cats[i].getX()][cats[i].getY()+1]==1 || worldArray[cats[i].getX()][cats[i].getY()+1]==2)
							continue; //and if there is no wall or sea near the cat continue
						else {
							StdDraw.setPenColor(StdDraw.WHITE); //every time the cat moves, we draw white to get rid of the traces of the cat
							StdDraw.filledSquare(cats[i].getY()+0.425, 40- (cats[i].getX()+0.425), 0.425);
							cats[i].move(direction);} //move the cat 
				}
			}
			
			cats[i].draw(); //drawing the cat
			StdDraw.pause(50); //determining the speed of the cat


		}System.out.println("Food eaten: " + cats[i].getfoodCount()); //displaying the amount of food that has been eaten
	}


	/**
	 * Draws world according to the integers in the array
	 * 0 : white 
	 * 1 : gray (walls)
	 * 2 : blue (seas)
	 * 3 : magenta (foods)
	 * 
	 * @param n size of the square world
	 */

	public static void drawWorld (int[][] n) {

		for (int i = 0; i < n.length; i++) {
			for (int j = 0; j < n.length; j++) {
				if(n[i][j] == 0) {
					StdDraw.setPenColor(StdDraw.WHITE);}
				else if (n[i][j] == 1)
					StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
				else if (n[i][j] == 2)
					StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
				else if (n[i][j] == 3)
					StdDraw.setPenColor(StdDraw.MAGENTA);	
				else                  
					StdDraw.setPenColor(StdDraw.WHITE);
				StdDraw.filledSquare(j+0.45, n.length-(i+0.45), 0.45);	
			}
		}

	}


	/**
	 * 
	 * @param file is the txt file that is given
	 * @return a 2D array that stores the data from the txt file
	 * 
	 */
	public static int[][] loadNumbers(String file) {

		try { //beginning of try-catch (to see if there is any exception)
			File myFile = new File(file);
			Scanner first = new Scanner(myFile); //creating a scanner

			int rows ;
			int columns;
			String str;

			rows = first.nextInt(); //determining the values of rows and columns
			columns = first.nextInt();
			first.nextLine();

			int[][]array = new int[rows][columns]; //creating an array according to the size of the columns and rows

			int i=0;
			int j=0;
			
			while(first.hasNextLine()){ //if there is a line
				str = first.nextLine(); //store that line in the str string
				
				Scanner second = new Scanner(str); //creating a second scanner
				second.useDelimiter(";"); //splitting the string by using ; as delimiter
				while(second.hasNext()){
					array[j][i]= Integer.parseInt(second.next()); //parsing the string and returning an integer
					i++; //going through all the elements in the row
				}
				second.close();

				j++; //going to the next row (by increasing columns)
				i=0; //starting from the beginning of the row 
			}
			first.close();
			
			return array;
		}
		catch(Exception e) { //end of try-catch
			return null;
		}		
	}
}