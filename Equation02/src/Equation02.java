import java.util.Scanner;

public class Equation02 {

	public static void main(String[] args) {
		int a, b, c, d, e;
		
		Scanner input = new Scanner(System.in);
		System.out.print("��� 5���� �Է��ϼ��� : ");
		a = input.nextInt();
		b = input.nextInt();
		c = input.nextInt();
		d = input.nextInt();
		e = input.nextInt();
		
		int number[] = {a,b,c,d,e};
		
		//������ ��� ��Ÿ����
		String expression = "";
		int y = number.length;
		for (int x=0;x<number.length;x++) {
			y--;
			if (number[x] == 0) {
				continue;
			}
			if (x<number.length-1) {
				expression = expression + number[x]+"*x^"+y+" + ";
				continue;
			}
		}
		expression = expression + e;
		System.out.println(expression);
	
		
		System.out.print("x�� �Է��ϼ��� : ");
		int k = input.nextInt();
		
		//������ �����
		int total = 0;
		int j = number.length-1;
		for(int i=0;i < number.length;i++) {
			total = total + (int)(number[i]*Math.pow(k,j));
			j--;
		}

		System.out.println(total);

	}

}