/**
 * Polynomial Class
 * 
 * Program Explanation: 
 * This program loads several functions from an input text file and compute their zero derivative points. 
 * (In the range -10 to 10.)
 * Afterwards the program draws the functions and puts a black dot where the derivative is zero.
 * (There might be more than one zero derivative point.)
 * 
 */


import java.util.ArrayList;

public class Polynomial {

	//creating the data fields that are given in the uml diagram
	ArrayList<Double> X; 
	ArrayList<Double> Y;
	double h;

	//writing getter methods and setter methods
	public ArrayList<Double> getX() {
		return X;
	}
	public void setX(ArrayList<Double> x) {
		X = x;
	}
	public ArrayList<Double> getY() {
		return Y;
	}
	public void setY(ArrayList<Double> y) {
		Y = y;
	}
	public double getH() {
		return h;
	}
	public void setH(double h) {
		this.h = h;
	}
	public double evaluate (double x) { //since every function type will have it's own evaluate function we return 0 here
		return 0.0;
	}

	public void draw(){ //writing a draw function to draw the graphs of the functions
		//setting the scales according to our range
		StdDraw.setXscale(-10,10); 
		StdDraw.setYscale(-10,10);
		StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE); //setting the color to light blue
		for(double r = -10; r <= 10;r = r+0.001) { //going through our range (from -10 to 10)
			StdDraw.filledCircle(r, evaluate(r), 0.03); //drawing a circle at every point so we can have a line		
		}
	}

	/**
	 * @param xmin means where our range starts
	 * @param xmax means where our range ends
	 * @return an array of x values
	 *
	 * To explain what the function is doing (better):
	 * When we try to find the derivatives of a function by using the limit formula, usually we have more than 10 values.
	 * As an example let's say we got 0.0065, 0.0066, 0.0067, 0.0034, 0.0037, 0.0035.
	 * We should choose 0.0065 and 0.0034. To do that, first, 
	 * we check if the value is close enough the zero. Then we compare the two values and take the smaller one.
	 * Then the function checks if the difference between the values is decreasing or not. 
	 * If it is decreasing we stay in the same range (means we continue to find smaller values). 
	 * If it is increasing means we are at a new range.
	 * (60s is one range, 30s is another)
	 */


	public ArrayList<Double> derivative (double xmin, double xmax){
		//creating ArrayLists to store x(s) and y(s)
		ArrayList <Double> x = new ArrayList<>(); 
		ArrayList <Double> y = new ArrayList<>();

		double min=0.0001; //we will use min to determine if the difference between values is increasing or not
		double val1; 
		double val2; 

		int index=0; //we will use the index when we are choosing the 0 derivative points to take
		boolean firstime= true; //since there is nothing to compare before the first value we need to check where we are

		setH(0.00001);
		for (double i=xmin;i<=xmax;i=i+h) { //going through the given range

			//separating the calculation to see better
			double k; 
			double l;
			k = evaluate(i+h);
			l = evaluate(i);
			val2= Math.abs(k-l)/h; 
			val1= Math.abs(evaluate(i)-evaluate(i-h))/h; //the value that comes before val2

			if (val2 < 0.0001) { //if val2 is close enough to the zero
				if(val2<val1){ //and if val2 is smaller than the value that comes before itself
					if(val2<min){ //and if val2 is smaller than the minimum difference in it's range

						min=val1; //then we have a new minimum 
						if(!firstime) { // if we are not at the first value (since there is nothing to compare where the index is -1)
							//we remove what we had before 
							x.remove(index-1); 
							y.remove(index-1);
							index--; 
						}
						//and add our new value (because we found a smaller one (closer to 0))
						x.add(i); 
						y.add(evaluate(i)); 
						setX(x); 
						setY(y);
						index++; 
						firstime=false; //it is not our first time anymore
					}
				}
				else { 
					min=0.0001; //else we are in a new range where we need a new minimum
					firstime=true; //we want to keep the value we picked from the other range, so we act like it is our first time again (it actually is our first time in the new range)
				}
			}
		}
		return x; //returning the x(s)
	}


}
