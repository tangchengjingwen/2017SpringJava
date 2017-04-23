package javaTest;

public class Complex {
	private double real,imag;
	//constructor without parameter.
   public Complex(){
		real = 0; imag  = 0;
	}
	//constructor with one parameter.
   public Complex(double r){
		real = r; imag = 0;
	}
	//constructor with two parameter.
	public Complex(double r, double i){
		real = r; imag = i;
	}
	//plus method.
	public Complex plus(Complex b){
		return new Complex(real + b.real, imag + b.imag);
	}
	//times method.
	public Complex times(Complex b){
		return new Complex(real * b.real - imag * b.imag, imag * b.real + real * b.imag);
	}
	//return the negative of one complex.
	public Complex neg(){
		return new Complex(-real, -imag);
	}
	//return the absolute value of a complex.
	public double abs(){
		return Math.sqrt(real * real - imag *imag);
	}
	//return the complex by String.
	public String toString(){
		return  real + " + " + imag +"i";
	}
	  
	
	
	public static void main(String[] args){
	    Complex c1 = new Complex(); //   0 + 0i
	    Complex c2 = new Complex(2.5); // 2.5 + 0i
	    Complex c3 = new Complex(2.5, 1.8); //2.5 + 1.8i
	    Complex c4 = c2.plus(c3); // 5.0 + 1.8i
	    Complex c5 = c2.times(c3); // https://en.wikipedia.org/wiki/Complex_number
	    Complex c6 = c5.neg();
	    double m = c6.abs(); // magnitude of c6    sqrt of real^2 - imag^2

        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2);
        System.out.println("c3 = " + c3);
        System.out.println("c4 = " + c4);
        System.out.println("c5 = " + c5);
        System.out.println("c6 = " + c6);
        System.out.println("m = " + m);
	}

}
