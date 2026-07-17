/**
 * @param {Function} fn
 * @param {number} t
 * @return {Function}
 */
var debounce = function(fn, t) {

    let timer;

    return function(...args) {

        // Cancel previous timer
        clearTimeout(timer);

        // Create new timer
        timer = setTimeout(() => {
            fn(...args);
        }, t);
    };
};

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna