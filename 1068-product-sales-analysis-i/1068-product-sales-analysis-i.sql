# Write your MySQL query statement below
SELECT 
    Product.product_name,
    Sales.year,
    Sales.price
FROM Sales
JOIN Product
ON Sales.product_id = Product.product_id;

-- Synced seamlessly with LeetHub Pro
-- Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
-- Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna