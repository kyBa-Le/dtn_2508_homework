import java.sql.Date;

public class Program {
    public static void main(String[] args) {

        // Department
        Department dept1 = new Department(1, "Sale");
        Department dept2 = new Department(2, "Marketing");
        Department dept3 = new Department(3, "IT");
        System.out.println("Department 1 name: " + dept1.getDepartmentName());

        // Position
        Position pos1 = new Position(1, "Dev");
        Position pos2 = new Position(2, "Test");
        Position pos3 = new Position(3, "PM");
        System.out.println("Position 3 name: " + pos3.getPositionName());

        // Account
        Account acc1 = new Account(1, "nguyen.van.an@gmail.com", "nguyenvanan", "Nguyễn Văn An", dept1, pos1,
                Date.valueOf("2023-01-15"));
        Account acc2 = new Account(2, "tran.thi.binh@gmail.com", "tranthibinh", "Trần Thị Bình", dept2, pos2,
                Date.valueOf("2023-02-20"));
        Account acc3 = new Account(3, "le.van.cuong@gmail.com", "levancuong", "Lê Văn Cường", dept3, pos3,
                Date.valueOf("2023-03-10"));
        System.out.println("Account 1 full name: " + acc1.getFullName());

        // Group
        Group group1 = new Group(1, "Java Group", acc1, Date.valueOf("2023-04-01"));
        Group group2 = new Group(2, "Testing Group", acc2, Date.valueOf("2023-05-01"));
        Group group3 = new Group(3, "PM Group", acc3, Date.valueOf("2023-06-01"));
        System.out.println("Group 1 name: " + group1.getGroupName());

        // GroupAccount
        GroupAccount ga1 = new GroupAccount(group1, acc1, Date.valueOf("2023-04-05"));
        GroupAccount ga2 = new GroupAccount(group2, acc2, Date.valueOf("2023-05-05"));
        GroupAccount ga3 = new GroupAccount(group3, acc3, Date.valueOf("2023-06-05"));
        System.out.println("GroupAccount 1 join date: " + ga1.getJoinDate());

        // TypeQuestion
        TypeQuestion tq1 = new TypeQuestion(1, "Essay");
        TypeQuestion tq2 = new TypeQuestion(2, "Multiple-Choice");
        TypeQuestion tq3 = new TypeQuestion(3, "True/False");
        System.out.println("TypeQuestion 1 name: " + tq1.getTypeName());

        // CategoryQuestion
        CategoryQuestion cq1 = new CategoryQuestion(1, "Java");
        CategoryQuestion cq2 = new CategoryQuestion(2, "SQL");
        CategoryQuestion cq3 = new CategoryQuestion(3, "Postman");
        System.out.println("CategoryQuestion 1 name: " + cq1.getCategoryName());

        // Question
        Question q1 = new Question(1, "What is polymorphism?", cq1, tq1, acc1, Date.valueOf("2023-07-01"));
        Question q2 = new Question(2, "Write a JOIN query", cq2, tq2, acc2, Date.valueOf("2023-08-01"));
        Question q3 = new Question(3, "Test API", cq3, tq3, acc3, Date.valueOf("2023-09-01"));
        System.out.println("Question 1 content: " + q1.getContent());

        // Answer
        Answer ans1 = new Answer(1, "Answer for Q1", q1, true);
        Answer ans2 = new Answer(2, "Answer for Q2", q2, false);
        Answer ans3 = new Answer(3, "Answer for Q3", q3, true);
        System.out.println("Answer 1 content: " + ans1.getContent());

        // Exam
        Exam exam1 = new Exam(1, "EX001", "Java Final Test", cq1, 60, acc1, Date.valueOf("2023-10-01"));
        Exam exam2 = new Exam(2, "EX002", "SQL Exam", cq2, 45, acc2, Date.valueOf("2023-11-01"));
        Exam exam3 = new Exam(3, "EX003", "API Testing", cq3, 90, acc3, Date.valueOf("2023-12-01"));
        System.out.println("Exam 1 title: " + exam1.getTitle());

        // ExamQuestion
        ExamQuestion eq1 = new ExamQuestion(exam1, q1);
        ExamQuestion eq2 = new ExamQuestion(exam2, q2);
        ExamQuestion eq3 = new ExamQuestion(exam3, q3);
        System.out.println("ExamQuestion 1 question ID: " + eq1.getQuestion().getQuestionId());
    }
}