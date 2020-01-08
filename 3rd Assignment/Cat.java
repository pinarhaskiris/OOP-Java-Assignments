/**
 * Cat Class
 *
 * Program Explanation:
 * This program generates a map with seas, walls, food and a cat. Cat is randomly moving with one step at a time.
 * If the cat is near the food, it eats the food. Then the food disappears. Cat doesn't leave any traces.
 * Also cat can not step into the seas or the walls.
 * When the program is finished, the amount of food that the cat has eaten is displayed.
 * 
 */

import java.awt.Color;
import java.util.Random;


public class Cat { 
	
	//determining the data fields
	private int x;
	private int y;
	private Color color;
	private int foodCount;

	/**
	 * Constructor for the cat
	 * @param x x location
	 * @param y y location
	 * @param c color of the cat
	 */

	Cat(int x, int y, Color c) {
		this.x = x;
		this.y = y;
		this.color = c;
	}

	public int getfoodCount() { //getter function for the food count
		return foodCount;
	}
	public void setfoodCount(int foodCount) { //setter function for the food count
		this.foodCount=foodCount;
	}

	public int getX() { //getter function for x
		return x;
	}

	public void setX(int x) { //setter function for x
		this.x = x;
	}

	public int getY() { //getter function for y
		return y;
	}

	public void setY(int y) { //setter function for y
		this.y = y;
	}

	/**
	 * Increase the food count
	 */
	
	public void incFood() {
		this.foodCount++;
	}

	/**
	 * Draw the cat on the canvas
	 */
	
	public void draw() {
		StdDraw.setPenColor(color);
		StdDraw.filledCircle(y+0.5, 40 - (x+0.5), .3);
		StdDraw.show();
	}

	/**
	 * Moves the cat
	 * 
	 * Possible directions:
	 * 0: down
	 * 1: left
	 * 2: up
	 * 3: right
	 * @param direction Direction can be 0,1,2, or 3. See the explanations above.
	 */

	public void move(int direction) {
		if (direction == 0)
			x++;
		else if (direction == 1)
			y--;
		else if (direction == 2)
			x--;
		else if (direction == 3)
			y++;

	}


}