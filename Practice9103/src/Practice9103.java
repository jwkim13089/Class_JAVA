import java.util.Scanner;
public class Practice9103 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int i,j,k;
		
		System.out.print("원하는 단을 입력하세요 : ");
		k = input.nextInt();
		
		for(i=k-1;i<=k+1;i++) {
			if(i<1 || i>=10) {
				continue;
			}
			for(j=1;j<10;j++) {
				System.out.printf("%d x %d = %2d\n",i,j,i*j);
			}
			System.out.println();
		}

	}

}
