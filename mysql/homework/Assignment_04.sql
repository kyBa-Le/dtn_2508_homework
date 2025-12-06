use testing_system;

-- Question 1: Danh sách nhân viên và phòng ban của họ
SELECT a.account_id, a.email, a.username, a.full_name, d.department_name
FROM `account` a
LEFT JOIN department d ON a.department_id = d.department_id;

-- Question 2: Các account được tạo sau ngày 20/12/2010
SELECT *
FROM `account`
WHERE create_date > '2010-12-20';

-- Question 3: Lấy ra tất cả các developer
SELECT a.*
FROM `account` a
JOIN `position` p ON a.position_id = p.position_id
WHERE p.position_name = 'Dev';

-- Question 4: Các phòng ban có >3 nhân viên
SELECT d.department_name, COUNT(*) AS number_of_employee
FROM department d
JOIN `account` a ON d.department_id = a.department_id
GROUP BY d.department_id, d.department_name
HAVING COUNT(*) > 0;

-- Question 5: Danh sách câu hỏi được sử dụng trong đề thi nhiều nhất
SELECT q.question_id, q.content, COUNT(eq.exam_id) AS use_count
FROM question q
JOIN exam_question eq ON q.question_id = eq.question_id
GROUP BY q.question_id
HAVING COUNT(eq.exam_id) = (
    SELECT COUNT(exam_id)
    FROM exam_question
    GROUP BY question_id
    ORDER BY COUNT(exam_id) DESC
    LIMIT 1
);

-- Question 6: Thống kê mỗi category Question được sử dụng trong bao nhiêu Question
SELECT cq.category_name, COUNT(q.question_id) AS so_question
FROM category_question cq
LEFT JOIN question q ON cq.category_id = q.category_id
GROUP BY cq.category_id;

-- Question 7: Thống kê mỗi Question được sử dụng trong bao nhiêu Exam
SELECT q.question_id, q.content, COUNT(eq.exam_id) AS count_exam
FROM question q
LEFT JOIN exam_question eq ON q.question_id = eq.question_id
GROUP BY q.question_id, q.content;

-- Question 8: Question có nhiều câu trả lời nhất
SELECT q.question_id, q.content, COUNT(a.answer_id) AS number_of_answer
FROM question q
JOIN answer a ON q.question_id = a.question_id
GROUP BY q.question_id, q.content
HAVING COUNT(a.answer_id) = (
    SELECT COUNT(answer_id)
    FROM answer
    GROUP BY question_id
    ORDER BY COUNT(answer_id) DESC
    LIMIT 1
);

-- Question 9: Thống kê số lượng account trong mỗi group
SELECT g.group_name, COUNT(ga.account_id) AS number_of_account
FROM `group` g
LEFT JOIN group_account ga ON g.group_id = ga.group_id
GROUP BY g.group_id;

-- Question 10: Tìm chức vụ có ít người nhất
SELECT p.position_name, COUNT(a.account_id) AS number_of_employee
FROM `position` p
LEFT JOIN `account` a ON p.position_id = a.position_id
GROUP BY p.position_id, p.position_name
HAVING COUNT(a.account_id) = (
    SELECT COUNT(account_id)
    FROM `account`
    GROUP BY position_id
    ORDER BY COUNT(account_id)
    LIMIT 1
);

-- Question 11: Thống kê mỗi phòng ban có bao nhiêu dev, tester, scrum master, PM
SELECT d.department_name,
       SUM(CASE WHEN p.position_name = 'Dev' THEN 1 ELSE 0 END) AS Dev,
       SUM(CASE WHEN p.position_name = 'Test' THEN 1 ELSE 0 END) AS Test,
       SUM(CASE WHEN p.position_name = 'Scrum Master' THEN 1 ELSE 0 END) AS Scrum_Master,
       SUM(CASE WHEN p.position_name = 'PM' THEN 1 ELSE 0 END) AS PM
FROM department d
LEFT JOIN `account` a ON d.department_id = a.department_id
LEFT JOIN `position` p ON a.position_id = p.position_id
GROUP BY d.department_id, d.department_name;

-- Question 12: Thông tin chi tiết của câu hỏi (content, category, type, creator, answers...)
SELECT 
    q.question_id,
    q.content,
    cq.category_name,
    tq.type_name,
    a.full_name AS creator_name,
    ans.content AS answer_content,
    ans.is_correct
FROM question q
LEFT JOIN category_question cq ON q.category_id = cq.category_id
LEFT JOIN type_question tq ON q.type_id = tq.type_id
LEFT JOIN `account` a ON q.creator_id = a.account_id
LEFT JOIN answer ans ON q.question_id = ans.question_id;

-- Question 13: Số lượng câu hỏi của mỗi loại (Essay vs Multiple-Choice)
SELECT tq.type_name, COUNT(q.question_id) AS number_of_question
FROM type_question tq
LEFT JOIN question q ON tq.type_id = q.type_id
GROUP BY tq.type_id, tq.type_name;

-- Question 14 & 15: Group không có account nào (cùng 1 yêu cầu)
SELECT g.group_id, g.group_name
FROM `group` g
LEFT JOIN group_account ga ON g.group_id = ga.group_id
WHERE ga.account_id IS NULL;

-- Question 16: Question không có answer nào
SELECT q.question_id, q.content
FROM question q
LEFT JOIN answer a ON q.question_id = a.question_id
WHERE a.answer_id IS NULL;

-- Question 17: Ghép account thuộc group 1 và group 2, không trùng
SELECT ga.account_id FROM group_account ga WHERE ga.group_id = 1
UNION
SELECT ga.account_id FROM group_account ga WHERE ga.group_id = 2;

-- Question 18:
SELECT g.group_id, g.group_name
FROM `group` g
JOIN group_account ga ON g.group_id = ga.group_id
GROUP BY g.group_id, g.group_name
HAVING COUNT(ga.account_id) > 5

UNION ALL

SELECT g.group_id, g.group_name
FROM `group` g
JOIN group_account ga ON g.group_id = ga.group_id
GROUP BY g.group_id, g.group_name
HAVING COUNT(ga.account_id) < 7;