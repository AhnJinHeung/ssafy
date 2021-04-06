-- 사번이 100인 사원의 부서이름.
select	department_name
from 	departments
where 	department_id = 90;

select	department_id
from 	employees
where 	employee_id = 100;

-- subquery
select	department_name
from 	departments
where 	department_id = (
						select	department_id
						from 	employees
						where 	employee_id = 100
						);	
                        
                        
-- 부서가 ‘seattle’(대소문자 구분X)에 있는 부서의 부서 번호, 부서 이름.
select department_id, department_name
from departments
where location_id = (
					select location_id
					from locations
					where city = 'seattle'
					);

-- ‘adam’과 같은 부서에 근무하는 사원의 사번, 이름, 부서번호.
select employee_id, first_name, department_id
from employees
where department_id = (
					select	department_id
					from 	employees
					where	first_name = 'adam'
					);

select	department_id
from 	employees
where	first_name = 'adam';

-- 전체 사원의 평균 급여보다 많이 받는 사원의 사번, 이름, 급여.
select	employee_id, first_name, salary
from employees
where salary > (select avg(salary) from employees)
order by salary desc;


-- 근무 도시가 ‘seaTTle’(대소문자 구분X)인 사원의 사번, 이름.
select 	employee_id, first_name
from 	employees
where 	department_id in (
						select	department_id
						from 	departments
						where 	location_id = (
											select 	location_id
											from 	locations
											where 	lower(city) = lower('seaTTle')
											)
						);

-- 모든 사원 중 적어도(최소급여자보다) 30번 부서에서 근무하는 사원의 급여보다 많이 받는 사원의 사번, 이름, 급여, 부서번호
select employee_id, first_name, salary, department_id
from employees
where salary > any (
				select salary
				from employees
				where department_id = 30
				)
order by salary;

-- 30번 부서에서 근무하는 모든(최대급여자보다) 사원들보다 급여를 많이 받는 사원의 사번, 이름, 급여, 부서번호.
select employee_id, first_name, salary, department_id
from employees
where salary > all (
				select salary
				from employees
				where department_id = 30
				)
order by salary;

-- 커미션을 받는 사원중 매니저 사번이 148인 사원의 급여와 부서번호가 일치하는 사원의 사번, 이름
select employee_id, first_name
from employees
where (salary, department_id) in (
								select salary, department_id
								from employees
								where manager_id = 148
                                );

-- 모든 사원의 평균 급여보다 적게 받는 사원들과 같은 부서에서 근무하는 사원의 사번, 이름, 급여, 부서번호

select e.employee_id, e.first_name, e.salary, e.department_id
from (
		select distinct department_id
		from employees
		where salary < (select avg(salary) from employees)
	 ) a join employees e
on a.department_id = e.department_id;



select employee_id, first_name, salary
from employees
order by salary desc limit 0, 5;

-- 직급 아이디가 IT_PROG인 사원의 사번, 이름, 직급아이디, 부서이름



select e.employee_id, e.first_name, salary, department_id,
	   (select avg(salary) from employees where department_id = 60) as avg60
from employees e
where department_id = 60;


select now(), 5 + 3
from dual;


create table emp_copy
select * from employees;

create table emp_copy2
select * from employees
where 1 = 0;

create table emp_copy3
select employee_id eid, first_name name, salary sal, department_id did from employees
where department_id = 50;


select *
from emp_copy3;