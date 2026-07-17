class Solution {

    class TrieNode {

        TrieNode[] child = new TrieNode[26];
        List<String> words = new ArrayList<>();
    }

    TrieNode root = new TrieNode();

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        Arrays.sort(products);

        for(String word : products)
            insert(word);

        List<List<String>> ans = new ArrayList<>();

        TrieNode curr = root;

        for(char ch : searchWord.toCharArray()){

            if(curr != null)
                curr = curr.child[ch-'a'];

            if(curr == null)
                ans.add(new ArrayList<>());
            else
                ans.add(curr.words);
        }

        return ans;
    }

    private void insert(String word){

        TrieNode curr = root;

        for(char ch : word.toCharArray()){

            int index = ch-'a';

            if(curr.child[index]==null)
                curr.child[index]=new TrieNode();

            curr=curr.child[index];

            if(curr.words.size()<3)
                curr.words.add(word);
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna