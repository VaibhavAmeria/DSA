
WITH HighTraffic AS (
    -- Step 1: Filter for 100+ people and create a grouping identifier
    SELECT 
        id,
        visit_date,
        people,
        id - ROW_NUMBER() OVER (ORDER BY id) AS grp
    FROM Stadium
    WHERE people >= 100
),
GroupCounts AS (
    -- Step 2: Count the size of each continuous group
    SELECT 
        id,
        visit_date,
        people,
        COUNT(id) OVER (PARTITION BY grp) AS group_size
    FROM HighTraffic
)
-- Step 3: Filter for groups with 3 or more consecutive records
SELECT 
    id,
    visit_date,
    people
FROM GroupCounts
WHERE group_size >= 3
ORDER BY visit_date ASC;