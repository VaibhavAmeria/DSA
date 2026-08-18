# Write your MySQL query statement below

with daily_totals as (
    select
        visited_on,
        SUM(amount) as daily_total
    from customer
    GROUP BY visited_on
    ORDER BY visited_on
),
moving_stat as (
    select
        visited_on,
        SUM(daily_total) OVER (
            order by visited_on
            ROWS between 6 PRECEDING AND CURRENT ROW
        ) as amount,
        ROUND(
            AVG(daily_total) over (
                ORDER BY visited_on 
                ROWS BETWEEN 6 PRECEDING AND CURRENT ROW
            )
            ,2
        ) as average_amount,
        ROW_NUMBER() OVER (
            order by visited_on
        ) as row_num    
    FROM daily_totals
)

select 
    visited_on,
    amount, 
    average_amount
from moving_stat
where row_num >= 7
ORDER BY visited_on;
