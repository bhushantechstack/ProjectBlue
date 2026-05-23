// select max salary as per departement
SELECT department, MAX(salary) as max_salary FROM employee GROUP BY department;


// select max salary as per departement with employee name

SELECT e.dept_id,
       MAX(s.salary) AS max_salary
FROM employees e
JOIN salary_info s ON e.dept_id = s.dept_id
GROUP BY e.dept_id;