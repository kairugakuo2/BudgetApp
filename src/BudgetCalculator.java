import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

public class BudgetCalculator {

    // sum up all the expenses
    public static double totalExpenses(List<Expense> expenses){
        double total = 0.0;
        //loop through all expense objects in list "expenses"
        for (Expense expense : expenses) {
            total += expense.getAmount();
        }
        return total;
    }

    // calculate remaining budget ( total budget - expenses)
    public static double remainingBudget(double totalBudget, List<Expense> expenses){
        double totalExpenses = totalExpenses(expenses);
        return totalBudget - totalExpenses;
    }

    // calculate days left in month
    public static int daysLeft(){
        LocalDate today = LocalDate.now();
        YearMonth yearMonth = YearMonth.of(today.getYear(), today.getMonth());
        int lastDay = yearMonth.lengthOfMonth();
        return lastDay - today.getDayOfMonth();
    }

    //calculate daily spending limit (remaining budget / days left in month)
    public static double dailyLimit(double remainingBudget){
        int daysLeft = daysLeft();
        if(daysLeft > 0){
            return remainingBudget / daysLeft;
        } else{
            return 0;
        }
    }
}
