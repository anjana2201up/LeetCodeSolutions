# Write your MySQL query statement below
SELECT 
    id,
    COUNT(*) AS num
FROM (
    SELECT requester_id AS id
    FROM RequestAccepted
    
    UNION ALL
    
    SELECT accepter_id AS id
    FROM RequestAccepted
) t
GROUP BY id
ORDER BY num DESC
LIMIT 1;

-- Synced seamlessly with LeetHub Pro
-- Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
-- Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna