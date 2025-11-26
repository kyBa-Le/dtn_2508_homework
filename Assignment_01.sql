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