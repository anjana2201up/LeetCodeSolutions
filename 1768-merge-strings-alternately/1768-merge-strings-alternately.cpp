class Solution {
public:
    string mergeAlternately(string word1, string word2) {
        string res="";
        int l1=word1.length();
        int l2=word2.length();
        int i=0;
        int j=0;
        while(i<l1&&j<l2){
            res.push_back(word1[i]);
            res.push_back(word2[j]);
            i++;
            j++;
        }
        while(i<l1){
            res.push_back(word1[i]);
            i++;
        }
        while(j<l2){
            res.push_back(word2[j]);
            j++;
        }
        return res;
    }
};

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna