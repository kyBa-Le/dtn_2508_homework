USE testing_system;

-- Question 1
DELIMITER $$
CREATE PROCEDURE sp_get_accounts_by_department(IN dept_name VARCHAR(100))
BEGIN
    SELECT a.account_id, a.email, a.username, a.full_name
    FROM `account` a
    JOIN department d ON a.department_id = d.department_id
    WHERE d.department_name = dept_name;
END$$
DELIMITER ;

-- Question 2
DELIMITER $$
CREATE PROCEDURE sp_count_accounts_in_groups()
BEGIN
    SELECT g.group_name, COUNT(ga.account_id) AS total_members
    FROM `group` g
    LEFT JOIN group_account ga ON g.group_id = ga.group_id
    GROUP BY g.group_id, g.group_name;
END$$
DELIMITER ;

-- Question 3
DELIMITER $$
CREATE PROCEDURE sp_count_questions_by_type_current_month()
BEGIN
    SELECT t.type_name, COUNT(q.question_id) AS total
    FROM type_question t
    LEFT JOIN question q ON t.type_id = q.type_id
    WHERE MONTH(q.create_date) = MONTH(CURDATE()) 
      AND YEAR(q.create_date) = YEAR(CURDATE())
    GROUP BY t.type_id, t.type_name;
END$$
DELIMITER ;

-- Question 4
DELIMITER $$
CREATE PROCEDURE sp_get_typeid_with_most_questions(OUT max_type_id INT)
BEGIN
    SELECT type_id INTO max_type_id
    FROM question
    GROUP BY type_id
    ORDER BY COUNT(*) DESC
    LIMIT 1;
END$$
DELIMITER ;

-- Question 5 (Call Question 4 and return type name)
DELIMITER $$
CREATE PROCEDURE sp_get_type_name_with_most_questions()
BEGIN
    DECLARE max_id INT;
    CALL sp_get_typeid_with_most_questions(max_id);
    SELECT type_name 
    FROM type_question 
    WHERE type_id = max_id;
END$$
DELIMITER ;

-- Question 6
DELIMITER $$
CREATE PROCEDURE sp_search_group_or_account(IN search_str VARCHAR(100))
BEGIN
    SELECT group_name AS result, 'Group' AS type FROM `group` WHERE group_name LIKE CONCAT('%', search_str, '%')
    UNION
    SELECT username AS result, 'Account' AS type FROM `account` WHERE username LIKE CONCAT('%', search_str, '%');
END$$
DELIMITER ;

-- Question 7
DELIMITER $$
CREATE PROCEDURE sp_create_new_account(
    IN in_fullname VARCHAR(100),
    IN in_email VARCHAR(100)
)
BEGIN
    DECLARE v_username VARCHAR(50);
    DECLARE v_waiting_dept_id INT DEFAULT 1;
    
    SET v_username = SUBSTRING_INDEX(in_email, '@', 1);
    
    INSERT INTO `account` (email, username, full_name, department_id, position_id, create_date)
    VALUES (in_email, v_username, in_fullname, v_waiting_dept_id, 
            (SELECT position_id FROM `position` WHERE position_name = 'Dev' LIMIT 1),
            CURDATE());
    
    SELECT 'Account created successfully!' AS message;
END$$
DELIMITER ;

-- Question 8
DELIMITER $$
CREATE PROCEDURE sp_longest_question_by_type(IN q_type ENUM('Essay', 'Multiple-Choice'))
BEGIN
    SELECT q.question_id, q.content, CHAR_LENGTH(q.content) AS content_length
    FROM question q
    JOIN type_question tq ON q.type_id = tq.type_id
    WHERE tq.type_name = q_type
    ORDER BY CHAR_LENGTH(q.content) DESC
    LIMIT 1;
END$$
DELIMITER ;

-- Question 9
DELIMITER $$
CREATE PROCEDURE sp_delete_exam(IN exam_id_to_delete INT)
BEGIN
    DELETE FROM exam_question WHERE exam_id = exam_id_to_delete;
    DELETE FROM exam WHERE exam_id = exam_id_to_delete;
END$$
DELIMITER ;

-- Question 10
DELIMITER $$
CREATE PROCEDURE sp_delete_exams_older_than_3_years(OUT total_deleted INT)
BEGIN
    DECLARE done INT DEFAULT 0;
    DECLARE exam_id INT;
    DECLARE cur CURSOR FOR 
        SELECT exam_id FROM exam WHERE create_date < DATE_SUB(CURDATE(), INTERVAL 3 YEAR);
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;
    
    SET total_deleted = 0;
    
    OPEN cur;
    read_loop: LOOP
        FETCH cur INTO exam_id;
        IF done THEN LEAVE read_loop; END IF;
        
        CALL sp_delete_exam(exam_id);
        SET total_deleted = total_deleted + 1;
    END LOOP;
    CLOSE cur;
    
    SELECT total_deleted AS exams_deleted, 
           total_deleted AS exam_records_deleted,
           (SELECT COUNT(*) FROM exam_question eq 
            WHERE eq.exam_id IN (SELECT exam_id FROM exam WHERE create_date < DATE_SUB(CURDATE(), INTERVAL 3 YEAR))) 
           AS exam_question_records_deleted;
END$$
DELIMITER ;

-- Question 11
DELIMITER $$
CREATE PROCEDURE sp_delete_department_move_to_waiting(IN dept_name VARCHAR(100))
BEGIN
    DECLARE waiting_dept_id INT DEFAULT 999;
    
    UPDATE `account` 
    SET department_id = waiting_dept_id
    WHERE department_id = (SELECT department_id FROM department WHERE department_name = dept_name);
    
    DELETE FROM department WHERE department_name = dept_name;
    
    SELECT CONCAT('Department ', dept_name, ' deleted and accounts moved to Waiting Room') AS message;
END$$
DELIMITER ;

-- Question 12
DELIMITER $$
CREATE PROCEDURE sp_questions_per_month_this_year()
BEGIN
    SELECT 
        MONTH(create_date) AS month_number,
        COUNT(*) AS total_questions
    FROM question
    WHERE YEAR(create_date) = YEAR(CURDATE())
    GROUP BY MONTH(create_date)
    ORDER BY month_number;
END$$
DELIMITER ;

-- Question 13
DELIMITER $$
CREATE PROCEDURE sp_questions_last_6_months_with_zero()
BEGIN
    SELECT 
        m.month_num,
        COALESCE(q.total, 0) AS total_questions,
        CASE WHEN q.total IS NULL THEN 'No questions this month' ELSE '' END AS note
    FROM (
        SELECT MONTH(CURDATE() - INTERVAL (5 - n.n) MONTH) AS month_num
        FROM (SELECT 0 AS n UNION SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5) n
    ) m
    LEFT JOIN (
        SELECT MONTH(create_date) AS month_num, COUNT(*) AS total
        FROM question
        WHERE create_date >= DATE_SUB(CURDATE(), INTERVAL 5 MONTH)
        GROUP BY MONTH(create_date)
    ) q ON m.month_num = q.month_num
    ORDER BY m.month_num DESC;
END$$
DELIMITER ;