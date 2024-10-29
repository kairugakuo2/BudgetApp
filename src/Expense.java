import java.time.LocalDate;

public class Expense {
    private final double amount;
    private final String category;
    private final LocalDate date;
    private final String description;

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