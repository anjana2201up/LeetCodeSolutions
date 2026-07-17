class EventEmitter {

    constructor() {
        this.events = new Map();
    }

    /**
     * @param {string} eventName
     * @param {Function} callback
     * @return {Object}
     */
    subscribe(eventName, callback) {

        if (!this.events.has(eventName)) {
            this.events.set(eventName, []);
        }

        this.events.get(eventName).push(callback);


        return {
            unsubscribe: () => {

                let callbacks = this.events.get(eventName);

                let index = callbacks.indexOf(callback);

                if (index !== -1) {
                    callbacks.splice(index, 1);
                }

            }
        };
    }


    /**
     * @param {string} eventName
     * @param {Array} args
     * @return {Array}
     */
    emit(eventName, args = []) {

        if (!this.events.has(eventName)) {
            return [];
        }

        let result = [];

        for (let callback of this.events.get(eventName)) {
            result.push(callback(...args));
        }

        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna