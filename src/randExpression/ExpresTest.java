package randExpression;

public class ExpresTest {

}

class Requirement {
	public int range;
	public boolean negative;
	public boolean multiOrDiv;

	public Requirement(int Ran, boolean N, boolean MOD) {
		range = Ran;
		negative = N;
		multiOrDiv = MOD;
	}
}

class Expression {
	private String expression;
	private int result;

	public Expression(String E, String R) {
		expression = E;
		result = R;
	}

	public String getExpression() {
		return expression;
	}

	public String toString() {
		return expression + " = " + result;
	}
}