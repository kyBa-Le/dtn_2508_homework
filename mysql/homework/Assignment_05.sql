USE testing_system;

-- Question 1: View - List of employees in the Sale department
CREATE OR REPLACE VIEW v_sale_department_employees AS
SELECT a.account_id, a.email, a.username, a.full_name, a.create_date
FROM `account` a
WHERE a.department_id = (
    SELECT department_id
    FROM department
    WHERE department_name = 'Sale'
);

-- Question 2: View - Accounts that joined the most groups
CREATE OR REPLACE VIEW v_accounts_most_groups AS
SELECT a.account_id, a.email, a.username, a.full_name, COUNT(ga.group_id) AS number_of_groups
FROM `account` a
JOIN group_account ga ON a.account_id = ga.account_id
GROUP BY a.account_id, a.email, a.username, a.full_name
HAVING COUNT(ga.group_id) = (
    SELECT COUNT(group_id)
    FROM group_account
    GROUP BY account_id
    ORDER BY COUNT(group_id) DESC
    LIMIT 1
);

-- Question 3: View - Questions with content longer than 300 words → then drop it
CREATE OR REPLACE VIEW v_questions_too_long AS
SELECT question_id, content, LENGTH(content) AS content_length
FROM question
WHERE LENGTH(content) - LENGTH(REPLACE(content, ' ', '')) + 1 > 300;

DROP VIEW v_questions_too_long;

-- Question 4: View - Department(s) with the highest number of employees
CREATE OR REPLACE VIEW v_department_most_employees AS
SELECT d.department_id, d.department_name, COUNT(a.account_id) AS number_of_employees
FROM department d
JOIN `account` a ON d.department_id = a.department_id
GROUP BY d.department_id, d.department_name
HAVING COUNT(a.account_id) = (
    SELECT COUNT(account_id)
    FROM `account`
    GROUP BY department_id
    ORDER BY COUNT(account_id) DESC
    LIMIT 1
);

-- Question 5: View - All questions created by users whose name contains "Nguyen"
CREATE OR REPLACE VIEW v_questions_by_nguyen AS
SELECT q.question_id, q.content, q.create_date, a.full_name AS creator_name
FROM question q
JOIN `account` a ON q.creator_id = a.account_id
WHERE a.full_name LIKE 'Nguyen %'
   OR a.full_name LIKE '% Nguyen %';