/**
 * @param {Array} arr
 * @param {number} n
 * @return {Array}
 */
var flat = function(arr, n) {

    let result = [];

    function helper(array, depth) {

        for (let item of array) {

            if (Array.isArray(item) && depth < n) {

                helper(item, depth + 1);

            } else {

                result.push(item);

            }
        }
    }

    helper(arr, 0);

    return result;
};

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna