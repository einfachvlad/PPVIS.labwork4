package Controller;

import java.util.LinkedList;

public class ReversePolishNotation {

    boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    int priority(char operator) {
        if (operator == '*' || operator == '/')
            return 1;
        else if (operator == '+' || operator == '-')
            return 0;
        else return -1;
    }

    void letGo(LinkedList<Integer> st, char operator) {

        int someOne = st.removeLast();
        int someTwo = st.removeLast();

        switch (operator) {
            case '+':
                st.add(someTwo + someOne);
                break;
            case '-':
                st.add(someTwo - someOne);
                break;
            case '*':
                st.add(someTwo * someOne);
                break;
            case '/':
                st.add(someTwo / someOne);
                break;
            default:
                System.out.println("Oops");
        }
    }

  public  int eval(String s) {

        LinkedList<Integer> someInts = new LinkedList<>();
        LinkedList<Character> someOpers = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                someOpers.add('(');
            } else if (c == ')') {
                while (someOpers.getLast() != '(') {
                    letGo(someInts, someOpers.removeLast());
                }
                someOpers.removeLast();
            } else if (isOperator(c)) {
                while (!someOpers.isEmpty() &&
                        priority(someOpers.getLast()) >= priority(c)) {
                    letGo(someInts, someOpers.removeLast());
                }
                someOpers.add(c);
            } else {
                String operand = "";

                while (i < s.length() &&
                        Character.isDigit(s.charAt(i))) {
                    operand += s.charAt(i++);
                }
                --i;
                someInts.add(Integer.parseInt(operand));
            }
        }

        while (!someOpers.isEmpty()) {
            letGo(someInts, someOpers.removeLast());
        }
        return someInts.get(0);

    }

}
