# Write your MySQL query statement below
select
    employee_id,
    CASE 
        WHEN LEFT(name, 1) != 'M' and employee_id % 2 != 0 then salary 
        ELSE 0 
    END as bonus
from employees
order by employee_id