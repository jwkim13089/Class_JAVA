package self;

public class Man {
	int age;
	String name;
	boolean ismarried;
	int children;

	public static void main(String[] args) {
		Man person = new Man();
		person.age = 40;
		person.name = "James";
		person.ismarried = true;
		person.children = 3;
		
		System.out.println("���� :" + person.age);
		System.out.println("�̸� :" + person.name);
		System.out.println("��ȥ ���� :" + person.ismarried);
		System.out.println("�ڳ� �� :" + person.children);
		

	}

}
