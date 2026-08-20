# Write your MySQL query statement below
with class_student as (
    select 
        class,
        count(student) as student_count
    from courses
    group by class
)
select
    class
from class_student
where student_count >= 5