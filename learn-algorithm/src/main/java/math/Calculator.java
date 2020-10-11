package math;

import java.util.*;

public class Calculator {
    public static void main(String[] args) {
        List<String> expression = Arrays.asList("3", "+", "5", "*", "8", "-", "6");
        System.out.println(calc(expression));
    }

    public static int calc(List<String> express) {
        Stack<Integer> numStack = new Stack();
        Stack<String> oprStack = new Stack();
        Map<String, Integer> oprMap = new HashMap<String, Integer>() {{
            put("+", 1);
            put("-", 1);
            put("*", 2);
            put("/", 2);
        }};
        for (String s : express) {
            if (oprMap.containsKey(s)) {
                while (!oprStack.isEmpty() && oprMap.get(s) <= oprMap.get(oprStack.peek())) {
                    opr(oprStack, numStack);
                }
                oprStack.push(s);
            } else {
                numStack.push(Integer.valueOf(s));
            }
        }
        opr(oprStack, numStack);
        return numStack.pop();
    }

    public static void opr(Stack<String> oprStack, Stack<Integer> numStack) {
        Integer num1 = numStack.pop();
        Integer num2 = numStack.pop();
        String calc = oprStack.pop();
        Integer result = 0;
        switch (calc){
            case "+":
                result = num2 + num1;
                break;
            case "-":
                result = num2 - num1;
                break;
            case "*":
                result = num2 * num1;
                break;
            case "/":
                result = num2 / num1;
                break;
            default:
                result = 0;
                break;
        }
        numStack.push(result);
    }
}
