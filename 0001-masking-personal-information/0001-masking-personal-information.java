class Solution {
    public String maskPII(String s) {
        if(s.contains("@")) {
            String[] parts = s.toLowerCase().split("@");
            String name = parts[0];
            String domain = parts[1];

            return name.charAt(0) + "*****" + name.charAt(name.length() - 1) + "@" + domain;
        }

        StringBuilder digits = new StringBuilder();

        for(char c : s.toCharArray()) {
            if(Character.isDigit(c))
                digits.append(c);
        }

        String last = digits.substring(digits.length() - 4);
        int country = digits.length() - 10;

        StringBuilder ans = new StringBuilder();

        if(country > 0) {
            ans.append("+");
            for(int i = 0; i < country; i++)
                ans.append("*");
            ans.append("-");
        }

        ans.append("***-***-").append(last);

        return ans.toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna