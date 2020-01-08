/**
 * Polynomial1D Class
 * Program Explanation: 
 * This program loads several functions from an input text file and compute their zero derivative points. 
 * (In the range -10 to 10.)
 * Afterwards the program draws the functions and puts a black dot where the derivative is zero.
 * (There might be more than one zero derivative point.)
 * 
 */

public class Polynomial1D extends Polynomial {
	//creating the data fields that are given in the uml diagram
	private double a;
	private double b;

	//writing getter methods and setter methods
	public double getA() {
		return a;
	}
	public void setA(double a) {
		this.a = a;
	}
	public double getB() {
		return b;
	}
	public void setB(double b) {
		this.b = b;
	}
	//writing constructors
	public Polynomial1D() {}

	public Polynomial1D(double a, double b) {
		this.setA(a);
		this.setB(b);
	}

	@Override
	public double evaluate(double x) { //to evaluate the functions (finding f(x))
		return (getB()* x + getA());
	}
	@Override
	public void draw(){ //writing a draw function to draw the graphs of the functions
		StdDraw.setXscale(-10,10);
		StdDraw.setYscale(-10,10);
		StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE); //setting the color to light blue
		for(double r = -10; r <= 10;r = r+0.001) { //going through our range (from -10 to 10)
			StdDraw.filledCircle(r, evaluate(r), 0.03); //drawing a circle at every point so we can have a line
		}
	}

	@Override
	public String toString() { //to display the functions
		return "Function:" + "(" + getA() + ")x^1" + "+" + "(" + getB()+ ")\n" ;

	}

}
