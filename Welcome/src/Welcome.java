import java.util.Date;

public class Welcome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Date date = new Date();
		int currentHour = date.getHours();
		
		System.out.println("현재시간은 "+date);
		if (currentHour < 11) {
			System.out.println("Good morning");
		}
		else if (currentHour < 15) {
			System.out.println("Good afternoon");
		}
		else if (currentHour < 20) {
			System.out.println("Good evening");
		}
		else {
			System.out.println("Good night");
		}

	}

}
