# Write your MySQL query statement below

with customer_orders as (
	SELECT 
	        customer_number,
	        COUNT(order_number) AS order_count
	    FROM Orders
	GROUP BY customer_number
)

select 
	customer_number
from customer_orders
order by order_count desc
limit 1;
