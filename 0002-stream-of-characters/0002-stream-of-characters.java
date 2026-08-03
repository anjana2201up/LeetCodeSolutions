class StreamChecker {
    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        boolean end;
    }

    private TrieNode root;
    private StringBuilder stream;
    private int maxLen;

    public StreamChecker(String[] words) {
        root = new TrieNode();
        stream = new StringBuilder();
        maxLen = 0;

        for (String word : words) {
            maxLen = Math.max(maxLen, word.length());
            TrieNode node = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                int idx = word.charAt(i) - 'a';
                if (node.child[idx] == null) {
                    node.child[idx] = new TrieNode();
                }
                node = node.child[idx];
            }
            node.end = true;
        }
    }

    public boolean query(char letter) {
        stream.append(letter);
        if (stream.length() > maxLen) {
            stream.deleteCharAt(0);
        }

        TrieNode node = root;
        for (int i = stream.length() - 1; i >= 0; i--) {
            int idx = stream.charAt(i) - 'a';
            if (node.child[idx] == null) {
                return false;
            }
            node = node.child[idx];
            if (node.end) {
                return true;
            }
        }
        return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna