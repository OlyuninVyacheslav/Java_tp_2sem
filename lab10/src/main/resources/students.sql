drop table if exists students cascade;

create table students (
id serial primary key,
name varchar(20) not null,
passport_s integer not null unique,
passport_n integer not null unique
);

drop table if exists subjects cascade;

create table subjects (
id serial primary key,
name varchar(50) not null
);

drop table if exists progress cascade;

create table progress (
id serial primary key,
student_id integer not null references students(id)
    on delete cascade
    on update cascade,
subject_id integer not null references subjects(id)
    on delete cascade
    on update cascade,
grade integer not null,
constraint grade_value check (grade >=2 and grade <= 5)
);

insert into students (name, passport_n, passport_s) values ('Владимир', 3315, 541612);
insert into students (name, passport_n, passport_s) values ('Иван', 5412, 761389);
insert into students (name, passport_n, passport_s) values ('Антон', 3441, 105247);
insert into students (name, passport_n, passport_s) values ('Генадий', 3131, 423601);

insert into subjects values (default, 'Математика');
insert into subjects values (default, 'Информатика');
insert into subjects values (default, 'Физкультура');
insert into subjects values (default, 'Философия');

insert into progress values (default, 1, 1, 5);
insert into progress values (default, 1, 2, 4);
insert into progress values (default, 1, 3, 5);
insert into progress values (default, 1, 4, 5);

insert into progress values (default, 2, 1, 4);
insert into progress values (default, 2, 2, 4);
insert into progress values (default, 2, 3, 5);
insert into progress values (default, 2, 4, 5);

insert into progress values (default, 3, 1, 2);
insert into progress values (default, 3, 2, 5);
insert into progress values (default, 3, 3, 3);
insert into progress values (default, 3, 4, 5);

insert into progress values (default, 4, 1, 3);
insert into progress values (default, 4, 2, 3);
insert into progress values (default, 4, 3, 3);
insert into progress values (default, 4, 4, 3);



--Выводит всю информацию из таблиц
SELECT stud.name, subj.name, p.grade
FROM students stud
    JOIN progress p
    ON stud.id = p.student_id
    JOIN subjects subj
    ON p.subject_id = subj.id;

--Вывести список студентов, сдавших определенный предмет, на оценку выше 3;
SELECT stud.name, subj.name, p.grade
FROM students stud
    JOIN progress p
    ON stud.id = p.student_id
    JOIN subjects subj
    ON p.subject_id = subj.id
WHERE p.grade > 3 AND p.subject_id = 1;

--Посчитать средний балл по определенному предмету
SELECT subjects.name, AVG(progress.grade) as avg
FROM progress
    JOIN subjects
    ON progress.subject_id = subjects.id
WHERE subject_id = 1
GROUP BY subjects.name;


--Посчитать средний балл по определенному студенту;
SELECT students.name, AVG(progress.grade)
FROM progress
    JOIN subjects
    ON progress.subject_id = subjects.id
    JOIN students
    ON students.id = progress.student_id
GROUP BY students.name;


--Найти три предмета, которые сдали наибольшее количество студентов;
SELECT s.name, count(grade)
FROM (
    SELECT subject_id, grade
    FROM progress
    WHERE grade >= 3
     ) as p
JOIN subjects as s
ON subject_id = s.id
GROUP BY s.name
ORDER BY 2 DESC
LIMIT 3;

SELECT st.name as studName, sub.name as subjName, grade
FROM students st
JOIN progress
ON student_id = st.id
JOIN subjects sub
ON subject_id = sub.id
WHERE st.id not in (
SELECT sts.id
FROM students sts
JOIN progress
ON student_id = sts.id
WHERE grade < 4
)