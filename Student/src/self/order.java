package self;

public class order {
	String OrderNumber;
	String OrderId;
	String OrderDate;
	String OrderName;
	String OrderItemNumber;
	String OrderAddress;

	public static void main(String[] args) {
		order neworder = new order();
		neworder.OrderNumber = "201803120001";
		neworder.OrderId = "abc123";
		neworder.OrderDate = "2018�� 3�� 12��";
		neworder.OrderName = "ȫ���";
		neworder.OrderItemNumber = "PD0345-12";
		neworder.OrderAddress = "���� �������� ���ǵ��� 20����";
		
		System.out.println("�ֹ���ȣ : " + neworder.OrderNumber);
		System.out.println("�ֹ��� ���̵� : " + neworder.OrderId);
		System.out.println("�ֹ� ��¥ : " + neworder.OrderDate);
		System.out.println("�ֹ��� �̸� : " + neworder.OrderName);
		System.out.println("�ֹ� ��ǰ ��ȣ : " + neworder.OrderItemNumber);
		System.out.println("��� �ּ� : " + neworder.OrderAddress);
		
		


	}

}
