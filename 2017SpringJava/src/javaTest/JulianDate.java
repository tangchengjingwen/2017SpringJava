package javaTest;

public class JulianDate {
	private jday;
	private final double J200 = 0;
	
	public static void main(String[] args){
		JulianDate j = new JulianDate (2017, 1, 1);
		JulianDate j2 = new JulianDate (2017, 1, 1, 12, 0 ,0);
		JulianDate j3 = new JulianDate (2017, 2, 13, 16, 11, 0);
		System.out.println(j);
		JulianDate j4 = j3.plus(5.5);
		int year = j4.getYear();
		int mon  = j3.getMonth();
		int day = j3.getDay();
		String nmonName = j3.getMonName();
		
	}

}
