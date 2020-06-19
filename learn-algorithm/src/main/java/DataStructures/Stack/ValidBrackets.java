package DataStructures.Stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author zhaoxiaoping
 * @Description: 有效括号验证
 * @Date 2020-6-19
 **/
public class ValidBrackets {

  private HashMap<Character, Character> map = new HashMap<>();

  public ValidBrackets() {
    map.put(')', '(');
    map.put('}', '{');
    map.put(']', '[');
  }

  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (map.containsKey(c)) {
        char topElement = stack.isEmpty() ? '#' : stack.pop();
        if (topElement != map.get(c)) {
          return false;
        }
      } else {
        stack.push(c);
      }
    }
    return stack.isEmpty();
  }

  public static void main(String[] args) {
    String str = "()()()({[]})";
    ValidBrackets valid = new ValidBrackets();
    boolean valid1 = valid.isValid(str);
    System.out.println(valid1);
  }
}
