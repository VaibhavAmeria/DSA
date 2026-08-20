
with consolidatedData as (
	select 
		id,
		recordDate,
		temperature,
		LAG(temperature, 1, NULL) over (
			order by recordDate
		) as previousDayTemp,
        LAG(recordDate, 1) OVER (ORDER BY recordDate) AS previousDate
	from weather
	order by id
)
select 
	id
from consolidatedData
where previousDayTemp < temperature
and DATEDIFF(recordDate, previousDate) = 1;