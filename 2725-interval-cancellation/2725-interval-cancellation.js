/**
 * @param {Function} fn
 * @param {Array} args
 * @param {number} t
 * @return {Function}
 */
var cancellable = function(fn, args, t) {

    // Call immediately
    fn(...args);

    // Run repeatedly after every t milliseconds
    const intervalId = setInterval(() => {
        fn(...args);
    }, t);

    // Return cancel function
    return function cancelFn() {
        clearInterval(intervalId);
    };
};

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna