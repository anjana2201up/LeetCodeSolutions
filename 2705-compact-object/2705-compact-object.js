/**
 * @param {Object|Array} obj
 * @return {Object|Array}
 */
var compactObject = function(obj) {

    if (Array.isArray(obj)) {

        let result = [];

        for (let item of obj) {

            if (item && typeof item === "object") {
                result.push(compactObject(item));
            } 
            else if (item) {
                result.push(item);
            }

        }

        return result;

    } else {

        let result = {};

        for (let key in obj) {

            let value = obj[key];

            if (value && typeof value === "object") {

                result[key] = compactObject(value);

            } 
            else if (value) {

                result[key] = value;

            }
        }

        return result;
    }
};

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna