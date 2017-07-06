package algo.eval;

import algo.stack.LinkedListStack;
import algo.stack.Stack;

public class Expression {
  private Stack<Character> operators = new LinkedListStack<>();
  private Stack<Double> operands = new LinkedListStack<>();

  public double evaluate(String exprStr) {
    for (int i = 0; i < exprStr.length(); i++) {
      char ch = exprStr.charAt(i);
      String operand = "";
      if (Character.isDigit(ch)) {
        while (i < exprStr.length() && Character.isDigit(exprStr.charAt(i))) {
          operand += exprStr.charAt(i++);
        }
        --i;
        operands.push(Double.parseDouble(operand));
      } else if ("+-*/".indexOf(ch) != -1) {
        operators.push(ch);
      } else if (ch == ')') {

        double result = operands.pop();
        char operator = operators.pop();
        switch (operator) {
          case '+': result += operands.pop(); 
          break;
          case '*': result *= operands.pop(); 
          break;
          case '-': result = operands.pop() - result; 
          break;            
          case '/': result = operands.pop() / result; 
          break;
          default: result = 0.0;
        }
        operands.push(result);
      }
    }
    return operands.pop();
  }
}
