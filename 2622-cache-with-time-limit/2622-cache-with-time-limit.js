/**
 * @param {number} key
 * @param {number} value
 * @param {number} duration
 */
var TimeLimitedCache = function() {
    this.cache = new Map();
};


/**
 * @param {number} key
 * @param {number} value
 * @param {number} duration
 * @return {boolean}
 */
TimeLimitedCache.prototype.set = function(key, value, duration) {

    let existed = this.cache.has(key);

    // If key already exists, remove old timer
    if (existed) {
        clearTimeout(this.cache.get(key).timer);
    }

    const timer = setTimeout(() => {
        this.cache.delete(key);
    }, duration);


    this.cache.set(key, {
        value: value,
        timer: timer
    });

    return existed;
};


/**
 * @param {number} key
 * @return {number}
 */
TimeLimitedCache.prototype.get = function(key) {

    if (this.cache.has(key)) {
        return this.cache.get(key).value;
    }

    return -1;
};


/**
 * @return {number}
 */
TimeLimitedCache.prototype.count = function() {

    return this.cache.size;
};

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna