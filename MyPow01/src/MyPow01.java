
public class MyPow01 {
	
	public static double myPow(double base, double exp) {
		double square;
		double result = 1;
		for(int i = 0;i<exp;i++ ) {
			result = result * base;
		}
		
		return result;
	}

	public static void main(String args[]) 
    { 
        double a = 3; 
        double b = 4; 
        System.out.println(MyPow01.myPow(a, b)); 

    }
}
