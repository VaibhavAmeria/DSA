# Write your MySQL query statement below
WITH ranked_emp AS (
    select 
        id, 
        salary,
        DENSE_RANK() over (
            order by salary desc
        ) as salary_rank_desc
    from employee
)

select 
    MAX(CASE when salary_rank_desc = 2 THEN salary END) as SecondHighestSalary 
from ranked_emp