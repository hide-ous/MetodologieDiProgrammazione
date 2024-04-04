package lecture9;

public class FormulaTester {
	
	public static void main(String[] args) {
		Formula formula = new Formula() {
			
			@Override
			public double calculate(int a) {
				// TODO Auto-generated method stub
				return sqrt(a);
			}
		};

		System.out.println(formula.calculate(100)); // 100.0
		System.out.println(formula.sqrt(16)); // 4.0
		
	}

}
