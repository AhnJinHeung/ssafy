use scott;

select * from emp;
select * from dept;

select e.ENAME as '이름', e.JOB as '업무', e.SAL as '급여'
from emp as e
where e.DEPTNO = (select d.DEPTNO from dept d where d.LOC = 'CHICAGO');

select e.EMPNO as '사원번호', e.ENAME as '이름', e.JOB as '업무', e.DEPTNO as '부서번호'
from emp as e
where isnull(e.MGR);

select e.ENAME as '이름', e.JOB as '업무', e.MGR as '상사번호'
from emp as e
where e.MGR = (select ee.MGR from emp ee where ee.ENAME = 'BLAKE');

select *
from emp as e
order by HIREDATE limit 5;

select e.ENAME as '이름', e.JOB as '업무', (select d.DNAME from dept as d where d.DEPTNO = e.DEPTNO) as '부서명'
from emp as e
join emp as ee
on e.MGR = ee.EMPNO
where ee.ENAME = 'JONES';