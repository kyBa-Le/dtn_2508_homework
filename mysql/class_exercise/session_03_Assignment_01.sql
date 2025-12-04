create database fresher_training_manager;
use fresher_training_manager;

CREATE TABLE trainee (
    trainee_id INT PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(30),
    birth_date DATE,
    gender ENUM('male', 'female', 'unknown'),
    et_iq INT CHECK (et_iq >= 0 & et_iq <= 20),
    et_gmath INT CHECK (et_iq >= 0 & et_iq <= 20),
    et_english INT CHECK (et_iq >= 0 & et_iq <= 50),
    training_class VARCHAR(10),
    notes TEXT
);

insert into trainee values 
(0, 'Trainee 1', '2005/01/01', 'male', 10, 20, 10, 'Class 1', 'No note here'),
(0, 'Trainee 2', '2005/02/01', 'female', 20, 20, 50, 'Class 2', 'No note here'),
(0, 'Trainee 3', '2005/03/01', 'male', 10, 20, 50, 'Class 3', 'No note here'),
(0, 'Trainee 4', '2005/02/01', 'female', 20, 10, 50, 'Class 1', 'No note here'),
(0, 'Trainee 5', '2005/03/01', 'male', 10, 20, 50, 'Class 2', 'No note here'),
(0, 'Trainee 6', '2005/02/01', 'female', 20, 20, 50, 'Class 3', 'No note here'),
(0, 'Trainee 7', '2005/03/01', 'male', 10, 20, 10, 'Class 2', 'No note here'),
(0, 'Trainee 8', '2005/02/01', 'female', 20, 20, 50, 'Class 1', 'No note here'),
(0, 'Trainee 9', '2005/02/01', 'male', 10, 20, 10, 'Class 1', 'No note here'),
(0, 'Trainee 10', '2005/01/01', 'female', 20, 20, 50, 'Class 2', 'No note here'),
(0, 'Trainee 11 with longest name', '2005/01/01', 'male', 20, 20, 10, 'Class 3', 'No note here');

-- Delete for re-insertion 
DELETE FROM trainee 
WHERE
    trainee_id > 0;


-- Question 2

SELECT 
    MONTH(birth_date) AS birth_month, COUNT(*) AS total_pass
FROM
    trainee
WHERE
    (et_iq + et_gmath >= 20 AND et_iq >= 8
        AND et_gmath >= 8
        AND et_english >= 18)
GROUP BY (MONTH(birth_date));

-- Question 3

SELECT 
    *,
    TIMESTAMPDIFF(YEAR,
        birth_date,
        CURDATE()) AS age
FROM
    trainee
ORDER BY (CHAR_LENGTH(full_name)) DESC
LIMIT 1;

-- Question 4
SELECT 
    *
FROM
    trainee
WHERE
    (et_iq + et_gmath >= 20 AND et_iq >= 8
        AND et_gmath >= 8
        AND et_english >= 18);

-- Question 5
DELETE FROM trainee 
WHERE
    trainee_id = 3;
    
-- Question 6
UPDATE trainee 
SET 
    training_class = 2
WHERE
    trainee_id = 5;


