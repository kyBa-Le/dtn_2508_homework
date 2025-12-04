use testing_system;

-- Table 1
INSERT INTO `department` (department_name) VALUES
('Marketing'),
('Finance'),
('HR'),
('Sales'),
('Legal'),
('IT Support'),
('Operations'),
('Research'),
('Customer Service'),
('Administration');

-- Table 2
INSERT INTO `position` (position_name) VALUES
('Dev'),
('Tester'),
('Scrum Master'),
('Project Manager'),
('Designer'),
('Business Analyst'),
('DevOps Engineer'),
('Data Engineer'),
('Intern'),
('Tech Lead');


-- Table 3: Account
INSERT INTO `account` (email, username, full_name, department_id, position_id, create_date) VALUES
('alice@company.com', 'alice', 'Alice Johnson', 1, 1, '2025-01-10'),
('bob@company.com', 'bob', 'Bob Smith', 2, 2, '2025-01-11'),
('carol@company.com', 'carol', 'Carol White', 3, 3, '2025-01-12'),
('dave@company.com', 'dave', 'Dave Brown', 4, 4, '2025-01-13'),
('eve@company.com', 'eve', 'Eve Davis', 5, 5, '2025-01-14'),
('frank@company.com', 'frank', 'Frank Wilson', 6, 6, '2025-01-15'),
('grace@company.com', 'grace', 'Grace Lee', 7, 7, '2025-01-16'),
('heidi@company.com', 'heidi', 'Heidi Adams', 8, 8, '2025-01-17'),
('ivan@company.com', 'ivan', 'Ivan Thompson', 9, 9, '2025-01-18'),
('judy@company.com', 'judy', 'Judy Miller', 10, 10, '2025-01-19');

-- Table 4: Group
INSERT INTO `group` (group_name, creator_id, create_date) VALUES
('Alpha Team', 1, '2025-02-01'),
('Beta Team', 2, '2025-02-02'),
('Gamma Team', 3, '2025-02-03'),
('Delta Team', 4, '2025-02-04'),
('Epsilon Team', 5, '2025-02-05'),
('Zeta Team', 6, '2025-02-06'),
('Eta Team', 7, '2025-02-07'),
('Theta Team', 8, '2025-02-08'),
('Iota Team', 9, '2025-02-09'),
('Kappa Team', 10, '2025-02-10');

-- Table 5: GroupAccount
INSERT INTO group_account (group_id, account_id, join_date) VALUES
(1, 1, '2025-02-01'),
(2, 2, '2025-02-02'),
(3, 3, '2025-02-03'),
(4, 4, '2025-02-04'),
(5, 5, '2025-02-05'),
(6, 6, '2025-02-06'),
(7, 7, '2025-02-07'),
(8, 8, '2025-02-08'),
(9, 9, '2025-02-09'),
(10, 10, '2025-02-10');

-- Table 6: TypeQuestion
INSERT INTO type_question (type_name) VALUES
('Essay'),
('Multiple-Choice');

-- Table 7: CategoryQuestion
INSERT INTO category_question (category_name) VALUES
('Java'),
('SQL'),
('Python'),
('Networking'),
('Security'),
('Data Structures'),
('Algorithms'),
('Cloud Computing'),
('DevOps'),
('Operating Systems');

-- Table 8: Question
INSERT INTO question (content, category_id, type_id, creator_id, create_date) VALUES
('Explain OOP principles in Java.', 1, 1, 1, '2025-03-01'),
('What is a foreign key in SQL?', 2, 2, 2, '2025-03-02'),
('Write a Python loop to print numbers 1–10.', 3, 1, 3, '2025-03-03'),
('Explain TCP handshake.', 4, 1, 4, '2025-03-04'),
('What is SQL Injection?', 5, 2, 5, '2025-03-05'),
('Describe a linked list.', 6, 1, 6, '2025-03-06'),
('Explain Big-O complexity.', 7, 2, 7, '2025-03-07'),
('What is IaaS?', 8, 2, 8, '2025-03-08'),
('Explain CI/CD.', 9, 2, 9, '2025-03-09'),
('Describe process vs thread.', 10, 1, 10, '2025-03-10');

-- Table 9: Answer
INSERT INTO answer (content, question_id, is_correct) VALUES
('OOP has four pillars: Encapsulation, Inheritance, Polymorphism, Abstraction.', 1, TRUE),
('A foreign key enforces a link between two tables.', 2, TRUE),
('Use a for loop: for i in range(1,11).', 3, TRUE),
('TCP handshake uses SYN, SYN-ACK, ACK.', 4, TRUE),
('SQL Injection is an attack via malicious SQL queries.', 5, TRUE),
('A linked list is a linear structure of nodes.', 6, TRUE),
('Big-O describes algorithm complexity.', 7, TRUE),
('IaaS provides virtualized computing resources.', 8, TRUE),
('CI/CD stands for Continuous Integration / Continuous Deployment.', 9, TRUE),
('A process is independent; threads share memory.', 10, TRUE);

-- Table 10: Exam
INSERT INTO exam (code, title, category_id, duration, creator_id, create_date) VALUES
('EXAM001', 'Java Basics', 1, 60, 1, '2025-04-01'),
('EXAM002', 'SQL Essentials', 2, 45, 2, '2025-04-02'),
('EXAM003', 'Python Programming', 3, 75, 3, '2025-04-03'),
('EXAM004', 'Networking Concepts', 4, 50, 4, '2025-04-04'),
('EXAM005', 'Security Awareness', 5, 40, 5, '2025-04-05'),
('EXAM006', 'Data Structures', 6, 60, 6, '2025-04-06'),
('EXAM007', 'Algorithms Exam', 7, 70, 7, '2025-04-07'),
('EXAM008', 'Cloud Fundamentals', 8, 55, 8, '2025-04-08'),
('EXAM009', 'DevOps Concepts', 9, 45, 9, '2025-04-09'),
('EXAM010', 'Operating Systems', 10, 50, 10, '2025-04-10');

-- Table 11: ExamQuestion
INSERT INTO exam_question (exam_id, question_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);

