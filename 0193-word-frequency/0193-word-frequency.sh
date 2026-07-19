awk '{ 
    for(i = 1; i <= NF; i++) 
        count[$i]++ 
}
END {
    for(word in count)
        print word, count[word]
}' words.txt | sort -k2nr

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna