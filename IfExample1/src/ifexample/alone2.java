package ifexample;

public class alone2 {

	public static void main(String[] args) {
		int floor = 5;
		String shop;
		
		switch(floor) {
		case 1 :
			shop = "�౹";
			break;
		case 2 :
			shop = "����ȸ��";
			break;
		case 3 :
			shop = "�Ǻΰ�";
			break;
		case 4 :
			shop = "ġ��";
			break;
		default :
			shop = "�ｺ Ŭ��";
			break;
		}
		
		System.out.println(floor + "��" + shop + "�Դϴ�.");

	}

}
