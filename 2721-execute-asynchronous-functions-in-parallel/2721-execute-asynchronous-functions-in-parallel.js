/**
 * @param {Array<Function>} functions
 * @return {Promise<any>}
 */
var promiseAll = function(functions) {

    return new Promise((resolve, reject) => {

        let results = [];
        let completed = 0;

        functions.forEach((fn, index) => {

            fn()
            .then((value) => {

                results[index] = value;
                completed++;

                // All promises finished successfully
                if (completed === functions.length) {
                    resolve(results);
                }

            })
            .catch((error) => {

                // First rejection
                reject(error);

            });

        });

    });
};

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna