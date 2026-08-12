# Write your MySQL query statement below

WITH FirstLogins AS (
    SELECT 
        player_id, 
        MIN(event_date) AS first_login
    FROM Activity
    GROUP BY player_id
)
select 
    ROUND(
        COUNT(a.player_id) * 1.0 / (SELECT COUNT(DISTINCT player_id) FROM Activity), 
        2
    ) as fraction
from FirstLogins f
join activity a
    ON f.player_id = a.player_id 
   AND a.event_date = DATE_ADD(f.first_login, INTERVAL 1 DAY); 