-- Part 1
CREATE DATABASE testing_system;
USE testing_system;

-- Table 1: Department
CREATE TABLE department (
    department_id INT PRIMARY KEY AUTO_INCREMENT,
    department_name VARCHAR(100)
);

-- Table 2: Position
CREATE TABLE `position` (
    position_id INT PRIMARY KEY AUTO_INCREMENT,
    position_name ENUM('Dev', 'Test', 'Scrum Master', 'PM')
);

-- Table 3: Account
CREATE TABLE `account` (
    account_id INT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(100),
    username VARCHAR(50),
    full_name VARCHAR(100),
    department_id INT,
    position_id INT,
    create_date DATE,
    FOREIGN KEY (department_id) REFERENCES department(department_id),
    FOREIGN KEY (position_id) REFERENCES `position`(position_id)
);

-- Table 4: Group
CREATE TABLE `group` (
    group_id INT PRIMARY KEY AUTO_INCREMENT,
    group_name VARCHAR(100),
    creator_id INT,
    create_date DATE,
    FOREIGN KEY (creator_id) REFERENCES `account`(account_id)
);

-- Table 5: GroupAccount
CREATE TABLE group_account (
    group_id INT,
    account_id INT,
    join_date DATE,
    PRIMARY KEY (group_id, account_id),
    FOREIGN KEY (group_id) REFERENCES `group`(group_id),
    FOREIGN KEY (account_id) REFERENCES `account`(account_id)
);

-- Table 6: TypeQuestion
CREATE TABLE type_question (
    type_id INT PRIMARY KEY AUTO_INCREMENT,
    type_name ENUM('Essay', 'Multiple-Choice')
);

-- Table 7: CategoryQuestion
CREATE TABLE category_question (
    category_id INT PRIMARY KEY AUTO_INCREMENT,
    category_name VARCHAR(50)
);

-- Table 8: Question
CREATE TABLE question (
    question_id INT PRIMARY KEY AUTO_INCREMENT,
    content TEXT,
    category_id INT,
    type_id INT,
    creator_id INT,
    create_date DATE,
    FOREIGN KEY (category_id) REFERENCES category_question(category_id),
    FOREIGN KEY (type_id) REFERENCES type_question(type_id),
    FOREIGN KEY (creator_id) REFERENCES `account`(account_id)
);

-- Table 9: Answer
CREATE TABLE answer (
    answer_id INT PRIMARY KEY AUTO_INCREMENT,
    content TEXT,
    question_id INT,
    is_correct BOOLEAN,
    FOREIGN KEY (question_id) REFERENCES question(question_id)
);

-- Table 10: Exam
CREATE TABLE exam (
    exam_id INT PRIMARY KEY AUTO_INCREMENT,
    code CHAR(10),
    title VARCHAR(100),
    category_id INT,
    duration INT,                    -- minutes
    creator_id INT,
    create_date DATE,
    FOREIGN KEY (category_id) REFERENCES category_question(category_id),
    FOREIGN KEY (creator_id) REFERENCES `account`(account_id)
);

-- Table 11: ExamQuestion
CREATE TABLE exam_question (
    exam_id INT,
    question_id INT,
    PRIMARY KEY (exam_id, question_id),
    FOREIGN KEY (exam_id) REFERENCES exam(exam_id),
    FOREIGN KEY (question_id) REFERENCES question(question_id)
);

-- Assignment_02


-- Table 1
INSERT INTO `department` (department_name)  values
	('Marketing'),
    ('Finance'),
    ('HR'),
    ('Sales'),
    ('Legal')
;
-- Table 2
INSERT INTO `position` (position_name) values 
	('Dev'),
    ('Test'),
    ('Scrum Master'),
    ('PM')
;

-- Table 3: Account
INSERT INTO `account` (email, username, full_name, department_id, position_id, create_date) VALUES
('alice@company.com', 'alice', 'Alice Johnson', 1, 1, '2025-01-10'),
('bob@company.com', 'bob', 'Bob Smith', 2, 2, '2025-01-12'),
('carol@company.com', 'carol', 'Carol White', 3, 3, '2025-01-15'),
('dave@company.com', 'dave', 'Dave Brown', 4, 4, '2025-01-18'),
('eve@company.com', 'eve', 'Eve Davis', 5, 1, '2025-01-20');

-- Table 4: Group
INSERT INTO `group` (group_name, creator_id, create_date) VALUES
('Alpha Team', 1, '2025-02-01'),
('Beta Team', 2, '2025-02-03'),
('Gamma Team', 3, '2025-02-05'),
('Delta Team', 4, '2025-02-07'),
('Epsilon Team', 5, '2025-02-09');

-- Table 5: GroupAccount
INSERT INTO group_account (group_id, account_id, join_date) VALUES
(1, 1, '2025-02-01'),
(1, 2, '2025-02-02'),
(2, 3, '2025-02-03'),
(3, 4, '2025-02-05'),
(4, 5, '2025-02-07');

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
('Security');

-- Table 8: Question
INSERT INTO question (content, category_id, type_id, creator_id, create_date) VALUES
('Explain the concept of OOP in Java.', 1, 1, 1, '2025-03-01'),
('What is a primary key in SQL?', 2, 2, 2, '2025-03-02'),
('Write a Python function to reverse a string.', 3, 1, 3, '2025-03-03'),
('Explain the difference between TCP and UDP.', 4, 1, 4, '2025-03-04'),
('What is XSS and how to prevent it?', 5, 2, 5, '2025-03-05');

-- Table 9: Answer
INSERT INTO answer (content, question_id, is_correct) VALUES
('OOP is Object-Oriented Programming...', 1, TRUE),
('A primary key uniquely identifies each row.', 2, TRUE),
('Use the [::-1] slicing in Python to reverse.', 3, TRUE),
('TCP is connection-oriented; UDP is connectionless.', 4, TRUE),
('XSS is Cross-Site Scripting; prevent using input sanitization.', 5, TRUE);

-- Table 10: Exam
INSERT INTO exam (code, title, category_id, duration, creator_id, create_date) VALUES
('EXAM001', 'Java Basics', 1, 60, 1, '2025-04-01'),
('EXAM002', 'SQL Fundamentals', 2, 45, 2, '2025-04-02'),
('EXAM003', 'Python Coding', 3, 75, 3, '2025-04-03'),
('EXAM004', 'Networking Concepts', 4, 50, 4, '2025-04-04'),
('EXAM005', 'Web Security', 5, 40, 5, '2025-04-05');

-- Table 11: ExamQuestion
INSERT INTO exam_question (exam_id, question_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);
