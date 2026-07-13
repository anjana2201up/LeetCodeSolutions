import java.util.*;

class Solution {
    public String decodeString(String s) {

        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();

        StringBuilder current = new StringBuilder();
        int num = 0;

        for (char ch : s.toCharArray()) {

            if (Character.isDigit(ch)) {
                // Handle multi-digit numbers
                num = num * 10 + (ch - '0');
            }
            else if (ch == '[') {
                // Save current state
                countStack.push(num);
                stringStack.push(current);

                // Reset for new substring
                current = new StringBuilder();
                num = 0;
            }
            else if (ch == ']') {
                int repeat = countStack.pop();
                StringBuilder previous = stringStack.pop();

                // Append current string 'repeat' times
                for (int i = 0; i < repeat; i++) {
                    previous.append(current);
                }

                current = previous;
            }
            else {
                // Normal character
                current.append(ch);
            }
        }

        return current.toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna