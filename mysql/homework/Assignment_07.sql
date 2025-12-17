USE testing_system;

ALTER TABLE `account` ADD COLUMN gender ENUM('M', 'F', 'U') DEFAULT NULL;

-- Question 1
DELIMITER $$
CREATE TRIGGER trg_group_insert_before
BEFORE INSERT ON `group`
FOR EACH ROW
BEGIN
    IF NEW.create_date < DATE_SUB(CURDATE(), INTERVAL 1 YEAR) THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Cannot create group with create_date older than 1 year';
    END IF;
END$$
DELIMITER ;

-- Question 2
DELIMITER $$
CREATE TRIGGER trg_account_insert_sale
BEFORE INSERT ON `account`
FOR EACH ROW
BEGIN
    IF NEW.department_id = (SELECT department_id FROM department WHERE department_name = 'Sale') THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Department "Sale" cannot add more user';
    END IF;
END$$
DELIMITER ;

-- Question 3
DELIMITER $$
CREATE TRIGGER trg_group_account_insert_max_5
BEFORE INSERT ON group_account
FOR EACH ROW
BEGIN
    IF (SELECT COUNT(*) FROM group_account WHERE group_id = NEW.group_id) >= 5 THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'A group can have maximum 5 users';
    END IF;
END$$
DELIMITER ;

-- Question 4
DELIMITER $$
CREATE TRIGGER trg_exam_question_insert_max_10
BEFORE INSERT ON exam_question
FOR EACH ROW
BEGIN
    IF (SELECT COUNT(*) FROM exam_question WHERE exam_id = NEW.exam_id) >= 10 THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'An exam can have maximum 10 questions';
    END IF;
END$$
DELIMITER ;

-- Question 5
DELIMITER $$
CREATE TRIGGER trg_account_delete_admin
BEFORE DELETE ON `account`
FOR EACH ROW
BEGIN
    IF OLD.email = 'admin@gmail.com' THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Cannot delete admin account';
    END IF;
END$$
DELIMITER ;

-- Question 6
DELIMITER $$
CREATE TRIGGER trg_account_insert_waiting_dept
BEFORE INSERT ON `account`
FOR EACH ROW
BEGIN
    IF NEW.department_id IS NULL THEN
        SET NEW.department_id = (
            SELECT department_id 
            FROM department 
            WHERE department_name = 'Waiting Department' 
            LIMIT 1
        );
    END IF;
END$$
DELIMITER ;

-- Question 7
DELIMITER $$
CREATE TRIGGER trg_answer_insert_limits
BEFORE INSERT ON answer
FOR EACH ROW
BEGIN
    DECLARE total_answers INT;
    DECLARE correct_answers INT;
    
    SELECT COUNT(*), SUM(is_correct) 
    INTO total_answers, correct_answers
    FROM answer 
    WHERE question_id = NEW.question_id;
    
    IF total_answers >= 4 THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'A question can have maximum 4 answers';
    END IF;
    
    IF (correct_answers + IF(NEW.is_correct, 1, 0)) > 2 THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'A question can have maximum 2 correct answers';
    END IF;
END$$
DELIMITER ;

-- Question 8
DELIMITER $$
CREATE TRIGGER trg_account_gender_normalize_insert
BEFORE INSERT ON `account`
FOR EACH ROW
BEGIN
    IF NEW.gender = 'nam' THEN
        SET NEW.gender = 'M';
    ELSEIF NEW.gender = 'nữ' OR NEW.gender = 'nu' THEN
        SET NEW.gender = 'F';
    ELSEIF NEW.gender = 'chưa xác định' THEN
        SET NEW.gender = 'U';
    END IF;
END$$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER trg_account_gender_normalize_update
BEFORE UPDATE ON `account`
FOR EACH ROW
BEGIN
    IF NEW.gender = 'nam' THEN
        SET NEW.gender = 'M';
    ELSEIF NEW.gender = 'nữ' OR NEW.gender = 'nu' THEN
        SET NEW.gender = 'F';
    ELSEIF NEW.gender = 'chưa xác định' THEN
        SET NEW.gender = 'U';
    END IF;
END$$
DELIMITER ;

-- Question 9
DELIMITER $$
CREATE TRIGGER trg_exam_delete_recent
BEFORE DELETE ON exam
FOR EACH ROW
BEGIN
    IF OLD.create_date >= DATE_SUB(CURDATE(), INTERVAL 2 DAY) THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Cannot delete exam created in the last 2 days';
    END IF;
END$$
DELIMITER ;

-- Question 10
DELIMITER $$
CREATE TRIGGER trg_question_update_no_exam
BEFORE UPDATE ON question
FOR EACH ROW
BEGIN
    IF EXISTS (SELECT 1 FROM exam_question WHERE question_id = OLD.question_id) THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Cannot update question used in an exam';
    END IF;
END$$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER trg_question_delete_no_exam
BEFORE DELETE ON question
FOR EACH ROW
BEGIN
    IF EXISTS (SELECT 1 FROM exam_question WHERE question_id = OLD.question_id) THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Cannot delete question used in an exam';
    END IF;
END$$
DELIMITER ;

-- Question 12
SELECT 
    exam_id,
    code,
    title,
    category_id,
    creator_id,
    create_date,
    CASE 
        WHEN duration <= 30 THEN 'Short time'
        WHEN duration <= 60 THEN 'Medium time'
        ELSE 'Long time'
    END AS duration_category
FROM exam;

-- Question 13
SELECT 
    g.group_name,
    COUNT(ga.account_id) AS number_of_users,
    CASE 
        WHEN COUNT(ga.account_id) <= 5 THEN 'few'
        WHEN COUNT(ga.account_id) <= 20 THEN 'normal'
        ELSE 'higher'
    END AS the_number_user_amount
FROM `group` g
LEFT JOIN group_account ga ON g.group_id = ga.group_id
GROUP BY g.group_id, g.group_name;

-- Question 14
SELECT 
    d.department_name,
    COUNT(a.account_id) AS number_of_users,
    IF(COUNT(a.account_id) = 0, 'No User', CAST(COUNT(a.account_id) AS CHAR)) AS user_status
FROM department d
LEFT JOIN `account` a ON d.department_id = a.department_id
GROUP BY d.department_id, d.department_name;