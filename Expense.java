import java.time.LocalDate;

public class Expense {
    private double amount;
    private String category;
    private LocalDate date;
    private String description;

    //constructor
    public Expense (double amount, String category, LocalDate date, String description) {
        this.amount = amount;
        this.date = date;
        this.category = category;
        this.description = description;
    }

    //getters

    public double getAmount(){
        return amount;
    }
    public LocalDate getDate(){
        return date;
    }
    public String getCategory(){
        return category;
    }
    public String getDescription(){
        return description;
    }

}