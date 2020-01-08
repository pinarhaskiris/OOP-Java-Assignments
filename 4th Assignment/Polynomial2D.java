/**
 * Polynomial2D Class
 *
 * Program Explanation: 
 * This program loads several functions from an input text file and compute their zero derivative points. 
 * (In the range -10 to 10.)
 * Afterwards the program draws the functions and puts a black dot where the derivative is zero.
 * (There might be more than one zero derivative point.)
 * 
 */

public class Polynomial2D extends Polynomial {
	//creating the data fields that are given in the uml diagram
	double a;
	double b;
	double c;
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
	public double getC() {
		return c;
	}
	public void setC(double c) {
		this.c = c;
	}
	//writing constructors
	public Polynomial2D() {}

	public Polynomial2D(double a,double b, double c) {
		setA(a);
		setB(b);
		setC(c);
	}

	@Override
	public double evaluate (double x) { //to evaluate the functions (finding f(x))
		return getC()*x*x + getB()*x + getA();

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
	public String toString() {//to display the functions
		return "Function: (" + getC()+")x^2" + "+(" + getB() +")x^1" + "+(" +  getA() + ")\n";
	}

}
