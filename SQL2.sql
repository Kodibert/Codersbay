--3.1
select PLAYERNO,NAME from PLAYERS where YEAR_OF_BIRTH > 1960;
--3.2
select PLAYERNO,NAME,TOWN from PLAYERS where SEX ='F' and TOWN != 'Stratford';
--3.3
select PLAYERNO from PLAYERS where YEAR_JOINED between '1970' and '1980';
--3.4
select PLAYERNO,NAME,YEAR_OF_BIRTH from PLAYERS where  ;
--3.5
select PAYMENTNO,AMOUNT from PENALTIES where AMOUNT between '50' and '100';
--3.6
select PLAYERNO,NAME,TOWN from PLAYERS where TOWN != 'Stratford' and TOWN != 'Douglas';
--3.7
select PLAYERNO,NAME from PLAYERS where NAME like '%is%';
--3.8
select NAME from PLAYERS where LEAGUENO is null;
--3.9
select EMPNO,ENAME from EMP where COMM>SAL;
--3.10
select EMPNO,ENAME from EMP where DEPTNO = 30 and SAL >= 1500;
--3.11
select ENAME from EMP where JOB = 'MANAGER' and DEPTNO != 30;
--3.12
select ENAME from EMP where DEPTNO = 10 and JOB != 'MANAGER' and JOB != 'CLERK';
--3.13
select ENAME from emp where SAL between '1200' and '1500';
--3.14
select ENAME from emp where ENAME like '%ALL__%';
--3.15
select SAL+COMM,ENAME from EMP;
--3.16
select ENAME from EMP where COMM> SAL*0.25;
--3.17
select AVG(SAL) from EMP where JOB ='SALESMAN';
--3.18
select ENAME from EMP where COMM is not null ;
--3.19
select JOB from EMP where DEPTNO = 30;
--3.20
select ENAME from EMP where DEPTNO = 30;
--3.21
select ENAME from emp where HIREDATE between '04/01/81' and '15/04/81';

commit ;

--4.1
select TEAMNO from Teams where PLAYERNO = 27 and TEAMNO != 1;
--4.2
select Matches.PLAYERNO, NAME, INITIALS from PLAYERS,MATCHES where Matches.PLAYERNO = PLAYERS.PLAYERNO  group by Matches.PLAYERNO, NAME, INITIALS having count(WON) > 0 ;
--4.3
select PENALTIES.PLAYERNO, NAME, AMOUNT from PLAYERS, PENALTIES where PENALTIES.PLAYERNO = Players.PLAYERNO group by PENALTIES.PLAYERNO, NAME, AMOUNT having COUNT(AMOUNT) > 0;
--4.4
select PLAYERNO,NAME from PLAYERS,PENALTIES where AMOUNT > 50;
--4.5
select PLAYERNO,NAME,YEAR_OF_BIRTH from PLAYERS where YEAR_OF_BIRTH = (select YEAR_OF_BIRTH from PLAYERS where NAME='Parmenter' and INITIALS='R');
--4.6
select min(YEAR_OF_BIRTH) from PLAYERS;
--4.7
select DEPTNO from DEPT where not exists(select EMPNO from EMP where EMP.DEPTNO = DEPT.DEPTNO );
--4.8
select EMPNO,ENAME from EMP where JOB = (select JOB from EMP where ENAME = 'JONES');
--4.9
--4.10
select ename,SAL from EMP where SAL > (select max(SAL) from EMP where DEPTNO = 30);
--4.11 ???
select ENAME,JOB from EMP where DEPTNO = 10 and JOB != (select JOB from EMP where DEPTNO = 30);
--4.12
select EMPNO,ENAME,JOB,SAL from EMP where SAL= (select max(SAL) from EMP);

commit;


--5.1
select PLAYERNO,count(YEAR_JOINED) as Count from (select YEAR_JOINED,PLAYERNO from PLAYERS group by PLAYERNO) group by YEAR_JOINED;
--5.2
select avg(AMOUNT) from PENALTIES where AMOUNT >= 0;
--5.3
select AMOUNT from PENALTIES where PEN_DATE < '01/01/83';
--5.4
select TOWN from PLAYERS group by TOWN having count(*) >= 4;
--5.5
select PLAYERNO from PENALTIES group by PLAYERNO having count(AMOUNT) >= 150;
--5.6 ??
select NAME,INITIALS from PLAYERS,PENALTIES where PENALTIES.PLAYERNO > ( select PENALTIES.PLAYERNO from PENALTIES group by PENALTIES.PLAYERNO having count(PENALTIES.PLAYERNO));
--5.7
select PEN_DATE from PENALTIES group by PEN_DATE having count(PEN_DATE) = 2;
--5.8 ??
select NAME, INITIALS from PLAYERS join (select AMOUNT from PENALTIES group by AMOUNT having count(AMOUNT) > 40 );
--5.9
select NAME,INITIALS from PLAYERS p,PENALTIES where p.playerno = penalties.PLAYERNO group by NAME, INITIALS having sum(amount) >= all(select sum(amount) from PENALTIES group by PENALTIES.PLAYERNO);
--5.10 ??
select PEN_DATE from PENALTIES where PEN_DATE  (select count(PEN_DATE) from PENALTIES where PEN_DATE is not null);
--5.11
select PLAYERNO, TEAMNO,WON ,LOST from MATCHES order by WON asc;
--5.12
select ENAME,SAL from EMP where DEPTNO = 30 order by SAL DESC;
--5.13
select ENAME,sal,JOB from EMP order by JOB,SAL desc;
--5.14
select ENAME,HIREDATE from EMP order by HIREDATE desc,ENAME desc;
--5.15
select ENAME,JOB,sal,COMM from EMP where JOB = 'SALESMAN' order by SAL-Comm desc ;
--5.16 ?
select avg(SAL),job,count(*),DEPTNO from EMP group by DEPTNO,JOB;
--5.17
select job,count(*),avg(SAL) from EMP group by job having count(*) > 2;
--5.18
select DEPTNO,count(*) from EMP group by DEPTNO having count(*) > 2;
--5.19
select avg(SAL+COMM) from EMP where DEPTNO = 30;

commit;

--6.1
select NAME,INITIALS,WON from PLAYERS,MATCHES where PLAYERS.PLAYERNO = MATCHES.PLAYERNO;
--6.2
select NAME,PEN_DATE, AMOUNT from PLAYERS,PENALTIES where PLAYERS.PLAYERNO=PENALTIES.PLAYERNO order by AMOUNT DESC;
--6.3
select TEAMNO,NAME from PLAYERS,TEAMS where TEAMS.PLAYERNO = PLAYERS.PLAYERNO;
--6.4
select NAME,WON,LOST from MATCHES,PLAYERS where matches.PLAYERNO = players.PLAYERNO;
--6.5 ??
select PLAYERNO,NAME,AMOUNT from PLAYERS,PENALTIES where PLAYERS.PLAYERNO = PENALTIES.PLAYERNO order by AMOUNT asc ;
--6.6
select ENAME,LOC from emp , dept where ENAME ='ALLEN' and emp.DEPTNO = dept.DEPTNO;
--6.7
select ENAME,SAL,COMM,JOB from EMP where SAL+COMM > (select distinct avg(nvl(SAL+COMM),0)from EMP where JOB = 'MANAGER');
--6.8
select extract(year from HIREDATE)year,count(*) from EMP group by extract(year from HIREDATE)having count(*)>0;
--6.9
select ENAME,DEPTNO,job from EMP where JOB = (select JOB from DEPT where DEPT.DEPTNO = EMP.DEPTNO and EMP.DEPTNO = 30);

commit;

--7.1 ?????????
select NAME from PLAYERS,MATCHES,TEAMS where Teams.TEAMNO in(select TEAMS.TEAMNO from MATCHES where TEAMS.TEAMNO = 2) and teams.TEAMNO in(select TEAMS.TEAMNO from MATCHES where TEAMS.TEAMNO=1);
--7.2
select NAME,INITIALS from PLAYERS where players.PLAYERNO not in(select PENALTIES.playerno from PENALTIES where extract(year from PEN_DATE) = '1980');
--7.3
select NAME,AMOUNT from PLAYERS,PENALTIES where amount > 80 and PENALTIES.PLAYERNO=PLAYERS.PLAYERNO group by NAME, AMOUNT having count(penalties.playerno)>=1;
--7.4
select name,AMOUNT from PLAYERS,PENALTIES where AMOUNT > 80 and PENALTIES.PLAYERNO=PLAYERS.PLAYERNO group by name, AMOUNT;
--7.5
select ENAME, SAL,EMP.DEPTNO from EMP,DEPT where SAL > (select avg(SAL) from EMP where DEPT.DEPTNO=EMP.DEPTNO) order by DEPTNO;
--7.6
select * from DEPT where exists(select * from EMP where emp.DEPTNO = dept.DEPTNO);
--7.7
select * from DEPT where exists(select * from emp where emp.DEPTNO = dept.DEPTNO and SAL >= 1000);
--7.8
select * from DEPT where not exists(select * from EMP where  emp.DEPTNO = dept.DEPTNO and EMP.SAL <= 1000);

commit ;

--8.2
select * from PARTS where super in (select super from parts where super = 'P3') or super in (select super from parts where super = 'P9');
--8.3
select * from PARTS connect by prior sub = super start with sub = 'P1';
--8.4
select * from parts where price > 20 and super = 'P1' connect by prior sub = super start with sub = 'P1';
--8.5
select * from emp where JOB != 'MANAGER' connect by prior EMPNO = MGR start with ENAME = 'JONES';
--8.6
select * from emp connect by prior MGR = EMPNO start with ENAME = 'SMITH';
--8.7
select JOB, ENAME, avg(SAL) from EMP where MGR in (select EMPNO from EMP) or EMPNO in (select MGR from EMP) group by rollup (JOB, ENAME);

commit ;


--1.Select
select EMPLOYEE_ID,LAST_NAME,JOB_ID,HIRE_DATE as STARTDATE from EMPLOYEES order by EMPLOYEE_ID;
--2
select distinct JOB_ID from EMPLOYEES;
--3
select LAST_NAME,SALARY from EMPLOYEES where SALARY > 12000;
--4
select LAST_NAME,DEPARTMENT_ID from EMPLOYEES where EMPLOYEE_ID = 176;
--5
select LAST_NAME,JOB_ID,HIRE_DATE from EMPLOYEES order by HIRE_DATE asc ;
--6
select LAST_NAME,DEPARTMENT_ID from EMPLOYEES where DEPARTMENT_ID = 20 order by LAST_NAME asc ;
--7
select LAST_NAME employee,SALARY MonthlySalary,COMMISSION_PCT Commission from EMPLOYEES where COMMISSION_PCT = 0.20;

--1.Joins
select JOB_ID,sum(SALARY) from EMPLOYEES natural join JOBS group by JOB_ID order by sum(SALARY) desc;
--2
select EMPLOYEE_ID,FIRST_NAME,avg(SALARY) from EMPLOYEES natural join JOBS group by EMPLOYEE_ID, FIRST_NAME;
--3
select FIRST_NAME,LAST_NAME,JOB_TITLE from EMPLOYEES inner join JOBS J on EMPLOYEES.JOB_ID = J.JOB_ID;
--4
select DEPARTMENT_NAME, POSTAL_CODE, CITY, STATE_PROVINCE, STREET_ADDRESS from DEPARTMENTS, LOCATIONS where LOCATIONS.LOCATION_ID = DEPARTMENTS.LOCATION_ID;
--5
select DEPARTMENT_NAME, POSTAL_CODE, CITY, STATE_PROVINCE, STREET_ADDRESS, COUNTRY_ID from DEPARTMENTS, LOCATIONS where LOCATIONS.LOCATION_ID = DEPARTMENTS.LOCATION_ID;
--6
select FIRST_NAME + LAST_NAME Manager from EMPLOYEES,JOBS where JOBS.JOB_TITLE like 'Manager';
--7
select FIRST_NAME || LAST_NAME as Name, JOB_TITLE as job, SALARY, DEPARTMENT_NAME from EMPLOYEES, JOBS, DEPARTMENTS where JOBS.JOB_ID = EMPLOYEES.JOB_ID and DEPARTMENTS.DEPARTMENT_ID = EMPLOYEES.DEPARTMENT_ID;

--8
select LEVEL, lpad('', 1 * LEVEL) || LAST_NAME Hierarchy, City from EMPLOYEES, LOCATIONS, DEPARTMENTS where LOCATIONS.LOCATION_ID = DEPARTMENTS.LOCATION_ID and EMPLOYEES.DEPARTMENT_ID = DEPARTMENTS.DEPARTMENT_ID connect by prior EMPLOYEE_ID = EMPLOYEES.MANAGER_ID start with LAST_NAME = 'King';
