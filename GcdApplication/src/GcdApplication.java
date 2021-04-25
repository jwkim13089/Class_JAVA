import java.util.Scanner;

public class GcdApplication {

	public static int gcd(int x, int y) {
		int r;
		
		while (y!=0) {
			r = x%y;
			x=y;
			y=r;
		}
		return x;

	}
	
	public static int gcd2(int x, int y) {
		int r;
		if(y == 0) {
			return x;
		}
		else {
			r = x%y;
			x=y;
			return gcd2(x,r);
			
		}
		
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int x, y;
		System.out.print("number");
		x = s.nextInt();
		y = s.nextInt();
		
		System.out.println(gcd(x,y) + "," + gcd2(x,y));
	}
}
