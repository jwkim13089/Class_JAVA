import java.util.Scanner;

public class unit {

	public static void main(String[] args) {
		
		int count = 0;
		int a = 0, b = 0, c = 0, d = 0, e = 0;
		int number[] = {a,b,c,d,e};
		System.out.printf("�������� ��� : ");
		while (count < 5) {
			Scanner input = new Scanner(System.in);
			number[count] = input.nextInt();
			count++;
		}
		System.out.println("�������� ��� : "+ number);
		

	}

}
