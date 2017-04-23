package javaTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Gravbody {
	static final double G = 6.67408E-11;
	private double x, y, z;
	private double vx, vy, vz;
	private double ax, ay, az, a;
	private double dt, t;
	private double r, aphelion, perihelion, m, diameter, orbpe, rotaperi, axialtilt, orbinclin;
	private double v, d;
	private static double f;
	private String name, orbit, mass, diam, per, aphe, orbper, rotap, axialti, orbincli;
	
	//constructor of Gravbody.
	Gravbody(Scanner s,Gravbody[] a) {
		name = s.next();
		orbit = s.next();
		mass = s.next();
		diam = s.next();
		per = s.next();
		aphe = s.next();
		orbper = s.next();
		rotap = s.next();
		axialti = s.next();
		orbincli = s.next();
		
		aphelion = Double.valueOf(aphe);
		perihelion = Double.valueOf(per);
		m = Double.valueOf(mass);
		diameter = Double.valueOf(diam);
		orbpe = Double.valueOf(orbper);
		rotaperi = Double.valueOf(rotap);
		axialtilt = Double.valueOf(axialti);
		orbinclin = Double.valueOf(orbincli);
		r=(aphelion + perihelion)/2;
		if(orbit.equals("Sun"))
			x = r;
	/*		else{
				x=r+a[getnum(orbit)].x;
			}
		y = y + vy*t + 0.5*ay*t*t;
		z = z + vz*t + 0.5*az*t*t;	*/	
	}	
	
/*	public void getvolicity(Gravbody a){
		vx=vx+ax*dt;
		vy=vy+ay*dt;
		vz=vz+az*dt;
	}
	
	
	public static double getForce(Gravbody a){
		f=G	*a.m/(a.r*a.r);
		return f;
	}
	
	public double geta(Gravbody b){
		a=getForce(b)/m;
		return a;
	}

    public static int getnum(String a){
	    switch(a){
	      case "Earth": return 3;
	      case "Jupiter": return 6;
	      case "Mars": return 5;
	      default:return -1;
	    }
	} 
*/    
	// print method
	public static void print(Gravbody a){
		System.out.print(a.name + "\t");
		System.out.println(a.x  +"\t" + a.y + "\t" + a.z);	
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("solarsystem.dat"));
		scan.nextLine();
		Gravbody[] planet = new Gravbody[14];
		for(int i = 0;i < 14; i++)
			planet[i] = new Gravbody(scan,planet);
		System.out.println("planet" + "\t" + "x" +"\t"+ "y" +"\t" + "z");
		for(int i = 0; i < 14; i++)
			print(planet[i]);
	}
}
