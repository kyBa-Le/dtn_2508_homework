package java_core.homework.assignment5.exercise1.question1;

public class News implements INews {
    private int ID;
    private String Title;
    private String PublishDate;
    private String Author;
    private String Content;
    private float AverageRate;
    private final int[] Rates = new int[3];

    // Setters và Getters
    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getTitle() {
        return Title;
    }

    public void setPublishDate(String PublishDate) {
        this.PublishDate = PublishDate;
    }

    public String getPublishDate() {
        return PublishDate;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public String getAuthor() {
        return Author;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    public String getContent() {
        return Content;
    }

    // Chỉ có getter cho AverageRate
    public float getAverageRate() {
        return AverageRate;
    }

    // a) Method Display(): In ra thông tin tin tức
    @Override
    public void Display() {
        System.out.println("Title: " + Title);
        System.out.println("PublishDate: " + PublishDate);
        System.out.println("Author: " + Author);
        System.out.println("Content: " + Content);
        System.out.println("AverageRate: " + AverageRate);
    }

    // b) Method Calculate(): Tính AverageRate từ array Rates
    @Override
    public float Calculate() {
        if (Rates.length != 3) {
            System.out.println("Array Rates phải có đúng 3 phần tử!");
            return 0;
        }
        int sum = 0;
        for (int rate : Rates) {
            sum += rate;
        }
        return (float) sum / 3;
    }

    // Method setter để set giá trị cho array Rates
    public void setRates(int rate1, int rate2, int rate3) {
        Rates[0] = rate1;
        Rates[1] = rate2;
        Rates[2] = rate3;
    }
}