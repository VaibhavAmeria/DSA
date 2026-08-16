CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
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
            MAX(CASE when salary_rank_desc = N THEN salary ELSE NULL END)
        from ranked_emp
  );
END