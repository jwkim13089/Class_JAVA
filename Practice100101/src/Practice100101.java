import java.util.Scanner;

public class Practice100101 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] pick = new int[10];
		int place = 0;
		
		System.out.print("Enter the bound : ");
		int range = input.nextInt();
		System.out.print("Random number list : ");
		for(int i=0;i<pick.length;i++) {
			pick[i] = (int)(Math.random() * range)+1;
			System.out.print(pick[i]+" ");
		}
		System.out.println(" ");
		
		System.out.print("Enter key : ");
		int my_number = input.nextInt();
		System.out.print("Found at : ");
		for(int j=0;j<pick.length;j++) {
			if(pick[j] == my_number) {
				place +=1;
				System.out.print(j+" ");
			}
		}
		if (place == 0) {
			System.out.println("없습니다");
		}

	}

}
