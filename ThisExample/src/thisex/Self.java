package thisex;

class Subject {
	String name;
	String professor;
	
	Subject() {
		this("�ڹ����α׷���", "������ ������");
	}
	
	Subject(String name, String professor) {
		this.name = name;
		this.professor = professor;
	}
	
}

public class Self {

	public static void main(String[] args) {
		Subject Mon = new Subject();
		System.out.println(Mon.name);
		System.out.println(Mon.professor);

	}

}
