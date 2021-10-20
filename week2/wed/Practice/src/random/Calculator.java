package random;

public class Calculator {
	
	public Calculator() {
		
	}
	public int add(int a, int b, int c) {
		return a * b - c;
	}
	public int subtract(int a, int b, int c) {
		return a * b -(a + b);
	}
	public static void main(String[] args) {
		Calculator gotcha = new Calculator();
		System.out.println("I am learning this shit " + gotcha.add(2, 5, 6));
		System.out.println("Thank you lawd " + gotcha.subtract(1, 5, 2));
		Calculator gotcha2 = new Calculator();
		System.out.println(gotcha2.add(6, 9, 2));
	}
	

}
