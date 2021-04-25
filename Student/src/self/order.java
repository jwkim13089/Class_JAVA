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
		neworder.OrderDate = "2018년 3월 12일";
		neworder.OrderName = "홍길순";
		neworder.OrderItemNumber = "PD0345-12";
		neworder.OrderAddress = "서울 영등포구 여의도동 20번지";
		
		System.out.println("주문번호 : " + neworder.OrderNumber);
		System.out.println("주문자 아이디 : " + neworder.OrderId);
		System.out.println("주문 날짜 : " + neworder.OrderDate);
		System.out.println("주문자 이름 : " + neworder.OrderName);
		System.out.println("주문 상품 번호 : " + neworder.OrderItemNumber);
		System.out.println("배송 주소 : " + neworder.OrderAddress);
		
		


	}

}
