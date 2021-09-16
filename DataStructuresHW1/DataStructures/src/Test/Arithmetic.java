package Test;

import java.util.ArrayList;
import java.util.Stack;

public class Arithmetic {

	public String s;
	
	

	public Arithmetic(String s) {
		super();
		this.s = s;
	}
	
	public boolean isBalance(String arith) {
		//declare stack
		//Stack<dataType> stackName = new Stack<>();
		Stack<Character> charStack = new Stack<>();
		boolean test = true; 
		
		//this for loop will push ( onto stack 
		for(int i = 0; i < arith.length(); i++) {
		 	//if statements
			//if ( push
			if(arith.charAt(i) == '(') {	
				charStack.push(arith.charAt(i));	
			}   if(arith.charAt(i) == ')' && charStack.isEmpty() != true) {	
				charStack.pop();
			} 			else if (arith.charAt(i) == ')' && charStack.isEmpty() == true) {
								test = false;
			} 
		}//end for
		
		return test;
		
	} //end class
	
	
	//here we convert to postfix 	
	public String postFixExpression(String str) { 
		
		Stack<Character> charOps = new Stack<>();
		String converted = " ";
		int counter = 0;
		
		
		for (int i = 0; i < str.length(); i++) {   //"(( 2 + 3 ) * 5 ) * 8 ", postfix 2 3 + 5* 8*
			
			if (Character.isDigit(str.charAt(i)) == true) {
			     
				converted += str.charAt(i) + " "; }  //if it's a number put to output it...have to fix spacing on double digits
		
		//if stack is empty add operator to top of stack 
				   if ((str.charAt(i) == '+' ||   
					    str.charAt(i) == '-' ||
					    str.charAt(i) == '*' ||
				        str.charAt(i) == '/' ||
					    str.charAt(i) == '%' ||
					    str.charAt(i) == '(') && charOps.isEmpty() == true) {
					   
							charOps.push(str.charAt(i)); //push symbol onto the stack 
						    if (str.charAt(i) == '(') { counter++; } //trying to keep track of (
						    
					} else if (charOps.isEmpty() != true) { //if stack is not empty we compare operators
							
								if ((str.charAt(i) == '+' ||//if higher or equal precedence at peek   
								     str.charAt(i) == '-' ||//then pop and push new symbol
									 str.charAt(i) == '*' ||
									 str.charAt(i) == '/' || 
									 str.charAt(i) == '%' )
										    &&
									(charOps.peek() == '*' ||
									 charOps.peek() == '/' ||
									 charOps.peek() == '%' )) {
									
									//pop, assign to temp Char, add temp to String, push new symbol
									Character temp = charOps.pop(); 
									converted += temp + " "; 
									charOps.push(str.charAt(i));
								    }//end nested if, not empty 
								
							else if ((str.charAt(i) == '*' || //high precedence w/ low precedence at peek
									 str.charAt(i) == '/' ||   
									 str.charAt(i) == '%')  
											&&
								   (charOps.peek() == '+' || //if peek is lower precedence than scan
								    charOps.peek() == '-' )) 	{//leave peek and push scan onto stack 		
								
									charOps.push(str.charAt(i));
									}
								
							else if ((str.charAt(i) == '+' ||  
								     str.charAt(i) == '-')
										    &&
								    (charOps.peek() == '+' || //low precedence that are equal to each other
									 charOps.peek() == '-' ))	{
									
									Character temp2 = charOps.pop(); //pop and assign to temp character 
									converted += temp2 + " "; // append the popped to string 
									charOps.push(str.charAt(i));
									}
								
								 if (str.charAt(i) == '(') {//scan is (, push
							    	
							    	charOps.push(str.charAt(i));
							    	counter++; 
							    	}				
								//if we are scanning a symbol and encounter the first (, pop the ( and push the symbol
								if (charOps.peek() == '(' && counter > 1 )  {//scan is anything, peek is (, push 
							    	charOps.pop();  
							    	counter--;
							    	charOps.push(str.charAt(i));
							    	}
								if (charOps.peek() == '(' && counter == 1)  //scan is anything, peek is (, push 
					    	{
									charOps.push(str.charAt(i));
					    	}
							   // RIGHT PAReNTHESIS 
								if (str.charAt(i) == ')') {
									for (int q = 0; q < charOps.size(); ++q) {
											
											if (charOps.peek() != '(') {
												Character popped = charOps.pop();
												converted += popped + " ";
											} else if (charOps.peek() == '(' && counter == 2 ) {
												charOps.pop();
												counter--;
											} 
									}
											} //end else if 
							
								}//big if, not empty
								
								}//end for 
		
		while (charOps.isEmpty() != true) {
			
			
			if (charOps.peek() != '(') {
			Character leftovers = charOps.pop();
			converted += leftovers + " ";
			} else if (charOps.peek() == '(') { charOps.pop(); }
			
		}
			return converted;		
		}
			
		

	public String getPostfix(String s) { //this just returns the expression
		return postFixExpression(s);
	}
	
	public void evaluateRPN() {
		
	}
	
	
}
