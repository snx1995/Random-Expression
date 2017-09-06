package randExpression;

public class ExpresTest {

}

class Expression {
	private String expression;
	private String result;

	public Expression(String E,String R) {
		expression=E;
		result = R;
	}
	
	public String toString() {
		return expression + " = " + result;
	}
}