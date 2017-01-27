import java.util.ArrayList;

public class GenerateParentheses {

	public static void main(String[] args) {
		int n = 3;
		GenerateParentheses gp = new GenerateParentheses();
		gp.printParentheses(n);
	}

	private void printParentheses(int n) {
		ArrayList<String> result = new ArrayList<String>();
		dfs(result, "", n, n);
		for(String str: result)
			System.out.print(str + " ");
	}
	
	public void dfs(ArrayList<String> result, String s, int left, int right){
	    if(left > right)
	        return;
	 
	    if(left==0&&right==0){
	        result.add(s);
	        return;
	    }
	 
	    if(left>0){
	        dfs(result, s+"(", left-1, right);
	    }
	 
	    if(right>0){
	        dfs(result, s+")", left, right-1);
	    }
	}
}
