import java.util.Stack;

public class EvaluatePostfix {

	public static int evaluatePostFixExpression(String []exp) {
		if(exp.length == 1) {
			return Integer.parseInt(exp[0]);
		}
		
		Stack<Integer> st = new Stack<Integer>();
		for(String s : exp) {
			Integer operand = null;
			String operator = null;
			
			char curr = s.charAt(0);
			if(curr >= 48 && curr <= 57 || s.charAt(0) == '-' && s.length() > 2)
				operand = Integer.parseInt(s);
			else
				operator = s;
			
			if(operator != null) {
				int x = st.pop();
				int y = st.pop();
				
				switch(operator) {
				case "+" : operand = x + y;
							break;
				case "-" : operand = y - x;
							break;
				case "*" : operand = x * y;
							break;
				case "/" : operand = x / y;
							break;
				}
			}
			st.push(operand);
		}
		return st.pop();
	}
	
	public static void main(String[] args) {
		String[] op = {"5", "1", "2", "+", "4", "*", "+", "3", "-"};
        System.out.println("Value of the expression is " + evaluatePostFixExpression(op));
	}
}
