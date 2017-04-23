package javaTest;

public class Vec3d {
	private double x, y, z;
	//constructor
	public Vec3d(double x, double y, double z){
		this.x = x; this.y = y; this.z = z;
	}
	//crossProduct method with one parameter.
	public Vec3d cross(Vec3d b){
		return new Vec3d(this.y * b.z - this.z * b.y, this.z * b.x -this.x * b.z, this.x * b.y - this.y * b.x);
	}
	//crossProduct method with two parameter.
	public static Vec3d cross(Vec3d a, Vec3d b){
		return new Vec3d(a.y * b.z - a.z * b.y, a.z * b.x - a.x * b.z, a.x * b.y - a.y * b.x);
	}
	//dotProduct method with two parameter.
	public static double dot(Vec3d a, Vec3d b){
		return a.x * b.x + a.y * b.y + a.z *b.z;
	}
	//plus method with one parameter.
	public Vec3d plus(Vec3d b){
		return new Vec3d(this.x + b.x, this.y + b.y, this.z + b.z);
	}
	//take the negative of a instance. 
	public Vec3d neg(){
		return new Vec3d(-this.x, -this.y, -this.z);
	}
	//return the vec3d by String.
		public String toString(){
			return "( " + this.x + ", " + this.y + ", " + this.z + " )";
		}
	public static void main(String[] args) {
		Vec3d v1 = new Vec3d(1.0, 2.5, 3.0);
		Vec3d v2 = new Vec3d(-1.5, 1.0, 1.5);
		Vec3d v3 = v1.cross(v2);
		Vec3d v4 = Vec3d.cross(v1,v2);
		double d = Vec3d.dot(v1,v2);
		Vec3d v5 = v1.plus(v2);
//		Vec3d v6 = v1.times(v2);
		Vec3d v7 = v1.neg();
		System.out.println("v1 = " + v1);
		System.out.println("v2 = " + v2);
		System.out.println("v3 = " + v3);
		System.out.println("v4 = " + v4);
		System.out.println("d = " + d);
		System.out.println("v5 = " + v5);
//		System.out.println("v6 = " + v6);
		System.out.println("v7 = " + v7);
		
	}	

}
