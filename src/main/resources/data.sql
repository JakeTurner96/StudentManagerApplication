insert into student(course_title, date_of_birth, name) values
('Computer Science', '1996-8-16', 'Jake Turner'),
('Computer Science', '1998-4-11', 'Damon Tran'),
('Business Management', '1998-3-16', 'Adam Robinson'),
('Film', '1998-4-11', 'Connor Notman'),
('Economics', '1998-5-26', 'Mia Hardcastle');

insert into module(moduleid, coursework_weight, exam_weight, module_title) values

('1', '50', '50', 'Artificial Intelligence '),
('2', '30', '70', 'Data Structures and Algorithms'),
('3', '75', '25', 'Object Oriented Programming'),
('4', '20', '80', 'Software Engineering'),
('5', '100', '0', 'Web Development');

insert into student_modules(student_id, module_id) values
(1,1),
(1,2),
(1,3),

(2,1),
(2,2),
(2,3);





