awk '
{
    for (i = 1; i <= NF; i++) {
        if (NR == 1)
            res[i] = $i;
        else
            res[i] = res[i] " " $i;
    }
}
END {
    for (i = 1; i <= NF; i++)
        print res[i];
}' file.txt

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna