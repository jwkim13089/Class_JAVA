import java.util.Scanner;

public class Equation01 {

	public static void main(String[] args) {
		int a, b, c, d, e;
		
		Scanner input = new Scanner(System.in);
		System.out.print("계수 5개를 입력하세요 : ");
		a = input.nextInt();
		b = input.nextInt();
		c = input.nextInt();
		d = input.nextInt();
		e = input.nextInt();
		
		int number[] = {a,b,c,d,e};
		
		//방정식 모양 나타내기
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
	
		System.out.print("x를 입력하세요 : ");
		int k = input.nextInt();
		int total = 0;
		for(int i=0;i < number.length;i++) {
			for (int j=number.length-1;j<=0;j--) {
				total = total + (int)(number[i]*Math.pow(k, j));
			}
		}
		
		System.out.println(total);

	}

}
