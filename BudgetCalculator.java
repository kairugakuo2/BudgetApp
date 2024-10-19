import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

public class BudgetCalculator {

    // sum up all of the expenses
    public static double totalExpenses(List<Expense> expenses){
        double total = 0.0;
        for(int i = 0; i < expenses.size(); i++){
            Expense expense = expenses.get(i);
            totalExpenses += expense.getAmount();
        }
        return total;
    }
}