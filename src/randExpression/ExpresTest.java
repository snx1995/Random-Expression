package randExpression;

import java.util.Random;

public class ExpresTest {
	public static void main(String[] args) {
		Requirement req= new Requirement(100);
		Expression exp=randomCreate(req);
		System.out.println(exp);
	}

	public static Expression randomCreate(Requirement Req) {
		Random ra = new Random();
		int nums = ra.nextInt(Req.maxNums - Req.minNums) + Req.minNums;
		
		return recCreate(nums,Req,ra);
	}
	
	public static Expression recCreate(int n,Requirement req,Random ra) {
		Expression exp=null, exptmp=null;
		if(n==2) {
			int A=ra.nextInt(req.range);
			int B=ra.nextInt(req.range)+1;
			int s=ra.nextInt(4);
			switch (s) {
			case 0:
				exp=new Expression(A+"+"+B, A+B);
				break;
			case 1:
				exp=new Expression(A+"-"+B, A-B);
				break;
			case 2:
				exp=new Expression(A+"*"+B, A*B);
				break;
			case 3:
				exp=new Expression(A+"/"+B, A/B);
				break;
			default:
				break;
			}
		}
		else {
			exptmp =recCreate(n-1, req, ra);
			int A =ra.nextInt(req.range)+1;
			int s=ra.nextInt(4);
			switch (s) {
			case 0:
				exp=new Expression(A+"+"+exptmp.getExpression(), A+exptmp.getResult());
				break;
			case 1:
				exp=new Expression(A+"-"+exptmp.getExpression(), A - exptmp.getResult());
				break;
			case 2:
				exp=new Expression(A+"*"+"("+exptmp.getExpression()+")", A*exptmp.getResult());
				break;
			case 3:
				exp=new Expression("("+exptmp.getExpression()+")"+"/"+A, exptmp.getResult()/A);
				break;
			default:
				break;
			}
		}
		return exp;
	}
}

class Requirement {
	public int range;
	public boolean negative;
	public boolean multiOrDiv;
	public int minNums;
	public int maxNums;

	public Requirement(int Range, boolean N, boolean MOD, int Min, int Max) {
		range = Range;
		negative = N;
		multiOrDiv = MOD;
		minNums = Min;
		maxNums = Max;
	}

	public Requirement(int Range) {
		range = Range;
		negative = false;
		multiOrDiv = true;
		minNums = 2;
		maxNums = 10;
	}
}

class Expression {
	private String expression;
	private int result;

	public Expression(String E, int R) {
		expression = E;
		result = R;
	}

	public String getExpression() {
		return expression;
	}
	
	public int getResult() {
		return result;
	}

	public String toString() {
		return expression + " = " + result;
	}
}