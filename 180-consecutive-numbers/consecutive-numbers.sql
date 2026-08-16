# Write your MySQL query statement below
WITH consecutive_check as (
    select 
        id,
        num,
        LAG (num, 1) OVER (order by id) as prev1,
        LAG(num, 2) OVER (ORDER BY id) AS prev2
    from logs
)

select 
    DISTINCT num as ConsecutiveNums
FROM consecutive_check
WHERE num = prev1 AND num = prev2;
