package Test;
import Test.Arithmetic;

class RPN
{
public static void main(String[] arg)
{
		String s[] = {"5 + ) * ( 2",
					" 2 + ( - 3 * 5 ) ",
						"(( 2 + 3 ) * 5 ) * 8 ",
							"5 * 10 + ( 15 - 20 ) ) - 25",
									" 5 + ( 5 * 10 + ( 15 - 20 ) - 25 ) * 9"};
		
		//loop to create new Arithmetic objects for each string input
		for (int i = 0; i < s.length; i++)
		{
			Arithmetic a = new Arithmetic(s[i]); 
			
				if (a.isBalance(s[i])) {		{
						System.out.print("Expression " + s[i] + " is balanced\n");
						
						System.out.println("The post fixed expression is " + a.postFixExpression(s[i])); //will return fixed string
						System.out.println("-----------------------------------------------------");
						System.out.println();
						a.evaluateRPN(); //algo 3 
								
				} 
				}

					else {
							System.out.print("Expression " + s[i] + " is not balanced\n");
							System.out.println("-----------------------------------------------------");
							System.out.println();
			}
	}
}
}
