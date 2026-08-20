# Write your MySQL query statement below
WITH emp_sal_with_dept AS (
    select
        d.name as Department,
        e.name as Employee,
        e.salary as salary,
        DENSE_RANK() over (
            partition by e.departmentId
            order by salary desc
        ) as ranked
    from employee e
    left join department d
    on e.departmentId = d.id
)

select  
    Department,
    Employee,
    Salary
from emp_sal_with_dept
where ranked <= 3