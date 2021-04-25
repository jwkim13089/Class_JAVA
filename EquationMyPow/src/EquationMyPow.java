import java.util.Scanner;

public class EquationMyPow {
	
	public static double myPow(double base, double exp) {
		double square;
		double result = 1;
		for(int i = 0;i<exp;i++ ) {
			result = result * base;
		}
		
		return result;
	}

	public static void main(String[] args) {
		int number[] = {0,0,0,0,0};
		Scanner input = new Scanner(System.in);
		for(int count = 0;count<5;count++) 
			number[count] = input.nextInt();
		System.out.println("�������� ��� : "+ number[0]+number[1]+number[2]+number[3]+number[4]);
		
		//������ ��� ��Ÿ����
		String expression = "";
		int y = number.length;
		for (int x=0;x<number.length;x++) {
			y--;
			if (number[x] == 0)
				continue;
			if (x==0)
				expression = expression + number[x]+"*x^"+y;
			else if (x<=number.length-1) {
				expression = expression + " + "+number[x]+"*x^"+y;
				continue;
				} 
			}
		System.out.println("������ : " + expression);
	
		
		System.out.print("x �Է� : ");
		int k = input.nextInt();
		
		//�����Ŀ� x�� �������� �� ǥ��
		String substitution = "";
		int z = number.length;
		for (int x=0;x<number.length;x++) {
			z--;
			if (number[x] == 0)
				continue;
			if (x==0)
				substitution = substitution + number[x]+"*"+"("+k+")"+"^"+z;
			else if (x<=number.length-1) {
				substitution = substitution + " + "+number[x]+"*"+"("+k+")"+"^"+z;
				continue;
				} 
			}
		
		//������ �����
		int total = 0;
		String total_expression = "";
		int j = number.length;
		for(int i=0;i < number.length;i++) {
			j--;
			if(number[i] == 0) 
				continue;
			if(total_expression != "") {
				total_expression = total_expression + " + ";
			}
			int add = (int)(number[i]*EquationMyPow.myPow(k,j));
			total_expression = total_expression + add ;
			total = total + add;
		}
		System.out.println(substitution + " = " +total_expression + " = " + total);
	}
	
}