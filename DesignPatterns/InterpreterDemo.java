import java.util.*;

public class InterpreterDemo {
    public static void main(String[] args) {
        // Example input: "10 + 5 - 3"
        String input = "10 + 5 - 3";
        int result = interpret(input);
        System.out.println(input + " = " + result);
    }

    static int interpret(String input) {
        List<String> tokens = Arrays.asList(input.trim().split("\\s+"));
        if (tokens.size() < 3) throw new IllegalArgumentException("Invalid expression");

        Expression expr = new NumberExpression(Integer.parseInt(tokens.get(0)));

        for (int i = 1; i < tokens.size(); i += 2) {
            String op = tokens.get(i);
            int value = Integer.parseInt(tokens.get(i + 1));
            Expression right = new NumberExpression(value);

            expr = switch (op) {
                case "+" -> new AddExpression(expr, right);
                case "-" -> new SubExpression(expr, right);
                default -> throw new IllegalArgumentException("Unknown operator: " + op);
            };
        }
        return expr.interpret();
    }
}

interface Expression { int interpret(); }

class NumberExpression implements Expression {
    private final int value;
    NumberExpression(int value) { this.value = value; }
    public int interpret() { return value; }
}

class AddExpression implements Expression {
    private final Expression left, right;
    AddExpression(Expression left, Expression right) { this.left = left; this.right = right; }
    public int interpret() { return left.interpret() + right.interpret(); }
}

class SubExpression implements Expression {
    private final Expression left, right;
    SubExpression(Expression left, Expression right) { this.left = left; this.right = right; }
    public int interpret() { return left.interpret() - right.interpret(); }
}
