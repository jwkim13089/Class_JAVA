
public class Practice9101 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i,j,k;
		k=1;
		for(k=1;k<=7;k+=3) {
			for(j=1;j<10;j++) {
				for(i=k;i<k+3;i++) {
					System.out.printf("%d x %d = %2d	",i,j,i*j);
					
				}
				System.out.println();
				
			}
			System.out.println("------------------------------------------");
		}
	}
}
