package java_core.homework.assignment1;

public class Question {
    private int questionId;
    private String content;
    private CategoryQuestion category;
    private TypeQuestion type;
    private Account creator;
    private java.sql.Date createDate;

    public Question() {
    }

    public Question(int questionId, String content, CategoryQuestion category,
            TypeQuestion type, Account creator, java.sql.Date createDate) {
        this.questionId = questionId;
        this.content = content;
        this.category = category;
        this.type = type;
        this.creator = creator;
        this.createDate = createDate;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public CategoryQuestion getCategory() {
        return category;
    }

    public void setCategory(CategoryQuestion category) {
        this.category = category;
    }

    public TypeQuestion getType() {
        return type;
    }

    public void setType(TypeQuestion type) {
        this.type = type;
    }

    public Account getCreator() {
        return creator;
    }

    public void setCreator(Account creator) {
        this.creator = creator;
    }

    public java.sql.Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(java.sql.Date createDate) {
        this.createDate = createDate;
    }
}