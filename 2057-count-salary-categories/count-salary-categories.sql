select 
    'Low Salary' as category,
    Count(case when income  < 20000 then 1 END) as accounts_count
from accounts
UNION ALL
select 
    'Average Salary' as category,
    Count(case when income  between 20000 and 50000 then 1 END) as accounts_count
from accounts
UNION ALL
select 
    'High Salary' as category,
    Count(case when income  > 50000 then 1 END) as accounts_count
from accounts
ORDER BY FIELD (category, 'Low Salary', 'Average Salary', 'High Salary')
