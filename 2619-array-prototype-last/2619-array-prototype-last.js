/**
 * @return {null|boolean|number|string|Array|Object}
 */
Array.prototype.last = function() {

    if (this.length === 0) {
        return -1;
    }

    return this[this.length - 1];
};

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna