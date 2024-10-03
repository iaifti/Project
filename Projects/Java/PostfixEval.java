import java.util.Stack;

public class PostfixEval {
    public static int evalPostfix(String expression) {
        String[] idxs = expression.split("\\s+");
        Stack<Integer> stack = new Stack<>();

        for (String idx : idxs) {
            if (idx.matches("-?\\d+")) {
                stack.push(Integer.parseInt(idx));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                int result;
                
                switch (idx) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        result = num1 / num2;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + idx);
                }
                stack.push(result);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java PostfixEvaluator <postfix_expression>");
            System.exit(1);
        }

        String postfixExpression = args[0];
        int result = evalPostfix(postfixExpression);
        System.out.println("Result: " + result);
    }
}
