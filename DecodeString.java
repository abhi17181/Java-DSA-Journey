import java.util.Stack;

class Solution {
    static String decode(String str) {
        Stack<Integer> integerStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        String currentString = "";
        int num = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0'); // handle numbers with more than one digit
            } else if (ch == '[') {
                stringStack.push(currentString);  // store the current string
                integerStack.push(num);          // store the repeat count
                currentString = "";              // reset for the new bracket content
                num = 0;
            } else if (ch == ']') {
                int repeatCount = integerStack.pop();
                String prevString = stringStack.pop();
                StringBuilder sb = new StringBuilder(prevString);
                for (int j = 0; j < repeatCount; j++) {
                    sb.append(currentString);
                }
                currentString = sb.toString();
            } else {
                currentString += ch;  // build string
            }
        }

        return currentString;
    }

    public static void main(String args[]) {
        String str = "3[b2[ca]]";
        System.out.println(decode(str));  // Output: bcacabcacabcaca
    }
}
