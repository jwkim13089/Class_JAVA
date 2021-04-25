package loopexample;

public class Practice01 {

	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 2;
		char operator = '+';
		int answer = 0;
		
		switch(operator) {
		case '+' :
			answer = num1 + num2;
			break;
		case '-' :
			answer = num1 - num2;
			break;
		case '*' :
			answer = num1 * num2;
			break;
		case '/' :
			answer = num1 / num2;
			break;
		default :
			break;
		}
		System.out.println(answer);
	}

}
