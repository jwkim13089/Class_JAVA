package ifexample;

public class alone2 {

	public static void main(String[] args) {
		int floor = 5;
		String shop;
		
		switch(floor) {
		case 1 :
			shop = "약국";
			break;
		case 2 :
			shop = "정형회과";
			break;
		case 3 :
			shop = "피부과";
			break;
		case 4 :
			shop = "치과";
			break;
		default :
			shop = "헬스 클럽";
			break;
		}
		
		System.out.println(floor + "층" + shop + "입니다.");

	}

}
