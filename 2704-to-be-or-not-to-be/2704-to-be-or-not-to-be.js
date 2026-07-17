/**
 * @param {string} val
 * @return {Object}
 */
var expect = function(val) {

    return {
        toBe: function(other) {
            if (val === other) {
                return true;
            }
            throw new Error("Not Equal");
        },

        notToBe: function(other) {
            if (val !== other) {
                return true;
            }
            throw new Error("Equal");
        }
    };

};

/**
 * expect(5).toBe(5);        // true
 * expect(5).notToBe(5);     // throws Error("Equal")
 * expect(5).toBe(null);     // throws Error("Not Equal")
 * expect(5).notToBe(null);  // true
 */

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna