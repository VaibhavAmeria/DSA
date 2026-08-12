# Write your MySQL query statement below
with cte as (
    select 
        managerId,
        count(*) as direct_reports 
    from Employee
    WHERE managerId IS NOT NULL
    GROUP BY managerId
    HAVING COUNT(*) >= 5
)

select 
    e.name 
from Employee e
join cte employees
on e.id = employees.managerId 